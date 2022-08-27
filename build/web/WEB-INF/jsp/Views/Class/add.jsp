<%-- 
    Document   : form
    Created on : Aug 11, 2022, 10:44:39 PM
    Author     : AdminDEV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h3 class="header-title">Input information class</h3>

                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-6">
                        <f:form action="insert.htm" method="POST" commandName="c" >
                            <div class="mb-3" hidden="">
                                <label class="form-label">Id</label>
                                <f:input path="id" type="text" cssClass="form-control" placeholder="id" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Class Name</label>
                                <f:input path="className" type="text"  cssClass="form-control" placeholder="Class name"  />
                                <f:errors path="className" cssClass="error"/><br><br>  
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Course</label>
                                <f:input path="course" type="text"  cssClass="form-control" placeholder="Course" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">School year</label>
                                <f:input path="schoolYear" type="text"  cssClass="form-control" placeholder="School year" />
                            </div>

                            <div class="mb-3">
                                <label for="note" class="form-label">Note</label>
                                <f:textarea path="note" cssClass="form-control" id="example-textarea" rows="5" />
                            </div>

                            <div class="mb-3">
                                <div class="form-check">
                                    <f:checkbox path="status" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Status (Show/Hiden)</label>
                                </div>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a href="/FE_ExamApplication/class.htm" class="btn btn-danger">Back</a>
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