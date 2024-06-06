<%-- 
    Document   : Thesis
    Created on : May 27, 2024, 10:49:13 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:choose>
    <c:when test="${thesis.id > 0}"><h1 class="text-center text-info mt-1" > CẬP NHẬP KHÓA LUẬN</h1> </c:when>
    <c:otherwise><h1 class="text-center text-info mt-1" >THÊM KHÓA LUẬN </h1></c:otherwise>
</c:choose>

<div class="form-group">
    <form method="put" action="/QuanLyKhoaLuan/thesises"  >
        <label for="studentId">Sinh viên thực hiện:</label>
        <select id="studentId" name="studentId">
            <option value=""></option>
            <c:forEach items="${listStudent}" var="student">
                <option value="${student.id}">${student.firstName} ${student.lastName}</option>
            </c:forEach>
        </select>
        <input type="submit" class="btn btn-info" value="Thêm sinh viên"></input>
    </form>
    <br>
    <div>
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
                            <td><a href="<c:url value="/thesises/"/>?removeId=${c.firstName}"><button class="btn btn-danger">Xóa</button></a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>

<c:url value="/thesises" var="action" />
<form:form method="post" action="${action}" modelAttribute="thesis"  >
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="name" placeholder="Tên khóa luận" path="name"/>
        <label for="name"> Tên Khóa Luận</label>
    </div >

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="description" placeholder="Mô tả khóa luận" path="description"/>
        <label for="name"> Mô tả khóa luận</label>
    </div >

    <div class="form-floating">
        <form:select class="form-select" id="councilId"  path="councilId">
            <c:forEach items="${council}" var="c">
                <c:choose>
                    <c:when test="${c.id==thesis.councilId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh Sách Hội Đồng</label>
    </div>
    <div class="form-floating">
        <button class="btn btn-info mt-3" type="submit" >
            <c:choose>
                <c:when test="${thesis.id > 0}">Cập nhập Khóa Luận </c:when>
                <c:otherwise>Thêm Khóa Luận</c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id" />
    </div> 
</form:form>

