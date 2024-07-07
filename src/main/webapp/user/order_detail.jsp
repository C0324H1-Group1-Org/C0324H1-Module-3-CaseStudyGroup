<%--
  Created by IntelliJ IDEA.
  User: E7470
  Date: 07/07/2024
  Time: 11:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .gradient-custom {
            /* fallback for old browsers */
            background: #343a40; /* Màu dark chủ đạo */

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to top left, rgba(52, 58, 64, 1), rgba(54, 59, 65, 1));

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to top left, rgba(52, 58, 64, 1), rgba(54, 59, 65, 1));
        }

        .bg-warning-custom {
            background-color: #ffc107 !important; /* Màu warning */
        }

        .text-warning-custom {
            color: #ffc107 !important; /* Màu chữ warning */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/daisy"><img src="logo_daisy.png" alt="" width="50px" height="50px"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Áo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Quần</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Phụ Kiện</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cart">Giỏ Hàng</a>
                </li>
            </ul>
            <form class="d-flex mt-2">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-outline-light" type="button">Search</button>
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
                            <li><a class="dropdown-item" href="/user?action=order">Your order</a></li>
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
<section class="h-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-10 col-xl-8">
                <div class="card" style="border-radius: 10px;">
                    <div class="card-header px-4 py-5 bg-warning-custom">
                        <h5 class="text-muted mb-0">Thanks for your Order, <span>Anna</span>!</h5>
                    </div>
                    <div class="card-body p-4">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0" style="color: #a8729a;">Receipt</p>
                            <p class="small text-muted mb-0">Date order: </p>
                        </div>

<%--                        <c:forEach var="">--%>

<%--                        </c:forEach>--%>
                        <div class="card shadow-0 border mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2">
                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/13.webp"
                                             class="img-fluid" alt="imageProduct">
                                    </div>
                                    <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                        <p class="text-muted mb-0">Name Product</p>
                                    </div>
                                    <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                        <p class="text-muted mb-0 small">Quantity: 1</p>
                                    </div>
                                    <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                        <p class="text-muted mb-0 small">Price: 499 VND</p>
                                    </div>
                                    <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                        <p class="text-muted mb-0 small">Status</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="d-flex justify-content-between pt-2">
                            <p class="fw-bold mb-0">Order Details</p>
                            <p class="text-muted mb-0"><span class="fw-bold me-4">Total</span> $898.00</p>
                        </div>

                        <div class="d-flex justify-content-between pt-2">
                            <p class="text-muted mb-0">Invoice Number : 788152</p>
                            <p class="text-muted mb-0"><span class="fw-bold me-4">Discount</span> $19.00</p>
                        </div>

                        <div class="d-flex justify-content-between mb-5">
                            <p class="text-muted mb-0">Recepits Voucher : 18KU-62IIK</p>
                            <p class="text-muted mb-0"><span class="fw-bold me-4">Delivery Charges</span> Free</p>
                        </div>
                        <hr class="mb-4" style="background-color: #e0e0e0; opacity: 1;">
                        <h5 class="d-flex align-items-center justify-content-end text-uppercase mb-0">Total
                            paid: <span class="h2 mb-0 ms-2">$1040</span></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
