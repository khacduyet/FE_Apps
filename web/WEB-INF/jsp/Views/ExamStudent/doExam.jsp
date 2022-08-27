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
                <div class="card">
                    <div class="card-body">
                        <form action="finished_exam.htm" method="POST" id="submit_exam">
                            <h4 class="mt-0 header-title">Student Exam</h4>
                            <p class="text-muted font-14 mb-3">
                                <button type="submit" class="btn btn-success">Finish</button>
                                <button type="button" id="exam_show_time">Click me!</button>
                            </p>
                            <h4 class="header-title mb-4">Exam in progress. Good Luck!</h4>
                            <h4 style="color: red" class="mb-4" >Time: <p id="timer_exam"></p></h4>

                            <div class="row">
                                <div class="col-sm-3">
                                    <div class="nav flex-column nav-pills nav-pills-tab" id="v-pills-tab" role="tablist" aria-orientation="vertical" style="background: #fbfbfb; border-radius: 20px; height: 500px; overflow-y: auto;">
                                        <c:forEach items="${questions}" var="q" varStatus="loop">
                                            <a class="nav-link ${loop.count == 1 ? "active" : ""} show mb-1" id="v-pills-home-tab" data-bs-toggle="pill" href="#v-pills-${q.id}" role="tab" aria-controls="v-pills-${q.id}"
                                               aria-selected="false">
                                                Câu ${loop.count}
                                            </a>
                                        </c:forEach>
                                    </div>
                                </div>  
                                <div class="col-sm-9">
                                    <div class="tab-content pt-2">
                                        <input name="minuted" id="timeLost" hidden/>
                                        <input name="count" value="${count}" hidden/>
                                        <input name="idContest" value="${contest.id}" hidden/>
                                        <input name="timer_contest" id="timer_contest" value="${contest.testTime}" hidden/>
                                    </div>
                                    <div class="tab-content pt-2">
                                        <c:forEach items="${questions}" var="q" varStatus="loop">
                                            <div class="tab-pane fade show ${loop.count == 1 ? "active" : ""}" id="v-pills-${q.id}" role="tabpanel" aria-labelledby="v-pills-home-tab">
                                                <h4>
                                                    ${q.name}
                                                </h4>
                                                <c:forEach items="${q.Items}" var="item">
                                                    <div class="form-check mb-2 form-check-success">
                                                        <input class="form-check-input" type="radio" name="question${loop.count}" id="question${item.id}" value="${item.id}">
                                                        <label class="form-check-label" for="question${item.id}">${item.note}</label>
                                                    </div>  
                                                </c:forEach>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>  
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
