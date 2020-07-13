package club.banyuan.controller;

import club.banyuan.entity.Auction_item;
import club.banyuan.service.Auction_itemService;
import club.banyuan.service.impl.Auction_itemServiceImpl;
import club.banyuan.util.JdbcUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AuctionServlet", urlPatterns = "/auction.do")
public class AuctionServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    Auction_itemService items = new Auction_itemServiceImpl();
    HttpSession session = request.getSession();
    int id = Integer.valueOf(request.getParameter("id"));
    if (id != 0) {

      if (session.getAttribute("user") != null) {
        Auction_item itemById = null;
        try {
          itemById = items.getItemById(id);
        } catch (Exception e) {
          e.printStackTrace();
        }
        session.setAttribute("itemById", itemById);
        request.getRequestDispatcher("auctioning.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("Login.jsp").forward(request, response);
      }


    }

  }


  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
