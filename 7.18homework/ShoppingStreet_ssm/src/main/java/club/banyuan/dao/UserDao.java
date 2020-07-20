package club.banyuan.dao;

import club.banyuan.entity.User;

public interface UserDao {
    public int add(User user);
    public User getLoginUserbybyTwo(User user) throws Exception;
    public User getLoginUser(String loginName);
}
