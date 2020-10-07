package main.java.service;

import main.java.bean.User;
import main.java.dao.UserDao;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public void add(User user)
    {
        userDao.add(user);
    }

    public List<User> getUserList(int start,int count)
    {
        return userDao.getUserList(start,count);
    }

    public int getTotal()
    {
        return userDao.getTotal();
    }

    public User getUser(int id)
    {
        return userDao.getUser(id);
    }

    public int  delete(int id) {
        return userDao.delete(id);
    }

    public int update(User user) { return userDao.update(user); }

    public List<User> query(String name, String gender, String phone, String email) {
        return userDao.query(name,gender,phone,email);
    }
}

