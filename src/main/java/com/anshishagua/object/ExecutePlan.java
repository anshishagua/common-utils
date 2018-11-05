package com.anshishagua.object;

import java.util.List;

/**
 * ExecutePlan.java
 *
 * @author lixiao
 * @date 2018-10-27
 */

public class ExecutePlan {
    public class ExecuteSQL {
        private String alias;
        private String sql;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }
    }

    private List<ExecuteSQL> executeSQLs;

    public List<ExecuteSQL> getExecuteSQLs() {
        return executeSQLs;
    }

    public void setExecuteSQLs(List<ExecuteSQL> executeSQLs) {
        this.executeSQLs = executeSQLs;
    }
}
