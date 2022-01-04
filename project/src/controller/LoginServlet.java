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


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        IUserService iUserService = new UserService();
        HttpSession session = req.getSession();

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");

        String serverCode = (String) session.getAttribute("code");
        String client = req.getParameter("authcode");

        Boolean retu = verify(serverCode,client);

        if(!retu){
            //验证码错误
            resp.sendRedirect("/pages/error.jsp");
            return;
        }

        boolean re = iUserService.login(account, password);

        if (re) {
            //登录成功
            session.setAttribute("username", account);

//            req.getRequestDispatcher("/find-user").forward(req, resp);
            resp.sendRedirect("/pages/home.jsp");
        }
    }

    /**
     * 验证码大小写均可通过验证
     */
    private boolean verify(String serCode, String ClientCode) {
        if (serCode.length() == ClientCode.length()) {
            char[] serCodeLen = serCode.toCharArray();
            char[] ClientCodeLen = ClientCode.toCharArray();
            for (int i = 0; i < serCodeLen.length; i++) {
                int c = serCodeLen[i];
                int C = ClientCodeLen[i];
                if (c > C) {
                    if ((c - 32) != C) {
                        return false;
                    }
                } else if (c < C) {
                    if ((c + 32) != C) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
