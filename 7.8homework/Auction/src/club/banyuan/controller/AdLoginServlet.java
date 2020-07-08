package club.banyuan.controller;

import club.banyuan.entity.Administrator;
import club.banyuan.service.AdminstratorService;
import club.banyuan.service.impl.AdminstratorServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdLoginServlet", urlPatterns = "/admin.do")
public class AdLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(111);
    String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
    String password = new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8");
    System.out.println(name);
    AdminstratorService adminstratorService = new AdminstratorServiceImpl();
    HttpSession session = request.getSession();

    try {
      Administrator admin = adminstratorService.getLogin(name, password);
      if (admin != null) {
        session.setAttribute("Admin", admin);
        request.getRequestDispatcher("item_admin.jsp").forward(request, response);
        System.out.println(admin);
      }


    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
