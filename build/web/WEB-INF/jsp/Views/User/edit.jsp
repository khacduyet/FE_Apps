<%-- 
    Document   : form
    Created on : Aug 11, 2022, 10:44:39 PM
    Author     : AdminDEV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <h3 class="header-title">Input information user</h3>

                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-6">
                        <f:form action="edit.htm" method="POST" commandName="c" >
                            <div class="mb-3" hidden="">
                                <label class="form-label">Id</label>
                                <f:input path="id" type="text" cssClass="form-control" placeholder="id" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Name</label>
                                <f:input path="name" type="text"  cssClass="form-control" placeholder="Name" />
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <f:input path="email" type="text"  cssClass="form-control" placeholder="Email" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Age</label>
                                <f:input path="age" type="number"  cssClass="form-control" placeholder="Age" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Village</label>
                                <f:input path="village" type="text"  cssClass="form-control" placeholder="Village" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Date of birth</label>
                                <input name="dob" type="date" value="${dob}" Class="form-control" placeholder="Date of birth" />
                            </div>
                            <div class="mb-3">
                                <label for="idClass" class="form-label">Class</label>
                                <select class="form-select" name="idClass" id="idClass">
                                    <c:forEach items="${data}" var="cc">
                                        <option value="${cc.id}" ${cc.id == c.idClass ? "selected" : ""}>${cc.className}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="mb-3">
                                <div class="form-check">
                                    <f:checkbox path="isActive" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Active (Lock/Unlock)</label>
                                </div>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a href="/FE_ExamApplication/user.htm" class="btn btn-danger">Back</a>
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