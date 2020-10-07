package main.java.dao;

import java.sql.*;
import main.java.bean.User;
import java.util.ArrayList;
import java.util.List;

//工具类
//提供封装好的数据库操作
public class UserDao {
    //增加用户
    public void add(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = "insert into users values(null,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);
//            //生成id
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                user.setId(rs.getInt(1));
//            }

//            ps.setInt(1,user.getId());
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.execute();

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除指定用户
    public int delete(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = " delete from users where id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    //查询特定用户
    public User getUser(int id) {
        User user = new User();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = "select * from users where id = ? ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
//                String description = rs.getString(6);

                user.setId(pid);
                user.setName(name);
                user.setGender(gender);
                user.setPhone(phone);
                user.setEmail(email);
//                user.show();
//                user.setDescription(description);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int update(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = "update users set name=?,gender=?,phone=?,email=? where id=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
//            ps.setString(5, user.getDescription());
            ps.setInt(5,user.getId());
            ps.execute();

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    //查询所有用户
    public List<User> getUserList(int start, int count) {
        List<User> users = new ArrayList<User>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = "select * from users order by id limit ?,?";
//            String sql = "select * from user order by id";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
//                String description = rs.getString(6);

                user.setId(id);
                user.setName(name);
                user.setGender(gender);
                user.setPhone(phone);
                user.setEmail(email);
//                user.setDescription(description);
                users.add(user);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    //获取总数
    public int getTotal() {
        int total = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            String sql = " select count(*) from  users ";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    //查询特定用户
    public List<User> query(String name, String gender, String phone, String email) {
        StringBuilder sql = new StringBuilder();
        List<User> users = new ArrayList<User>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection
                    ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC", "root", "1021");

            sql.append("select * from users where 1=1");
            if (name!=null&&!name.trim().isEmpty()){
                sql.append(" and name like ?");
            }
            if (gender!=null&&!gender.trim().isEmpty()){
                sql.append(" and gender=?");
            }
            if (phone!=null&&!phone.trim().isEmpty()){
                sql.append(" and phone like ?");
            }
            if (email!=null&&!email.trim().isEmpty()){
                sql.append(" and email like ?");
            }
            PreparedStatement ps = c.prepareStatement(sql.toString());
            if (name!=null&&!name.trim().isEmpty()){
                ps.setString(1,"%"+name+"%");
            }
            if (gender!=null&&!gender.trim().isEmpty()){
                if (name!=null&&!name.trim().isEmpty()){
                    ps.setString(2,gender);
                }else {
                    ps.setString(1,gender);
                }
            }
            if (phone!=null&&!phone.trim().isEmpty()){
                if (gender!=null&&!gender.trim().isEmpty()){
                    if (name!=null&&!name.trim().isEmpty()){
                        ps.setString(3,"%"+phone+"%");
                    }else {
                        ps.setString(2,"%"+phone+"%");
                    }
                }else {
                    ps.setString(1,"%"+phone+"%");
                }
            }
            if (email!=null&&!email.trim().isEmpty()){
                if (phone!=null&&!phone.trim().isEmpty()){
                    if (gender!=null&&!gender.trim().isEmpty()){
                        if (name!=null&&!name.trim().isEmpty()){
                            ps.setString(4,"%"+email+"%");
                        }else {
                            ps.setString(3,"%"+email+"%");
                        }
                    }else {
                        ps.setString(2,"%"+email+"%");
                    }
                }else {
                    ps.setString(1,"%"+email+"%");
                }
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt(1);
                String name1 = rs.getString(2);
                String gender1 = rs.getString(3);
                String phone1 = rs.getString(4);
                String email1 = rs.getString(5);

                user.setId(id);
                user.setName(name1);
                user.setGender(gender1);
                user.setPhone(phone1);
                user.setEmail(email1);
                users.add(user);
            }

            ps.close();

            c.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }
}

