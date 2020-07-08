package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistServlet", urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    User user = new User();
    user.setUsername(request.getParameter("username"));
    user.setPassword(request.getParameter("password"));
    user.setIdentity(request.getParameter("identity"));
    user.setTel(request.getParameter("tel"));
    user.setAddress(request.getParameter("address"));
    user.setPostcode(request.getParameter("postcode"));
    UserService userService = new UserServiceImpl();
    HttpSession session = request.getSession();
    try {
      String password = request.getParameter("password");
        int id = userService.regist(user);
        if (id > 0) {
          request.getRequestDispatcher("index.jsp").forward(request, response);
          System.out.println(id);
        } else {
          request.getRequestDispatcher("index2.jsp").forward(request, response);
        }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
