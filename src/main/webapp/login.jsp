<%-- 
    Document   : login
    Created on : 3 Oct, 2018, 3:57:03 PM
    Author     : glodeveloper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="ti">

    <%
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        String userID = (String) session.getAttribute("userID");      
        if (userID != null) {
            response.sendRedirect(request.getContextPath() + "/home");
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            String cookiename = c.getName();
            if (cookiename.equals("emailID")) {
                pageContext.setAttribute("emailID", c.getValue());
            } else if (cookiename.equals("password")) {
                pageContext.setAttribute("password", c.getValue());
            }
        }
    %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <title>Login</title>

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

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>        
    </head>

    <body ng-controller="loginctrl as ctrl">
        <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
        <div id="login-page"  >
            <div class="container">
                <form class="form-login" ng-submit="ctrl.submit()" name="loginform">
                    <h2 class="form-login-heading">sign in </h2>
                    <div class="loader" ng-show="loading"></div>
                    <div class="login-wrap" >
                        <b><p style="color: red" >${param.msg}</p></b>
                        <b><p style="color: red" >{{message}}</p></b>
                        <input type="hidden" ng-model="contextpath" ng-init="contextpath = '${pageContext.request.contextPath}'"/>
                        <input type="email" class="form-control" ng-model="emailID" name="emailID" ng-init="emailID = '${emailID}'" placeholder="Email ID" required autofocus>
                        <br>
                        <span ng-show="loginform.$dirty && loginform.emailID.$invalid" style="color: red">Enter valid Email ID </span>
                        <input type="password" class="form-control" ng-model="password" name="password" ng-init="password = '${password}'" placeholder="Password" required>
                        <label class="checkbox">
                            <input type="checkbox" name="rememberme" ng-model="rememberme"  > Remember me
                            <span class="pull-right">
                                <a data-toggle="modal"  href="login.html#myModal"> Forgot Password?</a>
                            </span>
                        </label>
                        <button class="btn btn-theme btn-block"  type="submit" ng-disabled="loginform.$invalid" ><i class="fa fa-lock" ></i> SIGN IN</button>                                               
                    </div>
                </form>
                <form class="form-login">
                    <!-- Modal -->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Forgot Password ?</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Enter your e-mail address below to reset your password.</p>
                                    <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                    <button class="btn btn-theme" type="button">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- modal -->
                </form>
            </div>
        </div>
        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/lib/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/lib/bootstrap/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/loginctrl.js"/>"></script>                
    </body>

</html>