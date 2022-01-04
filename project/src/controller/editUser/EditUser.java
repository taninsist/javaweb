package controller.editUser;

import domain.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-user")
public class EditUser extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = new User();
        String account = req.getParameter("account");
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("id"));
        user.setAccount(account);
        user.setSex(sex);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setEmail(email);
        user.setId(id);
        boolean re = userService.editUserById(user);
        if(re){
            resp.sendRedirect("/find-user");
        }
    }
}
