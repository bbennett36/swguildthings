<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog Posts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>Spring MVC Application from Archetype</h1>
            <hr/>

            <%@ include file="navbar.jsp" %>    
            <!-- show Modal End-->
        </div>

        <div class="container">

            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3>${blogPost.title}</h3></div>
                    <div class="panel-body">${blogPost.body}</div>
                    <div class="panel-footer"> Author: ${blogPost.author.username}        Created:${blogPost.creationDate}</div>

                </div>
            </div>
            <div class="col-md-6">
                <!--<button type="button" class="btn btn-primary btn-lg" id="btnCommentCollapse"data-toggle="collapse" data-target="#addComment">Add a comment</button>-->
                <!--<div id="addComment" class="collapse">-->
                <sec:authorize access="isAuthenticated()">
                    <form method="POST" class="form-horizontal">   
                        <input  type="hidden" id="blogId" value="${blogPost.id}" />
                        <div class="form-group">
                            <div class="col-md-6">
                                <textarea cols="50" rows="4" id="comment"></textarea>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <input type="submit" value="Add Comment" id="submitComment" class="btn btn-default center-block"/>
                        </div>
                    </form>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <p>Commenting Disabled. You must log-in if you would like to comment.</p>
                </sec:authorize>
            </div>

             <div class="col-md-6">
                            <table id="showComments" class="table table-bordered">
            <c:forEach items="${comments}" var="comment">
                <tr id="comment-row-${comment.id}">
                    <th>Author</th>
                    <th>Comment</th>
                    <th>Date</th>
                </tr>
                <tr>
                    
                    <td>${comment.userName}</td>
                    <td>${comment.comment}</td>
                    <td>${comment.commentDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>



        </div>    
        <!--</div>-->
        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/show_blogs.js"></script>
        <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>

    </body>
</html>

