from antlr4 import InputStream
from antlr4 import CommonTokenStream

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigNewVisitor import PigNewVisitor
from pig_to_spark import remove_comments
import GlobalContext
import AAA
from context import ExecContext


def load_program(path):
    f = open(path)

    result = ""

    for line in f:
        result += line
        result += "\n"

    return result

def main():
    program = """
        SET pig.exec.reducers.max 4000; 
        a = LOAD ###erwqrqwrqwe###; 
        STORE aaa INTO ###asfwer###;
        app_data_usage_bad_record = LOAD ###MDM_APP_DATA_USAGE_BAD_RECORD_F:$load_days###;
        REGISTER ../../pig_udfs/fact_udfs.py USING org.apache.pig.scripting.jython.JythonScriptEngine AS fact_udfs;
        a = FILTER aaa BY a.bbbb == (1 + 1 * 1.000) AND 2 == 2 AND common_udf.is_guid_valid(guid);
    """

    program = """
    retention = UNION retention_day0,retention_day1,retention_day2,retention_day3,retention_day4,retention_day5,retention_day6,retention_day7,retention_day14,retention_day30;
fake_id_to_four_key = DISTINCT fake_id_to_four_key;                       
    
    capi_log = FILTER capi_log BY ToString(ToDate(connection_start_at), 'YYYY-MM-dd') == '$target_date' AND
                                    ((connection_type == 'APP' AND connection_start_at != 0 AND connection_end_at != 0 AND (input_bytes + output_bytes) != 0) OR
                                    (connection_type == 'SCREEN' AND (connection_end_at - connection_start_at) <= 3600*1000*4) OR
                                    (connection_type != 'APP'));    
    """

    program = """
            app_data_usage_bad_record = LOAD ###MDM_APP_DATA_USAGE_BAD_RECORD_F:$load_days###;

    app_total_downloads_prev = FOREACH app_total_downloads_prev GENERATE app_id, country, device_type, total_downloads AS downloads;
curr_total_accum_downloads = UNION android_app_accum_downloads, ios_app_accum_downloads;
STORE total_downloads INTO ###APP_TOTAL_DOWNLOADS_I|range_type=MONTH###;
    capi_log = FILTER capi_log BY field == 1;    
    """

    program = """
    REGISTER ../pig_udfs/fact_udfs.py using org.apache.pig.scripting.jython.JythonScriptEngine as fact_udfs;

selected_devices = LOAD ###MDM_OPERATOR_SELECTED_DEVICE_I###;
plan_usage_monthly = LOAD ###MDM_OPERATOR_MATRIX_PLAN_USAGE_MONTHLY_I###;

device_usage_j = JOIN selected_devices BY guid_key, plan_usage_monthly BY guid_key;
device_usage = FOREACH device_usage_j GENERATE selected_devices::guid_key AS guid_key,
    selected_devices::iso_country_code AS country_code,
    selected_devices::operator_name AS operator_name,
    selected_devices::platform AS platform,
    selected_devices::device_type AS device_type,
    selected_devices::max_network_capability AS max_network_capability,
    fact_udfs.fix_data('$date', selected_devices::platform, plan_usage_monthly::domestic_mobile_bytes) AS domestic_mobile_bytes,
    (selected_devices::max_network_capability == 'LTE' ? fact_udfs.fix_data('$date', selected_devices::platform, plan_usage_monthly::domestic_lte_bytes) : 0L) AS domestic_lte_bytes,
    fact_udfs.fix_data('$date', selected_devices::platform, plan_usage_monthly::domestic_wifi_bytes) AS domestic_wifi_bytes,
    fact_udfs.fix_data('$date', selected_devices::platform, plan_usage_monthly::roaming_mobile_bytes) AS roaming_mobile_bytes,
    fact_udfs.fix_data('$date', selected_devices::platform, plan_usage_monthly::roaming_wifi_bytes) AS roaming_wifi_bytes,
    (domestic_mobile_bytes > 0 ? 1 : 0) AS reported_domestic_mobile_bytes,
    (domestic_wifi_bytes > 0 ? 1 : 0) AS reported_domestic_wifi_bytes,
    plan_usage_monthly::reported_domestic_bytes AS reported_domestic_bytes,
    plan_usage_monthly::reported_roaming_bytes AS reported_roaming_bytes,
    (plan_usage_monthly::reported_lte_bytes > 0 AND selected_devices::max_network_capability == 'LTE' ? 1 : 0) AS reported_lte_bytes,
    fact_udfs.count_roaming_days(plan_usage_monthly::bitwise_roaming_days) AS roaming_days;

device_usage_g = GROUP device_usage BY (country_code, operator_name, platform, device_type, max_network_capability);
device_usage_agg = FOREACH device_usage_g {
    GENERATE FLATTEN(group) AS (country_code, operator_name, platform, device_type, max_network_capability),
    SUM(device_usage.domestic_mobile_bytes) AS domestic_mobile_bytes,
    SUM(device_usage.domestic_lte_bytes) AS domestic_lte_bytes,
    SUM(device_usage.domestic_wifi_bytes) AS domestic_wifi_bytes,
    SUM(device_usage.roaming_mobile_bytes) AS roaming_mobile_bytes,
    SUM(device_usage.roaming_wifi_bytes) AS roaming_wifi_bytes,
    SUM(device_usage.reported_domestic_mobile_bytes) AS domestic_mobile_users,
    SUM(device_usage.reported_domestic_wifi_bytes) AS domestic_wifi_users,
    SUM(device_usage.reported_domestic_bytes) AS domestic_users,
    SUM(device_usage.reported_roaming_bytes) AS roaming_users,
    SUM(device_usage.reported_lte_bytes) AS lte_users,
    SUM(device_usage.roaming_days) AS roaming_days,
    COUNT(device_usage.guid_key + 1) AS total_users;
}    
    
    capi_ingest = LOAD ###IOS_CAPI_PRE_INGEST_LOG_F:$load_days:$load_date###;
capi_ingest = FILTER capi_ingest BY infid < 8;
capi_ingest = FOREACH capi_ingest GENERATE guid, sdk_publisher_id, connection_start_at, UPPER(iso_country_code) AS country;
ingest_data = FILTER capi_ingest BY ToString(ToDate(connection_start_at), 'YYYY-MM-dd') >= '$start_date' AND ToString(ToDate(connection_start_at), 'YYYY-MM-dd') <= '$date';
ingest_data = FOREACH ingest_data GENERATE guid,
    sdk_publisher_id,
    country,
    ToString(ToDate(connection_start_at), 'YYYY-MM-dd') AS date,
    connection_start_at;
result = FOREACH (GROUP ingest_data BY (guid, date)) {
    r = TOP(1, 4, ingest_data);
    GENERATE FLATTEN(r) AS (guid, sdk_publisher_id, country, date, connection_start_at);
}

result = FOREACH result GENERATE date, guid, sdk_publisher_id, country;
STORE result INTO ###MDM_CAPI_GUID_COUNTRY_O###;
            """

    program = """
/*
 * Copyright (c) 2015 App Annie Inc. All rights reserved.
 */
/**
Installed user base
**/



ios_app_info_i = LOAD ###IOS_APP_INFO_I###;
android_app_info_i = LOAD ###ANDROID_APP_INFO_I###;

ios_country_mapping = LOAD ###IOS_COUNTRY_MAPPING_D###;
android_country_mapping = LOAD ###ANDROID_COUNTRY_MAPPING_D###;

ios_app_info_j = JOIN ios_app_info_i BY country_id, ios_country_mapping BY country_id;
ios_app_info = FOREACH ios_app_info_j GENERATE ios_app_info_i::id AS app_id,
    'iOS' AS platform,
    (ios_app_info_i::bundle_id == 'com.apple.mobilemaps' ? 'com.apple.Maps' : ios_app_info_i::bundle_id) AS bundle_id,
    -- ios_app_info_i::bundle_id AS bundle_id,
    ios_app_info_i::version AS version,
    ios_country_mapping::country_code AS country_code,
    ios_app_info_i::category_id AS primary_category_id,
    ios_app_info_i::publisher_id AS publisher_id,
    ios_app_info_i::release_date AS release_date;


android_app_info_j = JOIN android_app_info_i BY country_id LEFT, android_country_mapping BY country_id;
android_app_info = FOREACH android_app_info_j GENERATE android_app_info_i::id AS app_id,
    'Android' AS platform,
    android_app_info_i::bundle_id AS bundle_id,
    android_app_info_i::version AS version,
    -- for china android many country code would be null on pg database side. fix manually here
    (android_country_mapping::country_code is NULL ? 'CN' : android_country_mapping::country_code) AS country_code,
    android_app_info_i::category_id AS primary_category_id,
    android_app_info_i::publisher_id AS publisher_id,
    android_app_info_i::release_date AS release_date;

app_info = UNION ios_app_info, android_app_info;
app_info = DISTINCT app_info;

STORE app_info INTO ###APP_INFO_D###;


ios_app_name_i = LOAD ###IOS_APP_NAME_I###;
ios_app_name_o = FOREACH ios_app_name_i GENERATE app_id, app_name, 'iOS' AS platform;
android_app_name_i = LOAD ###ANDROID_APP_NAME_I###;
android_app_name_o = FOREACH android_app_name_i GENERATE app_id, app_name, 'Android' AS platform;
app_name = UNION ios_app_name_o, android_app_name_o;
STORE app_name INTO ###APP_NAME_D###;

ios_category_mapping_i = LOAD ###IOS_CATEGORY_MAPPING_I###;
ios_category_mapping_o = FOREACH ios_category_mapping_i GENERATE category_id, category_name, 'iOS' AS platform, parent_id;
android_category_mapping_i = LOAD ###ANDROID_CATEGORY_MAPPING_I###;
android_category_mapping_o = FOREACH android_category_mapping_i GENERATE category_id, category_name, 'Android' AS platform, parent_id;
app_category = UNION ios_category_mapping_o, android_category_mapping_o;

parent_category = FOREACH app_category GENERATE *;

app_category = FOREACH (JOIN app_category BY (platform, parent_id) LEFT, parent_category BY (platform, category_id)) GENERATE
    app_category::category_id AS category_id,
    app_category::category_name AS category_name,
    app_category::platform AS platform,
    parent_category::category_name AS parent_category,
    parent_category::category_id AS parent_category_id;

STORE app_category INTO ###APP_CATEGORY_MAPPING_D###;


ios_app_publihser = LOAD ###IOS_APP_PUBLISHER_I###;
android_app_publihser = LOAD ###ANDROID_APP_PUBLISHER_I###;

ios_app_publihser = FOREACH ios_app_publihser GENERATE publisher_id, 'iOS' AS platform, publisher_name;
android_app_publihser = FOREACH android_app_publihser GENERATE publisher_id, 'Android' AS platform, publisher_name;

app_publisher =  UNION ios_app_publihser, android_app_publihser;
STORE app_publisher INTO ###APP_PUBLISHER_MAPPING_D###;
selected_devices = LOAD ###MDM_OPERATOR_SELECTED_DEVICE_I###;
plan_usage_monthly = LOAD ###MDM_OPERATOR_MATRIX_PLAN_USAGE_MONTHLY_I###;

device_usage_j = JOIN selected_devices BY guid_key, plan_usage_monthly BY guid_key;
android_app_info = FOREACH android_app_info_j GENERATE android_app_info_i::id AS app_id,
    'Android' AS platform,
    android_app_info_i::bundle_id AS bundle_id,
    android_app_info_i::version AS version,
    -- for china android many country code would be null on pg database side. fix manually here
    (android_country_mapping::country_code is NULL ? 'CN' : android_country_mapping::country_code) AS country_code,
    android_app_info_i::category_id AS primary_category_id,
    android_app_info_i::publisher_id AS publisher_id,
    android_app_info_i::release_date AS release_date;
    """

    #program = remove_comments(program)

    program = """
SET pig.exec.reducers.bytes.per.reducer 500000000;
SET mapreduce.map.java.opts -Xmx1638m;
SET mapreduce.map.memory.mb 5120;
SET mapreduce.reduce.java.opts -Xmx1638m;
SET mapreduce.reduce.memory.mb 5120;
SET mapreduce.output.fileoutputformat.compress true;
SET mapreduce.output.fileoutputformat.compress.codec org.apache.hadoop.io.compress.GzipCodec;
-- To give up specific reducer output, once Java RE runs into infinite loop in certain spacial case
SET mapreduce.map.failures.maxpercent 5;
SET mapreduce.reduce.failures.maxpercent 5;
SET mapreduce.reduce.speculative false;
SET mapreduce.reduce.maxattempts 1;
SET mapreduce.task.timeout 1800000000;
SET parquet.compression gzip;
SET mapreduce.fileoutputcommitter.algorithm.version 2;


register /usr/lib/pig/lib/jyson-1.0.2.jar;
register ../../pig_udfs/common_udfs.py USING org.apache.pig.scripting.jython.JythonScriptEngine AS common_udf;
register ../../pig_udfs/maintenance_udfs.py USING org.apache.pig.scripting.jython.JythonScriptEngine AS maintenance_udf;

DEFINE LongToString InvokeForString('java.lang.String.valueOf', 'Long');
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
capi_log = LOAD ###IOS_CAPI_PRE_INGEST_LOG_F:4###;


capi_log = FILTER capi_log BY ToString(ToDate(connection_start_at), 'YYYY-MM-dd') == '$target_date' AND
                                    ((connection_type == 'APP' AND connection_start_at != 0 AND connection_end_at != 0 AND (input_bytes + output_bytes) != 0) OR
                                    (connection_type == 'SCREEN' AND (connection_end_at - connection_start_at) <= 3600*1000*4) OR
                                    (connection_type != 'APP'));


capi_log = FILTER capi_log BY
    (connection_start_at > 0 AND connection_end_at > 0) AND
    (connection_type IN ('DELETE','PUT','OPTIONS','HEAD','TUNNEL','UDP','POST','SCREEN','APP','GET','BLOCKED','TCP','CONNECT') AND
    (
        connection_type == 'TUNNEL' OR
        (connection_type == 'SCREEN' AND (connection_end_at - connection_start_at) <= 3600*1000*4) OR
        ((connection_end_at - connection_start_at) <= 3600*1000*2)
    ) AND
    (common_udf.is_guid_valid(guid))
);

capi_log = FOREACH capi_log GENERATE
                common_udf.gen_fake_bundle_id(remote_server_host, http_uri, http_user_agent, connection_type) AS fake_bundle_id,
                guid,
                iso_country_code,
                latitude,
                longitude,
                sdk_publisher_id,
                sdk_bundle_id,
                infid,
                (remote_server_host IS NULL ? '' : remote_server_host) AS remote_server_host,
                (http_uri IS NULL ? '' : http_uri) AS http_uri,
                (http_user_agent IS NULL ? '' : http_user_agent) AS http_user_agent,
                (connection_type IS NULL ? '' : connection_type) AS connection_type,
                input_bytes,
                output_bytes,
                connection_start_at,
                connection_end_at;


fake_id_to_four_key = FOREACH capi_log GENERATE
                        fake_bundle_id,
                        remote_server_host,
                        http_uri,
                        http_user_agent,
                        connection_type;
fake_id_to_four_key = DISTINCT fake_id_to_four_key;                       


capi_log = FOREACH capi_log GENERATE
                guid,
                iso_country_code,
                latitude,
                longitude,
                sdk_publisher_id,
                sdk_bundle_id,
                infid,
                connection_type,
                input_bytes,
                output_bytes,
                connection_start_at,
                connection_end_at,
                fake_bundle_id;
capi_log = DISTINCT capi_log;



capi_session = FOREACH(GROUP capi_log BY (guid, iso_country_code, latitude, longitude, sdk_publisher_id, sdk_bundle_id)) {
               GENERATE FLATTEN(common_udf.capi_session(capi_log)) AS (
                    guid,
                    iso_country_code,
                    latitude,
                    longitude,
                    sdk_publisher_id,
                    sdk_bundle_id,
                    infid,              -- the most count infid for the fake_bundle_id
                    session_input_bytes,
                    session_output_bytes,
                    session_start_time,
                    session_end_time,
                    fake_bundle_id,
                    request_input_bytes,
                    request_output_bytes,
                    request_start_time,
                    request_end_time,
                    bundle_count,       -- fake_bundle_id count=1, prepared to be sum in the following process
                    session_id          -- to specify different sessions
               );
}



capi_session = DISTINCT capi_session;


capi_session = FOREACH capi_session GENERATE
    maintenance_udf.fake_device_id(guid) AS device_id,
    common_udf.capi_guid_transfer(guid) AS guid,
    iso_country_code,
    latitude,
    longitude,
    sdk_publisher_id,
    sdk_bundle_id,
    infid,
    fake_bundle_id,
    session_input_bytes,
    session_output_bytes,
    session_start_time,
    session_end_time,
    request_input_bytes,
    request_output_bytes,
    request_start_time,
    request_end_time,
    bundle_count,
    session_id;


capi_session = JOIN capi_session BY fake_bundle_id, fake_id_to_four_key BY fake_bundle_id;


capi_session = FOREACH capi_session GENERATE
                        '$target_date' AS date:chararray,
                        capi_session::device_id AS device_id:chararray,
                        capi_session::guid AS guid:chararray,
                        capi_session::iso_country_code AS iso_country_code:chararray,
                        capi_session::latitude AS latitude:chararray,
                        capi_session::longitude AS longitude:chararray,
                        capi_session::sdk_publisher_id AS sdk_publisher_id:chararray,
                        capi_session::sdk_bundle_id AS sdk_bundle_id:chararray,
                        capi_session::infid AS infid:int,
                        capi_session::session_input_bytes AS session_input_bytes:long,
                        capi_session::session_output_bytes AS session_output_bytes:long,
                        capi_session::session_start_time AS session_start_time:long,
                        capi_session::session_end_time AS session_end_time:long,
                        capi_session::request_input_bytes AS request_input_bytes:long,
                        capi_session::request_output_bytes AS request_output_bytes:long,
                        capi_session::request_start_time AS request_start_time:long,
                        capi_session::request_end_time AS request_end_time:long,
                        capi_session::bundle_count AS bundle_count:long,
                        capi_session::session_id AS session_id:long,
                        fake_id_to_four_key::remote_server_host AS remote_server_host:chararray,
                        fake_id_to_four_key::http_uri AS http_uri:chararray,
                        fake_id_to_four_key::http_user_agent AS http_user_agent:chararray,
                        fake_id_to_four_key::connection_type AS connection_type:chararray;

STORE capi_session INTO ###MDM_CAPI_SESSION_F|date=$target_date###;


    """

    input_stream = InputStream(program)
    lexer = PigLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigNewVisitor()
    AAA.name = "ewrwerwer"
    program = visitor.visitProgram(tree)

    exec_context = ExecContext()
    exec_context.schema_root = "/Users/xiaoli/IdeaProjects/aardvark-analyze/statistics/usage//schema/definitions/"
    print program.to_spark(exec_context)

    #print "%s" % exec_context.relation_map

    print "%s%s" % (111, 222)

main()

