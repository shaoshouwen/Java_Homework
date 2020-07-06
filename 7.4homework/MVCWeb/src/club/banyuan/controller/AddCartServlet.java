package club.banyuan.controller;

import club.banyuan.entity.Product;
import club.banyuan.service.ProductService;
import club.banyuan.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddCartServlet", urlPatterns = "/addCart.do")
public class AddCartServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int id = Integer.valueOf(request.getParameter("productId"));
    int num = Integer.valueOf(request.getParameter("num"));
    ProductService productService = new ProductServiceImpl();
    Product product = null;
    try {
      product = productService.getProductById(id);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    if (product != null) {
      HttpSession session = request.getSession();
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
          request.getRequestDispatcher("buycar.jsp").forward(request, response);
          return;
        }
      }
      cart.put(product, num);
      sum += product.getPrice();

      session.setAttribute("cart", cart);
      session.setAttribute("sum", sum);
    }

    request.getRequestDispatcher("buycar.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
