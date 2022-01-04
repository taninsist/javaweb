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


@WebServlet("/findUserByPage")
public class FindUserByPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        IUserService userService = new UserService();
        List<User> userList;
        String currentStr = req.getParameter("current");
        String flag = req.getParameter("flag");
        String keywork = req.getParameter("q");
        int current = 1;
        int limit = 5;
        int total = 0;
        if (currentStr != null) {
            //有提供当前页
            current = Integer.parseInt(currentStr);
        }
        if (flag != null || (keywork != null && keywork.length() > 0)) {
            //关键字分页查找
            userList = userService.findByKeyWork(keywork, current, limit);
            total = (userService.findAllByKey(keywork)).size();
            session.setAttribute("keyword", keywork);
        } else {
            total = (userService.findAll()).size();
            userList = userService.findUserByPage(current, limit);
        }
        int maxPage = total / limit + (total % limit > 0 ? 1 : 0);
        session.setAttribute("limit", limit);
        session.setAttribute("current", current);
        session.setAttribute("total", total);
        session.setAttribute("maxPage", maxPage);
        session.setAttribute("userList", userList);
        resp.sendRedirect("/pages/user-manage.jsp");
    }
}
