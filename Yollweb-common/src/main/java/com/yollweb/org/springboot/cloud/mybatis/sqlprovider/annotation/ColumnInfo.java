package com.yollweb.org.springboot.cloud.mybatis.sqlprovider.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnInfo {

   String name() ;

}
