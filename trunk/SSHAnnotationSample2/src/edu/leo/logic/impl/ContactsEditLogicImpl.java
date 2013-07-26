package edu.leo.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.leo.common.exception.SSHSampleException;
import edu.leo.common.util.BeanUtilEx;
import edu.leo.common.util.DateUtil;
import edu.leo.dao.entity.TContactsHeader;
import edu.leo.dao.entity.TContactsPhone;
import edu.leo.dao.entity.TContactsPhoneId;
import edu.leo.dao.service.ITContactsHeaderDao;
import edu.leo.dao.service.ITContactsPhoneDao;
import edu.leo.logic.IContactsEditLogic;
import edu.leo.value.ContactsInfoValue;
import edu.leo.value.LoginInfo;
import edu.leo.value.TContactsHeaderValue;
import edu.leo.value.TContactsPhoneValue;

@Service
public class ContactsEditLogicImpl implements IContactsEditLogic {

    /** Log */
    // private Log log = LogFactory.getLog(this.getClass());

    @Autowired(required = true)
    private ITContactsHeaderDao contactHeaderDao;

    @Autowired(required = true)
    private ITContactsPhoneDao contactPhoneDao;

    public ContactsInfoValue getContactsEditInfo(Long contactsSeq) throws Exception {

        ContactsInfoValue result = new ContactsInfoValue();

        // header search
        TContactsHeader headerEntity = contactHeaderDao.readValid(contactsSeq);
        // hedaer info : entity -> value
        TContactsHeaderValue headerInfo = new TContactsHeaderValue();
        BeanUtilEx.copyProperties(headerInfo, headerEntity);
        result.setHeaderInfo(headerInfo);

        // phone list search
        List<TContactsPhone> phoneEntityList = contactPhoneDao.getDataBySeq(contactsSeq);
        // phoneList info : entity -> value
        List<TContactsPhoneValue> phoneInfoList = new ArrayList<TContactsPhoneValue>();
        if (phoneEntityList != null) {
            for (TContactsPhone phoneEntity : phoneEntityList) {
                TContactsPhoneValue phoneInfo = new TContactsPhoneValue();
                BeanUtilEx.copyProperties(phoneInfo, phoneEntity);
                phoneInfo.setContactsSeq(phoneEntity.getId().getContactsSeq());
                phoneInfo.setPhoneType(phoneEntity.getId().getPhoneType());
                phoneInfoList.add(phoneInfo);
            }
            result.setPhoneList(phoneInfoList);
        }

        return result;
    }

    public void createContactsEditInfo(ContactsInfoValue contactsInfo, LoginInfo loginInfo) throws Exception {

        // hedaer info : value -> entity
        TContactsHeader headerEntity = new TContactsHeader();
        TContactsHeaderValue headerInfo = contactsInfo.getHeaderInfo();
        BeanUtilEx.copyProperties(headerEntity, headerInfo);
        headerEntity.setName(headerInfo.getNameFamily() + "　" + headerInfo.getNameGiven());
        headerEntity.setLastUpdateDate(DateUtil.getCurrentDate());

        // header insert
        Long contactsSeq = contactHeaderDao.create(headerEntity, loginInfo.getUserId() + "");

        // phoneList info : value -> entity
        if (contactsInfo.getPhoneList() != null) {
            for (TContactsPhoneValue phoneInfo : contactsInfo.getPhoneList()) {
                TContactsPhone phoneEntity = new TContactsPhone();
                BeanUtilEx.copyProperties(phoneEntity, phoneInfo);
                TContactsPhoneId id = new TContactsPhoneId();
                id.setContactsSeq(contactsSeq);
                id.setPhoneType(phoneInfo.getPhoneType());
                phoneEntity.setId(id);
                contactPhoneDao.create(phoneEntity, loginInfo.getUserId() + "");
            }
        }

    }

    public void updateContactsEditInfo(ContactsInfoValue contactsInfo, LoginInfo loginInfo) throws Exception {

        // hedaer info : update
        TContactsHeader headerEntity = contactHeaderDao.read(contactsInfo.getHeaderInfo().getContactsSeq());
        TContactsHeaderValue headerInfo = contactsInfo.getHeaderInfo();

        // 排他check
        if (headerEntity.getUpdCnt().longValue() != headerInfo.getUpdCnt().longValue()) {
            throw new SSHSampleException("排他error");
        }
        BeanUtilEx.copyProperties(headerEntity, headerInfo);
        headerEntity.setName(headerInfo.getNameFamily() + "　" + headerInfo.getNameGiven());
        headerEntity.setLastUpdateDate(DateUtil.getCurrentDate());
        headerEntity.setDelFlg("0");

        // header update
        contactHeaderDao.update(headerEntity, loginInfo.getUserId() + "");

        // phoneList info : value -> entity
        if (contactsInfo.getPhoneList() != null) {
            // delete - insert
            contactPhoneDao.deleteBySeq(headerInfo.getContactsSeq());
            for (TContactsPhoneValue phoneInfo : contactsInfo.getPhoneList()) {
                TContactsPhone phoneEntity = new TContactsPhone();
                BeanUtilEx.copyProperties(phoneEntity, phoneInfo);
                TContactsPhoneId id = new TContactsPhoneId();
                id.setContactsSeq(headerInfo.getContactsSeq());
                id.setPhoneType(phoneInfo.getPhoneType());
                phoneEntity.setId(id);
                contactPhoneDao.create(phoneEntity, loginInfo.getUserId() + "");
            }
        }

    }
}
