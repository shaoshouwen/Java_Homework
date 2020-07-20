package club.banyuan.service.impl;


import club.banyuan.dao.OrderDao;
import club.banyuan.dao.OrderDetailDao;
import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import com.mysql.cj.util.StringUtils;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;
  @Autowired
  private OrderDetailDao orderDetailDao;

  @Override
  public Order payShoppingCart(Map<Product, Integer> cart, double totalPrice, User user,
      String address) {
    Order order = new Order();
    order.setUserId(user.getId());
    order.setLoginName(user.getLoginName());
    order.setUserAddress(address);
    order.setCreateTime(new Date());
    order.setCost(totalPrice);
    order.setSerialNumber(new Random().toString());
    orderDao.add(order);
    for (Product product : cart.keySet()) {
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setOrderId(order.getId());
      orderDetail.setCost(product.getPrice());
      orderDetail.setProduct(product);
      orderDetail.setQuantity(cart.get(product));
      orderDetailDao.add(orderDetail);
    }
    return order;
  }
}
