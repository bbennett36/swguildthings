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
                    <c:if test="${showTable}">
                          <table class="table table-bordered">
                        <tr>
                            <th>Title</th>
                            <th>Release Date</th>
                            <th>MPAA Rating</th>
                            <th>Directors Name</th>
                            <th>Studio</th>
                            <th>Note</th>
                        </tr>
                        <c:forEach items="${found}" var="name">
                            <tr>
                                <td>${name.title}</td>
                                <td>${name.releaseDate}</td>
                                <td>${name.mPAA}</td>
                                <td>${name.directorsName}</td>
                                <td>${name.studio}</td>
                                <td>${name.note}</td>
                            </tr>
                        </c:forEach>


                        <c:if test="${showSearch}">
                            <td>${dvd.title}</td>
                            <td>${reportDate}</td>
                            <td>${dvd.mPAA}</td>
                            <td>${dvd.directorsName}</td>
                            <td>${dvd.studio}</td>
                            <td>${dvd.note}</td>
                        </c:if>
                        </table>
                    </c:if>


                    <c:if test="${avg}">
                        <h1>The average age is ${age}</h1>
                    </c:if>


                </div>
            </div>


            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
