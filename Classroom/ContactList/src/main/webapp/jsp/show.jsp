<%-- 
    Document   : show
    Created on : Jun 1, 2016, 10:10:47 AM
    Author     : apprentice
--%>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">

<!-- SWC Icon -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                <div class="col-md-6">
                    


                <div class="col-md-6">

                    First ${contact.firstName}<br />
                    Last ${contact.lastName}<br />
                    Company ${contact.company}<br />
                    Email ${contact.email}<br />
                    Phone ${contact.phone}<br />


                </div>


                <!-- Placed at the end of the document so the pages load faster -->
                <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

                </body>
                </html>
