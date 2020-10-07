package main.java.test;

import main.java.dao.UserDao;
import main.java.bean.User;
import java.util.List;

public class UserDaoTest {
    UserDao testdao = new UserDao();

    public static void main(String args[]) {
        UserDaoTest maintest = new UserDaoTest();
//        maintest.dosomething();
//        maintest.addtest();
//        maintest.deltest();
        maintest.gettotaltest();
//        maintest.getusertest();
        maintest.show();
    }

    //临时测试用
    private void dosomething() {
//        User tempUser = new User("Marci", "female", "806-827-8876", "marci@outlook.com");
//        tempUser.show();
    }

    private void addtest() {
//        UserDao testdao = new UserDao();
        User tempUser = new User("Marci", "female", "806-827-8876", "marci@outlook.com");
        tempUser.show();
        testdao.add(tempUser);
    }

    private void deltest() {
//        testdao.delete(5);
    }

    private void gettotaltest() {
        System.out.println(testdao.getTotal());
    }

    private void getusertest() {
        User tempuser = testdao.getUser(3);
        tempuser.show();
    }

    private void show() {
        List<User> anslist  = testdao.getUserList(0, 10);

        for(User temp : anslist) {
            temp.show();
        }
    }
}
