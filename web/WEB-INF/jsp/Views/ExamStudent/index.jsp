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
                        <h4 class="mt-0 header-title">Student Exam</h4>
                        <p class="text-muted font-14 mb-3">
                            <a href="class/initInsert.htm" class="btn btn-success">Finish</a>
                        </p>
                        <h4 class="header-title mb-4">Exam in progress. Good Luck!</h4>
                        <h4 style="color: red" class="mb-4">Time: 15p45s</h4>

                        <div class="row">
                            <div class="col-sm-3">
                                <div class="nav flex-column nav-pills nav-pills-tab" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                                    <a class="nav-link active show mb-1" id="v-pills-home-tab" data-bs-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1"
                                       aria-selected="true">
                                        Cau 1</a>
                                    <a class="nav-link mb-1" id="v-pills-profile-tab" data-bs-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2"
                                       aria-selected="false">
                                        Cau 2</a>
                                    <a class="nav-link mb-1" id="v-pills-messages-tab" data-bs-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3"
                                       aria-selected="false">
                                        Cau 3</a>
                                    <a class="nav-link mb-1" id="v-pills-settings-tab" data-bs-toggle="pill" href="#v-pills-4" role="tab" aria-controls="v-pills-4"
                                       aria-selected="false">
                                        Cau 4</a>
                                </div>
                            </div> <!-- end col-->
                            <div class="col-sm-9">
                                <div class="tab-content pt-2">
                                    <div class="tab-pane fade active show" id="v-pills-1" role="tabpanel" aria-labelledby="v-pills-home-tab">
                                        <div class="form-check mb-2 form-check-success">
                                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="customradio2">
                                            <label class="form-check-label" for="customradio2">Success</label>
                                        </div>  
                                        <div class="form-check mb-2 form-check-success">
                                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="customradio2">
                                            <label class="form-check-label" for="customradio2">Success</label>
                                        </div>
                                        <div class="form-check mb-2 form-check-success">
                                            <input class="form-check-input" type="radio" name="flexRadioDefault" id="customradio2">
                                            <label class="form-check-label" for="customradio2">Success</label>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                                        <p>Culpa dolor voluptate do laboris laboris irure reprehenderit id incididunt duis pariatur mollit aute magna
                                            pariatur consectetur. Eu veniam duis non ut dolor deserunt commodo et minim in quis laboris ipsum velit
                                            id veniam. Quis ut consectetur adipisicing officia excepteur non sit. Ut et elit aliquip labore Lorem
                                            enim eu. Ullamco mollit occaecat dolore ipsum id officia mollit qui esse anim eiusmod do sint minim consectetur
                                            qui.</p>
                                    </div>
                                    <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                                        <p>Fugiat id quis dolor culpa eiusmod anim velit excepteur proident dolor aute qui magna. Ad proident laboris
                                            ullamco esse anim Lorem Lorem veniam quis Lorem irure occaecat velit nostrud magna nulla. Velit et et
                                            proident Lorem do ea tempor officia dolor. Reprehenderit Lorem aliquip labore est magna commodo est ea
                                            veniam consectetur.</p>
                                    </div>
                                    <div class="tab-pane fade" id="v-pills-4" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                                        <p>Eu dolore ea ullamco dolore Lorem id cupidatat excepteur reprehenderit consectetur elit id dolor proident
                                            in cupidatat officia. Voluptate excepteur commodo labore nisi cillum duis aliqua do. Aliqua amet qui
                                            mollit consectetur nulla mollit velit aliqua veniam nisi id do Lorem deserunt amet. Culpa ullamco sit
                                            adipisicing labore officia magna elit nisi in aute tempor commodo eiusmod.</p>
                                    </div>
                                </div>
                            </div> <!-- end col-->
                        </div> <!-- end row-->
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
