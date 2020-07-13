package club.banyuan.dao;

import club.banyuan.entity.Auction_item;
import java.util.List;

public interface IAuction_itemDao extends IBaseDao{
  public List<Auction_item> getItemByName(String proName)throws Exception;
  public Auction_item getItemById(Integer id)throws Exception;
  public List<Auction_item> getAllItem() throws Exception;
}
