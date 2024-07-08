<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <meta charset="UTF-8" />
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />--%>
<%--    <meta name="description" content="" />--%>
<%--    <meta name="author" content="" />--%>
    <title>Chi tiết sản phẩm</title>
    <!-- Favicon-->
<%--    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dark-background {
            background-color: #040303;
            color: white;
        }
        .dark-background .btn-outline-dark {
            border-color: white;
            color: white;
        }
        .dark-background .btn-outline-dark:hover {
            background-color: white;
            color: black;
        }
        .dark-in{
            background-color: #292727;
            border-radius: 5px;
        }

    </style>
    <!-- Bootstrap icons-->
<%--    <link href="styles.css" rel="stylesheet" />--%>
    <!-- Core theme CSS (includes Bootstrap)-->


</head>
<body>
<!-- Navigation-->
<%@ include file="/navbar/navbar.jsp" %>
<!-- Product section-->
<div class="py-5 dark-background">
    <div class="container px-4 px-lg-5 my-5 dark-in">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${detail.getUrlImage()}" alt="..." /></div>
            <div class="col-md-6">
                <h1 class="display-5 fw-bolder">${detail.name}</h1>
                <div class="fs-5 mb-5">
                    <span><fmt:formatNumber type="number" maxFractionDigits="5" value="${detail.price}" />VND</span>
                </div>
                <p class="lead">${detail.description}</p>
                <div class="d-flex">
                    <input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="max-width: 3rem" />
                    <button class="btn btn-outline-warning flex-shrink-0" type="button">
                        <i class="bi-cart-fill me-1"></i>
                        Add to cart
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Related items section-->

<!-- Footer-->
<%@ include file="/footer/footer.jsp" %>
<!-- Bootstrap core JS-->
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>--%>
<!-- Core theme JS-->
</body>
</html>
