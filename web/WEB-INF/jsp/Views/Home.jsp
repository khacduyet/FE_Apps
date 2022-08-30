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
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h2 class="mt-0 header-title" style="text-transform: uppercase;">Statistical chart</h2>

                        <h4>
                            <div class="row">
                                <div class="col-md-8">
                                    Contest
                                </div>
                                <div class="col-md-4">
                                    <select class="form-select" id="_class_chart">
                                        
                                    </select>
                                </div>
                            </div>
                        </h4>
                        <table id="datatable1" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">
                                        #
                                    </th>
                                    <th scope="col">Passed</th>
                                    <th scope="col">Failed</th>
                                    <th scope="col">Test rate</th>
                                    <th scope="col">Total</th>
                                </tr>
                            </thead>
                            <tbody id="_contest_chart">
                                <tr>
                                    <td><b>Contest</b></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                        <hr/>
                        <h4>
                            <div class="row">
                                <div class="col-md-8">
                                    Result
                                </div>
                                <div class="col-md-4">
                                    <select class="form-select" id="_subject_chart">
                                        
                                    </select>
                                </div>
                            </div>
                        </h4>
                        <table id="datatable2" class="table table-bordered dt-responsive table-responsive nowrap">
                            <thead>
                                <tr class="text-center">
                                    <th scope="col">
                                        #
                                    </th>
                                    <th scope="col">Weak</th>
                                    <th scope="col">Medium</th>
                                    <th scope="col">Above average</th>
                                    <th scope="col">Good</th>
                                    <th scope="col">Total</th>
                                </tr>
                            </thead>
                            <tbody id="_result_chart">
                                <tr >
                                    <td><b>Number of students passing</b></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
