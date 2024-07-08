<%--
  Created by IntelliJ IDEA.
  User: h4kar
  Date: 7/4/2024
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daisy-1</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-dark text-white">
<%@ include file="/navbar/navbar.jsp" %>
<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://theme.hstatic.net/200000455169/1001172863/14/home_slider_image_1.jpg?v=190" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://pos.nvncdn.com/fcb45e-89373/bn/20240401_dXGuRmiz.gif" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://pos.nvncdn.com/fcb45e-89373/bn/20240105_YFCXEWGT.gif" class="d-block w-100" alt="...">
            </div>
        </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>

<div class="container pt-3">
    <h2>TOÀN BỘ SẢN PHẨM</h2>
    <div class="row row-cols-1 row-cols-md-4 g-4">
        <c:forEach items="${products}" var="product">
            <div class="col">
                <div class="card border border-warning border-3">
                 <a href="/productdetail?pid=${product.id}"><img  src="${product.getUrlImage()}" class="card-img-top" alt="..."></a>
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <div >
                            <p>${product.price} VND</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
<%--<<<<<<< HEAD--%>

<%--    <h2>TOÀN BỘ SẢN PHẨM</h2>--%>
<%--    <div class="row row-cols-1 row-cols-md-4 g-4">--%>
<%--        <div class="col">--%>
<%--            <div class="card border border-warning border-3">--%>
<%--                <img src="https://pos.nvncdn.com/fcb45e-89373/ps/20240625_Cj0hRa5K2E.jpeg" class="card-img-top" alt="...">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">BLACK BOXY T-SHIRT</h5>--%>
<%--                    <div >--%>
<%--                        <p>499.000 VND</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <div class="card border border-warning border-3">--%>
<%--                <img src="https://pos.nvncdn.com/fcb45e-89373/ps/20240625_wBH9kgYjf0.jpeg" class="card-img-top" alt="...">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">BROWN BOXY T-SHIRT</h5>--%>
<%--                    <p>499.000 VND</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <div class="card border border-warning border-3">--%>
<%--                <img src="https://pos.nvncdn.com/fcb45e-89373/ps/20240625_8J26sgeGwc.jpeg" class="card-img-top" alt="...">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">DANCER BOXY T-SHIRT</h5>--%>
<%--                    <p>499.000 VND</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <div class="card border border-warning border-3">--%>
<%--                <img src="https://pos.nvncdn.com/fcb45e-89373/ps/20240625_QglkJjSVrD.jpeg" class="card-img-top" alt="...">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">PINK BOXY T-SHIRT</h5>--%>
<%--                    <p>499.000 VND</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <div class="card border border-warning border-3">--%>
<%--                <img src="https://pos.nvncdn.com/fcb45e-89373/ps/20240401_4r3YqcokET.jpeg" class="card-img-top" alt="...">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title">BLACK FLARE TROUSERS</h5>--%>
<%--                    <p>999.000 VND</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--=======--%>
<%-->>>>>>> de1f7261adb5a466389d519e9a882d752281f193--%>

    </div>

</div>
</div>


</body>
</html>
