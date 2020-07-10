package club.banyuan.entity;

public class User {

  private int id;
  private String username;
  private String password;
  private String identity;
  private String tel;
  private String address;
  private String postcode;

  public User(int id, String username, String password, String identity, String tel,
      String address, String postcode) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.identity = identity;
    this.tel = tel;
    this.address = address;
    this.postcode = postcode;
  }

  public User() {

  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", identity='" + identity + '\'' +
        ", tel='" + tel + '\'' +
        ", address='" + address + '\'' +
        ", postcode='" + postcode + '\'' +
        '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }




}
