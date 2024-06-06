<%-- 
    Document   : student
    Created on : May 31, 2024, 2:29:35 PM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" action="/QuanLyKhoaLuan/student" modelAttribute="studentInfo" >
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="firstName" placeholder="Tên khóa luận" path="firstName"/>
        <label for="name">Tên</label>
    </div >

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="lastName" placeholder="Mô tả khóa luận" path="lastName"/>
        <label for="name"> Họ Lót</label>
    </div >

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="email" placeholder="Mô tả khóa luận" path="email"/>
        <label for="name">Email</label>
    </div >
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="phone" placeholder="Mô tả khóa luận" path="phone"/>
        <label for="name">Phone</label>
    </div >


    <div class="form-floating">
        <button class="btn btn-info mt-3" type="submit" >
            sản phẩm
        </button>

    </div> 
</form:form>

<!--<div>
    <table class="table">
        <thead>
            <tr>
                <th>Mã sinh viên</th>
                <th>Tên sinh viên</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${students != null}">
                <c:forEach items="${students}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.firstName} ${c.lastName}  </td>
                        <td><a href="<c:url value="/thesis/addThesis/"/>?removeId=${c.id}"><button class="btn btn-danger">Xóa</button></a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</div>-->
