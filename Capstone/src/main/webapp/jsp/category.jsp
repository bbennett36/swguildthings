<%-- 
    Document   : category
    Created on : Jun 23, 2016, 9:11:38 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category Admin</title>
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
                <h1 style="color: #D5D5D5">Category Administration</h1>
            </div>                             
            <%@ include file="navbar.jsp" %>
            <div class="col-md-1"></div>
            <div class="col-md-10">            
                <div class="navbar navbar-background">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/adminpages/pages">Page Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/admin/blogpost">Post Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/userroles/useradmin">User Administration</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/category/categories">Category Administration</a></li>
                    </ul>
                    <div class="taskDiv">
                        <h4>
                            <a id="btnCreateCategory">
                                <span class="glyphicon glyphicon-plus-sign"></span>Create New Category
                            </a>
                        </h4>
                    </div>
                </div>
                <div id="pageContent" class="col-md-12">                    
                <div class="row section">
                    <div class="col-md-12 sectionHead">
                        <h3>
                            <span data-toggle="collapse" data-target="#activeCategoryDiv" class="glyphicon glyphicon-th-list"></span>
                            Active Categories
                        </h3>                        
                    </div>
                    <div id="activeCategoryDiv" class="sectionContent">                        
                        <table id="activeCategoryTable" class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Category Name</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody id="activePostTbody">
                                <c:forEach items="${categories}" var="c">
                                    <tr id="category-row-${c.id}">
                                        <td>${c.category}</td>
                                        <td><a data-category-id="${c.id}" data-toggle="modal" data-target="#editCategoryModal">Edit</a></td>
                                        <td><a data-category-id="${c.id}" class="delete-link">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>

        <!--Modal for creating a new blogpost--> 
        <div id="createCategoryModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Create New Category</h4>
                    </div>
                    <div class="modal-body">                        
                        <form method="POST" class="form-horizontal">                            
                            <div class="form-group">
                                <label for="newPostTitle" class="col-md-4 control-label">Category Name:</label>
                                <div class="col-md-8">
                                    <input type="text" id="newCategory" />
                                </div>
                                <div class="col-md-4"></div>
                                <div id="warnPostTitle" class="col-md-8 warning"></div>
                            </div>
                            <div class="col-md-4"></div>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <input type="submit" value="Save Category" id="submitCategory" class="btn btn-primary center-block"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="editCategoryModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Category</h4>
                    </div>
                    <div class="modal-body">                        
                        <input type="hidden" id="edit-id" />
                        <div class="form-group">
                            <label for="newPostTitle" class="col-md-4 control-label">Category Name:</label>
                            <div class="col-md-8">
                                <input type="text" id="edit-category" />
                            </div>
                            <br />
                            <div class="col-md-4"></div>
                            <div id="warnPostTitle" class="col-md-8 warning"></div>
                        </div>
                        <div class="col-md-4"></div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <!--<input type="submit" value="Save Category" id="submitCategoryEdit" class="btn btn-primary center-block"/>-->
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                         <input type="submit" value="Save Category" id="submitCategoryEdit" class="btn btn-primary center-block"/>
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
        <script src="${pageContext.request.contextPath}/js/category.js"></script>

    </body>
</html>
