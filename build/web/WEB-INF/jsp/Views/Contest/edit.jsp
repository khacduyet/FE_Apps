<%-- 
    Document   : form
    Created on : Aug 11, 2022, 10:44:39 PM
    Author     : AdminDEV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h3 class="header-title">Input information contest</h3>

                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-6">
                        <f:form action="edit.htm" method="POST" commandName="c" onsubmit="return Validate()">
                            <div class="mb-3" hidden="">
                                <label class="form-label">Id</label>
                                <f:input path="id" type="text" cssClass="form-control" placeholder="id" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Contest Name</label>
                               <f:input id="className" path="className" type="text"  cssClass="form-control" placeholder="Class name" />
                                <p id="errclassName" class="error" value=""></p>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Test Date</label>
                                <input id="testDate" name="testDate" type="date" value="${testDate}"  class="form-control" placeholder="Test Date.." />
                                <p id="errtestDate" class="error" value=""></p>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Test Time (minute)</label>
                                <f:input id="testTime" path="testTime" type="number"  cssClass="form-control" placeholder="Test time.." />
                                <p id="errtestTime" class="error" value=""></p>
                            </div>

                            <div class="mb-3">
                                <label for="idClass" class="form-label">Class</label>
                                <select class="form-select" name="idClass" id="idClass">
                                    <c:forEach items="${cla}" var="ccc">
                                        <option value="${ccc.id}" ${c.idClass == ccc.id ? "selected" : ""}>${ccc.className}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            
                            <div class="mb-3">
                                <label for="idSubject" class="form-label">Subject</label>
                                <select class="form-select" name="idSubject" id="idSubject">
                                    <c:forEach items="${subs}" var="s">
                                        <option value="${s.id}" ${c.idSubject == s.id ? "selected" : ""}>${s.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="idExam" class="form-label">Exam</label>
                                <input type="hidden" value="${c.idExam}" id="idExamInput"/>
                                <select class="form-select" name="idExam" id="idExam">
                                    
                                </select>
                            </div>

                            <div class="mb-3">
                                <div class="form-check">
                                    <f:checkbox path="status" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Status (Show/Hiden)</label>
                                </div>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a href="/FE_ExamApplication/contest.htm" class="btn btn-danger">Back</a>
                            </div>
                        </f:form>
                    </div> <!-- end col -->
                    <div class="col-lg-4"></div>
                </div>
                <!-- end row-->

            </div> <!-- end card-body -->
        </div> <!-- end card -->
    </div><!-- end col -->
</div>
<script>
    function Validate() {
        var className = $('#className').val();
        var testDate = $('#testDate').val();
        var testTime = $('#testTime').val();
        if (className == '') {
            $('#errclassName').html('Class name is not null!');
            return false
        } else {
            $('#errclassName').html('');
        }
        if (testDate == '') {
            $('#errtestDate').html('Test date is not null!');
            return false
        } else {
            $('#errtestDate').html('');
        }
        if (testTime == '') {
            $('#errtestTime').html('Test time is not null!');
            return false
        } else {
            $('#errtestTime').html('');
        }
        return true;
    }
</script>