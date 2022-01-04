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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/find-user")
public class FindUser extends HttpServlet {
    /**
     * total 总数
     * current 当前页
     * limit 展示条数
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        HttpSession session = req.getSession();
        IUserService iUserService = new UserService();
        List<User> userList;

        int current = 1;
        int limit = 5;
        int total = (iUserService.findAll()).size();
        int maxPage = total / limit + (total % limit > 0 ? 1 : 0);
        userList = iUserService.findUserByPage(current, limit);

        session.setAttribute("limit", limit);
        session.setAttribute("current", current);
        session.setAttribute("total", total);
        session.setAttribute("maxPage", maxPage);
        session.setAttribute("userList", userList);

        resp.sendRedirect("/pages/user-manage.jsp");


    }
}
