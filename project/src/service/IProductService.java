package service;

import domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Boolean delProduct(int id);

    //batch
    Boolean batchDel(int ids[]);

    boolean add(Product product);

    Product findProductById(int id);

    Boolean editProductById(Product product);

    List<Product> findByKeyWord(String key, int current, int limit);

    List<Product> findAllByPage(int current, int limit);

    List<Product> findAllByKey(String key);
}
