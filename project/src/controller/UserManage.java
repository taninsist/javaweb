package controller;


import domain.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user-manage")
public class UserManage extends HttpServlet {
    IUserService iUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");

        List<User> userList;
        userList = iUserService.findAll();
        session.setAttribute("userList", userList);

        resp.sendRedirect("/pages/user-manage.jsp");

    }
}
