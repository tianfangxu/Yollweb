package com.yollweb.org.springboot.cloud.mybatis.dialect.dialects;

import com.yollweb.org.springboot.cloud.mybatis.dialect.IDialect;

public class PgDialect implements IDialect {

    public static final PgDialect INSTANCE = new PgDialect();

    @Override
    public String buildPaginationSql(String originalSql, int offset, int limit) {
        StringBuilder sql = new StringBuilder(originalSql);
        sql.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);
        return sql.toString();
    }
}
