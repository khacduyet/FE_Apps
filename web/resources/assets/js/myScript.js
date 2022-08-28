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
            str += "<option value='" + data.id + "' " + ((idExam == data.id) ? "selected" : "") + ">" + data.content + "</option>";
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



// Timer
$("#exam_show_time").click(setTimer);

function setTimer() {
    var minute = $("#timer_contest").val() - 1;
    var second = 60;
    var x = setInterval(function () {
        second -= 1;
        if (minute == 0 && second == 0) {
            clearInterval(x);
            $("#submit_exam").submit();
        } else {
            var str_minute = "";
            var str_second = "";
            if (str_minute < 10) {
                str_minute += "0" + minute;
            } else {
                str_minute += minute;
            }
            if (second < 10) {
                str_second += "0" + second;
            } else {
                str_second += second;
            }
            var timer = minute + ":" + str_second;
            $("#timer_exam").text(timer);
            if (second == 0) {
                second = 60;
                if (minute > 0) {
                    minute -= 1;
                    $("#timeLost").val(minute);
                }
            }
        }
    }, 1000);

}
setTimer();

$("._assign").click(function () {
    var id = $(this).data("id");
    var auth = getCookie("authorization");
    var url = "http://localhost:8080/ExamApplication/api/role/user_role/" + id;
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
        $("#_id").val(id);
        var str = "";
        $.each(x.data, function (index, data) {
            str += "<option value='" + data.id + "' " + ((data.isValid) ? "selected" : "") + ">" + data.name + " - " + data.code + "</option>";
        });
        $("#_role").html(str);
    });
});