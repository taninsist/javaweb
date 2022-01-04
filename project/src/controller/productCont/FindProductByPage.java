package controller.productCont;

import domain.Product;
import domain.User;
import service.IProductService;
import service.IUserService;
import service.impl.ProductService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-product-by-page")
public class FindProductByPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        IProductService productService = new ProductService();
        List<Product> productList;
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
            productList = productService.findByKeyWord(keywork, current, limit);
            total = (productService.findAllByKey(keywork)).size();
            session.setAttribute("keyword", keywork);
        } else {
            total = (productService.findAll()).size();
            productList = productService.findAllByPage(current, limit);
        }
        int maxPage = total / limit + (total % limit > 0 ? 1 : 0);
        session.setAttribute("limit", limit);
        session.setAttribute("current", current);
        session.setAttribute("total", total);
        session.setAttribute("maxPage", maxPage);
        session.setAttribute("products", productList);
        resp.sendRedirect("/pages/product-manage.jsp");
    }
}
