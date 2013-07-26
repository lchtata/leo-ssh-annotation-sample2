package edu.leo.dao.service;

import java.util.List;

import edu.leo.common.db.ICommonDao;
import edu.leo.dao.entity.MSystem;

public interface IMSystemDao extends ICommonDao<MSystem, String> {

    public List<MSystem> getSystemList();
}
