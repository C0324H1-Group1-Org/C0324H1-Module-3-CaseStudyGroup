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

<section class="py-4">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8 col-md-10">
                <div class="card border-0 rounded-3 shadow-lg bg-dark">
                    <div class="card-body p-4">
                        <div class="text-center mb-3">
                            <a href="#!">
                                <img src="logo_daisy.png" alt="BootstrapBrain Logo" width="120" height="120">
                            </a>
                        </div>
                        <h2 class="fs-5 fw-light text-center text-secondary mb-3">Register your account</h2>
                        <form class="row g-3" action="" method="post">
                            <div class="col-md-6">
                                <label for="fullName" class="form-label">Full Name</label>
                                <input type="text" class="form-control" name="name" value="${name}" id="fullName" placeholder="Full Name" required>
                            </div>
                            <div class="col-md-6">
                                <label for="phoneNumber" class="form-label">Phone Number</label>
                                <input type="text" class="form-control" name="phone" value="${phone}" id="phoneNumber" placeholder="Phone Number" required>
                            </div>
                            <div class="col-md-6">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" name="email" value="${email}" id="email" placeholder="name@example.com" required>
                            </div>
                            <div class="col-md-6">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" name="address" value="${address}" id="address" placeholder="Address" required>
                            </div>
                            <div class="col-md-6">
                                <label for="username" class="form-label">Username</label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text" id="inputGroupPrepend3">@</span>
                                    <input type="text" class="form-control" name="username" value="${username}" id="username" placeholder="Username" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Password" required>
                            </div>
                            <div class="col-12">
                                <div class="form-check">
                                    <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
                                    <label class="form-check-label" for="invalidCheck3">
                                        Agree to terms and conditions
                                    </label>
                                    <p style="color: red;">${message}</p>
                                </div>
                            </div>
                            <div class="col-12 text-center">
                                <button class="btn btn-warning btn-lg" type="submit">Register</button>
                            </div>
                            <p class="text-secondary text-center mb-0">Have an account? <a href="" class="link-warning text-decoration-none">Login Here</a></p>
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
