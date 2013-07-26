package edu.leo.dao.service;

import java.util.List;

import edu.leo.common.db.ICommonDao;
import edu.leo.dao.entity.TContactsHeader;
import edu.leo.value.ContactsListSearchParam;

public interface ITContactsHeaderDao extends ICommonDao<TContactsHeader, Long> {

    public List<TContactsHeader> getAllData(ContactsListSearchParam searchParam);

    public Long getAllDataCount(ContactsListSearchParam searchParam);

    public List<Object[]> getDetailInfo(Long contactsSeq);
}
