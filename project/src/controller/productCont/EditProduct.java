package controller.productCont;

import domain.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-product")
public class EditProduct extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String num = req.getParameter("num");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String departureTime = req.getParameter("departureTime");
        Float price = Float.parseFloat(req.getParameter("price"));
        String sort = req.getParameter("sort");
        int status = Integer.parseInt(req.getParameter("status"));
        Product product = new Product();
        product.setId(id);
        product.setProductNum(num);
        product.setProductName(name);
        product.setCityName(city);
        product.setDepartureTime(departureTime);
        product.setProductPrice(price);
        product.setProductDesc(sort);
        product.setProductStatus(status);
        boolean re = productService.editProductById(product);
        if (re) {
            resp.sendRedirect("/product-manage");
        }
    }
}
