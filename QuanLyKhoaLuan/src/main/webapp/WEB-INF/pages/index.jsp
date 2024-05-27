<%-- 
    Document   : index
    Created on : May 25, 2024, 2:17:16 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-1">QUẢN TRỊ KHÓA LUẬN </h1>
<div>
    <a class="btn btn-info" href="<c:url value="/thesises"/>">Thêm Khóa Luận </a>
</div>
<table class="table table-striped mt-1">
    <tr>

        <th>Id</th>
        <th>Tên Khóa Luận</th>
        <th>Mô tả</th>
        <th></th>
    </tr>
    <c:forEach items="${thesis}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>

                <a class="btn btn-info" href="#" />Cập nhật</a>
                <button  class="btn btn-danger">Xóa</button>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<c:url value="/js/script.js" />"></script>

