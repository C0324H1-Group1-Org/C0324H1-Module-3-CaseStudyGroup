<%--
  Created by IntelliJ IDEA.
  User: E7470
  Date: 07/07/2024
  Time: 11:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Order Details</title>
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
<body class="gradient-custom">
<%@ include file="/navbar/navbar.jsp" %>

<section class="h-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-10 col-xl-8">
                <div class="card" style="border-radius: 10px;">
                    <div class="card-header px-4 py-5 bg-warning-custom">
                        <h5 class="text-muted mb-0">Thanks for your Order</h5>
                    </div>
                    <c:set var="totalAll" value="${0}"></c:set>
                    <c:forEach var="orderDetail" items="${orderDetails}">

                    <div class="card-body p-4">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0" style="color: #a8729a;">Receipt</p>
                            <p class="small text-muted mb-0">Date order: ${orderDetail.dateOrder}</p>
                            <p class="text-muted mb-0 small">${orderDetail.status}</p>
                        </div>
                        <c:set var="total" value="${0}"></c:set>
                        <c:forEach var="detail" items="${orderDetail.orderProductDTOS}">
                            <div class="card shadow-0 border mb-4">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <img src="${detail.urlImage}" class="img-fluid" alt="Product Image">
                                        </div>
                                        <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                            <p class="text-muted mb-0">${detail.nameProduct}</p>
                                        </div>
                                        <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                            <p class="text-muted mb-0 small">Quantity: ${detail.quantity}</p>
                                        </div>
                                        <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
<%--                                            <p class="text-muted mb-0 small">Price: ${detail.price} VND</p>--%>
                                            <p class="text-muted mb-0 small"><fmt:formatNumber type="number" maxFractionDigits="5" value="${detail.price}" />VND</p>
                                        </div>
                                        <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
                                            <p class="text-muted mb-0 small"><fmt:formatNumber type="number" maxFractionDigits="5" value="${detail.price * detail.quantity}" />VND</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:set var="total" value="${total + detail.quantity * detail.price}"></c:set>
                        </c:forEach>
                        <c:set var="totalAll" value="${totalAll + total}"></c:set>
                        <div class="d-flex justify-content-between pt-2">
                            <p class="fw-bold mb-0">Order Details</p>
                            <p class="text-muted mb-0"><span class="fw-bold me-4">Total</span><fmt:formatNumber type="number" maxFractionDigits="5" value="${total}" /> VND</p>
                        </div>

                        <div class="d-flex justify-content-between pt-2">
                            <p class="fw-bold mb-0">Ship</p>
                            <p class="text-muted mb-0">Free</p>
                        </div>

                        <hr class="mb-4" style="background-color: #e0e0e0; opacity: 1;">

                    </div>
                    </c:forEach>
                    <h5 class="d-flex align-items-center justify-content-end text-uppercase mb-0">Total
                        paid: <span class="h2 mb-0 ms-2"><fmt:formatNumber type="number" maxFractionDigits="5" value="${totalAll}" /> VND</span></h5>
<%--                    END DIV CARD--%>
                </div>
            </div>
        </div>
    </div>
</section>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
