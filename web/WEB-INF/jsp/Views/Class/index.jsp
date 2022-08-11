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
                        <h4 class="mt-0 header-title">Default Example</h4>
                        <p class="text-muted font-14 mb-3">
                            <a href="/FE_ExamApplication/class/initInsert.htm" class="btn btn-primary">Add New Record</a>
                        </p>

                        <table id="datatable" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">#</th>
                                    <th scope="col">Class Name</th>
                                    <th scope="col">Note</th>
                                    <th scope="col">Course</th>
                                    <th scope="col">School Year</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Handle</th>
                                </tr>
                            </thead>


                            <tbody>
                                <c:forEach items="${data}" var="c" varStatus="loop">
                                    <tr class="text-center">
                                        <th scope="row">${loop.count}</th>
                                        <td>${c.className}</td>
                                        <td>${c.note}</td>
                                        <td>${c.course}</td>
                                        <td>${c.schoolYear}</td>
                                        <td>${c.status}</td>
                                        <td class="text-center">
                                        <a href="/FE_ExamApplication/class/initEdit.htm?id=${c.id}" class="btn btn-success" style="margin-right: 20px"> Edit </a>
                                        <a href="/FE_ExamApplication/class/delete.htm?id=${c.id}" class="btn btn-danger"> Delete </a>
                                    </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
