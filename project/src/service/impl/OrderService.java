package service.impl;

import dao.IOrderDao;
import dao.impl.IOrderDaoImpl;
import domain.Order;
import service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {

    private IOrderDao orderDao = new IOrderDaoImpl();

    @Override
    public List<Order> findAllByPage(int current, int limit) {
        return orderDao.findAllByPage(current, limit);
    }

    @Override
    public List<Order> findAllByKeywork(String key, int current, int limit) {
        return orderDao.findAllByKeywork(key, current, limit);
    }

    @Override
    public List<Order> findAllByKey(String key) {
        return orderDao.findAllByKey(key);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Boolean delOrder(int id) {
        return orderDao.delOrder(id);
    }

    @Override
    public Boolean batchDel(int[] ids) {
        return orderDao.batchDel(ids);
    }

    @Override
    public Order findProductById(int id) {
        return orderDao.findProductById(id);
    }

    @Override
    public Boolean editOrderById(Order order) {
        return orderDao.editOrderById(order);
    }
}
