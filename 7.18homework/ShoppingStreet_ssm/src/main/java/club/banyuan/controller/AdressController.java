package club.banyuan.controller;

import club.banyuan.dao.AddressDao;
import club.banyuan.entity.Address;
import club.banyuan.service.AddressService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdressController {

  @Autowired
  private AddressService addressService;

  public String addAddress(int id, HttpSession session) {

    List<Address> addressbyUserId = addressService.getAddressbyUserId(id);
    return "";
  }

}
