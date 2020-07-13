package club.banyuan.service;

import club.banyuan.entity.Administrator;
import java.sql.SQLException;

public interface AdminstratorService {
  public Administrator getLogin(String loginName,String pwd) throws SQLException;

}
