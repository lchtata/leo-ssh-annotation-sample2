package edu.leo.dao.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import edu.leo.common.db.CommonDaoImpl;
import edu.leo.dao.entity.TContactsHeader;
import edu.leo.dao.service.ITContactsHeaderDao;
import edu.leo.value.ContactsListSearchParam;

@Repository
public class TContactsHeaderDaoImpl extends CommonDaoImpl<TContactsHeader, Long> implements ITContactsHeaderDao {

    public TContactsHeaderDaoImpl() {
        super(TContactsHeader.class);
    }

    public List<TContactsHeader> getAllData(ContactsListSearchParam searchParam) {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);

        hql.append("FROM TContactsHeader ");
        hql.append("WHERE delFlg = '0' ");
        if (!StringUtils.isEmpty(searchParam.getSrchName())) {
            hql.append("AND name LIKE :name ");
        }

        Query query = session.createQuery(hql.toString());

        // 从第N条记录开始
        query.setFirstResult(searchParam.getFirstResult());
        // 设定取出最大记录数
        query.setMaxResults(searchParam.getMaxResult());
        if (!StringUtils.isEmpty(searchParam.getSrchName())) {
            query.setParameter("name", "%" + searchParam.getSrchName() + "%");
        }

        @SuppressWarnings("unchecked")
        List<TContactsHeader> contactsList = query.list();
        return contactsList;
    }

    public Long getAllDataCount(ContactsListSearchParam searchParam) {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);
        hql.append("SELECT COUNT(*) ");
        hql.append("FROM TContactsHeader ");
        hql.append("WHERE delFlg = '0' ");
        if (!StringUtils.isEmpty(searchParam.getSrchName())) {
            hql.append("AND name LIKE :name ");
        }

        Query query = session.createQuery(hql.toString());
        if (!StringUtils.isEmpty(searchParam.getSrchName())) {
            query.setParameter("name", "%" + searchParam.getSrchName() + "%");
        }

        Long count = (Long) query.uniqueResult();

        return count;
    }

    /**
     * left join
     */
    public List<Object[]> getDetailInfo(Long contactsSeq) {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);

        hql.append("SELECT ");
        hql.append("  header,phone ");
        hql.append("FROM ");
        hql.append("  TContactsHeaderJoin AS header ");
        hql.append("  LEFT OUTER JOIN header.phoneInfoSet AS phone ");
        hql.append("WHERE ");
        hql.append("  header.delFlg = '0' ");
        hql.append("  AND header.contactsSeq = :contactsSeq ");

        Query query = session.createQuery(hql.toString());

        query.setParameter("contactsSeq", contactsSeq);

        @SuppressWarnings("unchecked")
        List<Object[]> list = query.list();
        return list;
    }
}
