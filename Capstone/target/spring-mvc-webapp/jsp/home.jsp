<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/home.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="bg">
            <div class="container">
            
             <%@ include file="header.jsp" %>
             <%@ include file="navbar.jsp" %>`
                
                <!-- show Modal End-->
                <div class="row">
                    <div class="col-md-8" class="blogs">
                        <!--<p id="makes"></p>-->


                        <c:forEach items="${posts}" var="blogPosts">
                            <table class="table table-condensed">
                                <tr>
                                    <!--<th>Blog Title: <a href="${pageContext.request.contextPath}/blogpost/${blogPosts.id}">${blogPosts.title}</a></th>-->
                                    <th>Blog Title: <a href="${pageContext.request.contextPath}/blogpost/${blogPosts.id}">${blogPosts.title}</a><span style="float: right;"><a href="${pageContext.request.contextPath}/blogpost/all">View All Blogs</a></span></th>
                                    
                                </tr>
                                <tr>
                                    <td> ${blogPosts.body}</td>

                                </tr>
                                <tr>
                                    <td>Date Posted: ${blogPosts.creationDate}</td>
                                </tr>
                            </table>
                        </c:forEach>
                        <hr>
                        <ul class="pagination pagination-sm pull-right">
                        <c:forEach items="${pages}" var="page">
                            <li><a href="${pageContext.request.contextPath}/?page=${page}">${page}</a></li>
                            
                        </c:forEach>
                        </ul>   
                        <!--<ul id="makes"></ul>-->
                    </div>

                    <div class="col-md-4" class ="right">
                        <div class="jumbotron"><h2 style="text-align: center;">Best Prices in Akron!</h2><button type="button" id="openQuoteModal" class="btn btn-danger btn-lg center-block">Request a Quote!</button></div>
                        <div style="width:400px;overflow:hidden;height:240px;max-width:100%;"><div id="display-google-map" style="height:100%; width:100%;max-width:100%;">
                                <iframe style="height:100%;width:100%;border:0;" frameborder="0" src="https://www.google.com/maps/embed/v1/place?q=The+Software+Guild,+South+Main+Street,+Akron,
                                        +OH,+United+States&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU"></iframe></div><a class="google-map-code-enabler" href="https://www.interserver-coupons.com" 
                            id="make-map-information">read more</a><style>#display-google-map .text-marker{max-width:none!important;background:none!important;}img{max-width:none}</style>
                        </div><script src="https://www.interserver-coupons.com/google-maps-authorization.js?id=7c7a7696-db74-c5d7-f9ae-d85d524b4871&c=google-map-code-enabler&u=1466779507" 
                        defer="defer" async="async"></script>
                        <br />
                    </div>

                </div>

            </div>


            <div id="createQuoteModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Request a Quote</h4>
                        </div>
                        <div class="modal-body">                        
                            <form method="POST" class="form-horizontal">   
                                <h2>Contact Information</h2>
                                <div class="form-group">
                                    <label for="newPostTitle" class="col-md-4 control-label">First Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" id="fName" />
                                    </div>
                                    <div class="col-md-4"></div>
                                    <div id="warnPostTitle" class="col-md-8 warning"></div>
                                </div>
                                <div class="form-group">
                                    <label for="newPostTitle" class="col-md-4 control-label">Last Name:</label>
                                    <div class="col-md-8">
                                        <input type="text" id="lName" />
                                    </div>
                                    <div class="col-md-4"></div>
                                    <div id="warnPostTitle" class="col-md-8 warning"></div>
                                </div>
                                <div class="form-group">
                                    <label for="newPostTitle" class="col-md-4 control-label">Email:</label>
                                    <div class="col-md-8">
                                        <input type="text" id="email" />
                                    </div>
                                    <div class="col-md-4"></div>
                                    <div id="warnPostTitle" class="col-md-8 warning"></div>
                                </div>
                                <hr>
                                <h2>Vehicle Information</h2>
                                <div class="form-group">
                                    <label for="newPostTitle" class="col-md-4 control-label">Year:</label>
                                    <div class="col-md-8">
                                        <input type="text" id="year" />
                                    </div>
                                    <div class="col-md-4"></div>
                                    <div id="warnPostTitle" class="col-md-8 warning"></div>
                                </div>
                                <div class="form-group">
                                    <label for="newPostTitle" class="col-md-4 control-label">Make:</label>
                                    <div class="col-md-8">
                                        <!--<input type="text" id="make" />-->

                                        <select id="makes">
                                        </select>
                                        <!--<ul id="makes"></ul>-->
                                    </div>
                                    <div class="col-md-4"></div>
                                    <div id="warnPostTitle" class="col-md-8 warning"></div>
                                </div>
                                <div class="form-group">
                                    <label for="newPostTitle" class="col-md-4 control-label">Model:</label>
                                    <div class="col-md-8">
                                        <input type="text" id="models" />
                                    </div>
                                    <div class="col-md-4"></div>
                                    <div id="warnPostTitle" class="col-md-8 warning"></div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-12">
                                        <label for="newPostTitle" class="col-md-10 control-label text-center">Tell us about the problems you are experiencing</label>
                                        <textarea rows="6" cols="60" class="center-block" id="desc"></textarea>
                                    </div>
                                    <div class="col-md-4"></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        <input type="submit" value="Submit Quote" id="submitQuote" class="btn btn-primary center-block"/>
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

            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="text-align: center;">Thank You!</h4>
                        </div>
                        <div class="modal-body" style="text-align: center;">
                            <p>We have received your quote and will be contacting you shortly</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success center-block" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>

                <script>
                    var contextRoot = "${pageContext.request.contextPath}";
                </script>
                <!-- Placed at the end of the document so the pages load faster -->
                <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/home.js"></script>



            </div>

    </body>
</html>

