<%-- 
    Document   : home
    Created on : 9 Oct, 2018, 12:57:32 PM
    Author     : glodeveloper
--%>

<%@page import="com.glovision.ti.util.SessionUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    
    String userID = (String) session.getAttribute("userID");
    if (userID == null) {
        response.sendRedirect(request.getContextPath() + "/logout?msg=Session Time out Please login again");
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>Home</title>

        <!-- Favicons -->
        <link href="<c:url value="/resources/images/favicon.png"/>" rel="icon">
        <link href="<c:url value="/resources/images/apple-touch-icon.png"/>" rel="apple-touch-icon">

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/lib/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
        <!--external css-->
        <link href="<c:url value="/resources/lib/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/zabuto_calendar.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/lib/gritter/css/jquery.gritter.css"/>" />
        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style-responsive.css"/>" rel="stylesheet">
        <script src="<c:url value="/resources/lib/chart-master/Chart.js"/>"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>        
        <!--Leaflet-->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.4/dist/leaflet.css"/>
    </head>

    <body>
        <section id="container">
            <!-- **********************************************************************************************************************************************************
                TOP BAR CONTENT & NOTIFICATIONS
                *********************************************************************************************************************************************************** -->
            <!--header start-->
            <%@include file="header.jsp" %>
            <!--header end-->
            <!-- **********************************************************************************************************************************************************
                MAIN SIDEBAR MENU
                *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <%@include file="sidebar.jsp" %>
            <!--sidebar end-->
            <!-- **********************************************************************************************************************************************************
                MAIN CONTENT
                *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row mt">
                        <div class="col-sm-12">
                            <section class="panel">                                
                                <div class="panel-body">
                                    <div id="map"></div>
                                </div>
                            </section>
                        </div>
                    </div>                    
                </section>
                <!-- /wrapper -->
            </section>
            <!--main content end-->
            <!--footer start-->
            <%@include file="footer.jsp" %>
            <!--footer end-->
        </section>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/lib/jquery/jquery.min.js"/>"></script>

        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.min.js"/>"></script>
        <script class="include" type="text/javascript" src="<c:url value="/resources/lib/jquery.dcjqaccordion.2.7.js"/>"></script>
        <script src="<c:url value="/resources/lib/jquery.scrollTo.min.js"/>"></script>
        <script src="<c:url value="/resources/lib/jquery.nicescroll.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/lib/jquery.sparkline.js"/>"></script>
        <!--common script for all pages-->
        <script src="<c:url value="/resources/lib/common-scripts.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/lib/gritter/js/jquery.gritter.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/lib/gritter-conf.js"/>"></script>
        <!--Leaf let-->
        <%--        <script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js"></script> --%>
        <script src="<c:url value="/resources/js/${SystemProps.findByPropID(userID+'#map')}.js"/>"></script>
        <!--Google map-->
        <script src="https://maps.googleapis.com/maps/api/js?callback=initMap"async defer></script>        
    </body>

</html>