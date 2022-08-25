<%-- 
    Document   : form
    Created on : Aug 11, 2022, 10:44:39 PM
    Author     : AdminDEV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h3 class="header-title">Input information Question</h3>

                <f:form action="insert.htm" method="POST" commandName="c" >
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>Information Exam - Subject: ${subject.name}</h2>
                            <div class="mb-3" hidden="">
                                <label class="form-label">Id</label>
                                <f:input path="id" type="text" cssClass="form-control" placeholder="id" />
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Content</label>
                                <f:input path="content" type="text"  cssClass="form-control" placeholder="Name" />
                            </div>

                            <div class="mb-3">
                                <label for="note" class="form-label">Note</label>
                                <f:textarea path="note" cssClass="form-control" id="example-textarea" rows="5" />
                            </div>

                            <div class="mb-3">
                                <label for="note" class="form-label">Timer (minute)</label>
                                <f:input path="timer" type="number" cssClass="form-control"/>
                            </div>

                            <div class="mb-3">
                                <div class="form-check form-switch">
                                    <f:checkbox path="status" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Status (Show/Hiden)</label>
                                </div>
                            </div>


                        </div> <!-- end col -->
                        <div class="col-lg-12">  
                            <h2>List Question</h2>
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="mb-3">
                                        <label for="total" class="form-label">Total Point</label>
                                        <input value="0" id="totalPoint" type="text" Class="form-control" readonly=""/>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <p class="mb-1 fw-bold text-muted mt-3 mt-md-0">Questions</p>

                                    <select multiple="multiple" class="multi-select" id="my_multi_select2" name="questions" data-plugin="multiselect" data-selectable-optgroup="true">
                                        <c:forEach items="${levels}" var="level">
                                            <optgroup style="color: red;" label="${level.name} (${level.point})">
                                                <c:forEach items="${questions}" var="q">
                                                    <c:if test="${level.id == q.idLevel}">
                                                        <option value="${q.id}" data-point="${level.point}">${q.name}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </optgroup>
                                        </c:forEach>
                                    </select>
                                </div> <!-- end col -->
                                <div class="col-lg-12">
                                    <div class="mb-3" style="margin-top: 30px;">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                        <a href="/FE_ExamApplication/exam.htm" class="btn btn-danger">Back</a>
                                    </div>
                                </div>
                            </div> <!-- end row -->
                        </div>
                    </div> <!-- end col -->
                </div>
                <!-- end row-->
            </f:form>


        </div> <!-- end card-body -->
    </div> <!-- end card -->
</div><!-- end col -->
</div>