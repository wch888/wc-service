package com.wc.base.service;

import com.wc.base.bean.BasisCity;
import com.wc.base.dao.BasisCityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 地域管理 server
 */
@Service
public class BasisCityService {

    //缓存
    private static Map<Long, List<BasisCity>> cache = new LinkedHashMap();
    private static Map<Long, BasisCity> cacheById = new LinkedHashMap();

    @Autowired
    private BasisCityDao basisCityDao;

    /**
     * 根据地域ID获得地域对象
     *
     * @param id
     * @return 查找不到返回null
     */
    public BasisCity getById(long id) {
        BasisCity city = cacheById.get(id);
        if (city != null) {
            return city;
        }
        if (city == null) {
            city = basisCityDao.getEntityById(id);
            cacheById.put(id, city);
        }
        return city;
    }

    /**
     * 通过上级编码地域
     *
     * @param parentid
     */
    public List<BasisCity> getAreasByParentId(long parentid) {
        if (cache.get(parentid) != null) {
            return cache.get(parentid);
        }
        BasisCity city = new BasisCity();
        city.setCityParent(parentid);
        List<BasisCity> list = basisCityDao.getListByObj(city);
        cache.put(parentid, list);
        return list;
    }

}
