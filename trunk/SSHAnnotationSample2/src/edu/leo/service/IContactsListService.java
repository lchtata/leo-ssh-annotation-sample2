package edu.leo.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.leo.value.ContactsListSearchParam;
import edu.leo.value.TContactsHeaderValue;

public interface IContactsListService {

    public List<TContactsHeaderValue> getAllContactsData(ContactsListSearchParam searchParam) throws IllegalAccessException, InvocationTargetException;

    public Long getAllContactsDataCount(ContactsListSearchParam searchParam);
}
