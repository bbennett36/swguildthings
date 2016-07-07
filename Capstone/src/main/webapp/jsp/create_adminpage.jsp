<%-- 
    Document   : admin
    Created on : Jun 22, 2016, 10:31:46 AM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
                <h1 style="color: #D5D5D5">Admin Page</h1>
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
                    </ul>    
                </div>                            
                <div class="sectionContent" style="padding: 15px 0px 15px 0">
                    <form method="POST" class="form-horizontal">                               
                        <div class="form-group">
                            <label for="newPageName" class="col-md-2 control-label">Page Name:</label>
                            <div class="col-md-9">
                                <input type="text" name="newPageName" id="newPageName" class="form-control" />
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPageName" class="col-md-9 warning"></div>
                        </div>
                        <!--<div class="form-group">
                            <label for="newPageSequence" class="col-md-2 control-label">Page Sequence:</label>
                            <div class="col-md-9">
                                <input type="text" name="newPageSequence" id="newSequence" class="form-control" />
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPageSequence" class="col-md-9 warning"></div>
                        </div>-->
                        <div class="form-group">
                            <label for="newPageBody" class="col-md-2 control-label">Page Body:</label>
                            <div class="col-md-9">
                                <textarea class="tinyMceBody" type="text" name="newPageBody" id="newPageBody" style="height:500px; width: 500px">   
                                </textarea>
                            </div>
                            <div class="col-md-2"></div>
                            <div id="warnPageBody" class="col-md-9 warning"></div>
                        </div>
                        <!--<div class ="form-group">
                            <label for="userIdInput" class="col-md-4 control-label">Author: </label>
                            <div class="col-md-8">
                                <input type="hidden" class="form-control" id="userIdInput" value="${authenticatedUserId}" />
                           </div>
                        </div>-->
                        <div class ="form-group">
                            <label for="pageStatus" class="col-md-2 control-label">Set Page Status: </label>
                            <div class="col-md-8">
                                <select class="form-control" id="pageStatus"  >
                                    <c:forEach items="${pageStatus}" var="status">
                                        <option value="${status.id}" >${status.blogStatus}</option>  
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4"></div>
                            <div class="col-md-4">
                                <input type="submit" value="Create New Page" id="submitCreateNewAdminPage" class="btn btn-primary"/>
                            </div>
                             <h3><div id="printPageAdded" class="col-md-9 warning"></div></h3>
                        </div>
                    </form>                
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
                
        <script>
            var contextRoot = '${pageContext.request.contextPath}';
        </script>
              
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/adminpages.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce/jquery.tinymce.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
    </body>
</html>
