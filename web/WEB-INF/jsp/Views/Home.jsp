<%-- 
    Document   : Home
    Created on : Aug 4, 2022, 9:43:12 PM
    Author     : AdminDEV
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <a href="addClass.htm">INSERT</a>
        </div>
        <table class="table">
            <thead>
                <tr>
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
                    <tr>
                        <th scope="row">${loop.count}</th>
                        <td>${c.className}</td>
                        <td>${c.note}</td>
                        <td>${c.course}</td>
                        <td>${c.schoolYear}</td>
                        <td>${c.status}</td>
                        <td>
                            <a href="editClass.htm">EDIT</a>
                            <a href="deleteClass.htm">DELETE</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
