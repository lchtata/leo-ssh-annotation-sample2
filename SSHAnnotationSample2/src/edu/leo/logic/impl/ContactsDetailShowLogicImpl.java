package edu.leo.logic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.leo.common.util.BeanUtilEx;
import edu.leo.dao.entity.TContactsHeaderJoin;
import edu.leo.dao.entity.TContactsPhone;
import edu.leo.dao.service.ITContactsHeaderDao;
import edu.leo.logic.IContactsDetailShowLogic;
import edu.leo.value.ContactsInfoValue;
import edu.leo.value.TContactsHeaderValue;
import edu.leo.value.TContactsPhoneValue;

@Service
public class ContactsDetailShowLogicImpl implements IContactsDetailShowLogic {

    @Autowired(required = true)
    private ITContactsHeaderDao contactsDao;

    public ContactsInfoValue getDetailInfo(Long contactsSeq) throws Exception {
        ContactsInfoValue result = new ContactsInfoValue();
        List<Object[]> entityList = contactsDao.getDetailInfo(contactsSeq);
        if (entityList != null) {
            List<TContactsPhoneValue> phoneList = new ArrayList<TContactsPhoneValue>();
            for (Object entityAry[] : entityList) {
                TContactsHeaderJoin headerEntity = (TContactsHeaderJoin) entityAry[0];
                TContactsPhone phoneEntity = (TContactsPhone) entityAry[1];
                TContactsHeaderValue headerInfo = this.headerEntityToValue(headerEntity);
                if (result.getHeaderInfo() == null) {
                    result.setHeaderInfo(headerInfo);
                }
                if (phoneEntity != null) {
                    TContactsPhoneValue phoneInfo = this.phoneEntityToValue(phoneEntity);
                    phoneList.add(phoneInfo);
                }
            }
            result.setPhoneList(phoneList);
        }
        return result;
    }

    private TContactsHeaderValue headerEntityToValue(TContactsHeaderJoin entity) throws IllegalAccessException, InvocationTargetException {
        TContactsHeaderValue value = new TContactsHeaderValue();
        BeanUtilEx.copyProperties(value, entity);
        return value;
    }

    private TContactsPhoneValue phoneEntityToValue(TContactsPhone entity) throws IllegalAccessException, InvocationTargetException {
        TContactsPhoneValue value = new TContactsPhoneValue();
        BeanUtilEx.copyProperties(value, entity);
        value.setContactsSeq(entity.getId().getContactsSeq());
        value.setPhoneType(entity.getId().getPhoneType());
        return value;
    }
}
