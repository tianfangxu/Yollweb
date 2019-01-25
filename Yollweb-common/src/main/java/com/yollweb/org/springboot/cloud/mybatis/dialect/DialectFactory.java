package com.yollweb.org.springboot.cloud.mybatis.dialect;

import com.yollweb.org.springboot.cloud.exception.AppException;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.session.RowBounds;
import com.yollweb.org.springboot.cloud.mybatis.dialect.dialects.MySqlDialect;
import com.yollweb.org.springboot.cloud.mybatis.dialect.dialects.PgDialect;
import com.yollweb.org.springboot.cloud.mybatis.plugin.Pagination;

public class DialectFactory {

    public static String buildPaginationSql(Pagination page, String buildSql, String dialectType, String dialectClazz)
            throws Exception {
        return getiDialect(dialectType, dialectClazz).buildPaginationSql(buildSql, page.getOffset(), page.getSize());
    }

    public static String buildPaginationSql(RowBounds rowBounds, String buildSql, String dialectType, String dialectClazz)
            throws Exception {
        return getiDialect(dialectType, dialectClazz).buildPaginationSql(buildSql, rowBounds.getOffset(), rowBounds.getLimit());
    }

    private static IDialect getiDialect(String dialectType, String dialectClazz) throws Exception {
        IDialect dialect = null;
        if (StringUtils.isNotEmpty(dialectType)) {
            dialect = getDialectByDbType(dialectType);
        } else {
            if (StringUtils.isNotEmpty(dialectClazz)) {
                try {
                    Class<?> clazz = Class.forName(dialectClazz);
                    if (IDialect.class.isAssignableFrom(clazz)) {
                        dialect = (IDialect) clazz.newInstance();
                    }
                } catch (ClassNotFoundException e) {
                    throw new ExecutorException("Class :" + dialectClazz + " is not found");
                }
            }
        }

        if (dialect == null) {
            throw new ExecutorException("The value of the dialect property in mybatis configuration is not defined.");
        }
        return dialect;
    }

    private static IDialect getDialectByDbType(String dbtype) throws Exception {
        if ("mysql".equals(dbtype)) {
            return MySqlDialect.instance;
        } else if ("pg".equals(dbtype)) {
            return PgDialect.INSTANCE;
        } else {
            throw new AppException("Not support db type " + dbtype);
        }
    }
}
