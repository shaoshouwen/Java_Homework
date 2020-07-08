package club.banyuan.controller;

import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ValidateLoginNameServlet", urlPatterns = "/validate.do")
public class ValidateLoginNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(111);
        String result = "true";
        System.out.println("RdoGet");
        try {
            String loginName = request.getParameter("loginName");
            if (!loginName.isBlank()) {
                UserService userService = new UserServiceImpl();
                if (userService.isExist(loginName)) {
                    result = "false";
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(result);

        writer.flush();
        writer.close();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
