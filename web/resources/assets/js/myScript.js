function Total() {
    var val1 = [];
    $('select[name="questions"] option:selected').each(function () {
        val1.push($(this).data("point"));
    });
    var total = 0;
    $.each(val1, function (index, value) {
        total = total + parseFloat(value);
    });
    $("#totalPoint").val(total);
}
;
Total();
$("#my_multi_select2").change(Total);
function GetExam() {
    var idExam = $("#idExamInput").val();
    var id = $("#idSubject").val();
    var auth = getCookie("authorization");
    var url = "http://localhost:8080/ExamApplication/api/exam/subject_exam/" + id;
    fetch(url, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'text/plain',
            'Authorization': auth
        }
    }).then(function (res) {
        return res.json();
    }).then(function (x) {
        var str = "<option value='0' >Choose exam ..</option>";
        $.each(x.data, function (index, data) {
            str += "<option value='" + data.id + "' " + ((idExam == data.id) ? "selected" : "") +">" + data.content + "</option>";
        });
        $("#idExam").html(str);
    });
}
;
GetExam();
$("#idSubject").change(GetExam);

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}