/**
 *
 */
package com.wc.base.service;

import com.wc.base.bean.Setting;
import com.wc.base.dao.SettingDao;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 配置实现类
 */
@Service
public class SettingService {

    public static final String HOUSE_TYPE = "houseType";
    public static final String CLUE_STATUS = "clueStatus";
    public static final String INTEGRATION_LOG_TYPE = "integrationLogType";
    /**
     * 缓存
     */
    private static Map<String, Setting> cache = new HashMap<String, Setting>();
    private static Map<String, Map<String, String>> condition = new HashMap<String, Map<String, String>>();

    static {

        Map<String, String> houseType = new LinkedHashMap();
        houseType.put("0", "不限");
        houseType.put("1", "一居");
        houseType.put("2", "二居");
        houseType.put("3", "三居");
        houseType.put("4", "四居");
        houseType.put("5", "五居");
        houseType.put("6", "五居以上");
        condition.put(HOUSE_TYPE, houseType);

        Map<String, String> clueStatus = new LinkedHashMap();
        clueStatus.put("1", "置业顾问跟进中");
        clueStatus.put("2", "交易成功");
        clueStatus.put("-1", "交易失败");
        clueStatus.put("-2", "线索无效");
        condition.put(CLUE_STATUS, clueStatus);

        Map<String, String> integrationLogType = new LinkedHashMap();
        integrationLogType.put("buy", "兑换商品");
        integrationLogType.put("clue", "全民经纪人");
        integrationLogType.put("reg", "注册万昌会");
        integrationLogType.put("share", "分享赢积分");
        condition.put(INTEGRATION_LOG_TYPE, integrationLogType);
    }

    public Map<String, Map<String, String>> getAllCondition() {
        return condition;
    }

    public Map<String, String> getCondition(String code) {
        return condition.get(code);
    }

    @Autowired
    SettingDao settingDao;

    /**
     * 初始化，清空缓存
     */
    public void init() {
        if (cache.size() > 0) {
            cache.clear();
        }
    }
    public Setting getByCode(String code) {
        Setting setting = cache.get(code);
        if (null != setting) {
            return setting;
        }
        Setting query = new Setting();
        query.setCode(code);
        setting = settingDao.getEntityByObj(query);
        cache.put(setting.getCode(), setting);
        return setting;
    }

    public String getString(String code, String defaultValue) {
        Setting setting = getByCode(code);
        return null == setting ? defaultValue : setting.getContent();
    }

    public JSONObject getJSONObject(String code) {
        Setting setting = getByCode(code);
        if(null==setting|| StringUtils.isBlank(setting.getContent())){
            return null;
        }
        JSONObject json = JSONObject.fromObject(setting.getContent());
        return json;
    }

    public Integer getInt(String code, int defaultValue) {
        Setting setting = getByCode(code);
        return null == setting ? defaultValue : NumberUtils.toInt(setting.getContent());
    }

    public int insert(String code,String name, String content) {
        if (cache.size() > 0) {
            cache.clear();
        }
        Setting setting = new Setting();
        setting.setCode(code);
        setting.setContent(content);
        setting.setCreateTime(new Date());
        setting.setName(name);
        return settingDao.insert(setting);
    }

    public int update(String code,String content) {
        Setting setting = this.getByCode(code);
        if (cache.size() > 0) {
            cache.clear();
        }

        Setting update = new Setting();
        update.setId(setting.getId());
        update.setContent(content);
        return settingDao.update(update);
    }
}
