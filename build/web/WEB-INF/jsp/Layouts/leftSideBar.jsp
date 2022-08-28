<%-- 
    Document   : leftSideBar
    Created on : Aug 4, 2022, 9:31:33 PM
    Author     : AdminDEV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h-100" data-simplebar>

    <!-- User box -->
    <div class="user-box text-center">

        <img src="<c:url value="/resources/assets/images/users/user-1.jpg"/>" alt="user-img" title="Mat Helme" class="rounded-circle img-thumbnail avatar-md">
        <div class="dropdown">
            <a href="#" class="user-name dropdown-toggle h5 mt-2 mb-1 d-block" data-bs-toggle="dropdown"  aria-expanded="false">${currentUser.name}</a>
            <div class="dropdown-menu user-pro-dropdown">

                <!-- item-->
                <a href="javascript:void(0);" class="dropdown-item notify-item">
                    <i class="fe-user me-1"></i>
                    <span>My Account</span>
                </a>

                <!-- item-->
                <a href="javascript:void(0);" class="dropdown-item notify-item">
                    <i class="fe-settings me-1"></i>
                    <span>Settings</span>
                </a>

                <!-- item-->
                <a href="javascript:void(0);" class="dropdown-item notify-item">
                    <i class="fe-lock me-1"></i>
                    <span>Lock Screen</span>
                </a>

                <!-- item-->
                <a href="/FE_ExamApplication/logout.htm" class="dropdown-item notify-item">
                    <i class="fe-log-out me-1"></i>
                    <span>Logout</span>
                </a>

            </div>
        </div>

        <p class="text-muted left-user-info">Admin Head</p>

        <ul class="list-inline">
            <li class="list-inline-item">
                <a href="#" class="text-muted left-user-info">
                    <i class="mdi mdi-cog"></i>
                </a>
            </li>

            <li class="list-inline-item">
                <a href="#">
                    <i class="mdi mdi-power"></i>
                </a>
            </li>
        </ul>
    </div>

    <!--- Sidemenu -->
    <div id="sidebar-menu">

        <ul id="side-menu">

            <li class="menu-title">Navigation</li>

            <li>
                <a href="home.htm">
                    <i class="mdi mdi-view-dashboard-outline"></i>
                    <span class="badge bg-success rounded-pill float-end">9+</span>
                    <span> Dashboard </span>
                </a>
            </li>

            <li class="menu-title mt-2">Apps</li>
                <c:choose>
                    <c:when test="${role == 'ROLE_ADMIN' || role == 'ROLE_TEACHER'}">
                    <li>
                        <a href="/FE_ExamApplication/class.htm">
                            <i class="mdi mdi-calendar-blank-outline"></i>
                            <span> Class </span>
                        </a>
                    </li>
                    <li>
                        <a href="/FE_ExamApplication/user.htm">
                            <i class="mdi mdi-account-multiple-plus-outline"></i>
                            <span> User </span>
                        </a>
                    </li>
                    <li>
                        <a href="/FE_ExamApplication/subject.htm">
                            <i class="mdi mdi-file-multiple-outline"></i>
                            <span> Subject </span>
                        </a>
                    </li>
                    <li>
                        <a href="/FE_ExamApplication/level-point.htm">
                            <i class="mdi mdi-layers-outline"></i>
                            <span> Level point </span>
                        </a>
                    </li>

                    <li>
                        <a href="/FE_ExamApplication/question.htm">
                            <i class="mdi mdi-book-open-page-variant-outline"></i>
                            <span> Question </span>
                        </a>
                    </li>
                    <li>
                        <a href="/FE_ExamApplication/exam.htm">
                            <i class="mdi mdi-map-outline"></i>
                            <span> Exam </span>
                        </a>
                    </li>

                    <li>
                        <a href="/FE_ExamApplication/contest.htm">
                            <i class="mdi mdi-table"></i>
                            <span> Contest </span>
                        </a>
                    </li>
                </c:when>    
                <c:when test="${role == 'ROLE_USER'}">
                    <li>
                        <a href="/FE_ExamApplication/examstudent.htm">
                            <i class="mdi mdi-texture"></i>
                            <span> Exam Student </span>
                        </a>
                    </li>
                </c:when>  
            </c:choose>
            <li>
                <a href="/FE_ExamApplication/report.htm">
                    <i class="mdi mdi-shield-outline"></i>
                    <span> Report </span>
                </a>
            </li>
        </ul>

    </div>
    <!-- End Sidebar -->

    <div class="clearfix"></div>

</div>
<!-- Sidebar -left -->