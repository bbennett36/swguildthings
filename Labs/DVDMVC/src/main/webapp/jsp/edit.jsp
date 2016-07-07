<%-- 
    Document   : edit
    Created on : Jun 1, 2016, 10:19:15 AM
    Author     : apprentice
--%>

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
            <h1>Address Book</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}">Home</a></li>
                </ul>
            </div>

            <div class="row">

                <div class="col-md-6">
                    <form method="POST" action="./" class="form-horizontal">
                        <input type="hidden" name="id" value="${dvd.id}" />

                        <div class="form-group">
                            <label for="t" class="col-md-4 control-label">Title</label>
                            <div class="col-md-8">
                                <input name="title" id="t" placeholder="Title"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="t" class="col-md-4 control-label">Release Date</label>
                            <div class="col-md-8">
                                <input name="releaseDate" id="t" placeholder="(dd-mm-yyyy"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="sn" class="col-md-4 control-label">MPAA</label>
                            <div class="col-md-8">
                                <input name="mPAA" id="sn" placeholder="MPAA"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="snum" class="col-md-4 control-label">Directors name</label>
                            <div class="col-md-8">
                                <input name="directorsName" id="snum" placeholder="Directors Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cit" class="col-md-4 control-label">Studio</label>
                            <div class="col-md-8">
                                <input name="studio" id="cit" placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="st" class="col-md-4 control-label">Note</label>
                            <div class="col-md-8">
                                <input name="note" id="st" placeholder="Note"/>
                            </div>
                        </div>
                        <br />
                        <div class="col-md-8">
                            <button class=" btn btn-danger btn-lg pull-right" type="submit">Submit</button>
                        </div>
                    </form>
                </div>    
            </div>


        </div>        

    </body>
</html>
