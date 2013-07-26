package edu.leo.dao.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import edu.leo.common.db.CommonDaoImpl;
import edu.leo.dao.entity.MUser;
import edu.leo.dao.service.IMUserDao;

@Repository
public class MUserDaoImpl extends CommonDaoImpl<MUser, Long> implements IMUserDao {

    public MUserDaoImpl() {
        super(MUser.class);
    }

    public MUser getDataByLoginIdPwd(String loginId, String password) {
        final int STR_BUF_LEN = 512;

        Session session = getSession();
        StringBuffer hql = new StringBuffer(STR_BUF_LEN);

        hql.append("FROM MUser ");
        hql.append("WHERE loginId = :loginId ");
        hql.append("AND password = :password ");
        hql.append("and delFlg = '0'");

        Query query = session.createQuery(hql.toString());
        // query.setLong("loginId", loginId);
        query.setString("loginId", loginId);
        query.setString("password", password);

        MUser result = null;

        @SuppressWarnings("unchecked")
        List<MUser> userList = query.list();
        if (userList != null && userList.size() > 0) {
            result = userList.get(0);
        }
        return result;
    }
}
