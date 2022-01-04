package controller.orderCont;

import domain.Order;
import domain.User;
import service.IOrderService;
import service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-order")
public class EditOrder extends HttpServlet {

    private IOrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Order order = new Order();
        int status = Integer.parseInt(req.getParameter("status"));
        String desc = req.getParameter("desc");
        int payType = Integer.parseInt(req.getParameter("payType"));
        int id = Integer.parseInt(req.getParameter("id"));
        order.setStatus(status);
        order.setDesc(desc);
        order.setPayType(payType);
        order.setId(id);
        boolean re = orderService.editOrderById(order);
        if (re) {
            resp.sendRedirect("/find-order-by-page");
        }
    }
}
