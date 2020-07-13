package club.banyuan.service.impl;

import club.banyuan.dao.IAuction_itemDao;
import club.banyuan.dao.impl.Auction_itemDaoImpl;
import club.banyuan.entity.Auction_item;
import club.banyuan.service.Auction_itemService;
import club.banyuan.util.JdbcUtils;
import java.util.List;

public class Auction_itemServiceImpl implements Auction_itemService {

  @Override
  public List<Auction_item> getItemByName(String proName) throws Exception {
    IAuction_itemDao auction_itemDao = new Auction_itemDaoImpl(JdbcUtils.getConnection());
    return auction_itemDao.getItemByName(proName);
  }

  @Override
  public Auction_item getItemById(Integer id) throws Exception {
    IAuction_itemDao auction_itemDao = new Auction_itemDaoImpl(JdbcUtils.getConnection());
    return auction_itemDao.getItemById(id);
  }

  @Override
  public List<Auction_item> getAllitems() throws Exception {
    IAuction_itemDao auction_itemDao = new Auction_itemDaoImpl(JdbcUtils.getConnection());
    return  auction_itemDao.getAllItem();
  }
}
