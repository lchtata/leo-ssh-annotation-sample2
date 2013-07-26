package edu.leo.common.db;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.NamingStrategy;
import org.hibernate.cfg.ObjectNameNormalizer;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.OptimizerFactory;
import org.hibernate.id.enhanced.TableGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import edu.leo.common.exception.SSHSampleException;

public class CommonDaoImpl<T, PK extends Serializable> extends BaseHibernateDao implements ICommonDao<T, PK> {

    /** Log */
    protected Log log = LogFactory.getLog(this.getClass());

    private Class<T> type = null;

    public CommonDaoImpl(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public PK create(T o) {
        checkEntityValue(o, false);
        return (PK) getSession(false).save(o);
    }

    @SuppressWarnings("unchecked")
    public PK create(T o, String userId) {
        Date t = getDbSysdate();
        try {
            o.getClass().getMethod("setInsUserId", new Class[] { String.class }).invoke(o, userId);
            o.getClass().getMethod("setInsDate", new Class[] { Date.class }).invoke(o, t);
            o.getClass().getMethod("setUpdUserId", new Class[] { String.class }).invoke(o, userId);
            o.getClass().getMethod("setUpdDate", new Class[] { Date.class }).invoke(o, t);
            o.getClass().getMethod("setDelFlg", new Class[] { String.class }).invoke(o, "0");
            o.getClass().getMethod("setUpdCnt", new Class[] { Long.class }).invoke(o, Long.valueOf(1L));
        } catch (Exception e) {
            log.info("common column is not exist 。(" + o.toString() + ")");
        }
        checkEntityValue(o, false);
        return (PK) getSession(false).save(o);
    }

    public PK create(T o, long userId) {
        return create(o, userId + "");
    }

    @SuppressWarnings("unchecked")
    public T read(PK id) {
        return (T) getSession(false).get(type, id);
    }

    public T readValid(PK id) {

        T o = read(id);

        if (o != null) {
            String a = null;
            try {
                a = (String) o.getClass().getMethod("getDelFlg").invoke(o);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            if (!"0".equals(a)) {

                log.info("delete flg is open。(" + id.toString() + ")");

                getSession(false).evict(o);
                o = null;
            }
        }

        return o;
    }

    @SuppressWarnings("unchecked")
    public T read(PK id, LockMode mode) {
        return (T) getSession(false).get(type, id, mode);
    }

    public T readOrNew(PK id) {
        T ent = read(id);
        if (ent == null) {
            try {
                ent = type.getConstructor(new Class[] { id.getClass() }).newInstance(id);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return ent;
    }

    public T readOrNew(PK id, LockMode mode) {
        T ent = read(id, mode);
        if (ent == null) {
            try {
                ent = type.getConstructor(new Class[] { id.getClass() }).newInstance(id);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return ent;
    }

    public void update(T o) {
        checkEntityValue(o, false);
        getSession(false).update(o);
    }

    public void update(T o, String userId) {
        Date t = getDbSysdate();
        try {
            o.getClass().getMethod("setUpdUserId", new Class[] { String.class }).invoke(o, userId);
            o.getClass().getMethod("setUpdDate", new Class[] { Date.class }).invoke(o, t);
            Long updCnt = (Long) o.getClass().getMethod("getUpdCnt").invoke(o);
            updCnt = Long.valueOf(updCnt.longValue() + 1);
            o.getClass().getMethod("setUpdCnt", new Class[] { Long.class }).invoke(o, updCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkEntityValue(o, false);
        getSession(false).update(o);
    }

    public void createOrUpdate(T o) {
        checkEntityValue(o, false);
        getSession(false).saveOrUpdate(o);
    }

    public void createOrUpdate(T o, String userId) {
        // セッションキャッシュに存在していれば更新
        if (getSession(false).contains(o)) {
            update(o, userId);
        } else {
            create(o, userId);
        }
    }

    public void deletePhysical(T o) {
        if (o == null) {
            return;
        }
        Session session = getSession(false);

        session.delete(o);
        session.flush();
        session.evict(o);
    }

    @Deprecated
    public void deleteLogical(T o) throws Exception {
        log.error("未実装のため使用しないでください。");
        throw new SSHSampleException("未実装のため使用しないでください。");
    }

    public void deleteLogical(T o, String userId) {
        Date t = getDbSysdate();
        try {
            o.getClass().getMethod("setDelUserId", new Class[] { String.class }).invoke(o, userId);
            o.getClass().getMethod("setDelDate", new Class[] { Date.class }).invoke(o, t);
            o.getClass().getMethod("setDelFlg", new Class[] { String.class }).invoke(o, "1");
            Long updCnt = (Long) o.getClass().getMethod("getUpdCnt").invoke(o);
            updCnt = Long.valueOf(updCnt.longValue() + 1);
            o.getClass().getMethod("setUpdCnt", new Class[] { Long.class }).invoke(o, updCnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkEntityValue(o, false);
        getSession(false).update(o);
    }

    public Class<T> getType() {
        return type;
    }

    public void flush() {
        getSession(false).flush();
    }

    public Date getDbSysdate() {
        return Calendar.getInstance().getTime();
    }

    public Long getSequence(String tableName) throws Exception {
        TableGenerator seq = new TableGenerator();

        // セッションの取得
        Session sess = getSession();
        SessionImplementor impler = (SessionImplementor) sess;

        Dialect dialect = impler.getFactory().getDialect();

        Properties prop = new Properties();
        prop.put(TableGenerator.IDENTIFIER_NORMALIZER, new ObjectNameNormalizer() {

            @Override
            protected boolean isUseQuotedIdentifiersGlobally() {
                return false;
            }

            @Override
            protected NamingStrategy getNamingStrategy() {
                return null;
            }
        });

        prop.put(TableGenerator.SEGMENT_VALUE_PARAM, tableName);

        seq.configure(org.hibernate.type.LongType.class.newInstance(), prop, dialect);

        Long rtnValue = Long.parseLong(seq.generate(impler, null).toString());

        return rtnValue;
    }

    public Long getSequence(String tableName, int increment) throws Exception {
        TableGenerator seq = new TableGenerator();

        Session sess = getSession();
        SessionImplementor impler = (SessionImplementor) sess;

        Dialect dialect = impler.getFactory().getDialect();

        Properties prop = new Properties();
        prop.put(TableGenerator.IDENTIFIER_NORMALIZER, new ObjectNameNormalizer() {

            @Override
            protected boolean isUseQuotedIdentifiersGlobally() {
                return false;
            }

            @Override
            protected NamingStrategy getNamingStrategy() {
                return null;
            }
        });

        prop.put(TableGenerator.SEGMENT_VALUE_PARAM, tableName);

        if (increment > 0) {
            prop.put(TableGenerator.INCREMENT_PARAM, String.valueOf(increment));
            prop.put(TableGenerator.OPT_PARAM, OptimizerFactory.POOL_LO);
        }

        seq.configure(org.hibernate.type.LongType.class.newInstance(), prop, dialect);

        Long rtnValue = Long.parseLong(seq.generate(impler, null).toString());

        return rtnValue;
    }

    protected void checkEntityValue(Object entityObject, boolean checkIdColumnNull) {
        CommonEntityValueCheck cpEntityValueCheck = new CommonEntityValueCheck();
        cpEntityValueCheck.setCheckIdColumnNull(checkIdColumnNull);

        try {
            cpEntityValueCheck.check(entityObject);
        } catch (SSHSampleException e) {
            String msg = "";
            msg += e.getClass().getName();
            msg += ":エンティティのチェック処理により不正値が検出されました。";
            msg += ":" + e.getMessage();
            log.error(msg);

        } catch (Exception e) {
            String msg = "";
            msg += "エンティティのチェック処理で致命的なエラーが発生しました。";
            msg += "この例外は上位層へ throw されません。";
            msg += "この例外によるバッチ処理への影響はありません。";
            log.fatal(msg, e);
        }
    }

    public void clear() {
        getSession(false).clear();
    }

    public void evict(Object entityObject) {
        getSession(false).evict(entityObject);
    }

    public void closeIterator(Iterator<?> it) {

        if (it != null) {
            Hibernate.close(it);
        }
    }

}
