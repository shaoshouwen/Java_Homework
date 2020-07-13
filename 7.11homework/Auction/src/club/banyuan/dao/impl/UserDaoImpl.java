package club.banyuan.dao.impl;

import club.banyuan.dao.IUserDao;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

  public UserDaoImpl(Connection conn) {
    super(conn);
  }

  @Override
  public int add(User user) {
    String sql = "insert into user values(null,?,?,?,?,?,?)";
    Object[] params = new Object[]{user.getUsername()
        , user.getPassword(), user.getIdentity(), user.getTel(), user.getAddress(),
        user.getPostcode()};
    int i = executeInsert(sql, params);
    return i;
  }

  @Override
  public User getLoginUser(String username, String pwd) {
    String sql = "select * from user where username=? and password=?";
    ResultSet rs = executeQuery(sql, new Object[]{username, pwd});
    User user = null;
    try {
      if (rs.next()) {
        user = tableToClass(rs);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return user;
  }

//    @Override
//    public boolean validate(String loginName) {
//        String sql = "select loginName from user where loginName = ?";
//        ResultSet rs = executeQuery(sql,new Object[]{loginName});
//        boolean validate = true;
//        try {
//            if (rs.next()){
//                validate = false;
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return validate;
//    }

  @Override
  public User tableToClass(ResultSet rs) throws Exception {
    User user = new User(rs.getInt(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5), rs.getString(6), rs.getString(7));

    return user;
  }
}
