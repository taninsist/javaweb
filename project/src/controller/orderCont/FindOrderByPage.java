package controller.orderCont;

import domain.Order;
import domain.User;
import service.IOrderService;
import service.IUserService;
import service.impl.OrderService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-order-by-page")
public class FindOrderByPage extends HttpServlet {
    private IOrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        List<Order> orderList;
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
            orderList = orderService.findAllByKeywork(keywork, current, limit);
            total = (orderService.findAllByKey(keywork)).size();
            session.setAttribute("keyword", keywork);
        } else {
            total = (orderService.findAll()).size();
            orderList = orderService.findAllByPage(current, limit);
        }
        int maxPage = total / limit + (total % limit > 0 ? 1 : 0);
        session.setAttribute("limit", limit);
        session.setAttribute("current", current);
        session.setAttribute("total", total);
        session.setAttribute("maxPage", maxPage);
        session.setAttribute("orderList", orderList);
        resp.sendRedirect("/pages/order-manage.jsp");
    }
}
