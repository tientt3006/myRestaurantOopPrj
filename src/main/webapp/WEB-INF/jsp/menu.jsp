<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<c:set var="title" value="OOP Dinner - Log in" scope="page"/>
<%@ include file="head.jspf" %>


<body>
    <div class="wrapper">
        <!--Header Section--> 
        
        <%@ include file="cus_header.jspf" %>
        <div class="main-container">
            <div class="menu-container">
                <h2>Menu</h2>
                <div class="filter-sort-bar">
                    <form action="menu.jsp" method="GET">
                        <label for="category">Categorize: </label>
                        <select name="category" id="category">
                            <option value="">All</option>
                            <option value=1>Meat</option>
                            <option value=2>Wine</option>
                            <option value=3>Vegetable</option>
                        </select>

                        <label for="sort">Price:</label>
                        <select name="sort" id="sort">
                            <option value="">Default</option>
                            <option value="price-asc">Increasing</option>
                            <option value="price-desc">Decreasing</option>
                        </select>

                        <button type="submit">Filter</button>
                    </form>
                </div>
                
                
                
                
                
                
                
                <div class="menu">
                    <c:forEach var="dish" items="${dishes}">
                        <div class="menu-item">
                            <img src="${pageContext.request.contextPath}/img/PRRestaurant.jpg" alt="${dish}">
                            <h3>${dish.dishName}</h3>
                            <p>${dish.ingredient}</p>
                            <p>${dish.price} $</p>
                        </div>
                    </c:forEach>
                </div>
                <div class="pagination">
                    <c:if test="${currentPage > 1}">
                        <a href="?page=${currentPage - 1}">Prior Page</a>
                    </c:if>
                    
                    <c:forEach var="i" begin="1" end="${totalPages}">
                        <a href="?page=${i}" style="${i == currentPage ? 'font-weight: bold;' : ''}">
                            ${i}
                        </a>
                    </c:forEach>
                    
                    <c:if test="${currentPage < totalPages}">
                        <a href="?page=${currentPage + 1}">Next Page</a>
                    </c:if>
                  
                </div>
            </div>
        </div>
        <!-- Footer -->
        <%@ include file="cus_footer.jspf" %>
    </div>
</body>
</html>                

