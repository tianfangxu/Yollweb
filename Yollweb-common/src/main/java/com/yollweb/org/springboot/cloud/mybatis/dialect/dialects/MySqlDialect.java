package com.yollweb.org.springboot.cloud.mybatis.dialect.dialects;

import com.yollweb.org.springboot.cloud.mybatis.dialect.IDialect;

public class MySqlDialect implements IDialect {

    public static final MySqlDialect instance = new MySqlDialect();

    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" LIMIT ").append(offset).append(",").append(limit);
        return sql.toString();
    }

}
