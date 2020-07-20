package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

  @Autowired
  private OrderService orderService;

  @RequestMapping("/creatOrder")
  public String creatOrder(HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "Login";
    } else {
      User user = (User) session.getAttribute("user");

      String address = "南京";
      double totalPrice = Double.parseDouble(session.getAttribute("totalPrice").toString());
      Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
      Order order = orderService.payShoppingCart(cart, totalPrice, user, address);
      session.setAttribute("order", order);
      session.removeAttribute("cart");
      session.removeAttribute("totalPrice");
      return "BuyCar3";
    }
  }
}







