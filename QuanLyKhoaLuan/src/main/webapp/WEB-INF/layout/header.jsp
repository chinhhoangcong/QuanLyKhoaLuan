<%-- 
    Document   : header
    Created on : May 27, 2024, 10:37:15 AM
    Author     : ACER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/" />">Trang Chủ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>"> Quản Lý khóa luận</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/council"/>"> Quản Lý Hội Đồng</a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class=" btn btn-info " href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class=" btn btn-danger " href="<c:url value="/" />">Chào ${pageContext.request.userPrincipal.name}!</a>
                        </li>
                        <li class="nav-item">
                            <a class=" btn btn-info " href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                </c:choose>
                <li class="nav-item">
                    <a class=" btn btn-danger " href="<c:url value="/stats" />">Thống kê báo cáo</a>
                </li>
            </ul>

        </div>
        <form action="<c:url value="/" />" class="d-flex">
            <input class="form-control me-2" name="kw" type="search" placeholder="Nhập tên...">
            <button class="btn btn-primary" type="submit">Tìm</button>
        </form>
    </div>
</nav>