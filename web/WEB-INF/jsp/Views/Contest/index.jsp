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
                    <div class="card-body"m pha
                         <h4 class="mt-0 header-title">Contest Data</h4>
                        <p class="text-muted font-14 mb-3">
                            <a href="contest/initInsert.htm" class="btn btn-primary">Add New Contest</a>
                        </p>

                        <table id="datatable" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">#</th>
                                    <th scope="col">Contest Name</th>
                                    <th scope="col">Test Date</th>
                                    <th scope="col">Test Time</th>
                                    <th scope="col">Subject</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Handle</th>
                                </tr>
                            </thead>


                            <tbody>
                                <c:forEach items="${data}" var="c" varStatus="loop">
                                    <tr class="text-center">
                                        <th scope="row">${loop.count}</th>
                                        <td>${c.className}</td>
                                        <td>
                                          <fmt:parseDate value="${c.testDate}" pattern="yyyy-MM-dd HH:mm" var="myDate"/>
                                         <fmt:formatDate value="${myDate}" pattern="dd-MM-yyyy"/>
                                    </td>
                                    <td>${c.testTime}</td>
                                   <td>${c.subjectName}</td>
                                    <td>
                                      ${c.status ? 'Show' : 'Hidden'}
                                   </td>
                                <td class="text-center">
                                    <a href="contest/detail.htm?id=${c.id}" class="btn btn-primary" style="margin-right: 20px"> Details </a>
                                    <a href="contest/initEdit.htm?id=${c.id}" class="btn btn-success" style="margin-right: 20px"> Edit </a>
                                    <a href="contest/remove.htm?id=${c.id}" class="btn btn-danger" onclick="return confirm('Are you sure?');"> Delete </a>
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
