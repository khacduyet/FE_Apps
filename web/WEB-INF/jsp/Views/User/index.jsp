<%-- 
    Document   : Home
    Created on : Aug 4, 2022, 9:43:12 PM
    Author     : AdminDEV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <a href="/FE_ExamApplication/user/initInsert.htm" class="btn btn-primary">Add New Record</a>
                        </p>

                        <table id="datatable" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">#</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Age</th>
                                    <th scope="col">Village</th>
                                    <th scope="col">Date of birth</th>
                                    <th scope="col">Active</th>
                                    <th scope="col">Handle</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${data}" var="c" varStatus="loop">
                                    <tr class="text-center">
                                        <th scope="row">${loop.count}</th>
                                        <td>${c.username}</td>
                                        <td>${c.name}</td>
                                        <td>${c.email}</td>
                                        <td>${c.age}</td>
                                        <td>${c.village}</td>

                                        <td>
                                            <fmt:parseDate value="${c.dob}" pattern="yyyy-MM-dd HH:mm" var="myDate"/>
                                            <fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"/>
                                        </td>

                                        <td>
                                            ${c.isActive ? 'Show' : 'Hidden'}
                                        </td>
                                        <td class="text-center">
                                            <button type="button" class="btn btn-info _assign" data-bs-toggle="modal" data-bs-target="#login-modal" data-id="${c.id}">Assign Role</button>
                                            <a href="/FE_ExamApplication/user/initEdit.htm?id=${c.id}" class="btn btn-success" style="margin-right: 20px"> Edit </a>
                                            <a href="/FE_ExamApplication/user/remove.htm?id=${c.id}" class="btn btn-danger" onclick="return confirm('Are you sure?');"> Delete </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
        <div id="login-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="text-center mt-2 mb-4">
                            <div class="auth-logo">
                                <div class="logo logo-light">
                                    <span class="logo-lg">
                                        <img src="assets/images/logo-light.png" alt="" height="22">
                                    </span>
                                </div>

                                <div class="logo logo-dark">
                                    <span class="logo-lg">
                                        <img src="assets/images/logo-dark.png" alt="" height="22">
                                    </span>
                                </div>
                            </div>
                        </div>

                        <form action="user/assign_role.htm" class="px-3" method="POST">
                            <h2>ASSIGN PERMISSION</h2>
                            <div class="mb-3">
                                <input name="idUser" value="" type="hidden" id="_id"/>
                            </div>
                            <div class="mb-3">
                                <select class="form-select" name="idRole" id="_role">

                                </select>
                            </div>
                            <div class="mb-2 text-center">
                                <button class="btn rounded-pill btn-primary" type="submit">Submit</button>
                            </div>

                        </form>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
