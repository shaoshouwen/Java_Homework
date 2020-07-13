package club.banyuan.controller;

import club.banyuan.entity.Auction_item;
import club.banyuan.service.ModifyItemService;
import club.banyuan.service.impl.ModifyItemServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete.do")
public class DeleteServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(10);
    ModifyItemService modifyItemService = new ModifyItemServiceImpl();
    HttpSession session = request.getSession();
//    Auction_item auction_item = (Auction_item) session.getAttribute("allitems");
    int id = Integer.valueOf(request.getParameter("id"));

    if (id > 0) {
      int uid = 0;
      try {
        uid = modifyItemService.deleteitem(id);
        System.out.println(uid);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      if (id > 0) {
        request.getRequestDispatcher("show.do").forward(request, response);
      }
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
