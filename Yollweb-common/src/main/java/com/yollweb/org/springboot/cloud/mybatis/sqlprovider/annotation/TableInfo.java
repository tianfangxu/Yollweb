package com.yollweb.org.springboot.cloud.mybatis.sqlprovider.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableInfo {

    String name();
}
