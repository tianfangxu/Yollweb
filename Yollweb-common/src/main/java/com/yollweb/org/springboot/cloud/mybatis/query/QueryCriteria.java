package com.yollweb.org.springboot.cloud.mybatis.query;

import com.yollweb.org.springboot.cloud.mybatis.plugin.Page;

public interface QueryCriteria {

    Page getPage();

    void setPage(Page page);

    QueryCriteria andIs(String field);

    QueryCriteria orIs(String field);

    QueryCriteria andLike(String field);

    QueryCriteria orLike(String field);

    String getCondition();
}
