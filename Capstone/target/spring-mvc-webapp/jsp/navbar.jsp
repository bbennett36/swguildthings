<%-- 
    Document   : navbar
    Created on : Jun 23, 2016, 9:21:43 AM
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
        <meta charset="utf-8">

    </head>
    <body>


        <nav class="navbar navbar-inverse">
            <div class="container-fluid">


                <ul class="nav navbar-nav nav-divider">
                    <li ><a href="${pageContext.request.contextPath}"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                        <c:forEach items="${adminPage}" var="page">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/admin/${page.urlSlug}">${page.pageName}</a></li>
                        </c:forEach>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/adminpages/pages"><span class="glyphicon glyphicon-lock"></span> Administration</a></li>
                        </sec:authorize>
                </ul>
                <ul class="nav navbar-nav navbar-right">

                    <li>
                        <sec:authorize access="!isAuthenticated()">
                            <a href="${pageContext.request.contextPath}/login/signup"><strong>Sign up</strong></a>
                        </sec:authorize>
                    </li>
                    <li>
                        <sec:authorize access="!isAuthenticated()">
                            <a href="${pageContext.request.contextPath}/login/login"><strong><span class="glyphicon glyphicon-log-in"></span> Login</strong></a>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <a href="${pageContext.request.contextPath}/logout"><strong> <span class="glyphicon glyphicon-log-out"></span> Logout</strong></a>
                        </sec:authorize>
                    </li>
                </ul>

            </div>
        </nav>         

    </body>
</html>
