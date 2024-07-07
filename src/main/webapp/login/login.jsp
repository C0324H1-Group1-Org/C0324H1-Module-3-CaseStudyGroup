<%--
  Created by IntelliJ IDEA.
  User: E7470
  Date: 05/07/2024
  Time: 11:02 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                    <a class="nav-link" href="javascript:void(0)">Giỏ Hàng</a>
                </li>
            </ul>
            <form class="d-flex mt-2">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-outline-warning" type="button">Search</button>
            </form>
        </div>
    </div>
</nav>

<section class=" py-3 py-md-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4" >
                <div class="card rounded-3 shadow-sm bg-dark">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <div class="text-center text-white mb-3">
                            <a href="#!">
                                <img src="logo_daisy.png" alt="BootstrapBrain Logo" width="150" height="150">
                            </a>
                        </div>
                        <h2 class="fs-6 fw-normal text-center text-secondary mb-4">Sign in to your account</h2>
                        <form action="" method="post">
                            <div class="row gy-2 overflow-hidden">
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="username" value="${user.username}" id="username" placeholder="username" required>
                                        <label for="username" class="form-label">Username</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="password" id="password" value="" placeholder="Password" required>
                                        <label for="password" class="form-label">Password</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="d-flex gap-2 justify-content-between">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value="" name="rememberMe" id="rememberMe">
                                            <label class="form-check-label text-secondary" for="rememberMe">
                                                Keep me logged in
                                            </label>
                                        </div>
                                        <a href="#!" class="link-warning text-decoration-none">Forgot password?</a>
                                    </div>
                                </div>
                                <p style="color: red;">${message}</p>
                                <div class="col-12">
                                    <div class="d-grid my-3">
                                        <button class="btn btn-warning btn-lg" type="submit">Log in</button>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <p class="m-0 text-secondary text-center">Don't have an account? <a href="?action=register" class="link-warning text-decoration-none">Sign up</a></p>
                                </div>
                            </div>
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
