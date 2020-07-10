package club.banyuan.service;

import club.banyuan.entity.Auction_item;

import java.sql.SQLException;

public interface ModifyItemService {
    public int modifyitem(Auction_item auction_item) throws SQLException;
    public int insertitem(Auction_item auction_item) throws SQLException;

}
