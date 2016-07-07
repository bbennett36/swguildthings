<%-- 
    Document   : edit
    Created on : Jun 1, 2016, 10:19:15 AM
    Author     : apprentice
--%>

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
            <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>

            <div class="row">

                <div class="col-md-6">
                    <form method="POST" action="./" class="form-horizontal">
                        
                        <input type="hidden" name="id" value="${address.id}" />
                        <div class="form-group">
                            <label for="fname" class="col-md-4 control-label">First</label>
                            <div class="col-md-8">
                                <input name="firstName" id="fname" placeholder="First Name" value="${address.firstName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="lname" class="col-md-4 control-label">Last</label>
                            <div class="col-md-8">
                                <input name="lastName" id="lname" placeholder="Last Name" value="${address.lastName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="sn" class="col-md-4 control-label">Street Name</label>
                            <div class="col-md-8">
                                <input name="streetName" id="sn" placeholder="Street Name" value="${address.streetName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="snum" class="col-md-4 control-label">Street Number</label>
                            <div class="col-md-8">
                                <input name="streetNumber" id="snum" placeholder="Street Number" value="${address.streetNumber}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="cit" class="col-md-4 control-label">City</label>
                            <div class="col-md-8">
                                <input name="city" id="cit" placeholder="City" value="${address.city}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="st" class="col-md-4 control-label">State</label>
                            <div class="col-md-8">
                                <input name="state" id="st" placeholder="State" value="${address.state}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="z" class="col-md-4 control-label">Zip</label>
                            <div class="col-md-8">
                                <input name="zip" id="z" placeholder="Zip" value="${address.zip}"/>
                            </div>
                        </div>
                        <br />
                        <button class=" btn btn-danger btn-lg" type="submit">Submit</button>
                    </form>
                </div>    
            </div>


        </div>        

    </body>
</html>
