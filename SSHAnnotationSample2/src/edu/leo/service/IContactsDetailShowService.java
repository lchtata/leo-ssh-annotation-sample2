package edu.leo.service;

import edu.leo.value.ContactsInfoValue;

public interface IContactsDetailShowService {

    public ContactsInfoValue getDetailInfo(Long contactsSeq) throws Exception;
}
