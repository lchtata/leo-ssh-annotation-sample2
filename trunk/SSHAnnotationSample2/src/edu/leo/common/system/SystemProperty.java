package edu.leo.common.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.leo.dao.entity.MSystem;
import edu.leo.logic.IMSystemLogic;

public class SystemProperty {

    private boolean isLoadProFileFlg = true;

    private static Map<String, String> systemPropertyMap = new LinkedHashMap<String, String>();

    private static final String INIT_PROPERTY_NAME = "system-manager.init.properties";

    /** Log */
    protected Log log = LogFactory.getLog(this.getClass());

    @Autowired(required = true)
    private IMSystemLogic systemLogic;

    /**
     * run by spring framework<br>
     * see[applicationContext.xml]
     */
    public void init() {
        log.info("■■■■■■system properties init start■■■■■■");

        systemPropertyMap.clear();

        if (systemLogic == null) {
            log.error("there is no system logic class..");
        } else {

            List<MSystem> list = systemLogic.getSystemList();

            for (MSystem entity : list) {
                String key = entity.getSysKey();
                String val = entity.getSysVal();
                if (!systemPropertyMap.containsKey(key)) {
                    systemPropertyMap.put(key, val);
                }
            }
        }

        if (isLoadProFileFlg) {
            loadFromProperties();
        }

        log.info("■■■■■■system properties init end■■■■■■");
    }

    public static String getProperty(String key) {
        return systemPropertyMap.get(key);
    }

    public static String getProperty(String key, String defaultValue) {
        String result = null;
        String value = getProperty(key);
        if (StringUtils.isEmpty(value)) {
            result = defaultValue;
        } else {
            result = value;
        }
        return result;
    }

    private void loadFromProperties() {
        InputStream is = null;

        try {
            Properties prop = new Properties();

            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(INIT_PROPERTY_NAME);

            if (is != null) {
                prop.load(is);
            } else {
                log.warn("there is no " + INIT_PROPERTY_NAME + " files");
                return;
            }

            Set<Object> keys = prop.keySet();

            for (Iterator<Object> it = keys.iterator(); it.hasNext();) {
                String key = it.next().toString();
                String val = prop.getProperty(key);
                if (!systemPropertyMap.containsKey(key)) {
                    systemPropertyMap.put(key, val);
                }
            }

        } catch (IOException ioe) {
            log.error(INIT_PROPERTY_NAME, ioe);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                log.error(INIT_PROPERTY_NAME, ioe);
            }
        }
    }

    public static Map<String, String> getSystemPropertyMap() {
        Map<String, String> resultMap = Collections.unmodifiableMap(systemPropertyMap);
        return resultMap;
    }
}
