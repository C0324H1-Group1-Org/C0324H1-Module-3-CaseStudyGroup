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
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@ include file="/navbar/navbar.jsp" %>
<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active h-50">
            <img src="https://theme.hstatic.net/200000690725/1001078549/14/slide_3_img.jpg?v=422" alt="Los Angeles" class="d-block " style="width:100%">
        </div>
        <div class="carousel-item h-50">
            <img src="https://theme.hstatic.net/200000690725/1001078549/14/slide_4_img.jpg?v=422" alt="Chicago" class="d-block " style="width:100%">
        </div>
        <div class="carousel-item h-50">
            <img src="https://theme.hstatic.net/200000690725/1001078549/14/slide_1_img.jpg?v=422" alt="New York" class="d-block " style="width:100%">
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
        <div class="col">
            <div class="card">
                <img src="https://product.hstatic.net/200000690725/product/fstp003-bl-1_53580331053_o_cd70f360b4ac414e97e2a2f70db3f39e_master.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">ÁO POLO</h5>
                    <p class="card-text">Mô tả sản phẩm</p>
                    <p>199000 VND</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="https://product.hstatic.net/200000690725/product/fstp003-bl-1_53580331053_o_cd70f360b4ac414e97e2a2f70db3f39e_master.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">ÁO POLO</h5>
                    <p class="card-text">Mô tả sản phẩm</p>
                    <p>199000 VND</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="https://product.hstatic.net/200000690725/product/fstp003-bl-1_53580331053_o_cd70f360b4ac414e97e2a2f70db3f39e_master.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">ÁO POLO</h5>
                    <p class="card-text">Mô tả sản phẩm</p>
                    <p>199000 VND</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="https://product.hstatic.net/200000690725/product/fstp003-bl-1_53580331053_o_cd70f360b4ac414e97e2a2f70db3f39e_master.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">ÁO POLO</h5>
                    <p class="card-text">Mô tả sản phẩm</p>
                    <p>199000 VND</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="https://product.hstatic.net/200000690725/product/fstp003-bl-1_53580331053_o_cd70f360b4ac414e97e2a2f70db3f39e_master.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">ÁO POLO</h5>
                    <p class="card-text">Mô tả sản phẩm</p>
                    <p>199000 VND</p>
                </div>
            </div>
        </div>

    </div>

</div>



</body>
</html>
