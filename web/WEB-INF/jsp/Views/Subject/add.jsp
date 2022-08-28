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
                <h3 class="header-title">Input information subject</h3>

                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-6">
                        <f:form action="insert.htm" method="POST" commandName="c" onsubmit="return Validate()">
                            <div class="mb-3" hidden="">
                                <label class="form-label">Id</label>
                                <f:input path="id" type="text" cssClass="form-control" placeholder="id" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Name</label>
                                <f:input id="name" path="name" type="text"  cssClass="form-control" placeholder="Name" />
                                <label id="errname" class="error" value=""></label>
                            </div>

                            <div class="mb-3">
                                <label for="note" class="form-label">Note</label>
                                <f:textarea id="note" path="note" cssClass="form-control" id="example-textarea" rows="5" />
                            </div>

                            <div class="mb-3">
                                <div class="form-check">
                                    <f:checkbox path="status" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Status (Show/Hiden)</label>
                                </div>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a href="/FE_ExamApplication/subject.htm" class="btn btn-danger">Back</a>
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
        var name = $('#name').val();
        if (name == '') {
            $('#errname').html('Name is not null!');
            return false
        } else {
            $('#errname').html('');
        }
        return true;
    }
</script>