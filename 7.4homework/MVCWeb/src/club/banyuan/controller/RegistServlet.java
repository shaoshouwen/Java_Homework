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
    user.setLoginName(request.getParameter("loginName"));
//    user.setUserName(request.getParameter("userName"));
    user.setPassword(request.getParameter("password"));
//    user.setSex(Integer.valueOf(request.getParameter("sex")));
    user.setEmail(request.getParameter("email"));
    user.setMobile(request.getParameter("mobile"));
//    boolean flag = false;
    UserService userService = new UserServiceImpl();
    HttpSession session = request.getSession();
    try {
      String password = request.getParameter("password");
      String confirm = request.getParameter("confirm");

      if (password != null && confirm != null && password.equals(confirm)) {
        int id = userService.regist(user);
        if (id > 0) {
//          flag = true;
          request.getRequestDispatcher("index.jsp").forward(request, response);
          System.out.println(id);
        } else {
          request.getRequestDispatcher("index2.jsp").forward(request, response);
        }
      }else {
        session.setAttribute("password",password);
        session.setAttribute("confirm",confirm);

        request.getRequestDispatcher("index2.jsp").forward(request,response);
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
