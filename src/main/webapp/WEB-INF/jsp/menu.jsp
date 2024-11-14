<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Menu" scope="page"/>
<%@ include file="head.jspf" %>

<body>
    <div class="wrapper">
        <!--Header Section--> 
        <%@ include file="cus_header.jspf" %>
        
        <!--Main Section-->
        <div class="main-container">
            <div class="menu-container">
                <jsp:useBean id="categories" scope="session" type="java.util.List"/>
                <jsp:useBean id="sortTypes" scope="application" type="java.util.HashMap"/>
                <jsp:useBean id="dishes" scope="request" type="java.util.List"/>
                <jsp:useBean id="totalPages" scope="request" type="java.lang.Integer"/>
                <nav class="c_header">
                    <form class="c_selectsort_form" action="${pageContext.request.contextPath}/menu" method="get">
                        <div class="left">
                            <div>
                                Category:
                                <label>
                                    <select name="category" class="form-select">
                                        <option value="0">All dishes</option>
                                        <c:forEach var="category" items="${categories}">
                                            <option ${param.category == category.categoryId ? "selected" : ""} value="${category.categoryId}">
                                                    ${category.categoryName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </div>
                            <div>
                                SortBy:
                                <select name="sortBy" class="form-select">
                                    <c:forEach var="sort" items="${applicationScope.sortTypes}">
                                        <option ${param.sortBy == sort.value ? "selected" : ""} value="${sort.value}">${sort.key}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                ShowOnPage:
                                <select name="dishesInPage" class="form-select">
                                    <c:forTokens items="8,16,30" delims="," var="item">
                                        <option ${param.dishesInPage == item ? "selected" : ""}>${item}</option>
                                    </c:forTokens>
                                </select>
                            </div>
                            <select name="page" style="display: none">
                                <option value="0" selected></option>
                            </select>
                        </div>
                        <div class="right">
                            <input class="btn btn-outline-secondary" type="submit" value="SHOW"/>
                        </div>
                        
                    </form>
                </nav>
                        
                <div class="menu">
                    <c:forEach var="dish" items="${dishes}">
                        <div class="menu-item">
                            <img src="${pageContext.request.contextPath}/img/dish-${dish.dishId}.jpg" alt="${dish.dishName}">
                            <h3>${dish.dishName}</h3>
                            <p>${dish.ingredient}</p>
                            <p>${dish.price} VND</p>
                        </div>
                    </c:forEach>
                </div>
                
                <nav class="pagination">
                    <ul class="pagination justify-content-end">
                        <c:if test="${param.page > 0}">
                        <li class="page-item ${param.page > 0 ? "" : "disabled"}">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/menu?category=${param.category}&sortBy=${param.sortBy}&page=${param.page-1}&dishesInPage=${param.dishesInPage}"
                               tabindex="-1">
                                Previous
                            </a>
                        </li>
                        </c:if>
                        <c:forEach var="num" begin="0" end="${totalPages}">
                            <li class="page-item ${param.page == num ? "active" : ""}">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/menu?category=${param.category}&sortBy=${param.sortBy}&page=${num}&dishesInPage=${param.dishesInPage}">
                                        ${num+1}
                                </a>
                            </li>
                        </c:forEach>
                        <c:if test="${param.page < totalPages}">
                        <li class="page-item ${param.page < totalPages ? "" : "disabled"}">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/menu?category=${param.category}&sortBy=${param.sortBy}&page=${param.page+1}&dishesInPage=${param.dishesInPage}">
                                Next
                            </a>
                        </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
                        
                        
        <!-- Footer Section -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>                

