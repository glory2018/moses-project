function pageRequest(pageNum) {
    var url = '/customer/list';
    var params = {
        currentState: $("#currentState").val(),
        customerLevel: $("#customerLevel").val(),
        pageNum: pageNum,
        pageSize: 10
    };
    $.post(url, params, function (data) {
        $("#table_list").html(data);
    });
}
