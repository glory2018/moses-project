$(function () {
    //上传文件显示名称
    bsCustomFileInput.init();
});
// function statistics() {
//     $.post("/statistics/continued", {group: $("#group").val(), data: $("#data").val()}, function (result) {
//         $("#status").html(result.status);
//         $("#content").html(result.statusMap);
//     });
// }

function reset() {
    $("#group").val("");
    $("#data").val("");
    $("#status").val("");
    $("#content").val("");
}
