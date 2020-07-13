package club.banyuan.service.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) throws SQLException {
        IUserDao IUserDao = new UserDaoImpl(JdbcUtils.getConnection());
        return IUserDao.getLoginUser(username,password);
    }

    @Override
    public int regist(User user) throws SQLException {
        IUserDao IUserDao = new UserDaoImpl(JdbcUtils.getConnection());
        return IUserDao.add(user);
    }

//    @Override
//    public boolean validate(String loginName) throws Exception {
//        IUserDao IUserDao = new UserDaoImpl(JdbcUtils.getConnection());
//        return IUserDao.validate(loginName);
//    }


}
