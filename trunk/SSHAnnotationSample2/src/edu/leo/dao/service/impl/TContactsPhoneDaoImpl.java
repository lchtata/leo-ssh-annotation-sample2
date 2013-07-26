package edu.leo.dao.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import edu.leo.common.db.CommonDaoImpl;
import edu.leo.dao.entity.TContactsPhone;
import edu.leo.dao.entity.TContactsPhoneId;
import edu.leo.dao.service.ITContactsPhoneDao;

@Repository
public class TContactsPhoneDaoImpl extends CommonDaoImpl<TContactsPhone, TContactsPhoneId> implements ITContactsPhoneDao {

    public TContactsPhoneDaoImpl() {
        super(TContactsPhone.class);
    }

    public List<TContactsPhone> getDataBySeq(Long contactsSeq) {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);

        hql.append("FROM TContactsPhone ");
        hql.append("WHERE delFlg = '0' ");
        hql.append("AND id.contactsSeq = :contactsSeq ");

        Query query = session.createQuery(hql.toString());

        query.setParameter("contactsSeq", contactsSeq);

        @SuppressWarnings("unchecked")
        List<TContactsPhone> phoneList = query.list();
        return phoneList;
    }

    public void deleteBySeq(Long contactsSeq) {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);

        hql.append("DELETE TContactsPhone ");
        hql.append("WHERE id.contactsSeq = :contactsSeq ");

        Query query = session.createQuery(hql.toString());

        query.setParameter("contactsSeq", contactsSeq);

        query.executeUpdate();
    }
}
