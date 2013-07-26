package edu.leo.common.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

public final class BeanUtilEx {

    private BeanUtilEx() {
    }

    static {
        // 注册sql.date的转换器，即允许BeanUtils.copyProperties时的源目标的sql类型的值允许为空
        ConvertUtils.register(new SqlDateConverter(), java.util.Date.class);
        // ConvertUtils.register(new SqlDateConverter(), java.sql.Date.class);
        // ConvertUtils.register(new SqlTimestampConverter(),
        // java.sql.Timestamp.class);
        // 注册util.date的转换器，即允许BeanUtils.copyProperties时的源目标的util类型的值允许为空
        ConvertUtils.register(new UtilDateConverter(), java.util.Date.class);
    }

    public static void copyProperties(Object target, Object source) throws InvocationTargetException, IllegalAccessException {
        // update bu zhuzf at 2004-9-29
        // 支持对日期copy

        org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);

    }
}
