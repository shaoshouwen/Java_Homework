package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class UserDaoImpl extends BaseDaoImpl implements UserDao {

  public UserDaoImpl(Connection conn) {
    super(conn);
  }

  @Override
  public User register(User user) {
    String sql = "insert into user(id,loginName,userName,password,sex,email,mobile) values(null,?,?,?,?,?,?)";
    Object[] params = new Object[]{user.getLoginName()
        , user.getUserName(), user.getPassword(), user.getSex(), user.getEmail(), user.getMobile()};
    int i = executeInsert(sql, params);
    if (i > 0) {
      return user;
    }
    return null;
  }

  @Override
  public User login(User user) throws Exception {
    String sql = "select id,loginName,password,email,mobile from user where loginName=? and password=?";
    ResultSet rs = this
        .executeQuery(sql.toString(), new String[]{user.getUserName(), user.getPassword()});

    try {
      if (rs.next()) {
        user = (User) this.tableToClass(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.closeResource();
      this.closeResource(rs);
    }
    return user;
  }


  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User();
    user.setLoginName(rs.getString("loginName"));
    user.setPassword(rs.getString("password"));
    user.setEmail(rs.getString("email"));
    user.setMobile(rs.getString("mobile"));
    user.setId(rs.getInt("id"));
    return user;
  }
}
