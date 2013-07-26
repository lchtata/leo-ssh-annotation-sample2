package edu.leo.logic;

import edu.leo.value.ContactsInfoValue;

public interface IContactsDetailShowLogic {

    public ContactsInfoValue getDetailInfo(Long contactsSeq) throws Exception;
}
