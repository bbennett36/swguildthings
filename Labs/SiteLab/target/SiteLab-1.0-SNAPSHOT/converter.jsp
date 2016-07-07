<%-- 
    Document   : converter
    Created on : May 28, 2016, 1:48:46 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Converter</title>

        <link ref="stylesheet" href=css/bootstrap.css" type="text/css">
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


        <h1>Converter</h1>

        <br />


        <c:if test="${! hideMenu}">
            <h2>Choose conversion type</h2>
            <form action="ConverterController?action=choice" method="POST">
                <button type="submit" class="btn btn-primary btn-lg" name="mass">Mass</button>
                <button type="submit" class="btn btn-info btn-lg" name="temp">Temperature</button>
                <button type="submit" class="btn btn-success btn-lg" name="currency">Currency</button>
            </form>
        </c:if> 

        <h1>${error}</h1>    

        <c:if test="${tempMenu}">
            <form action="ConverterController?action=FtoC" method="POST">
                <input type="text" name="f" placeholder="Enter Farenheit degrees"/>
                <button type="submit" class="btn btn-info btn-lg">Fahrenheit to Celsius</button>
            </form>
            <br />
            <form action="ConverterController?action=CtoF" method="POST">
                <input type="text" name="c" placeholder="Enter Celcius degrees"/>
                <button type="submit" class="btn btn-info btn-lg">Celsius to Fahrenheit</button>
            </form>
            <br />
            <button id="again2" type="submit" class="btn btn-default btn-lg"><a href="http://localhost:8080/LuckySevenWeb/ConverterController">Go Back</a></button>

        </c:if> 

        <c:if test="${currMenu}">
            <form action="ConverterController?action=UStoEU" method="POST">
                <div class="input-group">
                    <span class="input-group-addon">$</span>
                    <input id="ls" type="text" name="usd"  placeholder="Enter USD amount" class="form-control">
                </div>
                <br />
                <button type="submit" class="btn btn-success btn-lg">USD to EURO</button>
            </form>
            <br />
            <form action="ConverterController?action=EUtoUS" method="POST">
                <div class="input-group">
                    <span class="input-group-addon">€</span>
                    <input id="ls" type="text" name="euro"  placeholder="Enter Euro amount" class="form-control">
                </div>
                <br />
                <button type="submit" class="btn btn-success btn-lg">EURO to USD</button>
            </form>
            <br />
            <br />
            <button id="again2" type="submit" class="btn btn-default btn-lg"><a href="http://localhost:8080/LuckySevenWeb/ConverterController">Go Back</a></button>
        </c:if> 

        <c:if test="${massMenu}">
            <form action="ConverterController?action=LBtoKG" method="POST">
                <div class="input-group">
                    <input type="text" name="lb"  placeholder="Enter Pounds" class="form-control">
                    <span class="input-group-addon">lbs</span>
                </div>
                <br />
                <button type="submit" class="btn btn-primary btn-lg">LB to KG</button>
            </form>
            <br />
            <form action="ConverterController?action=KGtoLB" method="POST">
                <div class="input-group">
                    <input type="text" name="kg"  placeholder="Enter Kilograms" class="form-control">
                    <span class="input-group-addon">kgs</span>
                </div>
                <br />
                <button type="submit" class="btn btn-primary btn-lg">KG to LB</button>
            </form>
            <br />
            <button id="again2" type="submit" class="btn btn-default btn-lg"><a href="http://localhost:8080/LuckySevenWeb/ConverterController">Go Back</a></button>
        </c:if> 




        <div class="footer">
            <p>Created by Brennan Bennett 2016</p>
        </div>   
    </body>
</html>
