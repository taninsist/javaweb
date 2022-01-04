package controller;


import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUser")
public class DelUser extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
//
        IUserService userService = new UserService();
        boolean re = userService.delUser(id);
//        if (re) {
//        req.getRequestDispatcher("/pages/success.jsp").forward(req, resp);
        resp.sendRedirect("/find-user");
//        }

    }
}
