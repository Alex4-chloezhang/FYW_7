<%--
  Created by IntelliJ IDEA.
  User: CP183
  Date: 2019/12/12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        @import url(css/c1.css);
    </style>
</head>
<body>
<h2>商品列表</h2>
<h2><a href="${pageContext.request.contextPath}/addItem.jsp">添加商品</a></h2>
<table>
    <tr>
        <th>序号</th>
        <th>商品名称</th>
        <th>描述</th>
        <th>库存数量</th>
        <th>操作</th>
    </tr>
    <c:if test="${not empty items}">
        <c:forEach items="${items}" var="im" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${im.name}</td>
                <td>${im.destr}</td>
                <td>${im.num}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/getItem?id=${im.id}">修改</a>
                    || <a href="${pageContext.request.contextPath}/deleteItem?id=${im.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty items}">
        <tr>
            <td colspan="5">没有数据</td>
        </tr>
    </c:if>
</table>
</body>
</html>
