<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Doncoi
  Date: 2020/10/5
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<%--使用post方法向UserServlet发送数据--%>
<form action="${pageContext.request.contextPath}/UserServlet" method="post">
    <input type="hidden" name="method" value="add">
    <table border="0" align="center"  style="width:600px; margin:44px auto" class="table">
        <tr>
            <td width="100px">学生姓名</td>
            <td width="40%">
                <input type="text" name="name"/>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                <input type="radio" name="gender" value="male" id="male"/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female"/>
                <label for="female">女</label>
            </td>
            <td>
                <label id="genderError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="phone" id="phone"/>
            </td>
            <td>
                <label id="phoneError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" id="email"/>
            </td>
            <td>
                <label id="emailError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" class="btn btn-primary"/>
                <input type="reset" name="reset" class="btn btn-default"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
