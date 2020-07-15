package club.banyuan.dao;

import club.banyuan.entity.Auction_item;
import java.util.List;

public interface IAuction_itemDao {
  public List<Auction_item> getItemByMsg(Auction_item auction_item)throws Exception;
  public Auction_item getItemById(Integer id)throws Exception;
  public List<Auction_item> getAllItem() throws Exception;
}
