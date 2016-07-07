<%-- 
    Document   : luckyseven
    Created on : May 26, 2016, 8:51:17 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>

        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/site.css">

    </head>
    <body>





        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <a class="navbar-brand glyphicon glyphicon-home"  href="http://localhost:8080/LuckySevenWeb/" ></a>
                <ul class="nav navbar-nav nav-tabs">
                    <li class="nav-item active"><a class="glyphicon glyphicon-piggy-bank" href="http://localhost:8080/LuckySevenWeb/LuckyServlet">LuckySevens</a></li> 
                    <li><a class="glyphicon glyphicon-flash" href="http://localhost:8080/LuckySevenWeb/FactorizerController" >Factorizer</a> </li>
                    <li><a class="glyphicon glyphicon-usd" href="http://localhost:8080/LuckySevenWeb/InterestCalcController" >InterestCalculator</a></li>
                    <li><a class="glyphicon glyphicon-cutlery" href="http://localhost:8080/LuckySevenWeb/TipCalcController" >TipCalculator</a></li>
                    <li><a class="glyphicon glyphicon-refresh" href="http://localhost:8080/LuckySevenWeb/ConverterController" >Converter</a></li>
                </ul>
            </div>  
        </nav>


        <h1>Lucky Sevens</h1>

        <br />
        <br />
        <form action="LuckyServlet" method="POST">
            <div class="input-group">
                <span class="input-group-addon">$</span>
                <input id="ls" type="text" name="bet"  placeholder="Enter Your Bet " class="form-control">
            </div>
            <br />

            <button type="submit" class="btn btn-success btn-lg">Roll Dice</button>

            <br />

        </form>
        <h1>${error}</h1>

        <div class="footer">
            <p>Created by Brennan Bennett 2016</p>
        </div>    
    </body>
</html>
