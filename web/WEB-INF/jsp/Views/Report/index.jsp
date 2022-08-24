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
                        <h4 class="mt-0 header-title">Report Data Table</h4>

                        <table id="datatable" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">#</th>
                                    <th scope="col">Student Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Content</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Handle</th>  
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${data}" var="c" varStatus="loop">
                                    <tr class="text-center">
                                        <th scope="row">${loop.count}</th>
                                        <td>${c.nameUser}</td>
                                        <td>${c.emailUser}</td>
                                        <td>${c.content}</td>
                                        <td>${c.status}</td>
                                        <td class="text-center">
                                        <a href="report/initEdit.htm?id=${c.id}" class="btn btn-success" style="margin-right: 20px"> View Details </a>
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
