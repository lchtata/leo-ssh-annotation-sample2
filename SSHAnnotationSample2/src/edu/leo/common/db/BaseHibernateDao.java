package edu.leo.common.db;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseHibernateDao {

    private SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired(required = true)
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Deprecated
    protected Session getSession(boolean allowCreate) {
        return getSession();
    }
}
