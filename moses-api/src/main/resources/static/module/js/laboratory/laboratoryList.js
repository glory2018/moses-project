function pageRequest(pageNum) {
    var url = '/laboratory/list';
    var params = {
        pageNum: pageNum,
        pageSize: 10
    };
    $.post(url, params, function (data) {
        $("#table_list").html(data);
    });
}
