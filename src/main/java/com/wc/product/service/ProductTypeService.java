package com.wc.product.service;

import com.wc.product.bean.ProductType;
import com.wc.product.dao.ProductTypeDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by rubi on 14-12-29.
 */
@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    public long add(ProductType product) {
        productTypeDao.insert(product);
        return product.getId();
    }

    public int update(ProductType product) {
        return productTypeDao.update(product);
    }

    public int delete(long id) {
        return productTypeDao.delete(id);
    }

    public List<ProductType> list(long pid) {
        ProductType query = new ProductType();
        query.setPid(pid);
        List<ProductType> list = productTypeDao.getListByObj(query, "", "order by id asc");
        return list;
    }


    public JSONObject groupByBuilding(long pid) {
        LinkedHashMap<String, List<ProductType>> map = new LinkedHashMap();
        List<ProductType> list = this.list(pid);


        for (ProductType productType : list) {
            String key = productType.getBuilding();
            if (StringUtils.isNotBlank(key)) {
                boolean contain = map.containsKey(key);
                if (contain) {
                    map.get(key).add(productType);
                } else {
                    List<ProductType> value = new ArrayList<ProductType>();
                    value.add(productType);
                    map.put(key, value);
                }

            }
        }
        JSONObject json = new JSONObject();
        JSONArray name = new JSONArray();
        JSONArray building = new JSONArray();
        for (String key : map.keySet()) {
            name.add(key);
            building.add(map.get(key));
        }
        json.put("name", name);
        json.put("building", building);
        return json;
    }

}
