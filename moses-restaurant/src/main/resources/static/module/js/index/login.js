$(function () {

});

function login() {
    var param = {
        username: $("#username").val(),
        password: $("#password").val()
    }
    $.post("/user/findUser", param, function (data) {
        if (data.flag) {
            location.href = "/main/index";
        } else {
            $("#errorMsg").html(data.flag);
        }
    });
}

function checkLogin() {
    var name = $("#username").val().toLowerCase();
    var pwd = $("#password").val().toLowerCase();
    if (name.trim() == "" || pwd.trim() == "") {
        $("#message").text("请输入用户名和密码");
        $('.msg').show();
        return false;
    } else {
        $('.msg').hide();
    }

    var md5info = name + pwd;
    $('#hidePwd').val(md5(md5info));
    //$("#password").val();
    return true;
}