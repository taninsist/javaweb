package controller.editUser;


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

@WebServlet("/to-edit-user")
public class toEditUSer extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  /to-edit-user?id=30
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.findUserById(id);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        resp.sendRedirect("/pages/edit-user.jsp");
    }
}
