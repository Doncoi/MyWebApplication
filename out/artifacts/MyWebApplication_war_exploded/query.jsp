<%--
  Created by IntelliJ IDEA.
  User: Doncoi
  Date: 2020/10/5
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
<h3 align="center">高级搜索</h3>
<form action="<c:url value="/QueryServlet"/>" method="get">
    <input type="hidden" name="method" value="query">
    <table border="0" align="center" style="width:600px; margin:44px auto" class="table">
        <tr>
            <td width="100px">用户名称</td>
            <td width="40%">
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                <select name="gender">
                    <option value="">==请选择性别==</option>
                    <option value="male">male</option>
                    <option value="female">female</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="phone"/>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="搜索" class="btn btn-primary"/>
                <input type="reset" value="重置" class="btn btn-default"/>
            </td>
        </tr>

    </table>
</form>

</body>
</html>