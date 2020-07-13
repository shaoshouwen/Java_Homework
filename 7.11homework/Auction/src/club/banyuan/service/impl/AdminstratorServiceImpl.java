package club.banyuan.service.impl;

import club.banyuan.dao.IAdministratorDao;
import club.banyuan.dao.impl.AdministratorDaoImpl;
import club.banyuan.entity.Administrator;
import club.banyuan.service.AdminstratorService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;

public class AdminstratorServiceImpl implements AdminstratorService {

  @Override
  public Administrator getLogin(String username, String pwd) throws SQLException {
    IAdministratorDao administratorDao = new AdministratorDaoImpl(JdbcUtils.getConnection());
    return administratorDao.getLogin(username,pwd);
  }
}
