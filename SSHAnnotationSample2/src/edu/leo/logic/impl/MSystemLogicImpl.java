package edu.leo.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.leo.dao.entity.MSystem;
import edu.leo.dao.service.IMSystemDao;
import edu.leo.logic.IMSystemLogic;

@Service
public class MSystemLogicImpl implements IMSystemLogic {

    @Autowired(required = true)
    private IMSystemDao systemDao;

    @Transactional(readOnly = true)
    public List<MSystem> getSystemList() {
        List<MSystem> list = systemDao.getSystemList();
        return list;
    }
}
