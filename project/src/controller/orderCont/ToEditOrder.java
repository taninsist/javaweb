package controller.orderCont;

import domain.Order;
import service.IOrderService;
import service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/to-edit-order")
public class ToEditOrder extends HttpServlet {

    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        int id = Integer.parseInt(req.getParameter("id"));

        HttpSession session = req.getSession();
        session.setAttribute("order",orderService.findProductById(id));

        resp.sendRedirect("/pages/edit-order.jsp");

    }
}
