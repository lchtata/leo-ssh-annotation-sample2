package edu.leo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

public final class UtilDateConverter implements Converter {

    @Override
    public Object convert(Class paramClass, Object paramObject) {
        if (paramObject == null) {
            return null;
        }
        String p = null;
        if (paramObject instanceof String) {
            p = (String) paramObject;
        } else {
            p = paramObject.toString();
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.parse(p.trim());
        } catch (Exception e) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                return df.parse(p.trim());
            } catch (ParseException ex) {
                return null;
            }
        }
    }

}
