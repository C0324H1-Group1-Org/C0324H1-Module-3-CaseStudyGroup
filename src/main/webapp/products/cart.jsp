<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: h4kar
  Date: 7/6/2024
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        body {
            background-color: #343a40;
            color: white;
        }
        .table-dark {
            background-color: #343a40;
            color: white;
        }
    </style>
</head>
<body>
<%@ include file="/navbar/navbar.jsp" %>
<div class="container mt-2">
    <h2 class="display-4">GIỎ HÀNG</h2>
    <hr>
    <c:choose>
        <c:when test="${empty carts}">
            <p>Ban chua them san pham nao vao gio hang</p>
            <a href="/daisy"><button type="button" class="btn btn-outline-success" >Quay lai mua hang</button></a>
        </c:when>
        <c:otherwise>
            <c:set var="total" value="${0}"></c:set>
            <table class="table table-hover table-dark">
                <thead>
                <tr>
                    <th>Hình ảnh</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${carts}" var="cart">
                    <tr>
                        <td><img src="${cart.urlImage}" alt="" style="width: 200px"></td>
                        <td class="align-middle">${cart.nameProduct}</td>
                        <td class="align-middle"><fmt:formatNumber type="number" maxFractionDigits="5" value="${cart.price}" /> VND</td>
                        <form action="cart?action=update" method="post">
                        <td class="align-middle">
                            <div data-mdb-input-init class="form-outline" style="width: 50%">
                                <input name="inputQuantity" min="1" type="number" id="typeNumber" class="form-control" value="${cart.quantity}"/>
                            </div>
                        </td>
                        <td class="align-middle"><fmt:formatNumber type="number" maxFractionDigits="5" value="${cart.priceQuantity}" /> VND</td>
                        <td class="align-middle">
                            <button type="submit" class="btn btn-warning" >Cập nhật</button>
                            <input type="hidden" name="idProduct" value="${cart.idProduct}">
                            <input type="hidden" name="idCart" value="${cart.idCart}">
                        </form>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${cart.idCart}">
                            Xóa
                        </button>
                        </td>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal${cart.idCart}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content bg-black text-white">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Bạn có muốn xóa sản phẩm ${cart.nameProduct}
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                                        <form action="/cart?action=delete" method="post">
                                            <button type="submit" class="btn btn-warning" >Xóa</button>
                                            <input type="hidden" name="idProduct" value="${cart.idProduct}">
                                            <input type="hidden" name="idCart" value="${cart.idCart}">
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </tr>
                    <c:set var="total" value="${total + cart.priceQuantity}"></c:set>
                </c:forEach>


                <tr>
                    <td><a href="/daisy"><button type="button" class="btn btn-secondary" >Quay lại mua hàng</button></a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        Tổng tiền <br>
                        <fmt:formatNumber type="number" maxFractionDigits="5" value="${total}" /> VND
                    </td>
                        <td><a href="/order?action=order"><button type="submit" class="btn btn-warning">Đặt hàng</button></a></td>
                </tr>

                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
