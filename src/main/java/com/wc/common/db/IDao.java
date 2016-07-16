package com.wc.common.db;

import java.io.Serializable;
import java.util.List;

public interface IDao<T extends Serializable, M> {


    int insert(M bean);

    int delete(T id);

    int deleteByEntity(M bean);

    int update(M bean);

    M getEntityById(T id);

    M getEntityByObj(M bean);


    M getEntityByObj(M bean, String where);


    int getCountByObj(M bean);


    int getCountByObj(M bean, String where);


    PagerControl<M> getPagerByObj(M bean, PageInfo pageInfo, String where);


    PagerControl<M> getPagerByObj(M bean, PageInfo pageInfo, String where, String order);


    List<M> getAllEntityObj();


    List<M> getListByObj(M bean);


    List<M> getListByObj(M bean, String where);


    List<M> getListByObj(M bean, String where, String order);


    List<M> getListByObj(M bean, PageInfo var2, String where);


    List<M> getListByObj(M bean, PageInfo pageInfo, String where, String order);


}
