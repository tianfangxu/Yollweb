package com.yollweb.org.springboot.cloud.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yollweb.org.springboot.cloud.conf.properties.AppProperties;
import com.yollweb.org.springboot.cloud.ctx.AppContext;
import com.yollweb.org.springboot.cloud.id.IdGenerator;
import com.yollweb.org.springboot.cloud.utils.StringUtils;
import com.yollweb.org.springboot.cloud.domain.mapper.BaseMapper;
import com.yollweb.org.springboot.cloud.domain.model.BaseEntity;
import com.yollweb.org.springboot.cloud.mybatis.plugin.Page;
import com.yollweb.org.springboot.cloud.mybatis.query.QueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public class CrudService<M extends BaseMapper<T>, T extends BaseEntity> extends BaseService {
	

    @Autowired
    protected AppProperties appProperties;

    @Autowired
    protected IdGenerator idGenerator;

    @Autowired
    protected M mapper;

    @Transactional(readOnly = false)
    public Long saveOrUpdate(T entity) {
        if (entity.getId() == null) {
            return insert(entity);
        } else {
            updateById(entity);
            return entity.getId();
        }
    }

    /**
     *
     * @param entity
     * @return
     */
    @Transactional(readOnly = false)
    public Long insert(T entity) {
        if (StringUtils.isNotBlank(appProperties.getDbid())) {
            entity.setId(idGenerator.genId());
        }
        entity.setCreateUser(AppContext.getCurrUserId());
        entity.setCreateDate(new Date());
        return mapper.insert(entity);
    }

    /**
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    public void deleteById(Serializable id) {
        mapper.deleteById(id);
    }

    /**
     *
     * @param columnMap
     * @return
     */
    @Transactional(readOnly = false)
    public void deleteByMap(Map<String, Object> columnMap) {
        mapper.deleteByMap(columnMap);
    }

    /**
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        mapper.delete(entity);
    }

    /**
     *
     * @param idList
     */
    @Transactional(readOnly = false)
    public void deleteByIdList(List<? extends Serializable> idList) {
        mapper.deleteByIdList(idList);
    }

    /**
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public void updateById(T entity) {
        entity.setUpdateUser(AppContext.getCurrUserId());
        entity.setUpdateDate(new Date());
        mapper.updateById(entity);
    }

    /**
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public void update(T entity) {
        entity.setUpdateUser(AppContext.getCurrUserId());
        entity.setUpdateDate(new Date());
        mapper.update(entity);
    }

    /**
     *
     * @param id
     * @return
     */
    public T selectById(Serializable id) {
        return mapper.selectById(id);
    }

    /**
     *
     * @param columnMap
     * @return
     */
    public List<T> selectByMap(Map<String, Object> columnMap) {
        return mapper.selectByMap(columnMap);
    }
    
    /**
    *
    * @param columnMap
    * @return
    */
   public List<T> selectByMap(Map<String, Object> columnMap,HttpServletRequest request) {
       return mapper.selectByMap(columnMap);
   }

    /**
     *
     * @param idList
     * @return
     */
    public List<T> selectByIdList(List<? extends Serializable> idList) {
        return mapper.selectByIdList(idList);
    }

    /**
     *
     * @param entity
     * @return
     */
    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    /**
     *
     * @param entity
     * @return
     */
    public Integer selectCount(T entity) {
        return mapper.selectCount(entity);
    }

    /**
     *
     * @param entity
     * @return
     */
    public List<T> selectList(T entity) {
        return mapper.selectList(entity);
    }

    /**
     *
     * @param criteria
     * @return
     */
    public T selectOne(QueryCriteria criteria) {
        return mapper.selectOneByCriteria(criteria);
    }

    /**
     *
     * @param criteria
     * @return
     */
    public Integer selectCount(QueryCriteria criteria) {
        return mapper.selectCountByCriteria(criteria);
    }

    /**
     *
     * @param criteria
     * @return
     */
    public List<T> selectList(QueryCriteria criteria) {
        return mapper.selectListByCriteria(criteria);
    }

    /**
     *
     * @param page
     * @param entity
     * @return
     */
    public Page<T> selectPage(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(mapper.selectList(entity));
        return page;
    }

    public Page<T> selectPage(QueryCriteria criteria) {
        Page page = criteria.getPage();
        page.setList(mapper.selectListByCriteria(criteria));
        return page;
    }
    
    @Transactional(readOnly = false)
    public void updateByIdFor(T entity) {
    	if(entity.getUpdateUser() == null) {
            entity.setUpdateUser(AppContext.getCurrUserId());
    	}
    	if(entity.getUpdateDate() == null) {
            entity.setUpdateDate(new Date());
    	}
        mapper.updateById(entity);
    }
	
	
	@Transactional(readOnly = false)
    public Long saveOrUpdateFor(T entity) {
        if (entity.getId() == null) {
            return insert(entity);
        } else {
            updateById(entity);
            return entity.getId();
        }
    }

    /**
     *
     * @param entity
     * @return
     */
    @Transactional(readOnly = false)
    public Long insertFor(T entity) {
    	if(entity.getCreateUser() == null) {
    		entity.setCreateUser(AppContext.getCurrUserId());
    	}
    	if(entity.getCreateDate() == null) {
    		entity.setCreateDate(new Date());
    	}
        
        return mapper.insert(entity);
    }

}
