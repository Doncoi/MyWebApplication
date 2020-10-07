package main.java.servlet;

import main.java.bean.User;
import main.java.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    //处理post动作
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        System.out.println("getting message...");
        UserService userService = new UserService();
        User user = new User();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String description = request.getParameter("description");
        System.out.println("message packaged...");
        //要求所有信息不能为空
        if (!name.trim().isEmpty()&&!gender.trim().isEmpty()&&!phone.trim().isEmpty()&&!email.trim().isEmpty()){
            System.out.println("adding new user...");
            user.setName(name);
            user.setGender(gender);
            user.setPhone(phone);
            user.setEmail(email);
            //user.setDescription(description);
            userService.add(user);
            System.out.println("user added...");
            request.setAttribute("msg", "恭喜，成功添加客户");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }else {
            request.setAttribute("msg", "信息不完整");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
