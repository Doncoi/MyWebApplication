package main.java.servlet;


import main.java.bean.User;
import main.java.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int start = 0;
        int count = 10;

        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
            // 当浏览器没有传参数start时
        }
        int next = start + count;
        int pre = start - count;
        //servlet类调用USerService类方法
        int total = new UserService().getTotal();

        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count)
            last = total - count;
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % count;
        //处理pre边界
        pre = Math.max(pre, 0);
        next = Math.min(next, last);

        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("last", last);
        //查询所有数据
        List<User> users = new UserService().getUserList(start,count);
        request.setAttribute("users", users);
        //数据库为空时
        if (users.size()>0){
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }else {
            request.setAttribute("msg", "暂无数据");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}