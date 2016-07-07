<%-- 
    Document   : adminusers
    Created on : Jun 28, 2016, 3:49:31 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User/Role Administration</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container col-md-12">
            <div class="pageHeader">
                <h1 style="color: #D5D5D5">User/Roll Administration</h1>
            </div>
            <%@ include file="navbar.jsp" %>            
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <div class="navbar navbar-background">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/adminpages/pages">Page Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/admin/blogpost">Post Administration</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/userroles/useradmin">User Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/category/categories">Category Administration</a></li>
                    </ul>
                </div>
                <div id="pageContent" class="col-md-12">                   
                    <div class="row section">
                        <div class="col-md-6">                                                            
                            <div class="col-md-12 sectionHead">
                                <div style="float: left; width: 50%">
                                    <h3>Users</h3>
                                </div>
                                <div style="float: left">
                                    <h3>
                                        <a href="${pageContext.request.contextPath}/userroles/createuser">
                                            <span class="glyphicon glyphicon-plus-sign"></span>Create New User
                                        </a>
                                    </h3>
                                </div>
                            </div>                            
                            <div id="usersDiv" class="sectionContent"> 
                                <table class="table table-bordered" id="userTable">
                                    <thead class="tableHead">
                                        <th>ID</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                        <th></th>
                                    </thead>
                                    <tbody id="userTbody">
                                        <c:forEach items="${userList}" var="user">
                                            <tr id="userRow-${user.id}">                                                
                                                <td>
                                                    <a data-userid="${user.id}" data-toggle="modal" data-target="#showUserModal">${user.id}</a>
                                                </td>
                                                <td>${user.firstName}</td>
                                                <td>${user.lastName}</td>
                                                <td>${user.email}</td>
                                                <td><a href="${pageContext.request.contextPath}/userroles/edituser/${user.id}">Edit</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="col-md-12 sectionHead">
                                <div style="float: left; width: 50%">
                                    <h3>Roles</h3>
                                </div>
                                <!--<div style="float: left">
                                    <h3>
                                        <a href="${pageContext.request.contextPath}/userroles/createuser">
                                            <span class="glyphicon glyphicon-plus-sign"></span>Create New Role
                                        </a>
                                    </h3>
                                </div>-->
                            </div>
                            <div id="roleDiv" class="sectionContent">
                                <table class="table table-bordered" id="roleTable">
                                    <thead class="tableHead">
                                        <th>ID</th>
                                        <th>Role</th>                                
                                    </thead>
                                    <tbody id="roleTbody">
                                        <c:forEach items="${roleList}" var="role">
                                            <tr id="roleRow-${role.id}">
                                                <td>${role.id}</td>
                                                <td>${role.role}</td>                                        
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
                                            
        <div id="showUserModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">User Info</h4>
                    </div>
                    <div class="modal-body">                        
                        <table class="table table-bordered" id="showUserTable">
                            <tr>
                                <th>Id:</th>
                                <td id="userId"></td>
                            </tr>
                            <tr>
                                <th>Username:</th>
                                <td id="userName"></td>
                            </tr>
                            <tr>
                                <th>First Name:</th>
                                <td id="userFirstName"></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td id="userLastName"></td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td id="userEmail"></td>
                            </tr> 
                            <tr>
                                <th>User Roles:</th>
                                <td id="tdUserRoles"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>                        
                    </div>
                </div>
            </div>
        </div>
                                        
        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/userroles.js"></script> 
    </body>
</html>
