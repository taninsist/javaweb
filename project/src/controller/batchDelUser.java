package controller;

import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/batch-del-user")
public class batchDelUser extends HttpServlet {

    private IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids[] = req.getParameterValues("ids");

        int idsInt[] = new int[ids.length];


        for (int i = 0;i < ids.length;i ++){
            idsInt[i] = (Integer.parseInt(ids[i]));
        }

        Boolean re =  userService.batchDel(idsInt);

        if(re){
            resp.sendRedirect("/find-user");
        }

    }
}
