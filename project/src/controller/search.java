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

@WebServlet("/search")
public class search extends HttpServlet {

    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String keywork = req.getParameter("q");
        String flag = req.getParameter("flag");
        HttpSession session = req.getSession();

//        //搜索用户
//        if ("searchUser".equals(flag)) {
//            List<User> userList = userService.findByKeyWork(keywork);
//            session.setAttribute("userList", userList);
//            resp.sendRedirect("/pages/user-manage.jsp");
//        }


    }
}
