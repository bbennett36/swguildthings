<%-- 
    Document   : admin
    Created on : Jun 2, 2016, 10:14:19 AM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flooring</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">


    </head>
    <body>


        <div class="container">
            <h1>Flooring</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/adminC/index">Admin Panel</a></li>
                </ul>
            </div>


            <div class="col-md-12 text-center">
                <h1>Admin Panel</h1>
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Add State & Tax Rate</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body">
                                <form method="POST" action="./createTax" class="form-group-sm">
                                    <div class="form-group">
                                        <!--<label for="t" class="col-md-6 control-label">State</label>-->
                                        <div class="col-md-12">
                                            <input name="state" id="t" placeholder="State Name"/>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="form-group">
                                        <!--<label for="sn" class="col-md-6 control-label">Tax</label>-->
                                        <div class="col-md-12">
                                            <input name="taxRate" id="sn" placeholder="State Tax Rate"/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <br/>
                                        <button class=" btn btn-danger center-block" type="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Add Product</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body">
                                <form method="POST" action="./createProduct" class="form-group-sm" >

                                    <div class="form-group">
                                        <!--<label for="t" class="col-md-8 control-label">Product Type</label>-->
                                        <div class="col-md-12">
                                            <input name="productType" id="t" placeholder="Product Type"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <!--<label for="sn" class="col-md-8 control-label">Material Cost PerSqFoot</label>-->
                                        <div class="col-md-12">
                                            <input name="matCostSqf" id="sn" placeholder="Material Cost PerSqFoot"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <!--<label for="snum" class="col-md-8 control-label">Labor Cost PerSqFoot</label>-->
                                        <div class="col-md-12">
                                            <input name="laborCostSqf" id="snum" placeholder="Labor Cost PerSqFoot" />
                                        </div>
                                    </div>
                                    <br />
                                    <div class="col-md-12">
                                        <br />
                                        <button class=" btn btn-danger btn-lg center-block" type="submit">Submit</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
        <div class="row">
            <div class="col-md-6 text-center">
                <h2>State & Tax Rates</h2>
                <table class="table table-bordered">
                    <tr>
                        <th>State</th>
                        <th>Tax Rate</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${taxes}" var="tax">
                        <tr>
                            <td>${tax.state}</td>
                            <td>${tax.taxRate}</td>
                            <td><a href="${pageContext.request.contextPath}/order/edit/${tax.id}">Edit</a></td>
                            <td><a href="delete/${tax.state}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6 text-center" id="two">
                <h2>Products</h2>
                <table class="table table-bordered">
                    <tr>
                        <th>Product Type</th>
                        <th>MaterialCost PerSqFt</th>
                        <th>LaborCost PerSqFt</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${products}" var="p">
                        <tr>
                            <td>${p.productType}</td>
                            <td>${p.matCostSqf}</td>
                            <td>${p.laborCostSqf}</td>
                            <td><a href="editAdmin/p=${p.productType}">Edit</a></td>
                            <td><a href="delete/p=${p.productType}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>


    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>