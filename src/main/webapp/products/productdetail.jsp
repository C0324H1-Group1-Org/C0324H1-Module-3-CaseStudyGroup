
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Chi tiết sản phẩm</title>
    <!-- Favicon-->
    <%--    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />--%>
    <link href="styles.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap icons-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <!-- Core theme CSS (includes Bootstrap)-->

</head>
<body>
<!-- Navigation-->
<%@ include file="/navbar/navbar.jsp" %>
<!-- Product section-->
<div class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${detail.getUrlImage()}" alt="..." /></div>
            <div class="col-md-6">
                <h1 class="display-5 fw-bolder">${detail.name}</h1>
                <div class="fs-5 mb-5">
                    <span><fmt:formatNumber type="number" maxFractionDigits="5" value="${detail.price}" />VND</span>
                </div>
                <p class="lead">${detail.description}</p>
                <form action="/productdetail" method="post">
                <div class="d-flex">

                    <input type="hidden" name="idProduct" value="${detail.id}">
                    <input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="max-width: 3rem" name="quantity"/>

                        <button class="btn btn-outline-dark flex-shrink-0" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Add to cart
                        </button>
                </div>
                </form>
                <c:if test="${not empty sessionScope.addToCartMessage}">
                    <div style="color: green;">
                            ${sessionScope.addToCartMessage}
                    </div>
                    <c:remove var="addToCartMessage" scope="session"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
<!-- Related items section-->

<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
</body>
</html>