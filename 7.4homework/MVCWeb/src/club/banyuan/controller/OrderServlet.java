package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.service.impl.OrderServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderServlet" ,urlPatterns = "/order.do")
public class OrderServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    OrderService orderService = new OrderServiceImpl();

    HttpSession session = request.getSession();
    List<Order> orderList = null;
    User user = (User)session.getAttribute("user");
    try {
      orderList = orderService.getOrderbyUserId(user.getId());
    } catch (Exception e) {
      e.printStackTrace();
    }
    if(orderList != null){
      session.setAttribute("orderList",orderList);
      request.getRequestDispatcher("Member_Order.jsp").forward(request,response);
      return;
    }
    response.sendRedirect("index.jsp");


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
