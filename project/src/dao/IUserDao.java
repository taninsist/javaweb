package dao;

import domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 登录
     */
    boolean login(String account, String password);

    //    /**
//     * 查找所有
//     * @return
//     */
    List<User> findAll();
//

    /**
     * 插入一个用户
     *
     * @param user
     * @return
     */
    boolean add(User user);

    //删除
    boolean delUser(int id);

    //查找通过分页
    List<User> findAllByPage(int current, int limit);

    //查找用户通过id
    User findUserById(int id);

    //修改用户，通过id
    Boolean editUserById(User user);

    //batch
    Boolean batchDel(int ids[]);

    //查找
    List<User> findByKeyWord(String key, int current, int limit);

    List<User> findAllByKey(String key);
}
