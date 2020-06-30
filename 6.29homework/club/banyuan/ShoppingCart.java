package club.banyuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入类似名：");
    String name = sc.nextLine();
    Map<String, Integer> map = new HashMap<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = JdbcUtils.getConnection("shoppingstreet");
      pstmt = conn.prepareStatement("select p.name , sum(od.QUANTITY)\n"
          + "from product p inner join order_detail od on p.id = od.productid  where name like ? or DESCRIPTION like ? group  by p.name;\n");
      pstmt.setString(1, "%" + name + "%");
      pstmt.setString(2, "%" + name + "%");
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Product pro = new Product();
        Order_detail od = new Order_detail();
        String productName = rs.getString(1);
        int quantity = rs.getInt(2);

        map.put(productName, quantity);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        JdbcUtils.close(conn, pstmt, rs);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    System.out.print("\t" + map);

  }


}

