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
        <title>Post Administration</title>

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
                <h1 style="color: #D5D5D5">Post Administration</h1>                
            </div>
            <%@ include file="navbar.jsp" %>
            <div class="col-md-1"></div>
            <div class="col-md-10">                
                <div class="navbar navbar-background">
                    <ul class="nav nav-tabs">
                        <li role="presentation"><a href="${pageContext.request.contextPath}/adminpages/pages">Page Administration</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/admin/blogpost">Post Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/userroles/useradmin">User Administration</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/category/categories">Category Administration</a></li>
                    </ul>
                    <div class="taskDiv">
                        <h4>
                            <a href="${pageContext.request.contextPath}/blogpost/createblogpost">
                                <span class="glyphicon glyphicon-plus-sign"></span>Create New Blogpost
                            </a>
                        </h4>
                    </div>
                </div>            
                <div id="pageContent" class="col-md-12">                    
                    <div class="row section">
                        <div class="col-md-12 sectionHead">
                            <h3>
                                <span data-toggle="collapse" data-target="#activePostDiv" class="glyphicon glyphicon-th-list"></span>
                                Active Posts
                            </h3>                        
                        </div>
                        <div id="activePostDiv" class="sectionContent">                    
                            <table id="activePostTable" class="table table-bordered">
                                <thead class="tableHead">
                                    <tr>
                                        <th>Title</th>
                                        <th>Category</th>
                                        <th>Creation Date</th>
                                        <th>Edit Post</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="activePostTbody">
                                    <c:forEach items="${activeBlogposts}" var="blogpost">
                                        <tr id="blogpostRow-${blogpost.id}">
                                            <td>${blogpost.title}</td>
                                            <td>${blogpost.category.category}</td>
                                            <td><fmt:formatDate value="${blogpost.creationDate}" pattern="MM/dd/yyyy"></fmt:formatDate></td>
                                            <td><a href="${pageContext.request.contextPath}/blogpost/edit/${blogpost.id}">Edit</a></td>
                                            <td>
                                                <a data-archivePost="${blogpost.id}" class="showArchiveModal">Archive Post</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row section">
                        <div class="col-md-12 sectionHead">
                            <h3>
                                <span data-toggle="collapse" data-target="#draftPostDiv" class="glyphicon glyphicon-th-list"></span>
                                Draft Posts
                            </h3>                        
                        </div>
                        <div id="draftPostDiv" class="collapse sectionContent">
                            <table id="draftPostTable" class="table table-bordered">
                                <thead class="tableHead">
                                    <tr>
                                        <th>Title</th>
                                        <th>Category</th>
                                        <th>Creation Date</th>
                                        <th>Edit</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="draftPostTbody">
                                    <c:forEach items="${draftBlogposts}" var="blogpost">
                                        <tr id="blogpostRow-${blogpost.id}">
                                            <td>${blogpost.title}</td>
                                            <td>${blogpost.category.category}</td>
                                            <td><fmt:formatDate value="${blogpost.creationDate}" pattern="MM/dd/yyyy"></fmt:formatDate></td>
                                            <td><a href="${pageContext.request.contextPath}/blogpost/edit/${blogpost.id}">Edit</a></td>
                                            <td>
                                                <a data-publishPost="${blogpost.id}" class="showPostModal">Publish Post</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row section">
                        <div class="col-md-12 sectionHead">                                                    
                            <h3>
                                <span data-toggle="collapse" data-target="#archivedPostDiv" class="glyphicon glyphicon-th-list"></span>
                                Archived Posts
                            </h3>                        
                        </div>
                        <div id="archivedPostDiv" class="collapse sectionContent">
                            <table id="archivedPostTable" class="table table-bordered">
                                <thead class="tableHead">
                                    <tr>
                                        <th>Title</th>
                                        <th>Category</th>
                                        <th>Creation Date</th>
                                        <th>Edit Post</th>
                                    </tr>
                                </thead>
                                <tbody id="archivedPostTbody">
                                    <c:forEach items="${archivedBlogposts}" var="blogpost">
                                        <tr id="blogpostRow-${blogpost.id}">
                                            <td>${blogpost.title}</td>
                                            <td>${blogpost.category.category}</td>
                                            <td><fmt:formatDate value="${blogpost.creationDate}" pattern="MM/dd/yyyy"></fmt:formatDate></td>
                                            <td><a href="${pageContext.request.contextPath}/blogpost/edit/${blogpost.id}">Edit</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>                                        
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>

        <div id="showPublishBlogpostModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Blogpost Summary</h4>
                    </div>
                    <div class="modal-body">
                        <div id="showModalHead">
                            <h5 style='color: red; font-weight: bold'>Please confirm that you would like to publish this post.</h5>
                        </div>
                        <table class="table table-bordered" id="showBlogpostTable">
                            <tr>
                                <th>Id:</th>
                                <td id="blogpostId"></td>
                            </tr>
                            <tr>
                                <th>Title:</th>
                                <td id="blogpostTitle"></td>
                            </tr>
                            <tr>
                                <th>Body:</th>
                                <td id="blogpostBody"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="btnPublishPost">Publish</button>
                    </div>
                </div>
            </div>
        </div>
        <div id="showArchiveBlogpostModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Blogpost Summary</h4>
                    </div>
                    <div class="modal-body">
                        <div id="showModalHead">
                            <h5 style='color: red; font-weight: bold'>Please confirm that you would like to archive this post.</h5>
                        </div>
                        <table class="table table-bordered" id="archiveBlogpostTable">
                            <tr>
                                <th>Id:</th>
                                <td id="archiveBlogpostId"></td>
                            </tr>
                            <tr>
                                <th>Title:</th>
                                <td id="archiveBlogpostTitle"></td>
                            </tr>
                            <tr>
                                <th>Body:</th>
                                <td id="archiveBlogpostBody"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="btnArchivePost">Archive</button>
                    </div>
                </div>
            </div>
        </div>        

        <script src="http://code.jquery.com/jquery-1.11.1.js">
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/blogpost.js"></script>        
        <script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script src="https://cdn.tinymce.com/4/tinymce.min.js"></script>
        
        <script>
            var contextRoot = "${pageContext.request.contextPath}";                        
        </script>
    </body>
</html>
