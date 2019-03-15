package com.chernikin.webapp.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductQueryBuilder {

    public SqlQuery buildSqlQuery(ProductCriteria criteria) {
        final List<String> sqlWhereParts = new ArrayList<>();
        final HashMap<Integer, String> sqlWhereParams = new HashMap<>();

        int sqlWhereCounter = 1;

        if (criteria.getCompany() != null) {
            sqlWhereParts.add("Company = ?");
            sqlWhereParams.put(sqlWhereCounter++, criteria.getCompany());
        }

        if (criteria.getProductName() != null) {
            sqlWhereParts.add("productName = ?");
            sqlWhereParams.put(sqlWhereCounter++, criteria.getProductName());
        }

        if (criteria.getPrice() != null) {
            sqlWhereParts.add("price = ?");
            sqlWhereParams.put(sqlWhereCounter++, criteria.getPrice());
        }
        return new SqlQuery(createSqlString(sqlWhereParts), sqlWhereParams);
    }

    private String createSqlString(List<String> sqlWhereParts) {
        final String sqlWhere = String.join(" and ", sqlWhereParts);
        String sql = "select * from products";
        if (!sqlWhere.isEmpty()) {
            sql += " where " + sqlWhere;
        }
        return sql;
    }
}
