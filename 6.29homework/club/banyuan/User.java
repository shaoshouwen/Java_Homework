package club.banyuan;

import java.sql.*;
import java.util.Scanner;

public class User {

  public static void main(String[] args) {
    //从控制台上输入的用户名和密码
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入用户名：");
    String name = sc.nextLine();
    System.out.println("请输入密码：");
    String password = sc.nextLine();

    try {
      validate(name, password);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

//    try {
//      register(name,password);
//    } catch (SQLException throwables) {
//      throwables.printStackTrace();
//    }

  }

//  public static void register(String name, String password) throws SQLException {
//    Connection conn = JdbcUtils.getConnection("Shoppingstreet");
//    String sql = "insert into USER values(null,'123',?,?,null,null,null,null,null)";
//    PreparedStatement pstmt = conn.prepareStatement(sql);
//    pstmt.setString(1, name);
//    pstmt.setString(2, password);
//
//    int row = pstmt.executeUpdate();
//    if (row > 0) {
//      System.out.println("success");
//    } else {
//      System.out.println("faile");
//    }
//    JdbcUtils.close(conn, pstmt);
//  }


  public static void validate(String name, String password) throws SQLException {
    Connection conn = JdbcUtils.getConnection("shoppingstreet");
    String sql = "select * from user where USERNAME=? and password=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setString(2, password);

    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
      System.out.println("success");
    } else {
      System.out.println("faile");
    }
    JdbcUtils.close(conn, pstmt, rs);
  }
}



