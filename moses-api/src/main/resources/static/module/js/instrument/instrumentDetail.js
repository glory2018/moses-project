$(function () {
    // $(".btn").click(function () {
    //     $("#mymodal").modal();
    // });
});

function openPhoto(fileName) {
    $("#photoId").attr('src', "/file/show?fileName=" + fileName);
    $("#mymodal").modal();
}
