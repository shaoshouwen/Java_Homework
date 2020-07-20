package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping("/regist")
  public String Register (User user){
    userService.add(user);
    return "Login";
  }

  @RequestMapping("/login")
  public String Login(User user, HttpSession session){
    User user1 = userService.getLoginUserbybyTwo(user);
    session.setAttribute("user",user1);
    return "index";
  }

}
