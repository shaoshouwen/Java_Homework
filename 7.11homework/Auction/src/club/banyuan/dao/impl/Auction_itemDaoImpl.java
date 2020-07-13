package club.banyuan.dao.impl;

import club.banyuan.dao.IAuction_itemDao;
import club.banyuan.entity.Auction_item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Auction_itemDaoImpl extends BaseDaoImpl implements IAuction_itemDao {


  public Auction_itemDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public Auction_item tableToClass(ResultSet rs) throws Exception {
    Auction_item auction_item = new Auction_item(rs.getInt(1), rs.getString(2), rs.getString(3),
        rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getDouble(7));
    return auction_item;
  }

  @Override
  public List<Auction_item> getItemByName(String proName) throws Exception {
    List<Auction_item> itemList = new ArrayList<>();
    String sql = "select * from auction_item where item_name like ?";
    String s = "%" + proName + "%";
    ResultSet rs = executeQuery(sql, new Object[]{s});
    while (rs.next()) {
      Auction_item product = new Auction_item();
      product = tableToClass(rs);
      itemList.add(product);
      System.out.println(itemList);
    }
    return itemList;
  }

  @Override
  public Auction_item getItemById(Integer id) throws Exception {
    Auction_item item = null;
    String sql = "select * from Auction_item where id = ?";
    ResultSet rs = executeQuery(sql, new Object[]{id});
    if (rs.next()) {
      item = tableToClass(rs);
    }
    return item;
  }

  @Override
  public List<Auction_item> getAllItem() throws Exception {

    List<Auction_item> itemList = new ArrayList<>();
    String sql = "select * from auction_item";
    PreparedStatement pstm = connection.prepareStatement(sql);
    ResultSet rs = pstm.executeQuery();
    while (rs.next()) {
      Auction_item auction_item = new Auction_item();
      auction_item = tableToClass(rs);
      System.out.println(auction_item);
      itemList.add(auction_item);
      System.out.println(itemList);

    }
    return itemList;
  }
}
