package club.banyuan.controller;

import club.banyuan.entity.Auction_item;
import club.banyuan.service.ModifyItemService;
import club.banyuan.service.impl.ModifyItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "ModifyItemServlet", urlPatterns = "/modify.do")
public class ModifyItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("do");
    ModifyItemService modifyItemService = new ModifyItemServiceImpl();
    String item_name = request.getParameter("item_name");
    String description = request.getParameter("description");
    String starting_price = request.getParameter("starting_price");
    Double base_price = Double.valueOf(request.getParameter("base_price"));
    String start_time = request.getParameter("start_time");
    String end_time = request.getParameter("end_time");
//    int id = 0 ;
    String id = request.getParameter("id");
    System.out.println(id);

    Auction_item auction_item = new Auction_item();
    auction_item.setItem_name(item_name);
    auction_item.setDescription(description);
    auction_item.setStart_time(start_time);
    auction_item.setEnd_time(end_time);
    auction_item.setBase_price(base_price);
//    auction_item.setId(id);
    System.out.println(auction_item.getItem_name());
    try {
      int modifyitem = modifyItemService.modifyitem(auction_item);
      if (modifyitem > 0) {
        request.getRequestDispatcher("show.do").forward(request, response);
      }


    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
doPost(request,response);
  }
}
