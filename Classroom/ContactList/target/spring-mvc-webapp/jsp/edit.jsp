<%-- 
    Document   : edit
    Created on : Jun 1, 2016, 7:06:40 AM
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
            <h1>Contact List</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>

            <div class="row">
                <!--                <div class="col-md-6">
                                    <h2>Edit</h2>
                                    <form method="POST" action="${contact.id}">
                                        <input name="firstName" placeholder="First Name"/><br />
                                        <input name="lastName" placeholder="Last Name"/><br />
                                        <input name="company" placeholder="Company Name"/><br />
                                        <input name="email" placeholder="Email Address"/><br />
                                        <input name="phone" placeholder="Phone"/><br />
                                        <br />
                                        <button class="btn-danger btn-lg" type="submit">Submit</button>
                                    </form>-->

                <div class="col-md-6">
                    <form method="POST" action="./" class="form-horizontal">
                        <input type="hidden" name="id" value="${contact.id}" />
                        <div class="form-group">
                            <label for="fname" class="col-md-4 control-label">First</label>
                            <div class="col-md-8">
                                <input name="firstName" id="fname" placeholder="First Name" value="${contact.firstName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="lname" class="col-md-4 control-label">Last</label>
                            <div class="col-md-8">
                                <input name="lastName" id="lname" placeholder="Last Name"  value="${contact.lastName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="com" class="col-md-4 control-label">Company</label>
                            <div class="col-md-8">
                                <input name="company" id="com" placeholder="Company Name"  value="${contact.company}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="ed" class="col-md-4 control-label">Email</label>
                            <div class="col-md-8">
                                <input name="email" id="ed" placeholder="Email Address"  value="${contact.email}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="ph" class="col-md-4 control-label">Phone</label>
                            <div class="col-md-8">
                                <input name="phone" id="ph" placeholder="Phone Number"  value="${contact.phone}"/>
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
