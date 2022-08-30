<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from coderthemes.com/adminto/layouts/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 02 Aug 2022 14:52:48 GMT -->

    <head>
        <jsp:include page="Layouts/header.jsp"></jsp:include>
        </head>
        <!-- body start -->
        <body class="loading" data-layout-color="light"  data-layout-mode="default" data-layout-size="fluid" data-topbar-color="light" data-leftbar-position="fixed" data-leftbar-color="light" data-leftbar-size='default' data-sidebar-user='true'>

            <!-- Begin page -->
            <div id="wrapper">


                <!-- Topbar Start -->
                <div class="navbar-custom">
                <jsp:include page="Layouts/topbar.jsp"></jsp:include>
                </div>

                <!-- end Topbar -->

                <!-- ========== Left Sidebar Start ========== -->
                <div class="left-side-menu">
                <jsp:include page="Layouts/leftSideBar.jsp"></jsp:include>
                </div>
                <!-- Left Sidebar End -->

                <!-- ============================================================== -->
                <!-- Start Page Content here -->
                <!-- ============================================================== -->

                <div class="content-page">
                    <div class="content">

                        <!-- Start Content-->
                        <div class="container-fluid">
                        <jsp:include page="${VIEW}"></jsp:include>
                        </div> <!-- container-fluid -->

                        <div class="toast fade ${msg != null ? "show" : "hide"}" role="alert" aria-live="assertive" aria-atomic="true" data-bs-toggle="toast" style="position: fixed; right: 10px;top: 80px;">
                        <div class="toast-header">
                            <img src="<c:url value="/resources/assets/images/logo-sm.png" />" alt="brand-logo" height="12" class="me-1" />
                            <strong class="me-auto">Adminto</strong>
                            <button type="button" class="btn-close ms-2" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                        <div class="toast-body">
                            ${msg}
                        </div>
                    </div> <!--end toast-->
                    <!-- Footer Start -->
                    <footer class="footer">
                        <jsp:include page="Layouts/footer.jsp"></jsp:include>
                        </footer>
                        <!-- end Footer -->

                    </div>
                    <!-- ============================================================== -->
                    <!-- End Page content -->
                    <!-- ============================================================== -->


                </div>
                <!-- END wrapper -->

                <!-- Right Sidebar -->
                <div class="right-bar">
                <jsp:include page="Layouts/rightSidebar.jsp"></jsp:include>
                    <!-- end slimscroll-menu-->
                </div>
                <!-- /Right-bar -->

                <!-- Right bar overlay-->
                <div class="rightbar-overlay"></div>

                <!--Scripts-->
            <jsp:include page="Layouts/scripts.jsp"></jsp:include>
            </div>

            <div id="_loading_back"  style="width: 100%; height: 100%; backdrop-filter: blur(5px); position: absolute; top: 0; left: 0; z-index: 10"></div>
            <img id="_loading_front"  src="<c:url value="/resources/assets/images/loading_tree.gif"/>" style="z-index: 999;position: fixed;top: 20%; left: 40%;" />
    </body>
    <!-- Mirrored from coderthemes.com/adminto/layouts/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 02 Aug 2022 14:53:14 GMT -->
</html>