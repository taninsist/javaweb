package service.impl;

import dao.IProjectDao;
import dao.impl.IProductImpl;
import domain.Product;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProjectDao projectDao = new IProductImpl();

    @Override
    public List<Product> findAll() {
        return projectDao.findAll();
    }

    @Override
    public Boolean delProduct(int id) {
        return projectDao.delUser(id);
    }

    @Override
    public Boolean batchDel(int[] ids) {
        return projectDao.batchDel(ids);
    }

    @Override
    public boolean add(Product product) {
        return projectDao.add(product);
    }

    @Override
    public Product findProductById(int id) {
        return projectDao.findProductById(id);
    }

    @Override
    public Boolean editProductById(Product product) {
        return projectDao.editProductById(product);
    }

    @Override
    public List<Product> findByKeyWord(String key, int current, int limit) {
        return projectDao.findByKeyWord(key, current, limit);
    }

    @Override
    public List<Product> findAllByPage(int current, int limit) {
        return projectDao.findAllByPage(current, limit);
    }

    @Override
    public List<Product> findAllByKey(String key) {
        return projectDao.findAllByKey(key);
    }
}
