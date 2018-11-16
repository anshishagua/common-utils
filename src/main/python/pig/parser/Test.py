from antlr4 import InputStream
from antlr4 import CommonTokenStream

from pig.generated.PigLexer import PigLexer
from pig.generated.PigParser import PigParser
from pig.parser.PigBaseVisitor import PigBaseVisitor
from pig.parser.PigNewVisitor import PigNewVisitor
from pig.parser.Number import Number


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
                app_data_usage_bad_record = LOAD ###MDM_APP_DATA_USAGE_BAD_RECORD_F:$load_days###;

  app_days_running_r = FILTER app_days_running_r BY ToDate(REPLACE(utc_date_key, '-', ''), 'YYYYMMdd') == ToDate('$date', 'YYYY-MM-dd')
    AND ToDate(agent_received_at, 'YYYY-MM-dd HH:mm:ss') >= SubtractDuration(ToDate(REPLACE(utc_date_key, '-', ''), 'YYYYMMdd'), 'P1D')
    AND ToDate(agent_received_at, 'YYYY-MM-dd HH:mm:ss') < AddDuration(ToDate(REPLACE(utc_date_key, '-', ''), 'YYYYMMdd'), 'P4D')
    AND days_running > 0 AND fetch_count > 0;
    
    reported_app_days_running_an_cn = DISTINCT reported_app_days_running_an_cn;
    guid_status_union = UNION onschema app_data_usage_an_cn, app_days_running_an_cn, app_screen_time_an_cn;
    dim_known_plan_j = JOIN dim_known_plan BY interface_key, dim_interface_plan BY interface_key USING 'replicated';
    STORE total_downloads INTO ###RINCON_APP_TOTAL_DOWNLOADS_FEATURE_I|range_type=MONTH###;

ipad_downloads = FOREACH  iPad_accum_downloads GENERATE  app_id, 
country, 'iPad' AS device_type:chararray, 
ipad_downloads AS downloads:long,
CASE WHEN a == 1 THEN 1 ELSE 3 END AS aaa;
    """

    program = """
    
   capi_log = FOREACH capi_log GENERATE  guid,
                                      iso_country_code,
                                      latitude,
                                      longitude,
                                      sdk_publisher_id,
                                      sdk_bundle_id,
                                      connection_type,
                                      infid,
                                      remote_server_port,
                                      (remote_server_host IS NULL ? '' : remote_server_host) AS remote_server_host,
                                      http_user_agent,
                                      http_refer,
                                      http_uri,
                                      input_bytes,
                                      output_bytes,
                                      transformed_at,
                                      connection_start_at,
                                      connection_end_at,
                                      app_identifier,
                                      sdk_version,
                                      os_version,
                                      app_version;
    """

    inputStream = InputStream(program)
    lexer = PigLexer(inputStream)
    stream = CommonTokenStream(lexer)
    parser = PigParser(stream)
    tree = parser.program()

    visitor = PigNewVisitor()

    program = visitor.visitProgram(tree)

    print program.toSpark()


main()
