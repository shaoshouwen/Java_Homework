package club.banyuan.dao.impl;

import club.banyuan.dao.IAdministratorDao;
import club.banyuan.entity.Administrator;
import club.banyuan.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;

public class AdministratorDaoImpl extends BaseDaoImpl implements IAdministratorDao {

  public AdministratorDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Administrator getLogin(String loginName, String pwd) {
    String sql = "select * from Administrator where name=? and password=?";
    ResultSet rs = executeQuery(sql, new Object[]{loginName, pwd});
    Administrator administrator = null;
    try {
      if (rs.next()) {
        administrator = tableToClass(rs);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return administrator;
  }

  @Override
  public Administrator tableToClass(ResultSet rs) throws Exception {
    Administrator administrator = new Administrator(rs.getInt(1),
        rs.getString(2),
        rs.getString(3)
    );
    return  administrator;
  }
}



