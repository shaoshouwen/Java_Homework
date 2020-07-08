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

@WebServlet(name = "AdLoginServlet",urlPatterns = "/admin.do")
public class AdLoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    AdminstratorService adminstratorService = new AdminstratorServiceImpl();
    HttpSession session = request.getSession();

    try {
      Administrator admin = adminstratorService.getLogin(name, password);
      if(admin != null){
        session.setAttribute("Admin",admin);
      }



    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
