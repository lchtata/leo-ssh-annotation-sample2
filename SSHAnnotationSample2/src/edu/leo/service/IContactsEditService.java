package edu.leo.service;

import edu.leo.value.ContactsInfoValue;
import edu.leo.value.LoginInfo;

public interface IContactsEditService {

    public ContactsInfoValue getContactsEditInfo(Long contactsSeq) throws Exception;

    public void createContactsEditInfo(ContactsInfoValue contactsInfo, LoginInfo loginInfo) throws Exception;

    public void updateContactsEditInfo(ContactsInfoValue contactsInfo, LoginInfo loginInfo) throws Exception;
}
