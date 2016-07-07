<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Controller Page</title>
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
            <h1>Contact List</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>





            <div class="row">
                <div class="col-md-6">
                    <table class="table table-bordered" id="contact-table">
                        <tr>
                            <th>First</th>
                            <th>Last</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach items="${contacts}" var="contact">
                            <tr id="contact-row-${contact.id}">
                                <td><a data-contact-id="${contact.id}" data-toggle="modal" data-target="#showContactModal">${contact.firstName}</a></td>
                                <td>${contact.lastName}</td>


                                <td><a data-contact-id="${contact.id}" data-toggle="modal" data-target="#editContactModal">Edit</a></td>
                                <td><a data-contact-id="${contact.id}" class="delete-link">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <form method="POST" class="form-horizontal"> 
                        <div class="form-group">
                            <label for="fname" class="col-md-4 control-label">First</label>
                            <div class="col-md-8">
                                <input type="text" id="first-name-input" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="lname" class="col-md-4 control-label">Last</label>
                            <div class="col-md-8">

                                <input type="text" id="last-name-input" class="form-control" />

                            </div>
                        </div>

                        <div class="form-group">
                            <label for="com" class="col-md-4 control-label">Company</label>
                            <div class="col-md-8">
                                <input type="text" id="company-input" class="form-control" />

                            </div>
                        </div>

                        <div class="form-group">
                            <label for="ed" class="col-md-4 control-label">Email</label>
                            <div> 
                                <div class="col-md-8">

                                    <input type="text" id="email-input" class="form-control" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="ph" class="col-md-4 control-label">Phone</label>
                            <div class="col-md-8">
                                <input type="text" id="phone-input" class="form-control" />

                            </div>
                        </div>
                        <!--                        <div class="form-group">
                                                    <label for="ph" class="col-md-4 control-label">Last Contacted</label>
                                                    <div class="col-md-8">
                                                        <input type="text" id="last-contacted-input" class="form-control" />
                        
                                                    </div>
                                                </div>-->

                        <!--<div id="add-contact-validation-errors">-->

                        <!--</div>-->

                        <br />
                        <button class=" btn btn-danger btn-lg" type="submit" id="create-submit">Submit</button>
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
                <h4 class="modal-title">Contact Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered" id="show-contact-table">
                            <tr>
                                <th>First Name:</th>
                                <td id="contact-first-name"></td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td id="contact-last-name"></td>
                            </tr>
                            <tr>
                                <th>Company</th>
                                <td id="contact-company"></td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td id="contact-email"></td>
                            </tr>
                            <tr>
                                <th>Phone</th>
                                <td id="contact-phone"></td>
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
                <h4 class="modal-title">Edit Contact Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">
                            <input type="hidden" id="edit-id" />
                            <tr>
                                <th>First Name:</th>
                                <td>
                                    <input type="text" id="edit-contact-first-name" />
                                </td>
                            </tr>
                            <tr>
                                <th>Last Name:</th>
                                <td>
                                    <input type="text" id="edit-contact-last-name" />
                                </td>
                            </tr>
                            <tr>
                                <th>Company</th>
                                <td>
                                    <input type="text" id="edit-contact-company" />
                                </td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td>
                                    <input type="text" id="edit-contact-email" />
                                </td>
                            </tr>
                            <tr>
                                <th>Phone</th>
                                <td>
                                    <input type="text" id="edit-contact-phone" />
                                </td>
                            </tr>

                        </table>

              </div>
              <div class="modal-footer">
                        <button type="submit" class="btn btn-danger center-block" id="edit-contact-button" >Save</button>
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
        <script src="${pageContext.request.contextPath}/js/app.js" ></script>
    </body>
</html>

