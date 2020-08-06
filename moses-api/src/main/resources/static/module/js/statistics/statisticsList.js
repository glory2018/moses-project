$(function () {
    laboratoryNum();
    yearNum();
});

function laboratoryNum() {
    $.get("/statistics/laboratoryNum", function (data) {
        var labelArr = [];
        var dataArr = [];
        var colorArr = ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de', '#62d1de', '#54d6b6', '#a6db69', '#ffd454', '#ffa361', '#d1d1d1'];
        for (j = 0, len = data.length; j < len; j++) {
            labelArr.push(data[j][0]);
            dataArr.push(data[j][1]);
        }
        generatePie(labelArr, dataArr, colorArr);
    });
}

function generatePie(labelArr, dataArr, colorArr) {
    var pieChartCanvas = $('#pieChart').get(0).getContext('2d')
    var pieData = {
        labels: labelArr,
        datasets: [
            {
                data: dataArr,
                backgroundColor: colorArr,
            }
        ]
    }
    var pieOptions = {
        legend: {
            display: false
        }
    }
    var pieChart = new Chart(pieChartCanvas, {
        type: 'doughnut',
        data: pieData,
        options: pieOptions
    })
}

function yearNum() {
    $.get("/statistics/yearNum", function (data) {
        var labelArr = [];
        var dataArr = [];
        for (j = 0, len = data.length; j < len; j++) {
            labelArr.push(data[j][0]);
            dataArr.push(data[j][1]);
        }
        generateChart(labelArr, dataArr);
    });
}

function generateChart(labelArr, dataArr) {
    var ticksStyle = {
        fontColor: '#495057',
        fontStyle: 'bold'
    }
    var mode = 'index'
    var intersect = true
    var $salesChart = $('#sales-chart')
    var salesChart = new Chart($salesChart, {
        type: 'bar',
        data: {
            labels: labelArr,
            datasets: [
                {
                    backgroundColor: '#007bff',
                    borderColor: '#007bff',
                    data: dataArr
                }
            ]
        },
        options: {
            maintainAspectRatio: false,
            tooltips: {
                mode: mode,
                intersect: intersect
            },
            hover: {
                mode: mode,
                intersect: intersect
            },
            legend: {
                display: false
            },
            scales: {
                yAxes: [{
                    // display: false,
                    gridLines: {
                        display: true,
                        lineWidth: '4px',
                        color: 'rgba(0, 0, 0, .2)',
                        zeroLineColor: 'transparent'
                    },
                    ticks: $.extend({
                        beginAtZero: true,
                        // Include a dollar sign in the ticks
                        callback: function (value, index, values) {
                            if (value >= 1000) {
                                value /= 1000
                                value += 'k'
                            }
                            return value
                        }
                    }, ticksStyle)
                }],
                xAxes: [{
                    display: true,
                    gridLines: {
                        display: false
                    },
                    ticks: ticksStyle
                }]
            }
        }
    })
}
