<%-- 
    Document   : factresponse
    Created on : May 26, 2016, 9:55:11 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>

        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/site.css">

    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <a class="navbar-brand glyphicon glyphicon-home"  href="http://localhost:8080/LuckySevenWeb/" ></a>
                <ul class="nav navbar-nav nav-tabs">
                    <li><a class="glyphicon glyphicon-piggy-bank" href="http://localhost:8080/LuckySevenWeb/LuckyServlet">LuckySevens</a></li> 
                    <li class="nav-item active"><a class="glyphicon glyphicon-flash" href="http://localhost:8080/LuckySevenWeb/FactorizerController" >Factorizer</a> </li>
                    <li><a class="glyphicon glyphicon-usd" href="http://localhost:8080/LuckySevenWeb/InterestCalcController" >InterestCalculator</a></li>
                    <li><a class="glyphicon glyphicon-cutlery" href="http://localhost:8080/LuckySevenWeb/TipCalcController" >TipCalculator</a></li>
                    <li><a class="glyphicon glyphicon-refresh" href="http://localhost:8080/LuckySevenWeb/ConverterController" >Converter</a></li>                    
                </ul>
            </div>  
        </nav>



        <h2>${printNum}</h2>
        <h2>${factors}</h2>
        <h2>${factorsAre}</h2>

        <c:forEach items="${numbers}" var="number">
            <h2>${number}</h2>
        </c:forEach>
        <h2>${totalFactor}</h2>
        <h2>${perfectNum}</h2>
        <h2>${factorC}</h2>

        <button id="again" type="submit" class="btn btn-danger btn-lg"><a href="http://localhost:8080/LuckySevenWeb/FactorizerController">Factor Again</a></button>
        <br  />
        <br />

        <div class="footer">
            <p>Created by Brennan Bennett 2016</p>
        </div>    

    </body>
</html>
