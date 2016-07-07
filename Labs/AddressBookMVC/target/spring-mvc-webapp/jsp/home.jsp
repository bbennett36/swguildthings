<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>


        <div class="container">
            <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>


            <div class="row">
                <div class="col-md-6">
                    <table class="table table-bordered" id="address-table">
                        <tr>
                            <th>First</th>
                            <th>Last</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${addresses}" var="address">
                            <tr id="address-row-${address.id}">
                                <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#showContactModal">${address.firstName}</a></td>
                                <td>${address.lastName}</td>
                                <td>${address.city}</td>
                                <td>${address.state}</td>
                                <td>${address.zip}</td>
                                <td><a data-address-id="${address.id}" data-toggle="modal" data-target="#editContactModal">Edit</a></td>
                                <td><a data-address-id="${address.id}" class="delete-link">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <form action="address/search" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchName" placeholder="Search by Last Name">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="submit">Go!</button>
                            </span>
                        </div><!-- /input-group -->
                    </form>
                    <br />
                    <form action="address/searchCity" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchCity" placeholder="Search by City">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Go!</button>
                            </span>
                        </div><!-- /input-group -->
                    </form>
                    <br />
                    <form action="address/searchZip" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchZip" placeholder="Search by Zip">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Go!</button>
                            </span>
                        </div>
                    </form>
                    <br />
                    <form action="address/searchState" method="get">
                        <div class="input-group">
                            <input type="text" class="form-control" name="searchState" placeholder="Search by State">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">Go!</button>
                            </span>
                        </div><!-- /input-group -->
                    </form>
                </div>

                <div class="col-md-6 text-center">
                    <form method="POST"  class="form-horizontal">
                        <div class="form-group">
                            <div class="col-md-8">
                                <input type="text" id="first-name-input"  class="form-control" placeholder="Enter First Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="last-name-input"  class="form-control" placeholder="Enter Last Name"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-8">
                                <input type="text" id="street-num-input"  class="form-control" placeholder="Enter Street Number"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-8">
                                <input type="text" id="street-name-input"  class="form-control"placeholder="Enter Street Name" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="city-input"  class="form-control" placeholder="Enter City"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="state-input"  class="form-control" placeholder="Enter State"/>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-8">

                                <input type="text" id="zip-input"  class="form-control" placeholder="Enter Zip Code"/>

                            </div>
                        </div>
                        
                        <div id="add-address-validation-errors">
                            
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
                <h4 class="modal-title">Address Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered" id="show-dvd-table">
                            <tr>
                                <th>First Name:</th>
                                <td id="address-first-name"></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td id="address-last-name"></td>
                            </tr>
                            <tr>
                                <th>Street Number:</th>
                                <td id="address-street-num"></td>
                            </tr>
                            <tr>
                                <th>Street Name:</th>
                                <td id="address-street-name"></td>
                            </tr>
                            <tr>
                                <th>City:</th>
                                <td id="address-city"></td>
                            </tr>
                            <tr>
                                <th>State:</th>
                                <td id="address-state"></td>
                            </tr>
                            <tr>
                                <th>Zip:</th>
                                <td id="address-zip"></td>
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
                <h4 class="modal-title">Edit Address Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">
                            <input type="hidden" id="edit-id" />
                            <tr>
                                <th>First Name:</th>
                                <td><input type = "text" id="edit-address-first-name" /></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td><input type = "text" id="edit-address-last-name" /></td>
                            </tr>
                            <tr>
                                <th>Street Number:</th>
                                <td> <input type = "text" id="edit-address-street-num" /></td>
                            </tr>
                            <tr>
                                <th>Street Name:</th>
                                <td><input type = "text" id="edit-address-street-name" /></td>
                            </tr>
                            <tr>
                                <th>City:</th>
                                <td><input type = "text" id="edit-address-city" /></td>
                            </tr>
                            <tr>
                                <th>State:</th>
                                <td><input type = "text" id="edit-address-state" /></td>
                            </tr>
                            <tr>
                                <th>Zip:</th>
                                <td><input type = "text" id="edit-address-zip" /></td>
                            </tr>


                        </table>

              </div>
              <div class="modal-footer">
                        <button type="submit" class="btn btn-danger center-block" id="edit-address-button" >Save</button>
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
        <script src="${pageContext.request.contextPath}/js/addressapp.js" ></script>

    </body>
</html>

