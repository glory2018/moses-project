var http = "http://10.8.154.47:8009";

function excludeEmpty(obj) {
    var res = '';
    if (obj != null) {
        res = obj;
    }
    return res;
}

function post(url, params, callback) {
    // $.post(url, params, function (data) {
    //     if (data != null && data != '' && data != 'failtrue') {
    //         var obj = eval('(' + data + ')');
    //         if (obj.status == 'SUCCESS') {
    //             var list = obj.responseBody.dataList;
    //             callback(list);
    //         }
    //     } else {
    //         alert("没有数据");
    //     }
    // });
    $.ajax({
        type: "POST",
        url: url,
        //必须
        contentType: "application/json",
        //表示返回值类型，非必须
        dataType: "json",
        data: JSON.stringify(params),
        success: function (data) {
            // if (data != null && data != '' && data != 'failtrue') {
            //     if (data.status == 'SUCCESS') {
            //         var list = data.responseBody.dataList;
            //         callback(list);
            //     }
            // } else {
            //     alert("没有数据");
            // }
            callback(data);
        }
    });
}

function initHeader(isMain) {
    var back = "back.png";
    if (isMain) {
        back = "set.png";
    }
    var html = '<ul class="list-inline">'
        + '<li style="width: 10%;"><img src="../img/main/' + back + '" width="30"/></li>'
        + '<li style="width: 80%;">  <p class="text-center">ALL IN ONE</p></li>'
        + '<li style="width: 10%;"><img src="../img/common/account.png"/></li>'
        + '</ul>';
    $("#headerId").html(html);
}

var menu_bottoms = ["main", "square", "book", "my"];

function initBottom(index) {
    var img;
    var prefix = '<div class="col-md-3 col-sm-3 col-xs-3" align="center"><li><a href="';
    var suffix = '</a></li></div>';
    var html = '<nav class="navbar navbar-fixed-bottom" style="background-color: white;">              '
        + '	<div class="container" align="center" style="border: 1px solid #ddd;">                             '
        + '		<ul class="nav nav-tabs nav-tabs-justified" style="line-height:60px;">                   '
        + '			<div class="row" align="center">                           ';
    for (var i = 0; i < 4; i++) {
        img = menu_bottoms[i];
        if (index == i) {
            img = img + "2";
        }
        html = html + prefix + '/' + menu_bottoms[i] + '/index">' + getImg(img) + suffix;
    }
    $("#bottomId").html(html + '</ul></div></nav>');
}

function getImg(name) {
    return '<img src="/img/common/' + name + '.jpg">';
}

function getParams() {
    var shopId = $("#shopId").val();
    var customerType = $("#customerType").val();
    var startTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    var startDate = $("#startDate").val();
    var endDate = $("#endDate").val();
    var page = $("#page").val();
    var pageSize = $("#pageSize").val();
    var init = $("#init").val();
    var params = {
        shopId: shopId,
        customerType: customerType,
        startTime: startTime,
        endTime: endTime,
        startDate: startDate,
        endDate: endDate,
        page: page,
        pageSize: pageSize,
        init: init
    };
    return params;
}

function initScroll(imgPath, num, links, names) {
    var html = '<ul class="nav nav-tabs nav-stacked" data-offset-top="125">';
    var prefix = '<li class="accordion" ><a href="/';
    var suffix = '</a></li>';
    var active = ['grey1', 'grey1', 'grey1', 'grey1', 'grey1', 'grey1'];
    active[num] = 'yellow2';
    var img = 1;
    for (var i = 0; i < links.length; i++) {
        if (num == i) {
            img = 2;
        } else {
            img = 1;
        }
        html = html + prefix + '' + links[i] + '/index" class="' + active[i] + '"><img src="' + imgPath + links[i] + img + '.png" class="img_right"> ' + names[i] + suffix;
    }
    alert(html + '</ul>');
    $("#myScrollspy").append(html + '</ul>');
}


function to(url) {
    $(location).attr('href', url);
}


function changeTab(id) {
    defaultTab(tabs);
    $("#" + id + "Id").css("background-color", "#D0021B");
    $("#" + id + "Id").css("color", "white");
    $("#" + id + "Tab").show();
}

function defaultTab(tabs) {
    var id;
    for (var i = 0; i < tabs.length; i++) {
        id = tabs[i];
        $("#" + id + "Tab").hide();
        $("#" + id + "Id").css("background-color", "white");
        $("#" + id + "Id").css("color", "black");
    }
}

function getStyle(i) {
    var style = "background-color:#f4f4f4;";
    if (i % 2 == 0) {
        style = "background-color:#ffffff;";
    }
    return style;
}
