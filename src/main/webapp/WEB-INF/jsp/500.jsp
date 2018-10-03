<%-- 
    Document   : 500
    Created on : 3 Oct, 2018, 5:05:45 PM
    Author     : glodeveloper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <title>Internal Server Error</title>

        <!-- Favicons -->
        <link href="<c:url value="/resources/images/favicon.png"/>" rel="icon">
        <link href="<c:url value="/resources/images/apple-touch-icon.png"/>" rel="apple-touch-icon">

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/lib/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
        <!--external css-->
        <link href="<c:url value="/resources/lib/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style-responsive.css"/>" rel="stylesheet">

    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3 p404 centered">
                    <img src="<c:url value="/resources/images/500.png"/>" alt="">
                    <h1>ERROR 500</h1>
                    <h3>Ouch!! Something Went Wrong!</h3>
                    <br>                    
                    <h5 class="mt">Hey, maybe you will be interested in these pages:</h5>
                    <p><a href="<c:url value="/home"/>">Home</a> | <a href="<c:url value="/login"/>">Login</a> | <a href="#"> Contact</a></p>
                </div>
            </div>
        </div>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/lib/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.min.js"/>"></script>
    </body>
</html>
