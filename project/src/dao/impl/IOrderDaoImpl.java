package dao.impl;

import dao.IOrderDao;
import domain.Order;
import domain.Product;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IOrderDaoImpl implements IOrderDao {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    @Override
    public List<Order> findAllByPage(int current, int limit) {
        int offset = (current - 1) * limit;
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT a.id,a.orderNum,a.orderTime,a.orderDesc,a.payType,a.orderStatus,c.productName,b.account FROM `orders` a INNER JOIN users b on a.userid=b.id INNER JOIN products c on a.productid = c.id limit ?,?";
        try {
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            //处理sql语句
            orderList = getOrders(resultSet);
            JDBCUtils.close(resultSet, statement, connection);
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("findAllByPage fail");
        }
        return orderList;
    }

    @Override
    public List<Order> findAllByKeywork(String key, int current, int limit) {
        int offset = (current - 1) * limit;
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT a.id,a.orderNum,a.orderTime,a.orderDesc,a.payType,a.orderStatus,c.productName,b.account FROM `orders` a INNER JOIN users b on a.userid=b.id INNER JOIN products c on a.productid = c.id where a.orderNum=? or a.orderTime=? or  b.account=? or c.productName=? limit ?,?";

        try {
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            statement = connection.prepareStatement(sql);
            statement.setString(1, key);
            statement.setString(2, key);
            statement.setString(3, key);
            statement.setString(4, key);
            statement.setInt(5, offset);
            statement.setInt(6, limit);

            resultSet = statement.executeQuery();
            //处理sql语句
            orderList = getOrders(resultSet);
            JDBCUtils.close(resultSet, statement, connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;
    }

    @Override
    public List<Order> findAllByKey(String key) {

        String sql = "SELECT a.id,a.orderNum,a.orderTime,a.orderDesc,a.payType,a.orderStatus,c.productName,b.account FROM `orders` a INNER JOIN users b on a.userid=b.id INNER JOIN products c on a.productid = c.id where a.orderNum=? or a.orderTime=? or  b.account=? or c.productName=?";

        List<Order> orderList = new ArrayList<>();

        try {

            /**
             * a.orderNum=? or a.orderTime=? or  b.account=? or c.productName=?
             */
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            statement = connection.prepareStatement(sql);
            statement.setString(1, key);
            statement.setString(2, key);
            statement.setString(3, key);
            statement.setString(4, key);

            resultSet = statement.executeQuery();
            //处理sql语句
            orderList = getOrders(resultSet);
            JDBCUtils.close(resultSet, statement, connection);

        } catch (SQLException e) {
            System.out.println(e);

        }

        return orderList;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();

        String sql = "SELECT a.id,a.orderNum,a.orderTime,a.orderDesc,a.payType,a.orderStatus,c.productName,b.account FROM `orders` a INNER JOIN users b on a.userid=b.id INNER JOIN products c on a.productid = c.id";
        try {
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();
            //处理sql语句
            orderList = getOrders(resultSet);
            JDBCUtils.close(resultSet, statement, connection);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("order findall fail");

        }

        return orderList;
    }

    @Override
    public Boolean delOrder(int id) {
        String sql = "delete from orders where id=?";
        try {
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int re = statement.executeUpdate();
            //处理sql语句

            JDBCUtils.close(resultSet, statement, connection);

            return re > 0;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("order findall fail");
        }
        return false;
    }

    @Override
    public Boolean batchDel(int[] ids) {
        try {
            String sql = "delete from orders where id=?";
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);

            for (int id : ids) {
                statement.setInt(1, id);
                //执行sql语句
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("batch del fail");
        }

        return true;
    }

    @Override
    public Order findProductById(int id) {
        List<Order> orderList = new ArrayList<>();


        String sql = "SELECT a.id,a.orderNum,a.orderTime,a.orderDesc,a.payType,a.orderStatus,c.productName,b.account FROM `orders` a INNER JOIN users b on a.userid=b.id INNER JOIN products c on a.productid = c.id where a.id=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            orderList = getOrders(resultSet);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("batch del fail");
        }


        return orderList.get(0);
    }

    @Override
    public Boolean editOrderById(Order order) {
        String sql = "update `orders` set `orderStatus`=?, `orderDesc`=?, payType=? where id=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getStatus());
            statement.setString(2, order.getDesc());
            statement.setInt(3, order.getPayType());
            statement.setInt(4, order.getId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("batch del fail");
        }

        return false;
    }

    public List<Order> getOrders(ResultSet resultSet) {
        List<Order> list = new ArrayList<>();

        try {
            while (resultSet.next()) {

                Order order = new Order();


                int id = resultSet.getInt(1);
                String num = resultSet.getString(2);
                String date = resultSet.getString(3);
                String desc = resultSet.getString(4);
                int payType = resultSet.getInt(5);
                int status = resultSet.getInt(6);
                String productName = resultSet.getString(7);
                String userName = resultSet.getString(8);

                order.setId(id);
                order.setNum(num);
                order.setDate(date);
                order.setDesc(desc);
                order.setPayType(payType);
                order.setStatus(status);
                order.setProductName(productName);
                order.setUserName(userName);

                list.add(order);

            }

        } catch (SQLException e) {
            System.out.println("product 遍历失败");

        }


        return list;
    }


}
