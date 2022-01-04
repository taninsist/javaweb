package dao.impl;

import dao.IUserDao;
import domain.User;
import utils.JDBCUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    @Override
    public boolean login(String account, String password) {
        String sql = "SELECT account,password FROM users WHERE account=? AND password=?;";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, account);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            boolean result = resultSet.next();
            JDBCUtils.close(resultSet, statement, connection);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            //创建连接对象
            connection = JDBCUtils.getConnection();
            //定义sql语句
            String sql = "select * from users";
            statement = connection.prepareStatement(sql);
            //执行sql语句
            resultSet = statement.executeQuery();
            //处理sql语句
            userList = getUsers(resultSet);
            JDBCUtils.close(resultSet, statement, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean delUser(int id) {

        String sql = "delete from users where id=?";


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

    //    @Override
    public List<User> findAllByPage(int current, int limit) {
        int offset = (current - 1) * limit;

        List<User> userList = new ArrayList<>();

        String sql = "select * from users limit ?,?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            //执行sql语句
            resultSet = statement.executeQuery();
            //处理sql语句
            userList = getUsers(resultSet);


            JDBCUtils.close(resultSet, statement, connection);


        } catch (SQLException e) {
            System.out.println("user delete fail");
        }

        return userList;
    }

    @Override
    public List<User> findAllByKey(String key) {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM users WHERE `account`=? OR `passWord`=? OR `email`=? or `sex`=? or `address`=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, key);
            statement.setString(2, key);
            statement.setString(3, key);
            statement.setString(4, key);
            statement.setString(5, key);

            resultSet = statement.executeQuery();
            userList = getUsers(resultSet);

            JDBCUtils.close(resultSet, statement, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    @Override
    public User findUserById(int id) {
        List<User> userList = new ArrayList<>();
        String sql = "select * from users where id=?";

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            //执行sql语句
            resultSet = statement.executeQuery();

            userList = getUsers(resultSet);
            //处理sql语句
        } catch (SQLException e) {
            System.out.println("find user by id fail");
        }

        return userList.get(0);
    }

    @Override
    public Boolean editUserById(User user) {
        String sql = "update `users` set `account`=?,`sex`=?,`address`=?,`birthday`=?,`email`=?  where id=?";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getAccount());
            statement.setString(2, user.getSex());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getBirthday());
            statement.setString(5, user.getEmail());
            statement.setInt(6, user.getId());
            int re = statement.executeUpdate();
            if (re != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("edit user by id fail");
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Boolean batchDel(int[] ids) {

        try {
            String sql = "delete from users where id=?";
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
    public List<User> findByKeyWord(String key, int current, int limit) {
        List<User> list = new ArrayList<>();
        int offset = (current - 1) * limit;
        String sql = "SELECT * FROM users WHERE `account`=? OR `passWord`=? OR `email`=? or `sex`=? or `address`=?  limit ?,? ";
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
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String account = resultSet.getString(2);
                String passWord = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String address = resultSet.getString(5);
                String birthday = resultSet.getString(6);
                String email = resultSet.getString(7);
                list.add(new User(id, account, passWord, sex, address, birthday, email));
            }
            JDBCUtils.close(resultSet, statement, connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean add(User user) {
        String sql = "insert into users values(null,?,?,?,?,?,?)";
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getAccount());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSex());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getBirthday());
            statement.setString(6, user.getEmail());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("add user fail");
            System.out.println(e);
        }

        return false;
    }

    private List<User> getUsers(ResultSet resultSet) {
        List<User> userList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String address = resultSet.getString(5);
                String birthday = resultSet.getString(6);
                String email = resultSet.getString(7);
                User user = new User();
                user.setId(id);
                user.setAccount(username);
                user.setPassword(password);
                user.setSex(sex);
                user.setAddress(address);
                user.setBirthday(birthday);
                user.setEmail(email);
                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println("user 遍历失败");

        }
        return userList;
    }

}
