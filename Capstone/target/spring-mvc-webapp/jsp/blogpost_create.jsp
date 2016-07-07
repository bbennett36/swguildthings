<%--
    Document   : posts
    Created on : Jun 22, 2016, 2:52:14 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Blogpost</title>

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
                <h1 style="color: #D5D5D5">Create New Blogpost</h1>
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
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/blogpost/blogpost_create">New Blogpost</a></li>
                    </ul>
                </div>                
                <div class="sectionContent" style="padding: 15px 0px 15px 0">                    
                    <form method="POST" class="form-horizontal">
                        <input type="hidden" id="newBlogpostAuthor" value="${author.id}" />
                        <div class="form-group">                                    
                            <label for="newPostTitle" class="col-md-2 control-label">Title:</label>
                            <div class="col-md-9">
                                <input type="text" name="newPostTitle" id="newPostTitle" class="form-control" />
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPostTitle" class="col-md-9 warning"></div>
                        </div>
                        <div class="form-group">
                            <label for="newCategory" class="col-md-2 control-label">Category:</label>
                            <div class="col-md-9">
                                <select type="text" name="newCategory" id="newCategory" class="form-control" >
                                    <option value=""></option>
                                    <c:forEach items="${categoryList}" var="category">
                                        <option value="${category.id}">${category.category}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPostCategory" class="col-md-9 warning"></div>
                        </div>
                        <div class="form-group">
                            <label for="newPostBody" class="col-md-2 control-label">Body:</label>
                            <div class="col-md-9">
                                <textarea type="text" name="newPostBody" id="newPostBody" class="tinyMceBody" style="height:500px; width: 500px"></textarea>
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPostBody" class="col-md-9 warning"></div>
                        </div>
                        <div class="form-group">
                            <label for="newPostStartDate" class="col-md-2 control-label">Start Date:</label>
                            <div class="col-md-9">
                                <input type="date" name="newPostStartDate" id="newPostStartDate"  />
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPostStartDate" class="col-md-9 warning"></div>
                        </div>
                        <div class="form-group">
                            <label for="newPostExpirationDate" class="col-md-2 control-label">Expiration Date:</label>
                            <div class="col-md-9">
                                <input type="date" name="newPostExpirationDate" id="newPostExpirationDate" />
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPostExpirationDate" class="col-md-9 warning"></div>
                        </div>                    
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <input type="submit" value="Save Post as Draft" id="submitCreateSave" class="btn btn-primary submitCreateSave"/>
                            </div>
                            <div class="col-md-4">
                                <input type="submit" value="Publish Post" id="submitCreatePublish" class="btn btn-primary submitCreateSave"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>

        <div id="showCreateBlogpostModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Blogpost Summary</h4>
                    </div>
                    <div class="modal-body">
                        <div id="showModalHead">
                            <h5 style='color: green; font-weight: bold'>The blogpost was successfully created!</h5>
                        </div>
                        <table class="table table-bordered" id="showBlogpostTable">
                            <tr>
                                <th>Blogpost Id:</th>
                                <td id="createBlogpostId"></td>
                            </tr>
                            <tr>
                                <th>Title:</th>
                                <td id="createBlogpostTitle"></td>
                            </tr>
                            <tr>
                                <th>Body:</th>
                                <td id="createBlogpostBody">${bp.body}</td>
                            </tr>
                            <tr>
                                <th>Author</th>
                                <td id="createBlogpostAuthor"></td>
                            </tr>
                            <tr>
                                <th>Creation Date</th>
                                <td id="createBlogpostCreationDate"></td>
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
        <script src="${pageContext.request.contextPath}/js/blogpost.js"></script>        
        <script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
    </body>
</html>
