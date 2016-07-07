<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <!--<link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">-->

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->

        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">


    </head>
    <body>

        <p></p>
        <div class="container">
            <div class="col-md-12">
                <div class="navbar navbar-inverse">
                    <ul class="nav navbar-nav nav-justified">
                        <li role="presentation" class="active" id="title"><a href="${pageContext.request.contextPath}">Flooring Mastery</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-4 text-center">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Add Order</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body text-center" id="two">
                                <form method="POST"class="form-group" id="f">
                                    <input  id="name-input" type="text" class="form-control" placeholder="Enter Name"/>
                                    <br/>

                                    <input type="date" id="date-input" placeholder="Enter Date (DDMMYYYY)" class="form-control"/>
                                    <br />

                                    <input type="text" id="area-input" class="form-control" placeholder="Enter Area"/>
                                    <div id="select2">
                                        <br />
                                        <select id="state-input" class="form-control">
                                            <option>Select a State</option>
                                            <c:forEach items="${taxes}" var="t">
                                                <option>${t.state}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div id="select2">
                                        <br />
                                        <select id="product-input" class="form-control">
                                            <option>Select a Product type</option>
                                            <c:forEach items="${products}" var="p">
                                                <option>${p.productType}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div id="add-flooring-validation-errors"></div>
                                    <br />
                                    <button class=" btn btn-default btn-lg center-block" type="submit" id="create-submit">Submit Order</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Add State</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body text-center" id="two">
                                <form method="POST" class="form-group-sm">
                                    <input name="state" id="t-state-input" placeholder="Enter State Name" class="form-control"/>
                                    <br />
                                    <input name="taxRate" id="t-rate-input" placeholder="Enter State Tax Rate" class="form-control"/>
                                    <br/>
                                    <div id="add-flooring-validation-errors3"></div>
                                    <button class=" btn btn-default btn-lg center-block" id="tax-submit" type="submit" class="form-control">Submit State</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Add Product</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse">
                            <div class="panel-body" id="two">
                                <form method="POST"class="form-group-sm" >
                                    <input name="productType" id="p-type-input" placeholder="Enter Product Type" class="form-control"/>
                                    <br />
                                    <input name="matCostSqf" id="p-mcs-input" placeholder="Enter MaterialCost PerSqFoot" class="form-control"/>
                                    <br />
                                    <input name="laborCostSqf" id="p-lcs-input" placeholder="Enter LaborCost PerSqFoot" class="form-control"/>
                                    <br />
                                    <div id="add-flooring-validation-errors2"></div>
                                    <button class="btn btn-default btn-lg center-block" type="submit" id="product-submit">Submit Product</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8 text-center">
                <div class="panel-group" id="accordion2">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Show All Orders</a>
                            </h4>
                        </div>
                        <div id="collapse4" class="panel-collapse collapse">
                            <div class="panel-body text-center" id="two">
                                <table class="table" id="order-table">
                                    <thead>
                                        <tr style="background-color: #000; color: white;">
                                            <th>Order Id</th>
                                            <th>Name</th>
                                            <th>Date</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${orders}" var="order">
                                            <tr id="order-row-${order.id}">
                                                <td><a data-order-id="${order.id}" data-toggle="modal" data-target="#showContactModal">${order.id}</a></td>
                                                <td>${order.name}</td>
                                                <td>${order.date}</td>
                                                <td><a data-order-id="${order.id}" data-toggle="modal" data-target="#editContactModal">Edit</a></td>
                                                <td><a data-order-id="${order.id}" class="delete-link">Delete</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group" id="accordion2">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Show All States</a>
                            </h4>
                        </div>
                        <div id="collapse5" class="panel-collapse collapse">
                            <div class="panel-body text-center" id="two">
                                <table class="table" id="tax-table">
                                    <tr style="background-color: #000; color: white;">
                                        <th>State</th>
                                        <th>Tax Rate</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                    <c:forEach items="${taxes}" var="tax">
                                        <tr id="tax-row-${tax.id}">
                                            <td><a data-tax-id="${tax.id}" data-toggle="modal" data-target="#showTaxModal">${tax.state}</a></td>
                                            <td>${tax.taxRate}%</td>
                                            <td><a data-tax-id="${tax.id}" data-toggle="modal" data-target="#editTaxModal">Edit</a></td>
                                            <td><a data-tax-id="${tax.id}" class="delete-link3">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group" id="accordion2">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">Show All Products</a>
                            </h4>
                        </div>
                        <div id="collapse6" class="panel-collapse collapse">
                            <div class="panel-body text-center" id="two">
                                <table class="table"  id="product-table">
                                    <tr style="background-color: #000; color: white;">
                                        <th>Product Type</th>
                                        <th>Material Cost PerSqFt</th>
                                        <th>Labor Cost PerSqFt</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                    <c:forEach items="${products}" var="p">
                                        <tr id="product-row-${p.id}">
                                            <td><a data-product-id="${p.id}" data-toggle="modal" data-target="#showProductModal">${p.productType}</a></td>
                                            <td>$${p.matCostSqf}</td>
                                            <td>$${p.laborCostSqf}</td>
                                            <td><a data-product-id="${p.id}" data-toggle="modal" data-target="#editProductModal">Edit</a></td>
                                            <td><a data-product-id="${p.id}" class="delete-link2">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group" id="accordion2">
                    <div class="panel panel-default">
                        <div class="panel-heading" id="one">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse7">Show Order Log</a>
                            </h4>
                        </div>
                        <div id="collapse7" class="panelString-collapse collapse">
                            <div class="panel-body text-center" id="two">
                                <table class="table">
                                    <tr style="background-color: #000; color: white;">
                                        <th>Log ID</th>
                                        <th>Order ID</th>
                                        <th>Name</th>
                                        <th>Log Time</th>
                                        <th>Log Reason</th>
                                    </tr>
                                    <c:forEach items="${audits}" var="a">
                                        <tr>
                                            <td>${a.id}</td>
                                            <td>${a.orderId}</td>
                                            <td>${a.name}</td>
                                            <td>${a.date}</td>
                                            <td>${a.type}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="showContactModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Order Details</h4>
                                <button type="button" class="btn btn-default center-block" data-dismiss="modal">Close</button>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">
                            <tr>
                                <th>Name:</th>
                                <td id="order-name"></td>
                            </tr>
                            <tr>
                                <th>State:</th>
                                <td id="order-state"></td>
                            </tr>
                            <tr>
                                <th>Tax Rate</th>
                                <td id="order-tax"></td>
                            </tr>
                            <tr>
                                <th>Date</th>
                                <td id="order-date"></td>
                            </tr>
                            <tr>
                                <th>Product</th>
                                <td id="order-product"></td>
                            </tr>
                            <tr>
                                <th>Area</th>
                                <td id="order-area"></td>
                            </tr>
                            <tr>
                                <th>Labor Cost</th>
                                <td id="order-lc"></td>
                            </tr>
                            <tr>
                                <th>Labor Cost perSqFt</th>
                                <td id="order-lcs"></td>
                            </tr>
                            <tr>
                                <th>Material Cost</th>
                                <td id="order-mc"></td>
                            </tr>
                            <tr>
                                <th>Material Cost perSqFt</th>
                                <td id="order-mcs"></td>
                            </tr>
                            <tr>
                                <th>Tax Total</th>
                                <td id="order-tt"></td>
                            </tr>
                            <tr>
                                <th>Total</th>
                                <td id="order-total"></td>
                            </tr>

                        </table>
                    </div>
              <div class="modal-footer">
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
                <h4 class="modal-title">Edit Order Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">


                            <input type="hidden" id="edit-id" />
                            <tr>
                                <th>Name:</th>
                                <td>
                                    <input type="text" id="edit-order-name" />
                                </td>
                            </tr>
                            <tr>
                                <th>State:</th>
                                <td>
                                    <select id="edit-order-state" class="form-control">
                                        <option>Select a State</option>
                                        <c:forEach items="${taxes}" var="t">
                                            <option>${t.state}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <!--                            <td>
                                                                <input type="type" id="edit-order-state" />
                                                            </td>-->
                            </tr>
                            <tr>
                                <th>Tax</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>Date</th>
                                <td>
                                    <input type="date" id="edit-order-date" />
                                </td>
                            </tr>
                            <tr>
                                <th>Product</th>
                                <td>
                                    <select id="edit-order-product" class="form-control">
                                        <option>Select a Product type</option>
                                        <c:forEach items="${products}" var="p">
                                            <option>${p.productType}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Area</th>
                                <td>
                                    <input type='text' id="edit-order-area" />
                                </td>
                            </tr>
                            <tr>
                                <th>Labor Cost</th>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th>Labor Cost perSqFt</th>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th>Material Cost</th>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th>Material Cost perSqFt</th>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th>Tax Total</th>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th>Total
                                </th>
                                <td>
                                </td>
                            </tr>


                        </table>

              </div>
              <div class="modal-footer">

                        <div id="add-flooring-validation-errors"></div>
                        <button type="submit" class="btn btn-danger center-block" id="edit-order-button" >Save</button>
                        <br />
                    <button type="button" class="btn btn-default center-block" data-dismiss="modal">Close</button>


              </div>
            </div>

          </div>
        </div>

        <div id="showProductModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Order Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered" id="show-dvd-table">
                            <tr>
                                <th>Product Type:</th>
                                <td id="product-type"></td>
                            </tr>
                            <tr>
                                <th>Material Cost perSqFt</th>
                                <td id="product-mcs"></td>
                            </tr>
                            <tr>
                                <th>Labor Cost perSqFt</th>
                                <td id="product-lcs"></td>
                            </tr>


                        </table>
                    </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
        </div>
        <div id="editProductModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Product</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">

                            <input type="hidden" id="edit-id2" />
                            <tr>
                                <th>Product Type:</th>
                                <td>
                                    <input type="text" id="edit-p-type" />
                                </td>
                            </tr>
                            <tr>
                                <th>Material Cost perSqFt</th>
                                <td>
                                    <input type="text" id="edit-p-mcs" />
                                </td>
                            </tr>
                            <tr>
                                <th>Labor Cost perSqFt</th>
                                <td>
                                    <input type="text" id="edit-p-lcs" />
                                </td>
                            </tr>



                        </table>

              </div>
              <div class="modal-footer">
                        <button type="submit" class="btn btn-danger center-block" id="edit-product-button" >Save</button>
                        <br />
                    <button type="button" class="btn btn-default center-block" data-dismiss="modal">Close</button>


              </div>
            </div>

          </div>
        </div>

        <div id="showTaxModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">State Details</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered" id="show-dvd-table">
                            <tr>
                                <th>State Name:</th>
                                <td id="state-name"></td>
                            </tr>
                            <tr>
                                <th>State Tax Rate:</th>
                                <td id="state-rate"></td>
                            </tr>

                        </table>
                    </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>

          </div>
        </div>

        <div id="editTaxModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit State</h4>
              </div>
              <div class="modal-body">

                  <table class="table table-bordered">

                            <input type="hidden" id="edit-id3" />
                            <tr>
                                <th>State Name:</th>
                                <td>
                                    <input type="text" id="edit-state" />
                                </td>
                            </tr>
                            <tr>
                                <th>Tax Rate:</th>
                                <td>
                                    <input type="text" id="edit-rate" />
                                </td>
                            </tr>



                        </table>

              </div>
              <div class="modal-footer">
                        <button type="submit" class="btn btn-danger center-block" id="edit-tax-button" >Save</button>
                        <br />
                    <button type="button" class="btn btn-default center-block" data-dismiss="modal">Close</button>


              </div>
            </div>

          </div>
        </div>            


        <script>
            var contextRoot = "${pageContext.request.contextPath}";
        </script>



        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/flooringapp.js"></script>

    </body>
</html>

