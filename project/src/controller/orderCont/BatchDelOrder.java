package controller.orderCont;

import service.IOrderService;
import service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/batch-del-order")
public class BatchDelOrder extends HttpServlet {

    private IOrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String ids[] = req.getParameterValues("ids");

        int idsInt[] = new int[ids.length];


        for (int i = 0; i < ids.length; i++) {
            idsInt[i] = (Integer.parseInt(ids[i]));
        }

        Boolean re = orderService.batchDel(idsInt);

        if (re) {
            resp.sendRedirect("/find-order-by-page");
        }


    }
}
