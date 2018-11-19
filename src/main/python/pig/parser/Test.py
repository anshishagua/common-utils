from antlr4 import InputStream
from antlr4 import CommonTokenStream

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigBaseVisitor import PigBaseVisitor
from pig.parser.PigNewVisitor import PigNewVisitor
from pig.parser.Number import Number
from pig_to_spark import remove_comments


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
/*
 * Copyright (c) 2015 App Annie Inc. All rights reserved.
 */
SET pig.exec.reducers.max 4000;
SET mapreduce.output.fileoutputformat.compress true;
SET mapreduce.output.fileoutputformat.compress.codec org.apache.hadoop.io.compress.GzipCodec;
REGISTER ../../pig_udfs/fact_udfs.py USING org.apache.pig.scripting.jython.JythonScriptEngine AS fact_udfs;

-- build bad record hourly, daily, monthly
app_data_usage_bad_record = LOAD ###MDM_APP_DATA_USAGE_BAD_RECORD_F:$load_days###;
data_usage_bad_guid = FOREACH app_data_usage_bad_record {
    date = ToString(ToDate(utc_date_key, 'yyyyMMdd'), 'yyyy-MM-dd');
    GENERATE SUBSTRING(date, 0, 7) AS month:chararray,
        date AS date:chararray,
        local_time_key AS local_time_key:long,
        guid_key AS guid_key;
}
data_usage_bad_guid = DISTINCT data_usage_bad_guid;

app_days_running_bad_record = LOAD ###MDM_APP_DAYS_RUNNING_BAD_RECORD_F:$load_days###;
days_running_bad_guid = FOREACH app_days_running_bad_record {
    date = ToString(ToDate(utc_date_key, 'yyyyMMdd'), 'yyyy-MM-dd');
    GENERATE SUBSTRING(date, 0, 7) AS month:chararray,
        date AS date:chararray,
        local_time_key AS local_time_key:long,
        guid_key AS guid_key;
}
days_running_bad_guid = DISTINCT days_running_bad_guid;

app_screen_time_bad_record = LOAD ###MDM_APP_SCREEN_TIME_BAD_RECORD_F:$load_days###;
screen_time_bad_guid = FOREACH app_screen_time_bad_record {
    date = ToString(ToDate(utc_date_key, 'yyyyMMdd'), 'yyyy-MM-dd');
    GENERATE SUBSTRING(date, 0, 7) AS month:chararray,
        date AS date:chararray,
        local_time_key AS local_time_key:long,
        guid_key AS guid_key;
}
screen_time_bad_guid = DISTINCT screen_time_bad_guid;

bad_guid_union = UNION data_usage_bad_guid, days_running_bad_guid, screen_time_bad_guid;
bad_guid_distict = DISTINCT bad_guid_union;

bad_guid_hourly = FOREACH bad_guid_distict GENERATE month, date, local_time_key, guid_key, 'hourly' AS granularity;
bad_guid_hourly = DISTINCT bad_guid_hourly;

bad_guid_daily = FOREACH bad_guid_hourly GENERATE month, date, 'ALL', guid_key, 'daily' AS granularity;
bad_guid_daily = DISTINCT bad_guid_daily;

bad_guid_monthly = FOREACH bad_guid_daily GENERATE month, 'ALL', 'ALL', guid_key, 'monthly' AS granularity;
bad_guid_monthly = DISTINCT bad_guid_monthly;

bad_guid = UNION bad_guid_hourly, bad_guid_daily, bad_guid_monthly;

-- app usage
-- SUBSTRING(ToString(ToDate((long)timestamp * 1000)), 0, 10) AS date
app_data_usage = LOAD ###MDM_APP_DATA_USAGE_F:$load_days###;
app_data_usage = FOREACH app_data_usage GENERATE
    SUBSTRING(ToString(ToDate((long)timestamp * 1000)), 0, 10) AS date,
    timestamp, local_timestamp, bundle_id, guid_key,
    interface_key, os_version, upload_bytes, download_bytes, is_roaming_usage;

app_data_usage_bad_record = FOREACH app_data_usage_bad_record GENERATE
    ToString(ToDate(utc_date_key, 'yyyyMMdd'), 'yyyy-MM-dd') AS date:chararray,
    fact_udfs.convert_mdm_time_to_timestamp(utc_date_key, utc_time_key) AS timestamp:long,
    fact_udfs.convert_mdm_time_to_timestamp(local_date_key, local_time_key) AS local_timestamp:long,
    bundle_name AS bundle_id, guid_key, interface_key, os_version, upload_bytes, download_bytes, is_roaming_usage;
app_data_usage = UNION app_data_usage, app_data_usage_bad_record;

app_data_usage = FOREACH app_data_usage GENERATE date,
    SUBSTRING(date, 0, 7) AS month:chararray,
    fact_udfs.convert_timestamp_to_time_key(local_timestamp) AS local_time_key:long,
    guid_key,
    interface_key,
    upload_bytes,
    download_bytes,
    is_roaming_usage;

interface_short_keys = FOREACH app_data_usage GENERATE interface_key;
interface_short_keys = DISTINCT interface_short_keys;

-- interface that has usage
dim_interface = LOAD ###MDM_DIM_INTERFACE_D###;
dim_interface_has_usage_j = JOIN dim_interface BY interface_key, interface_short_keys BY interface_key;
dim_interface_has_usage = FOREACH dim_interface_has_usage_j GENERATE dim_interface::interface_key AS interface_key,
    dim_interface::interface_type AS interface_type,
    dim_interface::interface_name AS interface_name,
    dim_interface::is_roaming AS is_roaming,
    dim_interface::is_public_wifi AS is_public_wifi,
    dim_interface::is_lte AS is_lte,
    dim_interface::nettype_id AS nettype_id,
    dim_interface::network_type_code AS network_type_code,
    dim_interface::interface_display_name AS interface_display_name,
    dim_interface::interface_type_display_name AS interface_type_display_name,
    dim_interface::network_location_display_name AS network_location_display_name,
    dim_interface::mobile_type_detailed_display_name AS mobile_type_detailed_display_name,
    dim_interface::mobile_type_simplified_display_name AS mobile_type_simplified_display_name,
    dim_interface::created_at AS created_at;

-- interface magic numbers:  (-1), (-2), (1794), (1494)
dim_interface_magic_num = FILTER dim_interface BY interface_key IN (-1, -2, 1794, 1494);
dim_interface_selected = UNION dim_interface_has_usage, dim_interface_magic_num;
dim_interface_selected = DISTINCT dim_interface_selected;

interface_short = FOREACH dim_interface_selected GENERATE interface_key,
    (CASE LOWER(interface_name)
        WHEN 'roaming' THEN 'roaming'
        WHEN 'mobile' THEN 'domestic'
        ELSE LOWER(network_location_display_name)
    END) AS network_location,
    (LOWER(interface_name) == 'roaming' ? 'mobile' : LOWER(interface_name)) AS interface,
    (CASE
        WHEN LOWER(interface_name) == 'wifi' THEN (is_public_wifi == 'yes' ? 'public wifi' : 'private wifi')
        WHEN nettype_id == 11 THEN '2g'
        ELSE LOWER(mobile_type_simplified_display_name)
    END) AS interface_type_level1,
    (nettype_id == 11 ? 'cdma' : LOWER(mobile_type_detailed_display_name)) AS interface_type_level2,
    LOWER(network_type_code) AS interface_type_level3,
    nettype_id AS interface_type_level3_code;

STORE interface_short INTO ###MDM_INTERFACE_SHORT_I###;

-- plan usage
-- TODO: based on is_roaming_usage, and SQL
app_data_usage_g = GROUP app_data_usage BY (month, date, local_time_key, guid_key, interface_key, is_roaming_usage);
app_data_usage = FOREACH app_data_usage_g GENERATE FLATTEN(group) AS (month, date, local_time_key, guid_key, interface_key, is_roaming_usage),
    SUM(app_data_usage.upload_bytes) AS upload_bytes,
    SUM(app_data_usage.download_bytes) AS download_bytes;

app_usage_hourly_g = GROUP app_data_usage BY (month, date, local_time_key, guid_key, interface_key, is_roaming_usage);
app_usage_hourly = FOREACH app_usage_hourly_g GENERATE FLATTEN(group) AS (month, date, local_time_key, guid_key, interface_key, is_roaming_usage),
    SUM(app_data_usage.upload_bytes) AS upload_bytes,
    SUM(app_data_usage.download_bytes) AS download_bytes,
    'hourly' AS granularity;

app_usage_daily_g = GROUP app_usage_hourly BY (month, date, 'ALL', guid_key, interface_key, is_roaming_usage);
app_usage_daily = FOREACH app_usage_daily_g GENERATE FLATTEN(group) AS (month, date, local_time_key, guid_key, interface_key, is_roaming_usage),
    SUM(app_usage_hourly.upload_bytes) AS upload_bytes,
    SUM(app_usage_hourly.download_bytes) AS download_bytes,
    'daily' AS granularity;

app_usage_monthly_g = GROUP app_usage_daily BY (month, 'ALL', 'ALL', guid_key, interface_key, is_roaming_usage);
app_usage_monthly = FOREACH app_usage_monthly_g GENERATE FLATTEN(group) AS (month, date, local_time_key, guid_key, interface_key, is_roaming_usage),
    SUM(app_usage_daily.upload_bytes) AS upload_bytes,
    SUM(app_usage_daily.download_bytes) AS download_bytes,
    'monthly' AS granularity;

app_usage = UNION app_usage_hourly, app_usage_daily, app_usage_monthly;

app_usage_interface_short_j = JOIN app_usage BY interface_key, interface_short BY interface_key USING 'replicated';
app_usage_interface_short = FOREACH app_usage_interface_short_j {
    bytes = app_usage::upload_bytes + app_usage::download_bytes;
    network_location = interface_short::network_location;
    interface = interface_short::interface;
    interface_type_level1 = interface_short::interface_type_level1;
    GENERATE app_usage::month AS month,
        app_usage::date AS date,
        app_usage::local_time_key AS local_time_key,
        app_usage::granularity AS granularity,
        app_usage::guid_key AS guid_key,
        bytes AS bytes,
        (network_location == 'domestic' AND interface == 'mobile' AND is_roaming_usage == 'no' ? bytes : 0) AS domestic_mobile_bytes,
        (network_location == 'domestic' AND interface == 'mobile' AND interface_type_level1 == '4g' AND is_roaming_usage == 'no' ? bytes : 0) AS domestic_lte_bytes,
        (network_location == 'domestic' AND interface == 'wifi' AND is_roaming_usage == 'no' ? bytes : 0) AS domestic_wifi_bytes,
        ((network_location == 'roaming' AND interface == 'mobile') OR (network_location == 'domestic' AND interface == 'mobile' AND is_roaming_usage == 'yes') ? bytes : 0) AS roaming_mobile_bytes,
        ((network_location == 'roaming' AND interface == 'mobile' AND interface_type_level1 == '4g') OR (network_location == 'domestic' AND interface == 'mobile' AND interface_type_level1 == '4g' AND is_roaming_usage == 'yes') ? bytes : 0) AS roaming_lte_bytes,
        ((network_location == 'roaming' AND interface == 'wifi') OR (network_location == 'domestic' AND interface == 'wifi' AND is_roaming_usage == 'yes') ? bytes : 0) AS roaming_wifi_bytes,
        (network_location == 'domestic' AND is_roaming_usage == 'no' AND bytes > 0 ? 1 : 0) AS reported_domestic_bytes,
        (network_location == 'roaming' OR (network_location == 'domestic' AND is_roaming_usage == 'yes') AND bytes > 0 ? 1 : 0) AS reported_roaming_bytes,
        (network_location == 'domestic' AND interface == 'mobile' AND interface_type_level1 == '4g' AND is_roaming_usage == 'no' AND bytes > 0 ? 1 : 0) AS reported_lte_bytes;
}

guid_usage_g = GROUP app_usage_interface_short BY (month, date, local_time_key, granularity, guid_key);
guid_usage = FOREACH guid_usage_g GENERATE FLATTEN(group) AS (month, date, local_time_key, granularity, guid_key),
    SUM(app_usage_interface_short.bytes) AS bytes,
    SUM(app_usage_interface_short.domestic_mobile_bytes) AS domestic_mobile_bytes,
    SUM(app_usage_interface_short.domestic_lte_bytes) AS domestic_lte_bytes,
    SUM(app_usage_interface_short.domestic_wifi_bytes) AS domestic_wifi_bytes,
    SUM(app_usage_interface_short.roaming_mobile_bytes) AS roaming_mobile_bytes,
    SUM(app_usage_interface_short.roaming_lte_bytes) AS roaming_lte_bytes,
    SUM(app_usage_interface_short.roaming_wifi_bytes) AS roaming_wifi_bytes,
    MAX(app_usage_interface_short.reported_domestic_bytes) AS reported_domestic_bytes,
    MAX(app_usage_interface_short.reported_roaming_bytes) AS reported_roaming_bytes,
    MAX(app_usage_interface_short.reported_lte_bytes) AS reported_lte_bytes;

guid_usage_with_bad_j = JOIN guid_usage BY (month, date, local_time_key, guid_key, granularity) LEFT, bad_guid BY (month, date, local_time_key, guid_key, granularity) USING 'skewed';
guid_usage_with_bad = FOREACH guid_usage_with_bad_j GENERATE guid_usage::month AS month,
    guid_usage::date AS date,
    guid_usage::local_time_key AS local_time_key,
    guid_usage::granularity AS granularity,
    guid_usage::guid_key AS guid_key,
    (bad_guid::guid_key IS NOT NULL ? true : false) AS has_bad_record,
    guid_usage::bytes AS bytes,
    guid_usage::domestic_mobile_bytes AS domestic_mobile_bytes,
    guid_usage::domestic_lte_bytes AS domestic_lte_bytes,
    guid_usage::domestic_wifi_bytes AS domestic_wifi_bytes,
    guid_usage::roaming_mobile_bytes AS roaming_mobile_bytes,
    guid_usage::roaming_lte_bytes AS roaming_lte_bytes,
    guid_usage::roaming_wifi_bytes AS roaming_wifi_bytes,
    guid_usage::reported_domestic_bytes AS reported_domestic_bytes,
    guid_usage::reported_roaming_bytes AS reported_roaming_bytes,
    guid_usage::reported_lte_bytes AS reported_lte_bytes;

-- ONLY users have domestic mobile (including lte) data usage can contribute to reports.
guid_usage_with_bad = FILTER guid_usage_with_bad BY domestic_mobile_bytes > 0 OR domestic_lte_bytes > 0;

plan_usage_group_hourly = FILTER guid_usage_with_bad BY granularity == 'hourly' AND has_bad_record == false;
STORE plan_usage_group_hourly INTO ###MDM_OPERATOR_MATRIX_PLAN_USAGE_HOURLY_I###;

plan_usage_group_daily = FILTER guid_usage_with_bad BY granularity == 'daily' AND has_bad_record == false;
STORE plan_usage_group_daily INTO ###MDM_OPERATOR_MATRIX_PLAN_USAGE_DAILY_I###;

plan_usage_group_monthly = FILTER guid_usage_with_bad BY granularity == 'monthly';

app_usage_daily_interface_short_j = JOIN app_usage_daily BY interface_key, interface_short BY interface_key USING 'replicated';
app_usage_daily_interface_short = FOREACH app_usage_daily_interface_short_j {
    bytes = app_usage_daily::upload_bytes + app_usage_daily::download_bytes;
    GENERATE app_usage_daily::month AS month,
        app_usage_daily::date AS date,
        app_usage_daily::guid_key AS guid_key,
        bytes AS bytes,
        interface_short::network_location AS network_location;
}

roaming_days_monthly = FOREACH(GROUP app_usage_daily_interface_short BY (month, guid_key))
    GENERATE FLATTEN(group) AS (month, guid_key),
        fact_udfs.bitwise_roaming_days(app_usage_daily_interface_short) AS bitwise_roaming_days;

plan_usage_group_monthly_roaming_days_j = JOIN plan_usage_group_monthly BY (month, guid_key), roaming_days_monthly BY (month, guid_key) USING 'skewed';
plan_usage_group_monthly_roaming_days = FOREACH plan_usage_group_monthly_roaming_days_j
    GENERATE plan_usage_group_monthly::month AS month,
         plan_usage_group_monthly::date AS date,
         plan_usage_group_monthly::local_time_key AS local_time_key,
         plan_usage_group_monthly::granularity AS granularity,
         plan_usage_group_monthly::guid_key AS guid_key,
         plan_usage_group_monthly::has_bad_record AS has_bad_record,
         plan_usage_group_monthly::bytes AS bytes,
         plan_usage_group_monthly::domestic_mobile_bytes AS domestic_mobile_bytes,
         plan_usage_group_monthly::domestic_lte_bytes AS domestic_lte_bytes,
         plan_usage_group_monthly::domestic_wifi_bytes AS domestic_wifi_bytes,
         plan_usage_group_monthly::roaming_mobile_bytes AS roaming_mobile_bytes,
         plan_usage_group_monthly::roaming_lte_bytes AS roaming_lte_bytes,
         plan_usage_group_monthly::roaming_wifi_bytes AS roaming_wifi_bytes,
         plan_usage_group_monthly::reported_domestic_bytes AS reported_domestic_bytes,
         plan_usage_group_monthly::reported_roaming_bytes AS reported_roaming_bytes,
         plan_usage_group_monthly::reported_lte_bytes AS reported_lte_bytes,
         roaming_days_monthly::bitwise_roaming_days AS bitwise_roaming_days;
plan_usage_group_monthly_roaming_days = FILTER plan_usage_group_monthly_roaming_days BY has_bad_record == false;
STORE plan_usage_group_monthly_roaming_days INTO ###MDM_OPERATOR_MATRIX_PLAN_USAGE_MONTHLY_I###;

-- generate selected device and other info
selected_devices_android = LOAD ###MDM_SELECTED_DEVICE_O|range_type=MONTH###;
selected_devices_android = FILTER selected_devices_android BY is_selected == 'yes' AND platform == 1 AND is_supported_sdk == 'yes';
selected_devices = FOREACH selected_devices_android GENERATE
        date,
        guid_key,
        platform,
        operator_key,
        device_key,
        domestic_plan_key,
        roaming_plan_key,
        first_product_key,
        last_product_key,
        is_selected;

dim_operator = LOAD ###MDM_DIM_OPERATOR_NEW_D###;
dim_operator = FOREACH dim_operator GENERATE operator_key, country_name, iso_country_code, operator_name, operator_code_group;
dim_operator = FILTER dim_operator BY country_name != 'unknown';

dim_device = LOAD ###MDM_DIM_DEVICE_D###;
dim_device = FILTER dim_device BY (device_type == 'smartphone' OR device_type == 'tablet') AND (max_network_capability == '3g' OR max_network_capability == 'lte');
dim_device = FOREACH dim_device GENERATE device_key, device_type, max_network_capability;

selected_devices_join_operator = JOIN selected_devices BY operator_key, dim_operator BY operator_key USING 'skewed';
selected_devices_join_operator = FOREACH selected_devices_join_operator GENERATE selected_devices::guid_key AS guid_key,
    dim_operator::iso_country_code AS iso_country_code,
    (dim_operator::operator_code_group == 'top' ? dim_operator::operator_name : 'Other') AS operator_name,
    (selected_devices::platform == 1 ? 'Android' : 'iOS') AS platform,
    selected_devices::device_key AS device_key,
    selected_devices::domestic_plan_key AS domestic_plan_key,
    selected_devices::roaming_plan_key AS roaming_plan_key;

selected_devices_join_device = JOIN selected_devices_join_operator BY device_key, dim_device BY device_key USING 'replicated';
selected_devices_join_device = FOREACH selected_devices_join_device GENERATE selected_devices_join_operator::guid_key AS guid_key,
    selected_devices_join_operator::iso_country_code AS iso_country_code,
    selected_devices_join_operator::operator_name AS operator_name,
    selected_devices_join_operator::platform AS platform,
    selected_devices_join_operator::domestic_plan_key AS domestic_plan_key,
    selected_devices_join_operator::roaming_plan_key AS roaming_plan_key,
    (CASE dim_device::device_type
        WHEN 'smartphone' THEN 'Smartphone'
        WHEN 'tablet' THEN 'Tablet'
        ELSE dim_device::device_type
    END) AS device_type:chararray,
    (CASE dim_device::max_network_capability
        WHEN '3g' THEN '3G'
        WHEN 'lte' THEN 'LTE'
        ELSE dim_device::max_network_capability
    END) AS max_network_capability,
    (CASE WHEN 1 == 1 THEN 1 ELSE 2 END) AS max_ggg;
selected_devices_join_device = FILTER selected_devices_join_device BY platform == 'Android';    -- exclude IOS

STORE selected_devices_join_device INTO ###MDM_OPERATOR_SELECTED_DEVICE_I###;

    
    """


    program = remove_comments(program)

    inputStream = InputStream(program)
    lexer = PigLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigNewVisitor()

    program = visitor.visitProgram(tree)

    print program.toSpark()


main()
