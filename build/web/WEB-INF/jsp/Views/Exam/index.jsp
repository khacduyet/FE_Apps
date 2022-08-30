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
                        <h4 class="mt-0 header-title">Table List Exam</h4>
                        <div class="btn-group mb-2">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Add New Exam <i class="mdi mdi-chevron-down"></i></button>
                            <div class="dropdown-menu">
                                <c:forEach items="${subjects}" var="s">
                                    <a class="dropdown-item" href="exam/initInsert.htm?idSub=${s.id}">${s.name}</a>
                                </c:forEach>
                            </div>
                        </div>

                        <table id="datatable" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">#</th>
                                    <th scope="col">Content</th>
                                    <th scope="col">Note</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Handle</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${data}" var="c" varStatus="loop">
                                    <tr class="text-center">
                                        <th scope="row">${loop.count}</th>
                                        <td>${c.content}</td>
                                        <td>${c.note}</td>
                                        <td>
                                            ${c.status ? 'Show' : 'Hidden'}
                                        </td>
                                        <td class="text-center">
                                            <a href="exam/detais.htm?id=${c.id}" class="btn btn-primary" style="margin-right: 20px"> Show Details </a>
                                            <a href="exam/initEdit.htm?id=${c.id}" class="btn btn-success" style="margin-right: 20px"> Edit </a>
                                            <a href="exam/remove.htm?id=${c.id}" class="btn btn-danger" onclick="return confirm('Are you sure?');"> Delete </a>
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
