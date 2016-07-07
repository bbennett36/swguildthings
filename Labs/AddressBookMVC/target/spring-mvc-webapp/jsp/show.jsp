<%-- 
    Document   : show
    Created on : Jun 1, 2016, 10:10:47 AM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">

    <!-- SWC Icon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Contact List</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered">
                        <tr>
                            <th>First</th>
                            <th>Last</th>
                            <th>Street Number</th>
                            <th>Street Name</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip</th>
                            </th>
                        </tr>
                        <c:forEach items="${found}" var="name">
                            <tr>
                                <td>${name.firstName}</td>
                                <td>${name.lastName}</td>
                                <td>${name.streetNumber}</td>
                                <td>${name.streetName}</td>
                                <td>${name.city}</td>
                                <td>${name.state}</td>
                                <td>${name.zip}</td>
                            </tr>
                        </c:forEach>

                        <%--<c:if test="${showSearch}">--%>
<!--                            <td>${address.firstName}</td>
                            <td>${address.lastName}</td>
                            <td>${address.streetNumber}</td>
                            <td>${address.streetName}</td>
                            <td>${address.city}</td>
                            <td>${address.state}</td>
                            <td>${address.zip}</td>-->
                        <%--</c:if>--%>
                    </table>


                </div>

            </div>


            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
