<%-- 
    Document   : council
    Created on : May 27, 2024, 11:26:41 AM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-1">QUẢN TRỊ HỘI ĐỒNG </h1>
<!--<div>
    <a class="btn btn-info" href="<c:url value="/council"/>">Thêm Khóa Luận </a>
</div>-->
<table class="table table-striped mt-1">
    <tr>

        <th>Id</th>
        <th>Tên Hội Đồng </th>
        <th>Ngày Tạo Hội Đồng</th>
        <th></th>
    </tr>
    <c:forEach items="${council}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.createdDate}</td>
            <td>

                <a class="btn btn-info" href="#" />Cập nhật</a>
                <button  class="btn btn-danger">Xóa</button>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<c:url value="/js/script.js" />"></script>