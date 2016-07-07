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
        <title>Create User</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-duallistbox.css" rel="stylesheet" type="text/css" media="all">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container col-md-12">
            <div class="pageHeader">
                <h1 style="color: #D5D5D5">Create User</h1>
            </div>
            <%@ include file="navbar.jsp" %>            
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <div class="navbar navbar-background">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/adminpages/pages">Page Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/admin/blogpost">Post Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/userroles/useradmin">User Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/category/categories">Category Administration</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/userroles/edituser">Update User</a></li>
                    </ul>
                </div>            
                <div id="pageContent" class="col-md-12">                    
                    <div class="col-md-8 sectionContent" style="padding: 20px 20px 20px 5px">
                        <form action="POST">
                            <div class="row">
                                <input type="hidden" id="editUserId" value="${user.id}" />
                                <div class="form-group">                                    
                                    <label for="editUsername" class="col-md-3 control-label">Username:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="editUsername" id="editUsername" class="form-control" value="${user.username}" />
                                    </div>
                                    <div class="col-md-3"></div>
                                    <div id="warnUsername" class="col-md-9 warning"></div>
                                </div>
                                <div class="form-group">                                    
                                    <label for="editUserFirstName" class="col-md-3 control-label">First Name:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="editUserFirstName" id="editUserFirstName" class="form-control" value="${user.firstName}" />
                                    </div>
                                    <div class="col-md-3"></div>
                                    <div id="warnUserFirstName" class="col-md-9 warning"></div>
                                </div>
                                <div class="form-group">                                    
                                    <label for="editUserLastName" class="col-md-3 control-label">Last Name:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="editUserLastName" id="editUserLastName" class="form-control" value="${user.lastName}" />
                                    </div>
                                    <div class="col-md-3"></div>
                                    <div id="warnUserLastName" class="col-md-9 warning"></div>
                                </div>
                                <div class="form-group">                                    
                                    <label for="editUserEmail" class="col-md-3 control-label">Email:</label>
                                    <div class="col-md-9">
                                        <input type="text" name="editUserEmail" id="editUserEmail" class="form-control" value="${user.email}" />
                                    </div>
                                    <div class="col-md-3"></div>
                                    <div id="warnUserEmail" class="col-md-9 warning"></div>
                                </div>                                                          
                            </div>
                            <hr />
                            <div class="row">
                                <div class="col-md-6">
                                    <!--<h4>Roles for User</h4>-->
                                </div>
                                <div class="col-md-6">
                                    <input type="submit" value="Update User" id="submitUpdateUser" class="btn btn-primary" />
                                </div>
                            </div>
                            <!--<div class="row bootstrap-duallistbox-container"></div>                            
                                <div class="col-md-12">
                                    <select multiple="multiple" id="availableRoles" name="availableRoles" size="10" style="width:100%">
                                        <option value=""></option>
                                        <c:forEach items="${roleList}" var="role">
                                            <option value="${role.id}">${role.role}</option>                                            
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>-->
                        </form>                    
                    </div>                    
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
                
        <div id="createUserModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">User Info</h4>
                    </div>
                    <div class="modal-body">
                        <div id="showModalHead">
                            <h5 style='color: green; font-weight: bold'>The User was successfully updated!</h5>
                        </div>
                        <table class="table table-bordered" id="showUserTable">
                            <tr>
                                <th>Id:</th>
                                <td id="createUserId"></td>
                            </tr>
                            <tr>
                                <th>First Name:</th>
                                <td id="createUserFirstName"></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td id="createUserLastName"></td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td id="createUserEmail"></td>
                            </tr>
                            <tr>
                                <th>Roles:</th>
                                <td id="tdRoles"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>                      
                    </div>
                </div>
            </div>
        </div>
                                        
        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.bootstrap-duallistbox.js"></script>
        <script src="${pageContext.request.contextPath}/js/userroles.js"></script> 
    </body>
</html>
