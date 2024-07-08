<%--
  Created by IntelliJ IDEA.
  User: E7470
  Date: 07/07/2024
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
<body style="background-color: black">
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

<section class="py-4">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-8 col-md-10">
        <div class="card border-0 rounded-3 shadow-lg bg-dark">
          <div class="card-body p-4">
            <h3 class="fs-5 fw-light text-center text-white mb-3">Xác nhận đặt hàng</h3>
            <form class="row g-3" action="order?action=order" method="post">
              <div class="col-md-6">
                <label for="fullName" class="form-label">Full Name</label>
                <input type="text" class="form-control" name="name" value="${customer.name}" id="fullName" placeholder="Full Name" required>
              </div>
              <div class="col-md-6">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="text" class="form-control" name="phone" value="${customer.phone}" id="phoneNumber" placeholder="Phone Number" required>
              </div>
              <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" value="${customer.email}" id="email" placeholder="name@example.com" required>
              </div>
              <div class="col-md-6">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" name="address" value="${customer.address}" id="address" placeholder="Address" required>
              </div>
              <div class="col-12">
                <div class="form-check">
                  <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
                  <label class="form-check-label" for="invalidCheck3">
                    Thanh toán khi nhận hàng
                  </label>
                </div>
              </div>
              <form action="order?action=order&id=${order.id}" method="post">
                <div class="col-12 text-center">
                  <button class="btn btn-warning btn-lg" type="submit">Xác nhận</button>
                </div>
              </form>
            </form>
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
