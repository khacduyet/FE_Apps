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
                <h3 class="header-title">Input information level point</h3>

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
                                <p id="errname" class="error" value=""></p>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Point</label>
                                <f:input id="point" path="point" type="number" step="0.5"  cssClass="form-control" placeholder="Point" />
                                 <p id="errpoint" class="error" value=""></p>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Note</label>
                                <f:input path="note" type="text"  cssClass="form-control" placeholder="Note" />
                            </div>

                            <div class="mb-3">
                                <div class="form-check">
                                    <f:checkbox path="status" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Status (Show/Hiden)</label>
                                </div>
                            </div>
                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a href="/FE_ExamApplication/level-point.htm" class="btn btn-danger">Back</a>
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
        var point = $('#point').val();
        if (name == '') {
            $('#errname').html('Name is not null!');
            return false
        } else {
            $('#errname').html('');
        }
        if (point == '') {
            $('#errpoint').html('Point is not null!');
            return false
        } else {
            $('#errpoint').html('');
        }
        return true;
    }
</script>