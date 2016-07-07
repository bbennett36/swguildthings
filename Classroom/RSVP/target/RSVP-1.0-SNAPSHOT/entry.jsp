<%-- 
    Document   : entry
    Created on : May 26, 2016, 3:15:37 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Im having a party. Can you attend?</h1>
        
        <form action="RSVPServlet" method="POST">
            Answer: <input type="text" name="myAnswer" /> <br />
            Reason: <input type="text" name="myReason" /> <br />
            
            <input type="submit" value="Submit" />
        </form>
        
        <c:if test="${isGoing}">
                this only shows up if isGoing is true
            </c:if>    
    </body>
</html>
