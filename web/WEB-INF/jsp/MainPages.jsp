<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                    </div> <!-- content -->

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
    </body>

    <!-- Mirrored from coderthemes.com/adminto/layouts/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 02 Aug 2022 14:53:14 GMT -->
</html>