<%-- 
    Document   : form
    Created on : Aug 11, 2022, 10:44:39 PM
    Author     : AdminDEV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h3 class="header-title">Input information Question</h3>

                <f:form action="insert.htm" method="POST" commandName="c" onsubmit="return Validate()">
                    <div class="row">
                        <div class="col-lg-6">
                            <h2>Question</h2>
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
                                <label for="note" class="form-label">Note</label>
                                <f:textarea path="note" cssClass="form-control" id="example-textarea" rows="5" />
                            </div>

                            <div class="mb-3">
                                <label for="idSubject" class="form-label">Subject</label>
                                <select class="form-select" name="idSubject" id="idSubject">
                                    <c:forEach items="${subjects}" var="sub">
                                        <option value="${sub.id}">${sub.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label class="header-title mt-5 mt-sm-0">Level Point</label>
                            <c:forEach items="${levels}" var="level">
                                <div class="mb-3">
                                    <input type="radio" id="idLevel" name="idLevel" value="${level.id}" class="form-check-input" checked="true">
                                    <label  class="form-check-label" for="idLevel" >${level.name} (${level.point})</label>
                                </div>
                            </c:forEach>

                            <div class="mb-3">
                                <div class="form-check form-switch">
                                    <f:checkbox path="status" cssClass="form-check-input" />
                                    <label class="form-check-label" for="customCheck1">Status (Show/Hiden)</label>
                                </div>
                            </div>

                            <div class="mb-3">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <a href="/FE_ExamApplication/question.htm" class="btn btn-danger">Back</a>
                            </div>
                        </div> <!-- end col -->
                        <div class="col-lg-6">                        
                            <h2>Answer</h2>
                            <div class="mb-3" >
                                <div class="form-check mb-2 form-check-success">
                                    <label for="note" class="form-label">A</label>
                                    <input class="form-check-input" type="radio" id="customradio10" checked=""  name="isTrue" value="0">
                                    <label class="form-check-label" for="customradio10">is true</label>
                                </div>
                                <textarea id="answer1" name="answer" class="form-control" id="example-textarea" rows="4"></textarea>
                                <p id="erranswer1" class="error" value=""></p>
                            </div>
                            <div class="mb-3" >
                                <div class="form-check mb-2 form-check-success">
                                    <label for="note" class="form-label">B</label>
                                    <input class="form-check-input" type="radio" id="customradio10"   name="isTrue" value="1">
                                    <label class="form-check-label" for="customradio10">is true</label>
                                </div>
                                <textarea id="answer2" name="answer" class="form-control" id="example-textarea" rows="4"></textarea>
                                <p id="erranswer2" class="error" value=""></p>
                            </div>
                            <div class="mb-3" >
                                <div class="form-check mb-2 form-check-success">
                                    <label for="note" class="form-label">C</label>
                                    <input class="form-check-input" type="radio" id="customradio10"  name="isTrue" value="2">
                                    <label class="form-check-label" for="customradio10">is true</label>
                                </div>
                                <textarea id="answer3" name="answer" class="form-control" id="example-textarea" rows="4"></textarea>
                                <p id="erranswer3" class="error" value=""></p>
                            </div>
                            <div class="mb-3" >
                                <div class="form-check mb-2 form-check-success">
                                    <label for="note" class="form-label">D</label>
                                    <input class="form-check-input" type="radio" id="customradio10" name="isTrue" value="3">
                                    <label class="form-check-label" for="customradio10">is true</label>
                                </div>
                                <textarea id="answer4" name="answer" class="form-control" id="example-textarea" rows="4"></textarea>
                                <p id="erranswer4" class="error" value=""></p>
                            </div>

                        </div> <!-- end col -->

                    </div>
                    <!-- end row-->
                </f:form>


            </div> <!-- end card-body -->
        </div> <!-- end card -->
    </div><!-- end col -->
</div>
<script>
    function Validate() {
        var name = $('#name').val();
        var answer1 = $('#answer1').val();
        var answer2 = $('#answer2').val();
        var answer3 = $('#answer3').val();
        var answer4 = $('#answer4').val();
        if (name == '') {
            $('#errname').html('Name is not null!');
            return false
        } else {
            $('#errname').html('');
        }
        if (answer1 == '') {
            $('#erranswer1').html('Answer is not null!');
            return false
        } else {
            $('#erranswer1').html('');
        }
        if (answer2 == '') {
            $('#erranswer2').html('Answer is not null!');
            return false
        } else {
            $('#erranswer2').html('');
        }
        if (answer3 == '') {
            $('#erranswer3').html('Answer is not null!');
            return false
        } else {
            $('#erranswer3').html('');
        }
        if (answer4 == '') {
            $('#erranswer4').html('Answer is not null!');
            return false
        } else {
            $('#erranswer4').html('');
        }
        return true;
    }
</script>