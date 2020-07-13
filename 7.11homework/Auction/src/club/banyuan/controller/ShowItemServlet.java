package club.banyuan.controller;

import club.banyuan.entity.Auction_item;
import club.banyuan.service.Auction_itemService;
import club.banyuan.service.impl.Auction_itemServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ShowItemServlet",urlPatterns = "/show.do")
public class ShowItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    Auction_itemService auction_itemService = new Auction_itemServiceImpl();
    HttpSession session = request.getSession();
    try {
      List<Auction_item> allitems = auction_itemService.getAllitems();
      if (allitems !=null){
        session.setAttribute("allitems",allitems);
//        System.out.println(allitems);
        request.getRequestDispatcher("item_admin.jsp").forward(request,response);

      }



    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
doPost(request,response);
  }
}
