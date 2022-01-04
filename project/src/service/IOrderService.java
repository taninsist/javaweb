package service;

import domain.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAllByPage(int current, int limit);

    List<Order> findAllByKeywork(String key, int current, int limit);

    List<Order> findAllByKey(String key);

    List<Order> findAll();

    Boolean delOrder(int id);

    Boolean batchDel(int ids[]);

    Order findProductById(int id);

    Boolean editOrderById(Order order);

}
