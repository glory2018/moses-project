function pageRequest(pageNum) {
    var url = '/instrument/list';
    var params = {
        instrumentCode:$("#instrumentCode").val(),
        instrumentName:$("#instrumentName").val(),
        pageNum: pageNum,
        pageSize: 10
    };
    $.post(url, params, function (data) {
        $("#table_list").html(data);
    });
}
