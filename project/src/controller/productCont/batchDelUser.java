package controller.productCont;

import service.IProductService;
import service.IUserService;
import service.impl.ProductService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/batch-del-product")
public class batchDelUser extends HttpServlet {

    private IProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids[] = req.getParameterValues("ids");

        int idsInt[] = new int[ids.length];


        for (int i = 0; i < ids.length; i++) {
            idsInt[i] = (Integer.parseInt(ids[i]));
        }

        Boolean re = productService.batchDel(idsInt);

        if (re) {
            resp.sendRedirect("/product-manage");
        }

    }
}
