package com.wc.common.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T extends Serializable, M> extends SqlSessionDaoSupport implements IDao<T, M> {
    public static final String insertSelective = ".insertSelective";
    public static final String updateSelective = ".updateByPrimaryKeySelective";
    public static final String selectByPrimaryKey = ".selectByPrimaryKey";
    public static final String selectByPrimaryKeys = ".selectByPrimaryKeys";
    public static final String getListByEntityAndPageInfo = ".getListByEntityAndPageInfo";
    public static final String getTotalByEntity = ".getTotalByEntity";
    public static final String deleteByPrimaryKey = ".deleteByPrimaryKey";
    public static final String deleteByEntity = ".deleteByEntity";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Class<M> curClassType = null;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public String getMapperNameSpace() {
        return getClass().getName();
    }

    public Map<String, Object> getMapParams(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        HashMap map = new HashMap();
        if (null != entity) {
            map.put("entity", entity);
        }

        if (null != pageInfo) {
            map.put("pageInfo", pageInfo);
        }

        if (null != whereSql) {
            map.put("whereSql", whereSql);
        }

        if (null != orderBySql) {
            map.put("orderBy", orderBySql);
        }

        return map;
    }

    public int insert(M entity) {
        return this.getSqlSession().insert(this.getMapperNameSpace() + ".insertSelective", entity);
    }

    public int update(M entity) {

        return this.getSqlSession().update(this.getMapperNameSpace() + ".updateByPrimaryKeySelective", entity);
    }

    public int delete(T pk) {
        return this.getSqlSession().delete(this.getMapperNameSpace() + ".deleteByPrimaryKey", pk);
    }

    public int deleteByEntity(M entity) {
        return this.getSqlSession().delete(this.getMapperNameSpace() + ".deleteByEntity", entity);
    }

    public M getEntityById(T pk) {
        M returnObj = (M) this.getSqlSession().selectOne(this.getMapperNameSpace() + ".selectByPrimaryKey", pk);

        return returnObj;
    }

    public M getEntityByObj(M entity) {
        return (M) this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, (PageInfo) null, null, (String) null));
    }

    public M getEntityByObj(M entity, String where) {
        return (M) this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, (PageInfo) null, where, (String) null));
    }


    public int getCountByObj(M entity) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntity", this.getMapParams(entity, (PageInfo) null, null, (String) null));
        return ((Integer) e).intValue();
    }

    public int getCountByObj(M entity, String where) {
        Object e = this.getSqlSession().selectOne(this.getMapperNameSpace() + ".getTotalByEntity", this.getMapParams(entity, (PageInfo) null, where, (String) null));
        return ((Integer) e).intValue();
    }


    public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo, String whereSql) {
        return getPagerByObj(entity, pageInfo, whereSql, null);
    }

    public PagerControl<M> getPagerByObj(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        PagerControl pagerControl = new PagerControl();
        Object list = new ArrayList();
        boolean total = false;

        int total1 = this.getCountByObj(entity, whereSql);
        if (total1 > 0) {
            list = this.getListByObj(entity, pageInfo, whereSql, orderBySql);
        }
        if(null!=pageInfo){
            pageInfo.setTotalCounts(total1);
        }
        if (list != null) {
            pagerControl.setEntityList((List) list);
        }

        pagerControl.setPageInfo(pageInfo);
        return pagerControl;
    }


    public List<M> getAllEntityObj() {
        return this.getListByObj((M) null, (String) null);
    }


    public List<M> getListByObj(M entity) {
        return this.getListByObj(entity, (PageInfo) null, (String) null, (String) null, false);
    }

    public List<M> getListByObj(M entity, boolean isMainDS) {
        return this.getListByObj(entity, (PageInfo) null, (String) null, (String) null, isMainDS);
    }

    public List<M> getListByObj(M entity, String whereSql) {
        return this.getListByObj(entity, (PageInfo) null, whereSql, (String) null, false);
    }


    /**
     * @deprecated
     */
    @Deprecated
    public List<M> getListByObj(M entity, String whereSql, String orderBySql) {
        return this.getListByObj(entity, (PageInfo) null, whereSql, orderBySql, false);
    }

    public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql) {
        return this.getListByObj(entity, pageInfo, whereSql, (String) null, false);
    }

    public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql, String orderBySql) {
        return this.getListByObj(entity, pageInfo, whereSql, orderBySql, false);
    }

    public List<M> getListByObj(M entity, PageInfo pageInfo, String whereSql, String orderBySql, boolean isMainDS) {
        return this.getSqlSession().selectList(this.getMapperNameSpace() + ".getListByEntityAndPageInfo", this.getMapParams(entity, pageInfo, whereSql, orderBySql));
    }
}
