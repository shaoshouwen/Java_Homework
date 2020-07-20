package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ProductController {

  @Autowired
  private ProductService productService;

  @RequestMapping("/search")
  public String SearchProduct(String productName, HttpSession session) {
    System.out.println(productName);
    if (!("".equals(productName) && productName == null)) {
      List<Product> productList = productService.getProductByName(productName);
      if (productList != null) {

        session.setAttribute("productList", productList);

      }
    }
    return "CategoryList";
  }

  @RequestMapping("/detail")
  public String productDetail(int id, HttpSession session) {

    if (id > 0) {
      Product product = productService.getProductById(id);
      if (product != null) {
        session.setAttribute("product", product);
      }
    }

    return "product";
  }

  @RequestMapping("/addCart")
  public String addCart(int productId, int num, HttpSession session) {
    Product product = null;
    try {
      product = productService.getProductById(productId);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    if (product != null) {
      Map<Product, Integer> cart = null;
      double sum = 0;
      int number = 0;

      if (session.getAttribute("cart") == null) {
        cart = new HashMap<>();
        sum = 0.0;

      } else {
        cart = (Map<Product, Integer>) session.getAttribute("cart");
        sum = (double) session.getAttribute("sum");


      }
      for (Product p : cart.keySet()) {
        if (p.getId().equals(product.getId())) {

          cart.put(p, cart.get(p) + 1);
          sum += product.getPrice();
          session.setAttribute("sum", sum);
          session.setAttribute("cart", cart);
          return "buycar";
        }
      }
      cart.put(product, num);
      sum += product.getPrice();

      session.setAttribute("cart", cart);
      session.setAttribute("sum", sum);
    }
    return "buycar";
  }

  @RequestMapping("/confirm")
  public String confirm(HttpSession session) {
    double totalPrice = (double) session.getAttribute("sum");
    System.out.println(totalPrice);
    if (session.getAttribute("user") == null) {
      return "Login";
    } else {
      session.setAttribute("totalPrice", totalPrice);
      return "BuyCar2";
    }
  }
}
