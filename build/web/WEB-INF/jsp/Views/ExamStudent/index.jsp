<%-- 
    Document   : Home
    Created on : Aug 4, 2022, 9:43:12 PM
    Author     : AdminDEV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
            <div class="col-12">
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
                                    <h4 class="text-uppercase mt-0">Your Test</h4>
                                </div>
                                <form action="start_exam.htm">
                                    <div class="mb-3 d-grid text-center">
                                        <select class="form-select" name="idContest" id="idContest">
                                            <c:if test="${contest.size() == 0}">
                                                <option disabled selected value> -- There is no test for you -- </option>
                                            </c:if>
                                            <c:forEach items="${contest}" var="con">
                                                <option value="${con.id}">${con.className}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="mb-3 d-grid text-center">
                                        <button class="btn btn-primary" type="submit" ${contest.size() == 0 ? "disabled" : ""}> Choose .. </button>
                                    </div>
                                </form>
                            </div> <!-- end card-body -->
                        </div>
                        <!-- end card -->

                        <div class="row mt-3">
                            <div class="col-12 text-center">
                                <p class="text-muted"><b>Good luck ..</b></p>
                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->

                    </div> <!-- end col -->
                </div>

            </div>
        </div>
    </body>
</html>
