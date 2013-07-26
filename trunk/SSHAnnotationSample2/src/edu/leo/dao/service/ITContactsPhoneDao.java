package edu.leo.dao.service;

import java.util.List;

import edu.leo.common.db.ICommonDao;
import edu.leo.dao.entity.TContactsPhone;
import edu.leo.dao.entity.TContactsPhoneId;

public interface ITContactsPhoneDao extends ICommonDao<TContactsPhone, TContactsPhoneId> {

    public List<TContactsPhone> getDataBySeq(Long contactsSeq);

    public void deleteBySeq(Long contactsSeq);
}
