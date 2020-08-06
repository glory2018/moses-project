$(function () {
    //上传文件显示名称
    bsCustomFileInput.init();
    $("#purchaseDate").datepicker({dateFormat: 'yymmdd'});
    $("[role='form']").validate();
})
