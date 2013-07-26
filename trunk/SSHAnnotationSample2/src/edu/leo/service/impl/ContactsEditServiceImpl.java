package edu.leo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.leo.logic.IContactsEditLogic;
import edu.leo.service.IContactsEditService;
import edu.leo.value.ContactsInfoValue;
import edu.leo.value.LoginInfo;

@Service
public class ContactsEditServiceImpl implements IContactsEditService {

    @Autowired(required = true)
    private IContactsEditLogic contactEditLogic;

    @Transactional(readOnly = true)
    public ContactsInfoValue getContactsEditInfo(Long contactsSeq) throws Exception {
        return contactEditLogic.getContactsEditInfo(contactsSeq);
    }

    @Transactional(readOnly = false, rollbackFor = Throwable.class)
    public void createContactsEditInfo(ContactsInfoValue contactsInfo, LoginInfo loginInfo) throws Exception {
        contactEditLogic.createContactsEditInfo(contactsInfo, loginInfo);
    }

    @Transactional(readOnly = false, rollbackFor = Throwable.class)
    public void updateContactsEditInfo(ContactsInfoValue contactsInfo, LoginInfo loginInfo) throws Exception {
        contactEditLogic.updateContactsEditInfo(contactsInfo, loginInfo);
    }
}
