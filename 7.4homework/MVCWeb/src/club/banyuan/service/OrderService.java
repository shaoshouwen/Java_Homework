package club.banyuan.service;

import club.banyuan.entity.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
  public List<Order> getOrderbyUserId(int userId) throws Exception;
}
