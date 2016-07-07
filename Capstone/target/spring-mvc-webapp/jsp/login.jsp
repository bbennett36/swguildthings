<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Akron Auto Body</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" />

    </head>
    <body>

        <div class="container">
            
         
           
             <%@ include file="header.jsp" %>
             <%@ include file="navbar.jsp" %>
            <c:if test="${not signUp}">
                <div class="row">
                    <div class="Absolute-Center is-Responsive">
                        <div class="col-sm-12 col-md-10 col-md-offset-1">
                            <h1 class="text-center" style="color: white;"> Login</h1>

                            <form action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input class="form-control" type="text" name='username' placeholder="Username" id="username"/>          
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input class="form-control" type="password" name='password' placeholder="Password"/>     
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-success btn-block">Login</button>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            </form>        
                            <button class="btn btn-default btn-block"><a href="${pageContext.request.contextPath}">Go Back</a></button>
                            <c:if test="${loginError ==1}">
                                <div> Error Login. Please supply valid credentials</div>
                            </c:if>
                        </div>  
                    </div>   
                </div>
            </c:if>

            <c:if test="${signUp}">
                <div class="row">
                    <div class="Absolute-Center is-Responsive2">
                        <div class="col-sm-12 col-md-10 col-md-offset-1">
                            <h3 class="text-center" style="color: white;">Sign Up</h3>
                            <form method="POST" action="createUser">
                                <div class="form-group input-group center-block">
                                    <input class="form-control" type="text" name='username' placeholder="Enter Desired Username" />
                                    <br/>
                                    <br/>
                                </div>

                                <div class="form-group input-group center-block">
                                    <input class="form-control" type="text" name='firstName' placeholder="Enter First Name" /> 
                                    <br/>
                                    <br/>
                                </div>
                                <div class="form-group input-group center-block">
                                    <input class="form-control" type="text" name='lastName' placeholder="Enter Last Name"/>   
                                    <br/>
                                    <br/>
                                </div>
                                <div class="form-group input-group center-block">
                                    <input class="form-control" type="text" name='email' placeholder="Enter Email"/>   
                                    <br/>
                                    <br/>
                                </div>

                                <div class="form-group input-group center-block">
                                    <input class="form-control" type="password" name='password' placeholder="Password"/>  
                                    <br/>
                                </div>

                                <div class="form-group">
                                    <br />
                                    <button type="submit" class="btn btn-success btn-block">Sign Up</button>
                                </div>
                                <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

                            </form>  
                            <button class="btn btn-default btn-block"><a href="${pageContext.request.contextPath}">Go Back</a></button>

                            <c:if test="${loginError ==1}">
                                <div> Error Login. Please supply valid credentials</div>
                            </c:if>
                        </div>  
                    </div>   
                </div>
            </c:if>
        </div>

        <script>
            var contextRoot = '${pageContext.request.contextPath}';

            document.getElementById('username').focus();
        </script>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/js/home.js"></script>-->

    </body>
</html>

