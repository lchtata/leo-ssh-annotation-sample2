package edu.leo.common.db;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.leo.common.exception.SSHSampleException;

public class CommonEntityValueCheck {

    private static final Set<String> cpCommonColumnsDefine;
    static {
        Set<String> set = new HashSet<String>();
        set.add("ins_date");
        set.add("ins_user_id");
        set.add("upd_date");
        set.add("upd_user_id");
        set.add("del_date");
        set.add("del_user_id");
        set.add("del_flg");
        set.add("upd_cnt");

        cpCommonColumnsDefine = Collections.unmodifiableSet(set);
    }

    private boolean checkIdColumnNull;

    private boolean checkCpCommonColumns;

    public CommonEntityValueCheck() {
        super();
        this.checkIdColumnNull = true;
        this.checkCpCommonColumns = false;
    }

    public void check(Object entityObject) throws SSHSampleException {
        Class<?> cls = entityObject.getClass();
        Table annTable = cls.getAnnotation(Table.class);
        if (annTable == null) {
            throw new IllegalArgumentException("@javax.persistence.Table が付与されていません。");
        }

        check(entityObject, annTable);
    }

    private void check(Object entityObject, Table annTable) throws SSHSampleException {
        Class<?> cls = entityObject.getClass();
        Entity annEntity = cls.getAnnotation(Entity.class);
        Embeddable annEmbeddable = cls.getAnnotation(Embeddable.class);
        if (annEntity == null && annEmbeddable == null) {
            throw new IllegalArgumentException("@javax.persistence.Entity または @javax.persistence.Embeddable が付与されていません。");
        }

        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            String methodName = method.getName();
            if (!methodName.startsWith("get"))
                continue;

            Class<?>[] params = method.getParameterTypes();
            if (params.length != 0)
                continue;

            EmbeddedId annEmbeddedId = method.getAnnotation(EmbeddedId.class);
            if (annEmbeddedId != null) {
                if (!methodName.equals("getId"))
                    continue;

                Object idObject = null;
                try {
                    idObject = method.invoke(entityObject);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

                if (idObject != null) {
                    check(idObject, annTable);
                }

            } else {
                Column annColumn = method.getAnnotation(Column.class);
                if (annColumn == null)
                    continue;

                if (!isCheckCpCommonColumns() && isCpCommonColumn(annColumn.name()))
                    continue;

                Object columnValue = null;
                try {
                    columnValue = method.invoke(entityObject);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

                Id annId = method.getAnnotation(Id.class);
                boolean idColumn = (annId != null) || (annEmbeddable != null);
                check(columnValue, annColumn, annTable, idColumn);
            }
        }
    }

    private void check(Object columnValue, Column annColumn, Table annTable, boolean idColumn) throws SSHSampleException {

        if (idColumn) {
            if (isCheckIdColumnNull()) {
                checkNull(columnValue, annColumn, annTable);
            }
        } else {
            checkNull(columnValue, annColumn, annTable);
        }

        if (columnValue != null) {
            checkLength(columnValue, annColumn, annTable);
        }
    }

    private void checkNull(Object columnValue, Column annColumn, Table annTable) throws SSHSampleException {
        String tableName = annTable.name();
        String columnName = annColumn.name();
        boolean nullable = annColumn.nullable();

        if (!nullable && columnValue == null) {
            String msg = "";
            msg += tableName + "." + columnName + " は not null です。";
            throw new SSHSampleException(msg);
        }
    }

    private void checkLength(Object columnValue, Column annColumn, Table annTable) throws SSHSampleException {
        String tableName = annTable.name();
        String columnName = annColumn.name();
        int columnLength = annColumn.length();
        int columnPrecision = annColumn.precision();
        // int columnScale = annColumn.scale();

        if (columnValue instanceof String) {
            String strValue = (String) columnValue;
            if (columnLength > 0 && strValue.length() > columnLength) {
                String msg = "";
                msg += tableName + "." + columnName + " の桁数が規定値を超えています。";
                msg += "length=" + columnLength + ", value=" + strValue;
                throw new SSHSampleException(msg);
            }
        } else if (columnValue instanceof Integer) {
            Integer intValue = (Integer) columnValue;
            int absInt = Math.abs(intValue.intValue());
            String strAbsInt = Integer.toString(absInt);
            if (columnPrecision > 0 && strAbsInt.length() > columnPrecision) {
                String msg = "";
                msg += tableName + "." + columnName + " の桁数が規定値を超えています。";
                msg += "length=" + columnPrecision + ", value=" + intValue;
                throw new SSHSampleException(msg);
            }
        } else if (columnValue instanceof Long) {
            Long longValue = (Long) columnValue;
            long absLong = Math.abs(longValue.longValue());
            String strAbsLong = Long.toString(absLong);
            if (columnPrecision > 0 && strAbsLong.length() > columnPrecision) {
                String msg = "";
                msg += tableName + "." + columnName + " の桁数が規定値を超えています。";
                msg += "length=" + columnPrecision + ", value=" + longValue;
                throw new SSHSampleException(msg);
            }
        } else if (columnValue instanceof Number) {
        } else if (columnValue instanceof Date) {
        } else {
        }
    }

    private boolean isCpCommonColumn(String columnName) {
        return cpCommonColumnsDefine.contains(columnName);
    }

    public boolean isCheckIdColumnNull() {
        return checkIdColumnNull;
    }

    public void setCheckIdColumnNull(boolean checkIdColumnNull) {
        this.checkIdColumnNull = checkIdColumnNull;
    }

    public boolean isCheckCpCommonColumns() {
        return checkCpCommonColumns;
    }

    public void setCheckCpCommonColumns(boolean checkCpCommonColumns) {
        this.checkCpCommonColumns = checkCpCommonColumns;
    }

}
