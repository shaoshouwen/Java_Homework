package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDao;
import club.banyuan.entity.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

  public OrderDaoImpl(Connection connection) {
    super(connection);
  }




  @Override
  public Object tableToClass(ResultSet rs) throws Exception {
    Order order = new Order();
    order.setId(rs.getInt("id"));
    order.setUserId(rs.getInt("userId"));
    order.setCreateTime(rs.getDate("createTime"));
    order.setCost(rs.getDouble("cost"));
    order.setUserAddress(rs.getString("userAddress"));
    order.setSerialNumber(rs.getString("serialNumber"));
    order.setLoginName(rs.getString("loginName"));
    return order;
  }

  @Override
  public List<Order> getOrderbyUserId(int userId) throws Exception {
    String sql = "select * from `order` where userId=?";
    ResultSet resultSet = null;
    List<Order> orderList = new ArrayList<>();
    resultSet = executeQuery(sql,new Integer[]{userId});
    while (resultSet.next()){
      orderList.add((Order) tableToClass(resultSet));
    }
    return orderList;
  }
}
