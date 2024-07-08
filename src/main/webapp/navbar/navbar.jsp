<%--
  Created by IntelliJ IDEA.
  User: h4kar
  Date: 7/4/2024
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/daisy?action=logo"><img src="logo_daisy.png" alt="" width="50px" height="50px"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/daisy?action=shirts">Áo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/daisy?action=pants">Quần</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Phụ Kiện</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cart">Giỏ Hàng</a>
                </li>
            </ul>
            <form class="d-flex mt-2" method="post" action="${pageContext.request.contextPath}/daisy">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                <input type="hidden" name="action" value="search">
<%--                <input class="form-control me-2" type="text" placeholder="Search">--%>
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
<%--            <a href="/login?action=login" class="btn btn-outline-warning ms-2 mb-2">Login</a>--%>
            <c:choose>
                <c:when test="${not empty username}">
                    <div class="dropdown ms-2 mb-2">
                        <button class="btn btn-outline-warning dropdown-toggle" type="button" id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                                ${username}
                        </button>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                            <li><a class="dropdown-item" href="/user?action=info">My account</a></li>
                            <li><a class="dropdown-item" href="/order?action=order">Your order</a></li>
                            <li><a class="dropdown-item" href="/login?action=logout">Logout</a></li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="/login?action=login" class="btn btn-outline-warning ms-2 mb-2">Login</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
