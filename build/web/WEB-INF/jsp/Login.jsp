<%-- 
    Document   : Login
    Created on : Aug 10, 2022, 10:14:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from coderthemes.com/adminto/layouts/auth-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 02 Aug 2022 14:53:43 GMT -->
    <head>
        <meta charset="utf-8" />
        <title>Log In | Adminto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- App favicon -->
        <link rel="shortcut icon" href="<c:url value="/resources/assets/images/favicon.ico"/>">

        <!-- App css -->

        <link href="<c:url value="/resources/assets/css/app.min.css"/>" rel="stylesheet" type="text/css" id="app-style" />

        <!-- icons -->
        <link href="<c:url value="/resources/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css" />

    </head>

    <body class="loading authentication-bg authentication-bg-pattern">

        <div class="account-pages my-5">
            <div class="container">

                <div class="row justify-content-center">
                    <div class="col-md-8 col-lg-6 col-xl-4">
                        <div class="text-center">   
                            <a href="index.html">
                                <img src="<c:url value="/resources/assets/css/app.min.css"/>assets/images/logo-dark.png" alt="" height="22" class="mx-auto">
                            </a>
                        </div>
                        <div class="card">
                            <div class="card-body p-4">

                                <div class="text-center mb-4">
                                    <h4 class="text-uppercase mt-0">Sign In</h4>
                                </div>

                                <f:form action="doLogin.htm" commandName="user" method="POST">
                                    <div class="mb-3">
                                        <label for="emailaddress" class="form-label">Username</label>
                                        <f:input  cssClass="form-control" path="username" type="text" required="" placeholder="Enter your username" />
                                    </div>

                                    <div class="mb-3">
                                        <label for="password" class="form-label">Password</label>
                                        <f:input cssClass="form-control" path="password" type="password" required="" placeholder="Enter your password" />
                                    </div>

                                    <div class="mb-3">
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input" id="checkbox-signin" checked>
                                            <label class="form-check-label" for="checkbox-signin">Remember me</label>
                                        </div>
                                    </div>
                                        <div><p style="color: red">${error}</p></div>
                                    <div class="mb-3 d-grid text-center">
                                        <button class="btn btn-primary" type="submit"> Log In </button>
                                    </div>
                                </f:form>

                            </div> <!-- end card-body -->
                        </div>
                        <!-- end card -->
                        <!-- end row -->

                    </div> <!-- end col -->
                </div>
                <!-- end row -->
            </div>
            <!-- end container -->
        </div>
        <!-- end page -->

        <!-- Vendor -->
        <script src="<c:url value="/resources/assets/libs/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/assets/libs/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <script src="<c:url value="/resources/assets/libs/simplebar/simplebar.min.js"/>"></script>
        <script src="<c:url value="/resources/assets/libs/node-waves/waves.min.js"/>"></script>
        <script src="<c:url value="/resources/assets/libs/waypoints/lib/jquery.waypoints.min.js"/>"></script>
        <script src="<c:url value="/resources/assets/libs/jquery.counterup/jquery.counterup.min.js"/>"></script>
        <script src="<c:url value="/resources/assets/libs/feather-icons/feather.min.js"/>"></script>

        <!-- App js -->
        <script src="<c:url value="/resources/assets/js/app.min.js"/>"></script>

    </body>

    <!-- Mirrored from coderthemes.com/adminto/layouts/auth-login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 02 Aug 2022 14:53:43 GMT -->
</html>
