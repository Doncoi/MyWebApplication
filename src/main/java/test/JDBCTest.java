package main.java.test;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

//数据库连接测试类
public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //创建连接
        Connection conn=DriverManager.getConnection
                ("jdbc:mysql://localhost/mydatabase?serverTimezone=UTC","root","1021");
        //得到执行sql语句的Statement对象
        Statement stmt = conn.createStatement();

        System.out.println("***Connection Success");
        //执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery("select * from users");
        //处理结果
        while (rs.next()) {
            for (int i = 1; i <= 5; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        //关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
