<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <!--<link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">-->

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>


        <div class="container">
            <h1>DVD Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>


            <div class="row">
                <div class="col-md-6">
                    <table class="table table-bordered" id="dvd-table">
                        <tr>
                            <th>Title</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${dvds}" var="dvd">
                            <tr id="dvd-row-${dvd.id}">
                                <td><a data-dvd-id="${dvd.id}" data-toggle="modal" data-target="#showContactModal">${dvd.title}</a></td>
                                <td><a data-dvd-id="${dvd.id}" data-toggle="modal" data-target="#editContactModal">Edit</a></td>
                                <td><a data-dvd-id="${dvd.id}" class="delete-link">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <form action="dvd/searchMPAA" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchMPAA" placeholder="Search by MPAA">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">Go!</button>
                            </span>
                        </div><!-- /input-group -->
                    </form>
                    <br />
                    <form action="dvd/searchStudio" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchStudio" placeholder="Search by Studio">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Go!</button>
                            </span>
                        </div><!-- /input-group -->
                    </form>
                    <br />
                    <form action="dvd/searchYears" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchYears" placeholder="Find DVDs in X years (Enter number of years)">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Go!</button>
                            </span>
                        </div><!-- /input-group -->
                    </form>
                    <br />
                    <form action="dvd/searchAvg" method="get">
                        <input class="btn btn-default" name="searchAvg" type="submit" value="Find Average Year" />
                    </form>
                    <form action="dvd/searchNew" method="get">
                        <input class="btn btn-default" name="searchNew" type="submit" value="Find Newest DVD" />
                    </form>
                    <form action="dvd/searchOld" method="get">
                        <input class="btn btn-default" name="searchOld" type="submit" value="Find Oldest DVD" />
                    </form>
                </div>
                <div class="col-md-6 text-center">
                    <form method="POST" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="title-input" placeholder="Title" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="date" id="release-date-input" class="form-control" />

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="mpaa-input" placeholder="Enter MPAA Rating" class="form-control" />

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="directors-name-input" placeholder="Enter Directors Name" class="form-control" />

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="studio-input" placeholder="Enter Studio" class="form-control" />

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="note-input" placeholder="Enter Notes" class="form-control" />

                            </div>
                        </div>
                        
                         <div id="add-dvd-validation-errors">
                            
                        </div>
                        <br />
                        <div class="col-md-8">
                            <button class=" btn btn-danger btn-lg" type="submit" id="create-submit">Submit</button>
                        </div>
                    </form>
                </div>    
            </div>      

        </div>
        <div id="showContactModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">DVD Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered" id="show-dvd-table">
                            <tr>
                                <th>Title:</th>
                                <td id="dvd-title"></td>
                            </tr>
                            <tr>
                                <th>Release Date:</th>
                                <td id="dvd-rd"></td>
                            </tr>
                            <tr>
                                <th>MPAA</th>
                                <td id="dvd-mpaa"></td>
                            </tr>
                            <tr>
                                <th>Directors Name</th>
                                <td id="dvd-directors-name"></td>
                            </tr>
                            <tr>
                                <th>Studio</th>
                                <td id="dvd-studio"></td>
                            </tr>
                            <tr>
                                <th>Notes</th>
                                <td id="dvd-notes"></td>
                            </tr>

                        </table>

              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
        </div>
        <div id="editContactModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit DVD Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">
                            <input type="hidden" id="edit-id" />
                            <tr>
                                <th>Title:</th>
                                <td>
                                    <input type="text" id="edit-dvd-title" />
                                </td>
                            </tr>
                            <tr>
                                <th>Release Date:</th>
                                <td>
                                    <input type="date" id="edit-dvd-rd" />
                                </td>
                            </tr>
                            <tr>
                                <th>MPAA</th>
                                <td>
                                    <input type="text" id="edit-dvd-mpaa" />
                                </td>
                            </tr>
                            <tr>
                                <th>Directors Name</th>
                                <td>
                                    <input type="text" id="edit-dvd-directors-name" />
                                </td>
                            </tr>
                            <tr>
                                <th>Studio</th>
                                <td>
                                    <input type='text' id="edit-dvd-studio" />
                                </td>
                            </tr>
                            <tr>
                                <th>Notes</th>
                                <td>
                                    <input type='text' id="edit-dvd-notes" />
                                </td>
                            </tr>


                        </table>

              </div>
              <div class="modal-footer">
                        <button type="submit" class="btn btn-danger center-block" id="edit-dvd-button" >Save</button>
                        <br />
                    <button type="button" class="btn btn-default center-block" data-dismiss="modal">Close</button>


              </div>
            </div>

          </div>
        </div>

        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>

        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdapp.js"></script>

    </body>
</html>
