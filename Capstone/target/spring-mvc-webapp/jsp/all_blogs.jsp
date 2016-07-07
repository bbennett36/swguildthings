<%-- 
    Document   : all_blogs
    Created on : Jul 3, 2016, 12:19:57 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Blog Posts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/all_blogs.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <!--<h1>Akron Auto Body</h1>-->
            <%@ include file="header.jsp" %> 

            <!-- show Modal begin-->                                
            <%@ include file="navbar.jsp" %>    
            <!-- show Modal End-->


            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 style="text-align: center">${blogPost.title}</h3></div>
                    <div class="panel-body">${blogPost.body}
                        <br />
                        <br />Author: ${blogPost.author.username}        
                        <br />Created: ${blogPost.creationDate}</div>
                    <div class="panel-footer"> 
                        <button data-toggle="collapse" class="btn btn-primary" data-target="#demo2">Show Comments</button>
                        <br />
                        <div class="collapse" id="demo2">
                            <table id="showComments" class="table table-hover" style="color: black;">
                                <c:forEach items="${comments}" var="comment">
                                    <tr id="comment-row-${comment.id}">
                                        <td>${comment.userName} said: ${comment.comment}</td>
                                        <td align="right">Date: ${comment.commentDate}</td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <sec:authorize access="!isAuthenticated()">
                                <p>Commenting Disabled. You must log-in if you would like to comment.</p>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                    <input  type="hidden" id="blogId" value="${blogPost.id}" />
                                    <div class="form-group">
                                        <textarea class="center-block" cols="50" rows="4" id="comment"></textarea>
                                        <input type="submit" value="Add Comment" id="submitComment" class="btn btn-default center-block"/>
                                    </div>
                                    </form>
                            </sec:authorize>
                        </div>
                    </div>
                </div>


            </div>
            <div class="col-md-4">
                <div class="annotated-list" id="users">
                    <input class="search" placeholder="Search" />
                    <button class="sort" data-sort="date">Sort by Date</button>
                    <table class="table table-responsive">
                        <thead>
                        <th>Blog Title</th>
                        <th>Date Posted</th>
                        </thead>
                        <tbody class="list">
                            <c:forEach items="${blogPosts}" var="b">
                                <tr>
                                    <td class="name"><a href="${pageContext.request.contextPath}/blogpost/${b.id}">${b.title}</a></td>
                                    <td class="date">${b.creationDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>
        <!--Placed at the end of the document so the pages load faster--> 
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/list.js/1.2.0/list.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/all_blogs.js"></script>
        <!--<script src="http://listjs.com/no-cdn/list.js"></script>-->





    </body>
</html>
