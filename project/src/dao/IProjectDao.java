package dao;

import domain.Product;
import domain.User;

import java.util.List;

public interface IProjectDao {
    List<Product> findAll();

    //删除
    boolean delUser(int id);

    //batch
    Boolean batchDel(int ids[]);

    boolean add(Product product);

    Product findProductById(int id);

    Boolean editProductById(Product product);

    List<Product> findByKeyWord(String key, int current, int limit);

    List<Product> findAllByPage(int current, int limit);

    List<Product> findAllByKey(String key);



}
