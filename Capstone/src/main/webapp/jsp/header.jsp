<%-- 
    Document   : header
    Created on : Jul 2, 201/6, 2:40:35 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div id="mycarousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="item active">
                <img src="${pageContext.request.contextPath}/img/header_img3.png" alt="Akron Auto Body" class="img-responsive">
                <div class="carousel-caption" style="color: black">
                   <h1>Akron Auto Body</h1>
                </div>
                <sec:authorize var="loggedIn" access="isAuthenticated()" />
                     <c:choose>
                         <c:when test="${loggedIn}">

                             <div style="color: black;position: absolute; bottom: 0; right: 0;"><span class="glyphicon glyphicon-user"></span> Welcome, <strong><%= request.getUserPrincipal().getName()%></strong> &nbsp;</div>

                         </c:when>
                         <c:otherwise>
                         </c:otherwise>
                     </c:choose>
            </div>
        </div>
    </div>
    </body>
</html>
