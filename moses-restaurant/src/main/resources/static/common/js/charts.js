var colorList = ['#ff7f50', '#87cefa', '#da70d6', '#32cd32', '#6495ed',
    '#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0',
    '#1e90ff', '#ff6347', '#7b68ee', '#00fa9a', '#ffd700',
    '#6699FF', '#ff6666', '#3cb371', '#b8860b', '#30e0e0'];

function setPieChart(id, title, name, category, data, dicyclo) {
    option = {
        title: {
            text: title,
            x: 'center'
        },
        color: colorList,
        tooltip: {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            show: false,
            data: category
        },
        toolbox: {
            show: false,
            feature: {
                mark: {
                    show: true
                },
                dataView: {
                    show: true,
                    readOnly: false
                },
                magicType: {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore: {
                    show: true
                },
                saveAsImage: {
                    show: true
                }
            }
        },
        calculable: true,
        series: getSeries(name, data, dicyclo)
    };
    // var myChart = echarts.init(document.getElementById(id), 'macarons');
    var myChart = echarts.init(document.getElementById(id));
    myChart.setOption(option);
}

function getSeries(name, data, dicyclo) {
    var series = [];
    if (dicyclo) {
        series = [
            {
                name: name,
                type: 'pie',
                radius: ['50%', '70%'],
                itemStyle: {
                    normal: {
                        label: {
                            show: false
                        },
                        labelLine: {
                            show: false
                        }
                    },
                    emphasis: {
                        label: {
                            show: true,
                            position: 'center',
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    }
                },
                data: data
            }
        ]
    } else {
        series = [{
            name: name,
            type: 'pie',
            radius: '35%',
            center: ['50%', '60%'],
            data: data
        }
        ]
    }
    return series;
}

function setColumnLineChart(id, legend, category, yAxis, name1, name2, name3, data1, data2, data3) {
    var option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: legend
        },
        xAxis: [
            {
                type: 'category',
                data: category
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: yAxis,
//				min : 0,
//				max : 250,
                interval: 50,
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
            {
                name: name1,
                type: 'bar',
                /*itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#fe6262'},
                                {offset: 0.5, color: '#fe4141'},
                                {offset: 1, color: '#fe1818'}
                            ]
                        ),
                    },
                    emphasis: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#fe6262'},
                                {offset: 0.5, color: '#fe4141'},
                                {offset: 1, color: '#fe1818'}
                            ]
                        )
                    }
                },*/

                /*设置柱状图颜色*/
                itemStyle: {
                    normal: {
                        color: function (params) {
                            // build a color map as your need.
                            return colorList[params.dataIndex]
                        },
                        /*信息显示方式*/
                        label: {
                            show: true,
                            position: 'top',
                            formatter: '{b}\n{c}'
                        }
                    }
                },
                data: data1
            },
            {
                name: name2,
                type: 'line',
                itemStyle: {
                    /*设置折线颜色*/
                    normal: {
                        /* color:'#c4cddc'*/
                    }
                },
                data: data2
            },
            {
                name: name3,
                type: 'line',
                itemStyle: {
                    /*设置折线颜色*/
                    normal: {
                        /* color:'#c4cddc'*/
                    }
                },
                data: data3
            }
        ]
    };
    // var myChart = echarts.init(document.getElementById(id), 'macarons');
    var myChart = echarts.init(document.getElementById(id));
    myChart.setOption(option);
}
