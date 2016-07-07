<%-- 
    Document   : bookatrip
    Created on : Jun 9, 2016, 10:05:25 AM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="../favicon.ico"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>First Class Travelers: Home</title>

        <meta name="Description"
              content="Intellectual Sports Training Solutions (ISTS) is a company that has been created to teach Players, Parents, Coaches, Teams, and Organizations about knowledge, skill, and performance for the sport of Baseball and Softball. Knowledge is the overall component that players need to reach their goals. Assessing a players current ability provides a realistic measurement of a players current skill. Utilizing knowledge to enhance a players skill will increase a players overall ability. Performance is a by product of a players increased knowledge and skill that will help them to become more confident to obtain success."/>
        <meta name="Keywords"
              content="traveling, trip, bus, ride, bus ride, vacation, employment, schedule, first, class, travelers, charter"/>


        <meta name="author" content="First Class Travelers"/>
        <meta name="rating" content="General"/>
        <meta name="distribution" content="Global"/>
        <meta name="language" content="English"/>

        <meta name="ROBOTS" content="INDEX,FOLLOW"/>
        <meta http-equiv="Expires" content="0"/>
        <meta name="revisit-after" content="1 days"/>
        <meta name="resource-type" content="document"/>
        <meta name="doc-type" content="Web Page"/>
        <meta name="doc-class" content="Living Document"/>
        <meta name="doc-rights" content="Copywritten Work"/>
        <meta name="copyright" content="First Class Travelers"/>

        <link rel="stylesheet" href="css/bootstrap.min.css"/>

        <!--<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">-->

        <link href="scripts/style.css" rel="stylesheet" type="text/css"/>


    </head>

    <body>
        <div id="top">&nbsp;</div>
        <!--<div id="booklogo"><a href="index.html" ><img src="images/FirstClass_Logo.jpg" width="927" height="175px" alt=""/></a></div>-->

        <div id="wrapper2">
            <br />
            <div class="col-md-4"><a href="index.html" ><img src="images/FirstClass_Logo.jpg" width="120" height="120" alt=""/></a>
            </div>
            <div class="col-md-4 text-center">
                    <form method="POST" action="trip/create" id="bookatrip" style="background-color: white">
                        <h1>Book Your Trip Today!</h1>
                        <hr>
                        <a href="#" class="btn btn-primary active" role="button">Round Trip</a>
                        <a href="#" class="btn btn-primary active" role="button">One Way</a>
                        <br/>
                        <br />
                        From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To
                        <br />
                        <div class="input-group" style="margin-left: 20px;">
                            <select id="from" class="form-control text-center" style="width: 180px;">
                                <option>Select a City</option>
                                <option>Akron, OH</option>
                                <option>Cleveland, OH</option>
                            </select>

                            <select id="to" class="form-control text-center" style="width: 180px;">
                                <option>Select a City</option>
                                <option>New York, NY</option>
                                <option>New Jersey, NJ</option>
                            </select>
                        </div>
                        <br />
                        Depart Date <br/>
                        <input type="date" id="departDate"/>
                        <br/>
                        <br/>
                        <select id="passengers" class="form-control text-center center-block" style="width: 200px;">
                            <option>Number of Passengers</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                        </select>
                        <hr>
                        <button type="submit" class="btn btn-primary btn-lg active" id="submit-trip">Find Trip</button>
                        <br />
                        <br />
                    </form>
            </div>
            <div class="col-md-4"></div>

            <div id="footer">

                <div style="font-family:Arial; font-size:10px; float:left; margin: 40px 0px 0px 10px;"><i>&copy; First Class
                        Tavelers LLC.</i>
                </div>

                <div style="float:right; margin: 5px 10px 0px 0px;">
                    <a href="http://www.facebook.com/" target="_blank"><img src="images/facebook.png"/></a><a
                        href="http://twitter.com/" target="_blank"></a><a href="mailto:firstclasstravelers@gmail.com"><img
                            src="images/email.png"/></a></div>

            </div>


        </div>

        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/js/busapp.js"></script>-->

    </body>
</html>
