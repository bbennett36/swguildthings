<%-- 
    Document   : convresponse
    Created on : May 28, 2016, 1:49:00 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Converter</title>

        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/site.css">


    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <a class="navbar-brand glyphicon glyphicon-home"  href="http://localhost:8080/LuckySevenWeb/" ></a>
                <ul class="nav navbar-nav nav-tabs">
                    <li><a class="glyphicon glyphicon-piggy-bank" href="http://localhost:8080/LuckySevenWeb/LuckyServlet">LuckySevens</a></li> 
                    <li><a class="glyphicon glyphicon-flash" href="http://localhost:8080/LuckySevenWeb/FactorizerController" >Factorizer</a> </li>
                    <li><a class="glyphicon glyphicon-usd" href="http://localhost:8080/LuckySevenWeb/InterestCalcController" >InterestCalculator</a></li>
                    <li><a class="glyphicon glyphicon-cutlery" href="http://localhost:8080/LuckySevenWeb/TipCalcController" >TipCalculator</a></li>
                    <li class="nav-item active"><a class="glyphicon glyphicon-refresh" href="http://localhost:8080/LuckySevenWeb/ConverterController" >Converter</a></li>
                </ul>
            </div>
        </nav>
        
        <br />
        <br />
        
        <h2>${c}</h2>
        <h2>${f}</h2>
        <h2>${euro}</h2>
        <h2>${dollars}</h2>
        <h2>${kg}</h2>
        <h2>${lb}</h2>

        <button id="again2" type="submit" class="btn btn-default btn-lg"><a href="http://localhost:8080/LuckySevenWeb/ConverterController">Convert Again</a></button>


        <div class="footer">
            <p>Created by Brennan Bennett 2016</p>
        </div>   


    </body>
</html>
