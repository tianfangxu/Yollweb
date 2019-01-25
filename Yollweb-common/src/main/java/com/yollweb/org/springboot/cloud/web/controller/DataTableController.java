package com.yollweb.org.springboot.cloud.web.controller;



import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import com.yollweb.org.springboot.cloud.utils.BeanUtils;
import com.yollweb.org.springboot.cloud.utils.ExceptionUtils;
import com.yollweb.org.springboot.cloud.utils.StringUtils;
import com.yollweb.org.springboot.cloud.domain.model.BaseEntity;
import com.yollweb.org.springboot.cloud.mybatis.plugin.Page;
import com.yollweb.org.springboot.cloud.mybatis.query.EntityQueryCriteria;
import com.yollweb.org.springboot.cloud.mybatis.query.QueryCriteria;

public abstract class DataTableController extends BaseController {

    protected abstract Class<?> support();

    protected QueryCriteria queryCriteria() {
        QueryCriteria queryCriteria = null;
        HttpServletRequest request = getServletRequest();
        Class<?> clazz = support();
        if (BaseEntity.class.isAssignableFrom(clazz)) {
            try {
                BaseEntity entity = (BaseEntity) clazz.newInstance();
                Field[] fields = BeanUtils.mergeDestClazzFields(clazz, BaseEntity.class);
                for (Field field : fields) {
                    String val = request.getParameter(field.getName());
                    if (StringUtils.isNotBlank(val)) {
                        BeanUtils.setPropertyValue(entity, field.getName(), field.getType().cast(val));
                    }
                }
                queryCriteria = new EntityQueryCriteria(entity);
                queryCriteria.setPage(page());
            } catch (Exception e) {
                logger.error("Cannot new instance with Class:" + clazz.getName(), e);
                throw ExceptionUtils.appException(e);
            }

        }

        return queryCriteria;
    }

    protected Page page() {
        HttpServletRequest request = getServletRequest();
        String pageNumber = request.getParameter("pageNumber");
        String pageSize = request.getParameter("pageSize");
        Page page;
        if (StringUtils.isNotBlank(pageNumber) && StringUtils.isNotBlank(pageSize)) {
            page = new Page(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));
        } else {
            page = new Page();
        }
        return page;
    }
}
