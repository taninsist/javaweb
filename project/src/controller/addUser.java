package controller;

import domain.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class addUser extends HttpServlet {

    private IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setSex(sex);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setEmail(email);

        Boolean re = userService.add(user);
        if(re){
            resp.sendRedirect("/find-user");
        }
    }

}
