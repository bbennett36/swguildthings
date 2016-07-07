<%-- 
    Document   : edit
    Created on : Jun 1, 2016, 10:19:15 AM
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
        <title>JSP Page</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/css/starter-template.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/site.css" rel="stylesheet">

        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>

        <div class="container">
            <div class="col-md-12">
                <div class="navbar navbar-inverse">
                    <ul class="nav navbar-nav nav-justified">
                        <li role="presentation" class="active" id="title"><a href="${pageContext.request.contextPath}">Flooring Mastery</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-4">
            </div>

            <div class="col-md-4 text-center">
                <c:if test="${editOrder}">
                    <h1 id="asd">Edit Order</h1>
                    <form method="POST" action="./" class="form-group" id="f">
                        <input type="hidden" name="id" value="${order.id}" />


                        <input name="name" id="t" class="form-control" value="${order.name}"/>
                        <br/>


                        <input name="date" id="d" value="${order.date}" class="form-control"/>
                        <br />

                        <input name="area" id="cit" class="form-control" value="${order.area}"/>
                        <div id="select2">
                            <br />
                            <select name="state" class="form-control">
                                <option>${order.state}</option>
                                <c:forEach items="${taxes}" var="t">
                                    <option>${t.state}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div id="select2">
                            <br />
                            <select name="product" class="form-control">
                                <option>${order.product}</option>
                                <c:forEach items="${products}" var="p">
                                    <option>${p.productType}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br />
                        <button class=" btn btn-default btn-lg center-block" type="submit">Submit Changes</button>
                         <br />
                        <a href="${pageContext.request.contextPath}" class="btn btn-default btn-lg center-block" role="button" style="width: 170px;">Go Back</a>
                    </form>
                </c:if>
                <c:if test="${editProd}">
                    <h1 id="asd">Edit Product</h1>
                    <form method="POST" action="${pageContext.request.contextPath}/order/edit/p" class="form-group-sm" >
                        <input type="hidden" name="id" value="${product.id}" />
                        <input name="productType" id="t" value="${product.productType}" class="form-control"/>
                        <br />
                        <input name="matCostSqf" id="sn" value="${product.matCostSqf}" class="form-control"/>
                        <br />
                        <input name="laborCostSqf" id="snum" value="${product.laborCostSqf}" class="form-control"/>
                        <br />
                        <button class=" btn btn-default btn-lg center-block" type="submit">Submit Changes</button>
                         <br />
                        <a href="${pageContext.request.contextPath}" class="btn btn-default btn-lg center-block" role="button" style="width: 170px;">Go Back</a>

                    </form>
                </c:if>
                <c:if test="${tEdit}">
                    <h1 id="asd">Edit State</h1>
                    <form method="POST" action="${pageContext.request.contextPath}/order/edit/t" class="form-group-sm" >
                        <input type="hidden" name="id" value="${tax.id}" />
                        <input name="state" id="t" value="${tax.state}" class="form-control"/>
                        <br />
                        <input name="taxRate" id="sn" value="${tax.taxRate}" class="form-control"/>
                        <br/>
                        <button class=" btn btn-default btn-lg center-block" type="submit">Submit Changes</button>
                        <br />
                        <a href="${pageContext.request.contextPath}" class="btn btn-default btn-lg center-block" role="button" style="width: 170px;">Go Back</a>
                    </form>
                </c:if>



            </div>   
            <div class="col-md-4">
            </div>

        </div>



    </body>
</html>
