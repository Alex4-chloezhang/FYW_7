<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/13
  Time: 9:11
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
<h2>新增商品</h2>
<form action="${pageContext.request.contextPath}/addItem" method="post">
    <table>
        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><input type="text" name="destr"></td>
        </tr>
        <tr>
            <td>库存数量</td>
            <td><input type="text" name="num"></td>
        </tr>
        <tr>
            <td colspan="2"><input id="addBtn" type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
<script type="application/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="application/javascript" src="js/jquery-validation-1.14.0_jquery.validate.js"></script>
<script type="application/javascript" src="js/jquery-validation-1.14.0_messages_zh.js"></script>
<script>
    $(function () {

    });
</script>
</html>
