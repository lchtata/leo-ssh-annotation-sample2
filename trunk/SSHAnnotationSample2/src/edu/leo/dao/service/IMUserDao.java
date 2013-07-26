package edu.leo.dao.service;

import edu.leo.common.db.ICommonDao;
import edu.leo.dao.entity.MUser;

public interface IMUserDao extends ICommonDao<MUser, Long> {

    public MUser getDataByLoginIdPwd(String loginId, String password);
}
