package club.banyuan.service.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.dao.impl.OrderDaoImpl;
import club.banyuan.entity.Order;
import club.banyuan.service.OrderService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;
import java.util.jar.JarEntry;

public class OrderServiceImpl implements OrderService {

  @Override
  public List<Order> getOrderbyUserId(int userId) throws Exception {
    OrderDaoImpl orderDao = new OrderDaoImpl(JdbcUtils.getConnection());
    return orderDao.getOrderbyUserId(userId);
  }
}
