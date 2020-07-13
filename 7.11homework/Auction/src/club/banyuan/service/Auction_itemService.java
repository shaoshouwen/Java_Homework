package club.banyuan.service;

import club.banyuan.entity.Auction_item;
import java.util.List;

public interface Auction_itemService {
  public List<Auction_item> getItemByName(String proName)throws Exception;
  public Auction_item getItemById(Integer id)throws Exception;
  public List<Auction_item> getAllitems() throws  Exception;
}
