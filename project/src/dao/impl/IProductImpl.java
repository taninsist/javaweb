package dao.impl;

import dao.IProjectDao;
import domain.Product;
import domain.User;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IProductImpl implements IProjectDao {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            String sql = "select * from products";
            statement = connection.prepareStatement(sql);
            //执行sql语句
            resultSet = statement.executeQuery();
            //处理sql语句
            products = getProducts(resultSet);
            JDBCUtils.close(resultSet, statement, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return products;
    }

    @Override
    public boolean delUser(int id) {
        String sql = "delete from products where id=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("删除失败");
        }
        return false;
    }


    @Override
    public Boolean batchDel(int[] ids) {

        try {
            String sql = "delete from products where id=?";
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
    public boolean add(Product product) {
        String sql = "insert into products values(null,?,?,?,?,?,?,?)";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getProductNum());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getCityName());
            statement.setString(4, product.getDepartureTime());
            statement.setFloat(5, product.getProductPrice());
            statement.setString(6, product.getProductDesc());
            statement.setInt(7, product.getProductStatus());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("add user fail");
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Product findProductById(int id) {
        String sql = "select * from `products` where id = ?";
        List<Product> products = new ArrayList<>();

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            //处理sql语句
            products = getProducts(resultSet);


        } catch (SQLException e) {
            System.out.println("findProductById user fail");
            System.out.println(e);
        }

        return products.get(0);
    }

    @Override
    public Boolean editProductById(Product product) {
        String sql = "update `products` set `productNum`=?,`productName`=?,`cityName`=?,`departureTime`=?,`productPrice`=?,`productDesc`=?,`productStatus`=? where `id`=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, product.getProductNum());
            statement.setString(2, product.getProductName());
            statement.setString(3, product.getCityName());
            statement.setString(4, product.getDepartureTime());
            statement.setFloat(5, product.getProductPrice());
            statement.setString(6, product.getProductDesc());
            statement.setInt(7, product.getProductStatus());
            statement.setInt(8, product.getId());
            int re = statement.executeUpdate();
            if (re != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("editProductById fail");
        }
        return false;
    }

    @Override
    public List<Product> findByKeyWord(String key, int current, int limit) {
        int offset = (current - 1) * limit;
        List<Product> products = new ArrayList<>();

        String sql = "select * from products where productNum=? or productName=? or departureTime=? or productDesc=? or cityName=? limit ?,?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, key);
            statement.setString(2, key);
            statement.setString(3, key);
            statement.setString(4, key);
            statement.setString(5, key);
            statement.setInt(6, offset);
            statement.setInt(7, limit);

            resultSet = statement.executeQuery();
            //处理sql语句
            products = getProducts(resultSet);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("editProductById fail");
        }


        return products;
    }

    @Override
    public List<Product> findAllByPage(int current, int limit) {
        int offset = (current - 1) * limit;
        List<Product> products = new ArrayList<>();

        String sql = "select * from products limit ?,?";

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            //处理sql语句
            products = getProducts(resultSet);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("editProductById fail");
        }

        return products;
    }

    @Override
    public List<Product> findAllByKey(String key) {
        List<Product> products = new ArrayList<>();

        String sql = "select * from products where productNum=? or productName=? or departureTime=? or productDesc=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, key);
            statement.setString(2, key);
            statement.setString(3, key);
            statement.setString(4, key);

            resultSet = statement.executeQuery();
            //处理sql语句
            products = getProducts(resultSet);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("editProductById fail");
        }


        return products;
    }


    private List<Product> getProducts(ResultSet resultSet) {
        List<Product> productList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String num = resultSet.getString(2);
                String name = resultSet.getString(3);
                String cityname = resultSet.getString(4);
                String departureTime = resultSet.getString(5);
                Float productPrice = resultSet.getFloat(6);
                String productDesc = resultSet.getString(7);
                int productStatus = resultSet.getInt(8);


                productList.add(new Product(id, num, name, cityname, departureTime, productPrice, productDesc, productStatus));

            }

        } catch (SQLException e) {
            System.out.println("product 遍历失败");

        }
        return productList;
    }
}
