$(function () {
    $("#register_form").validate({
        rules: {
            userName: {
                required: true,
                rangelength: [1, 20]
            },
            password: {
                required: true,
                rangelength: [1, 20]
            },
            repassword: {
                equalTo: "#password"
            },
            code: {
                required: true,
                remote: {
                    url: "/verificationCode",
                    type: "get",
                    data: {
                        code: $("#code").val()
                    }
                }
            },
        },
        messages: {
            userName: {
                required: '必填'
            },
            password: {
                required: '必填',
                minlength: '最少1个字符'
            },
            repassword: {
                required: '必填',
                minlength: '最少1个字符',
                equalTo: '两次输入的密码不一样'
            },
            code: {
                required: '必填',
                remote: '验证码不正确'
            },
        },
    });
});
// function checkLength(id) {
//     var reg = /^\w{1,20}$/;
//     var flag = reg.test($("#" + id).val());
//     warning(flag, id);
//     return flag;
// }
//
// function warning(flag, id) {
//     if (flag) {
//         $("#" + id).css("border", "");
//     } else {
//         $("#" + id).css("border", "1px solid red");
//     }
// }
//
// function confirmPassword() {
//     var password = $("#password").val();
//     var password2 = $("#password2").val();
//     var flag = (password == password2);
//     warning(flag, "password2");
//     return flag;
// }
// 校验验证码
// function verificationCode() {
//     $.get("/verificationCode", {code: $("#code").val()}, function (data) {
//         warning(data, "code");
//         return data;
//     });
// }
// function save() {
//     // return checkLength("userName") && checkLength("password") && confirmPassword() && verificationCode();
// }
//获取验证码
// function getVerify(obj) {
//     obj.src = "/getVerify?" + Math.random();
// }