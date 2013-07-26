package edu.leo.logic;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import edu.leo.value.ContactsListSearchParam;
import edu.leo.value.TContactsHeaderValue;

public interface IContactsListLogic {

    public List<TContactsHeaderValue> getAllContactsData(ContactsListSearchParam searchParam) throws IllegalAccessException, InvocationTargetException;

    public Long getAllDataCount(ContactsListSearchParam searchParam);
}
