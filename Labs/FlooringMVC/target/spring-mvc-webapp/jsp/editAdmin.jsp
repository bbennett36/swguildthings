<%-- 
    Document   : editAdmin
    Created on : Jun 2, 2016, 8:09:40 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>

        <div class="container">
            <h1>Flooring</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/adminC/index">Admin Panel</a></li>
                </ul>
            </div>

            <div class="row">
                <div class="col-md-12 text-center">
                    <c:if test="${pEdit}">
                        <form method="POST" action="./" class="form-group-sm" >

                            <div class="form-group">
                                <div class="col-md-12">
                                    <input name="productType" id="t" placeholder="Product Type"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <input name="matCostSqf" id="sn" placeholder="Material Cost PerSqFoot"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12">
                                    <input name="laborCostSqf" id="snum" placeholder="Labor Cost PerSqFoot" />
                                </div>
                            </div>
                            <br />
                            <div class="col-md-12">
                                <br />
                                <button class=" btn btn-danger btn-lg center-block" type="submit">Submit</button>
                            </div>
                        </form>
                    </c:if>    
                </div>    
            </div>


        </div>        

    </body>
</html>
