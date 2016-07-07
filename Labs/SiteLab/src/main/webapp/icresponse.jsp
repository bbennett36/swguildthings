<%-- 
    Document   : icreponse
    Created on : May 27, 2016, 7:24:45 AM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>

    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/site.css">


    <body>




        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <a class="navbar-brand glyphicon glyphicon-home"  href="http://localhost:8080/LuckySevenWeb/" ></a>
                <ul class="nav navbar-nav nav-tabs">
                    <li><a class="glyphicon glyphicon-piggy-bank" href="http://localhost:8080/LuckySevenWeb/LuckyServlet">LuckySevens</a></li> 
                    <li><a class="glyphicon glyphicon-flash" href="http://localhost:8080/LuckySevenWeb/FactorizerController" >Factorizer</a> </li>
                    <li class="nav-item active"><a class="glyphicon glyphicon-usd" href="http://localhost:8080/LuckySevenWeb/InterestCalcController" >InterestCalculator</a></li>
                    <li><a class="glyphicon glyphicon-cutlery" href="http://localhost:8080/LuckySevenWeb/TipCalcController" >TipCalculator</a></li>
                    <li><a class="glyphicon glyphicon-refresh" href="http://localhost:8080/LuckySevenWeb/ConverterController" >Converter</a></li>
                </ul>
            </div>  
        </nav>


        
        <c:forEach items="${printStuff}" var="p">
            <p id="ic">${p}</p>
        </c:forEach>


        <button id="again" type="submit" class="btn btn-warning btn-lg"><a href="http://localhost:8080/LuckySevenWeb/InterestCalcController">Calculate Again</a></button>


        <div class="footer">
            <p>Created by Brennan Bennett 2016</p>
        </div>    



    </body>
</html>
