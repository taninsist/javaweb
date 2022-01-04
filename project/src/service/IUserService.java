package service;


import domain.User;

import java.util.List;

public interface IUserService {
    Boolean login(String account, String password);

    List<User> findAll();

    Boolean delUser(int id);

    List<User> findUserByPage(int current, int limit);

    User findUserById(int id);

    Boolean editUserById(User user);

    Boolean add(User user);

    //batch
    Boolean batchDel(int ids[]);

    List<User> findByKeyWork(String key, int current, int limit);

    List<User> findAllByKey(String key);
}
