package club.banyuan.service.impl;

import club.banyuan.dao.ModifyItemDao;
import club.banyuan.dao.impl.ModifyItemDaoImpl;
import club.banyuan.entity.Auction_item;
import club.banyuan.service.ModifyItemService;
import club.banyuan.util.JdbcUtils;

import java.sql.SQLException;

public class ModifyItemServiceImpl implements ModifyItemService {

  @Override
  public int modifyitem(Auction_item auction_item) throws SQLException {
    ModifyItemDao modifyItemDao = new ModifyItemDaoImpl(JdbcUtils.getConnection());
    return modifyItemDao.modifyProduct(auction_item);
  }

  @Override
  public int insertitem(Auction_item auction_item) throws SQLException {
    ModifyItemDao modifyItemDao = new ModifyItemDaoImpl(JdbcUtils.getConnection());
    return modifyItemDao.insertProduct(auction_item);
  }

  @Override
  public int deleteitem(int id) throws SQLException {
    ModifyItemDao modifyItemDao = new ModifyItemDaoImpl(JdbcUtils.getConnection());
    return modifyItemDao.deleteProduct(id);
  }
}
