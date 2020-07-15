package club.banyuan.dao;

import club.banyuan.entity.User;

public interface UserDao {
    public int add(User user);
    public User getLoginUser(String loginName,String pwd);
//    public boolean validate(String loginName);
}
