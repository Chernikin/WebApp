package com.chernikin.webapp.database;

import java.util.Map;

public class SqlQuery {

    private String sql;
    private Map<Integer, String> params;


    public SqlQuery(String sql, Map<Integer, String> params) {
        this.sql = sql;
        this.params = params;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParams() {
        return params;
    }

    public void setParams(Map<Integer, String> params) {
        this.params = params;
    }
}
