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

@WebServlet(name = "Search_itemServlet",urlPatterns = "/search.do")
public class Search_itemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(111);
    String itemName = new String(request.getParameter("itemName").getBytes("iso-8859-1"), "utf-8");
    Auction_itemService auction_itemService = new Auction_itemServiceImpl();
    HttpSession session = request.getSession();
    try {
      List<Auction_item> itemByName = auction_itemService.getItemByName(itemName);
      List<Auction_item> allitems = auction_itemService.getAllitems();
      session.setAttribute("allitemsList",allitems);
      if(itemByName != null){
        System.out.println(itemByName);
        System.out.println(itemName);
        for (Auction_item allitem : allitems) {
          System.out.println(allitem);
        }
        session.setAttribute("itemByName",itemByName);
        request.getRequestDispatcher("itemslist.jsp").forward(request,response);
        return;
      }



      request.getRequestDispatcher("itemslist.jsp").forward(request,response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
