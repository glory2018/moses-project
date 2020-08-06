function statistics() {
    $.post("/statistics/pair", {data: $("#data").val()}, function (result) {
        $("#content").html(result);
    });
}

function reset() {
    $("#data").val("");
    $("#content").val("");
}