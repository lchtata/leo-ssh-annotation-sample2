package edu.leo.logic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.leo.common.util.BeanUtilEx;
import edu.leo.dao.entity.TContactsHeader;
import edu.leo.dao.service.ITContactsHeaderDao;
import edu.leo.logic.IContactsListLogic;
import edu.leo.value.ContactsListSearchParam;
import edu.leo.value.TContactsHeaderValue;

@Service
public class ContactsListLogicImpl implements IContactsListLogic {

    @Autowired(required = true)
    private ITContactsHeaderDao contactsDao;

    public List<TContactsHeaderValue> getAllContactsData(ContactsListSearchParam searchParam) throws IllegalAccessException, InvocationTargetException {
        List<TContactsHeaderValue> resultList = new ArrayList<TContactsHeaderValue>();
        List<TContactsHeader> entityList = contactsDao.getAllData(searchParam);
        if (entityList != null) {
            for (TContactsHeader entity : entityList) {
                TContactsHeaderValue value = this.entityToValue(entity);
                resultList.add(value);
            }
        }
        return resultList;
    }

    public Long getAllDataCount(ContactsListSearchParam searchParam) {
        Long count = contactsDao.getAllDataCount(searchParam);
        return count;
    }

    private TContactsHeaderValue entityToValue(TContactsHeader entity) throws IllegalAccessException, InvocationTargetException {
        TContactsHeaderValue value = new TContactsHeaderValue();
        BeanUtilEx.copyProperties(value, entity);
        return value;
    }
}
