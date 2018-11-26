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

    #program = remove_comments(program)

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

main()

