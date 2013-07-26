package edu.leo.dao.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import edu.leo.common.db.CommonDaoImpl;
import edu.leo.dao.entity.MSystem;
import edu.leo.dao.service.IMSystemDao;

@Repository
public class MSystemDaoImpl extends CommonDaoImpl<MSystem, String> implements IMSystemDao {

    public MSystemDaoImpl() {
        super(MSystem.class);
    }

    public List<MSystem> getSystemList() {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);

        hql.append("FROM MSystem ");
        hql.append("WHERE delFlg = '0' ");
        hql.append("ORDER BY sysKey ");

        Query query = session.createQuery(hql.toString());

        @SuppressWarnings("unchecked")
        List<MSystem> list = query.list();
        return list;
    }
}
