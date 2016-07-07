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
        <p></p>
        <div class="container">
            <div class="col-md-12">
                <div class="navbar navbar-inverse">
                    <ul class="nav navbar-nav nav-justified">
                        <li role="presentation" class="active" id="title"><a href="${pageContext.request.contextPath}">Flooring Mastery</a></li>
                    </ul>
                </div>
            </div>





            <!--<div class="row">-->
            <div class="col-md-12">
                <table class="table">
                    <c:if test="${stateSearch}">
                        <tr style="background-color: #000; color: white;">
                            <th>State</th>
                            <th>Tax Rate</th>
                        </tr>
                        <tr>
                            <td>${tax.state}</td>
                            <td>${rateFormat}</td>
                        </tr>
                    </c:if>

                    <c:if test="${pSearch}">
                        <tr style="background-color: #000; color: white;">
                            <th>Product Type</th>
                            <th>Material Cost PerSqFt</th>
                            <th>Labor Cost PerSqFt</th>
                        </tr>
                        <tr>
                            <td>${product.productType}</td>
                            <td>${product.matCostSqf}</td>
                            <td>${product.laborCostSqf}</td>
                        </tr>
                    </c:if>

                    <c:if test="${showSearch}">
                        <tr style="background-color: #000; color: white;">
                            <th>Name</th>
                            <th>State</th>
                            <th>Tax Rate</th>
                            <th>Date</th>
                            <th>Product</th>
                            <th>Area</th>
                            <th>Labor Cost</th>
                            <th>Labor Cost per SqFt</th>
                            <th>Material Cost</th>
                            <th>Material Cost per SqFt</th>
                            <th>Tax Total</th>
                            <th>Total</th>
                        </tr>
                        <tr>
                            <td>${order.name}</td>
                            <td>${order.state}</td>
                            <td>${tax}</td>
                            <td>${order.date}</td>
                            <td>${order.product}</td>
                            <td>${area}</td>
                            <td>${lc}</td>
                            <td>${lcs}</td>
                            <td>${mc}</td>
                            <td>${mcs}</td>
                            <td>${tt}</td>
                            <td>${total}</td>
                        </tr>
                    </c:if>
                </table>

                <a href="${pageContext.request.contextPath}" class="btn btn-default btn-lg center-block" role="button" style="width: 170px;">Go Back</a>

            </div>
        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
