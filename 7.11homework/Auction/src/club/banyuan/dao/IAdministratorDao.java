package club.banyuan.dao;

import club.banyuan.entity.Administrator;

public interface IAdministratorDao extends IBaseDao{
  public Administrator getLogin(String loginName,String pwd);

}
