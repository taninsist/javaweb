package service.impl;


import dao.IUserDao;
import dao.impl.IUserDaoImpl;
import domain.User;
import service.IUserService;

import java.util.List;

public class UserService implements IUserService {

    private IUserDao iUserDao = new IUserDaoImpl();

    @Override
    public Boolean login(String account, String password) {
        return iUserDao.login(account, password);
    }

    @Override
    public List<User> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public Boolean delUser(int id) {
        return iUserDao.delUser(id);
    }

    @Override
    public List<User> findUserByPage(int current, int limit) {
        return iUserDao.findAllByPage(current, limit);
    }

    @Override
    public User findUserById(int id) {
        return iUserDao.findUserById(id);
    }

    @Override
    public Boolean editUserById(User user) {
        return iUserDao.editUserById(user);
    }

    @Override
    public Boolean add(User user) {
        return iUserDao.add(user);
    }

    @Override
    public Boolean batchDel(int[] ids) {
        return iUserDao.batchDel(ids);
    }

    @Override
    public List<User> findByKeyWork(String key, int current, int limit) {
        return iUserDao.findByKeyWord(key, current, limit);
    }

    @Override
    public List<User> findAllByKey(String key) {
        return iUserDao.findAllByKey(key);
    }
}
