<%--
  Created by IntelliJ IDEA.
  User: Doncoi
  Date: 2020/9/26
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>学生信息管理系统</title>
  </head>
  <body>
    <h1>学生信息管理系统</h1>
<%--    <a href="<c:url value='/helloworld.jsp'/>"> Hello World! </a>--%>
    <hr></hr>
    <a href="<c:url value='/add.jsp'/>">添加学生</a>
    <hr></hr>
    <a href="<c:url value='/UserListServlet'/>">查询信息</a>
    <hr></hr>
    <a href="<c:url value='/query.jsp'/>">搜索用户</a>
  </body>
</html>
