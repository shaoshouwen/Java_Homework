package club.banyuan.dao;


import club.banyuan.entity.Auction_item;

public interface ModifyItemDao  {
    public int modifyProduct(Auction_item auction_item);
    public int insertProduct(Auction_item auction_item);
    public int deleteProduct(int id);
}
