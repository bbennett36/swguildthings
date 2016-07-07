<%-- 
    Document   : admin
    Created on : Jun 22, 2016, 10:31:46 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Pages</title>

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
                <h1 style="color: #D5D5D5">Page Administration</h1>                                                                                      
            </div>
            <%@ include file="navbar.jsp" %>
            </hr>
            <div class="col-md-1"></div>
            <div class="col-md-10">
            <div class="navbar navbar-background">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/adminpages/pages">Page Administration</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin/blogpost">Post Administration</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/userroles/useradmin">User Administration</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/category/categories">Category Administration</a></li>
                </ul>
                <div class="taskDiv">
                    <h4>
                        <a href="${pageContext.request.contextPath}/adminpages/createnewstaticpage">
                            <span class="glyphicon glyphicon-plus-sign"></span>Create New Static Page
                        </a>
                    </h4>                        
                </div>
            </div>            
            <div id="pageContent" class="col-md-12">                               
                <div class="row section">                    
                    <div class="col-md-12 sectionHead">
                        <h3 class="col-md-12">
                            <div style="float: left; width: 35%">
                            <span data-toggle="collapse" data-target="#activePageDiv" class="glyphicon glyphicon-th-list"></span>
                            Active Static Pages
                            </div>
                            <div style="float: left">
                                <form method="POST">
                                    <input type="submit" id="submitOrderAdminpages" value="Save Page Order" class="btn btn-success" />
                                </form>
                            </div>
                        </h3>                        
                    </div>                    
                    <div id="activePageDiv" class="sectionContent">
                        <table id="activePostTable" class="table table-bordered">
                            <thead class="tableHead">
                                <tr>
                                    <th>Title</th>
                                    <th>Sequence</th>
                                    <th>Creation Date</th>
                                    <th>Created By</th>                                                                       
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tbody id="activePostTbody">
                               <c:forEach items="${activePageList}" var="adminPages">
                                <tr id="adminpage-row-${adminPages.id}">
                                   <td>
                                        <a data-pageid="${adminPages.id}" data-toggle="modal" data-target="#showAdminpageModal">${adminPages.pageName}</a>
                                    </td>
                                    <td class="tdSequence">${adminPages.sequence}</td>
                                    <td><fmt:formatDate value="${adminPages.creationDate}" pattern="MM/dd/yyyy"></fmt:formatDate></td>                                    
                                    <td>${adminPages.author.username}</td>                                    
                                    <td><a href="${pageContext.request.contextPath}/adminpages/edit/${adminPages.id}"> Edit</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row section">
                    <div class="col-md-12 sectionHead">
                        <h3>
                            <span data-toggle="collapse" data-target="#draftPageDiv" class="glyphicon glyphicon-th-list"></span>
                            Draft Static Pages
                        </h3>
                    </div>                    
                    <div id="draftPageDiv" class="collapse sectionContent">
                        <table id="draftPageTable" class="table table-bordered">
                            <thead class="tableHead">
                                <tr>
                                    <th>Title</th>                                    
                                    <th>Creation Date</th>
                                    <th>Created By</th>                                    
                                    <th>Edit</th>                                
                                </tr>
                            </thead>
                            <tbody id="draftAdminPageTbody">
                                 <c:forEach items="${draftPageList}" var="adminPages">
                                <tr id="adminpage-row-${adminPages.id}">
                                    <td>
                                        <a data-pageid="${adminPages.id}" data-toggle="modal" data-target="#showAdminpageModal">${adminPages.pageName}</a>
                                    </td>                                    
                                    <td><fmt:formatDate value="${adminPages.creationDate}" pattern="MM/dd/yyyy"></fmt:formatDate></td>
                                    <td>${adminPages.author.username}</td>
                                    <td><a href="${pageContext.request.contextPath}/adminpages/edit/${adminPages.id}"> Edit</a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row section">
                    <div class="col-md-12 sectionHead">
                        <h3>
                            <span data-toggle="collapse" data-target="#archivedPageDiv" class="glyphicon glyphicon-th-list"></span>
                            Archived Static Pages
                        </h3>
                    </div>                    
                    <div id="archivedPageDiv" class="collapse sectionContent" >                    
                        <table id="archivedPageTable" class="table table-bordered">
                            <thead class="tableHead">
                                <tr>
                                    <th>Title</th>                                    
                                    <th>Creation Date</th>
                                    <th>Created By</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tbody id="archivedPostTbody">
                                 <c:forEach items="${archivedPageList}" var="adminPages">
                                <tr id="address-row-${adminPages.id}">
                                    <td>
                                        <a data-pageid="${adminPages.id}" data-toggle="modal" data-target="#showAdminpageModal">${adminPages.pageName}</a>
                                    </td>                                                                        
                                    <td><fmt:formatDate value="${adminPages.creationDate}" pattern="MM/dd/yyyy"></fmt:formatDate></td>
                                    <td>${adminPages.author.username}</td>
                                    <td><a href="${pageContext.request.contextPath}/adminpages/edit/${adminPages.id}"> Edit</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
                            
        <div id="showAdminpageModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">User Info</h4>
                    </div>
                    <div class="modal-body">                        
                        <table class="table table-bordered" id="showAdminPageTable">
                            <tr>
                                <th>Id:</th>
                                <td id="pageId"></td>
                            </tr>
                            <tr>
                                <th>Title:</th>
                                <td id="pageTitle"></td>
                            </tr>
                            <tr>
                                <th>Status:</th>
                                <td id="pageStatus"></td>
                            </tr>
                            <tr>
                                <th>Creation Date:</th>
                                <td id="pageCreationDate"></td>
                            </tr>
                            <tr>
                                <th>Author:</th>
                                <td id="pageAuthor"></td>
                            </tr> 
                            <tr>
                                <th>Last Modified Date:</th>
                                <td id="pageLastModifiedDate"></td>
                            </tr>
                            <!--<tr>
                                <th>Last Modified By:</th>
                                <td id="pageLastModifiedBy"></td>
                            </tr>-->
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>                        
                    </div>
                </div>
            </div>
        </div>
        
        <script src="http://code.jquery.com/jquery-1.11.1.js"></script> 
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/adminpages.js"></script>        
        <script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script src="https://cdn.tinymce.com/4/tinymce.min.js"></script>
        
        <script>
            var contextRoot = '${pageContext.request.contextPath}';            
        </script>
    </body>
</html>
