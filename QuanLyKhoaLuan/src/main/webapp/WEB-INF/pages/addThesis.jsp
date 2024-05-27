<%-- 
    Document   : Thesis
    Created on : May 27, 2024, 10:49:13 AM
    Author     : ACER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-1" > Thêm Khóa Luận</h1>
<c:url value="/thesises" var="action" />
<form:form method="post" action="${action}" modelAttribute="thesis" >
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
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh Sách Hội Đồng</label>
    </div>
    <div class="form-floating">
        <button class="btn btn-info" type="submit" >
           Thêm Khóa Luận
        </button>

    </div>
    

</form:form>





<%--<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"  />
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="name" placeholder="Tên sản phẩm" path="name"/>
        <label for="name"> tên sản phẩm</label>
    </div >

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="price" placeholder="giá sản phẩm" path="price"/>
        <label for="name">giá sản phẩm</label>
    </div>       
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="image" path="file"/>
        <label for="image"> ảnh sản phẩm</label>
        <c:if test="${product.id > 0}">
            <img src="${product.image}" width="200" class="img-fluid" />
        </c:if>
    </div>

    <div class="form-floating">
        <form:select class="form-select" id="categoryId"  path="categoryId">
            <c:forEach items="${category}" var="c">
                <c:choose>
                    <c:when test="${c.id==product.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh Mục</label>
    </div>

    <div class="form-floating">
        <button class="btn btn-info" type="submit" >
            <c:choose>
                <c:when test="${product.id > 0}">cập nhập sản phẩm </c:when>
                <c:otherwise>Thêm sản phẩm</c:otherwise>
            </c:choose>
        </button>
        <form:hidden path="id" />
    </div>

</form:form>--%>

