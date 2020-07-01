package club.banyuan.servlet;

import club.banyuan.dao.UserDao;
import club.banyuan.dao.impl.UserDaoImpl;
import club.banyuan.entity.User;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    boolean flag = false;
    try {
      UserDao userDao = new UserDaoImpl(JdbcUtils.getConnection());
      User loginUser = userDao.getLoginUser(loginName, password);

      if (loginUser.getLoginName() !=null){
        flag = true;
        System.out.println(loginUser);
      }
      response.setCharacterEncoding("utf-8");
      PrintWriter writer = response.getWriter();
      writer.println("<html>");
      writer.println("<meta charset='utf-8'/>");
      writer.println("<body>");
      writer.println(flag==true?"登录成功":"不存在，重新登录");

      writer.println("</body>");
      writer.println("</html>");
      writer.flush();
      writer.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    System.out.println("登录......");


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);

  }
}
