package edu.leo.common.db;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.LockMode;

public interface ICommonDao<T, PK extends Serializable> {

    void clear();

    void evict(Object entityObject);

    void closeIterator(Iterator<?> it);

    PK create(T newInstance);

    PK create(T newInstance, String userId);

    T read(PK id);

    T readValid(PK id);

    T read(PK id, LockMode mode);

    T readOrNew(PK id);

    T readOrNew(PK id, LockMode mode);

    void update(T transientObject);

    void update(T transientObject, String userId);

    void createOrUpdate(T transientObject);

    void createOrUpdate(T o, String userId);

    void deletePhysical(T persistentObject);

    void deleteLogical(T persistentObject) throws Exception;

    void deleteLogical(T persistentObject, String userId);

    void flush();

    Date getDbSysdate();

    Long getSequence(String tableName) throws Exception;

    Long getSequence(String tableName, int increment) throws Exception;
}
