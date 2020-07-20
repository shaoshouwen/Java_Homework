package club.banyuan.service;

import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import java.util.List;
import java.util.Map;

public interface OrderService {

  public Order payShoppingCart(Map<Product,Integer> car,double totalPrice, User user,String address);
}
