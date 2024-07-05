<%--
  Created by IntelliJ IDEA.
  User: E7470
  Date: 05/07/2024
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%--<nav class="navbar navbar-expand-sm navbar-dark bg-dark">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="javascript:void(0)"><img src="logo_daisy.png" alt="" width="50px" height="50px"></a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collapse navbar-collapse" id="mynavbar">--%>
<%--            <ul class="navbar-nav me-auto">--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="javascript:void(0)">Áo</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="javascript:void(0)">Quần</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="javascript:void(0)">Phụ Kiện</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="javascript:void(0)">Giỏ Hàng</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--            <form class="d-flex mt-2">--%>
<%--                <input class="form-control me-2" type="text" placeholder="Search">--%>
<%--                <button class="btn btn-outline-warning" type="button">Search</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

<section class="bg-dark py-3 py-md-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12">
                <div class="card border border-light-subtle rounded-3 shadow-sm bg-dark">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <div class="text-center text-white mb-3">
                            <a href="#!">
                                <img src="logo_daisy.png" alt="BootstrapBrain Logo" width="150" height="150">
                            </a>
                        </div>
                        <h2 class="fs-6 fw-normal text-center text-secondary mb-4">Register your account</h2>
                        <form action="#!">
                            <div class="row gx-2 overflow-hidden">
                                <div class="col-md-6">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="name" id="fullName" placeholder="Full Name" required>
                                        <label for="fullName" class="form-label">Full Name</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="phone" id="phoneNumber" placeholder="Phone Number" required>
                                        <label for="phoneNumber" class="form-label">Phone Number</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com" required>
                                        <label for="email" class="form-label">Email</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="address" id="address" placeholder="Address" required>
                                        <label for="address" class="form-label">Address</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                                        <label for="username" class="form-label">Username</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                                        <label for="password" class="form-label">Password</label>
                                    </div>
                                </div>
                            </div>
                            <div class="d-grid my-3 mx-5">
                                <button class="btn btn-warning btn-lg" type="submit">Register</button>
                            </div>
                            <p class="m-0 text-secondary text-center">Have an account? <a href="" class="link-warning text-decoration-none">Login Here</a></p>
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
