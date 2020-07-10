package club.banyuan.entity;

import java.util.Date;

public class Auction_item {

  private int id;
  private String item_name;
  private String description;
  private Date start_time;
  private Date end_time;
  private Double starting_price;
  private Double base_price;

  public Auction_item() {
  }

  @Override
  public String toString() {
    return "Auction_item{" +
        "id=" + id +
        ", item_name='" + item_name + '\'' +
        ", description='" + description + '\'' +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", starting_price=" + starting_price +
        ", base_price=" + base_price +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getItem_name() {
    return item_name;
  }

  public void setItem_name(String item_name) {
    this.item_name = item_name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStart_time() {
    return start_time;
  }

  public void setStart_time(Date start_time) {
    this.start_time = start_time;
  }

  public Date getEnd_time() {
    return end_time;
  }

  public void setEnd_time(Date end_time) {
    this.end_time = end_time;
  }

  public Double getStarting_price() {
    return starting_price;
  }

  public void setStarting_price(Double starting_price) {
    this.starting_price = starting_price;
  }

  public Double getBase_price() {
    return base_price;
  }

  public void setBase_price(Double base_price) {
    this.base_price = base_price;
  }

  public Auction_item(int id, String item_name, String description, Date start_time,
      Date end_time, Double starting_price, Double base_price) {
    this.id = id;
    this.item_name = item_name;
    this.description = description;
    this.start_time = start_time;
    this.end_time = end_time;
    this.starting_price = starting_price;
    this.base_price = base_price;
  }
}
