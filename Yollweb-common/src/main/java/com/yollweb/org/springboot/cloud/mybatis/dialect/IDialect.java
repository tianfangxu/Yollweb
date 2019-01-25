package com.yollweb.org.springboot.cloud.mybatis.dialect;

public interface IDialect {

    String buildPaginationSql(String originalSql, int offset, int limit);
}
