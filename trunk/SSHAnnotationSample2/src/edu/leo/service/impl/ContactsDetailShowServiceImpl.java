package edu.leo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.leo.logic.IContactsDetailShowLogic;
import edu.leo.service.IContactsDetailShowService;
import edu.leo.value.ContactsInfoValue;

@Service
public class ContactsDetailShowServiceImpl implements IContactsDetailShowService {

    @Autowired(required = true)
    private IContactsDetailShowLogic detailShowLogic;

    @Transactional(readOnly = true)
    public ContactsInfoValue getDetailInfo(Long contactsSeq) throws Exception {
        return detailShowLogic.getDetailInfo(contactsSeq);
    }
}
