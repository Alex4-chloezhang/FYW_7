<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/13
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        @import "css/c1.css";
    </style>
</head>
<body>
<h2>修改商品</h2>
<form action="${pageContext.request.contextPath}/updateItem" method="post">
    <table>
        <tr>
            <td>商品名称</td>
            <td>
                <input type="hidden" name="id" value="${im.id}">
                <input type="text" name="name" value="${im.name}">
            </td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><input type="text" name="destr" value="${im.destr}"></td>
        </tr>
        <tr>
            <td>库存数量</td>
            <td><input type="text" name="num" value="${im.num}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
