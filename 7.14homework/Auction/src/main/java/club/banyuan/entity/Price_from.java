package club.banyuan.entity;

import java.util.Date;

public class Price_from {

  private int id;
  private Date auction_time;
  private Double auction_price;
  private int bidderid;
  private int itemid;
  private String boddername;

  public Price_from() {
  }

  @Override
  public String toString() {
    return "Price_from{" +
        "id=" + id +
        ", auction_time=" + auction_time +
        ", auction_price=" + auction_price +
        ", bidderid=" + bidderid +
        ", itemid=" + itemid +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getAuction_time() {
    return auction_time;
  }

  public void setAuction_time(Date auction_time) {
    this.auction_time = auction_time;
  }

  public Double getAuction_price() {
    return auction_price;
  }

  public void setAuction_price(Double auction_price) {
    this.auction_price = auction_price;
  }

  public int getBidderid() {
    return bidderid;
  }

  public void setBidderid(int bidderid) {
    this.bidderid = bidderid;
  }

  public int getItemid() {
    return itemid;
  }

  public void setItemid(int itemid) {
    this.itemid = itemid;
  }

  public String getBoddername() {
    return boddername;
  }

  public void setBoddername(String boddername) {
    this.boddername = boddername;
  }

  public Price_from(int id, Date auction_time, Double auction_price, int bidderid, int itemid,
      String boddername) {
    this.id = id;
    this.auction_time = auction_time;
    this.auction_price = auction_price;
    this.bidderid = bidderid;
    this.itemid = itemid;
    this.boddername = boddername;
  }
}
