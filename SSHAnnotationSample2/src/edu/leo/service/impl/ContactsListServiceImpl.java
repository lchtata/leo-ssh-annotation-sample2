package edu.leo.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.leo.logic.IContactsListLogic;
import edu.leo.service.IContactsListService;
import edu.leo.value.ContactsListSearchParam;
import edu.leo.value.TContactsHeaderValue;

@Service
public class ContactsListServiceImpl implements IContactsListService {

    @Autowired(required = true)
    private IContactsListLogic contactsLogic;

    // @Transactional(readOnly = false, rollbackFor = Throwable.class)
    @Transactional(readOnly = true)
    public List<TContactsHeaderValue> getAllContactsData(ContactsListSearchParam searchParam) throws IllegalAccessException, InvocationTargetException {
        return contactsLogic.getAllContactsData(searchParam);
    }

    @Transactional(readOnly = true)
    public Long getAllContactsDataCount(ContactsListSearchParam searchParam) {
        return contactsLogic.getAllDataCount(searchParam);
    }
}
