/**
 * Created by meng on 2017/5/18.
 */
$(function () {
    var charts = $('.chart');
    charts.css({
        'height':charts.width()*0.6
    });
    var myChart1 = echarts.init(charts[0]);
    var myChart2 = echarts.init(charts[1]);
    var myChart3 = echarts.init(charts[2]);

    // 指定图表的配置项和数据
    var option1 = {
        color: ['#D8361B'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:['评价次数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : ['参与单位1', '参与单位2', '参与单位3', '参与单位4', '参与单位5', '参与单位6', '参与单位7','参与单位8','参与单位9','参与单位10'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                // axisLabel: {
                //     formatter: '{value}%'
                // },
            }
        ],
        series : [
            {
                name:'评价次数',
                type:'bar',
                barWidth: '60%',
                data:getRandomData(300,1000,10),
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
            }
        ]
    };
    var option2 = {
        color: ['#FF7F50'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:['好评率']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : ['参与单位1', '参与单位2', '参与单位3', '参与单位4', '参与单位5', '参与单位6', '参与单位7','参与单位8','参与单位9','参与单位10'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel: {
                    formatter: '{value}%'
                },
            }
        ],
        series : [
            {
                name:'好评率',
                type:'bar',
                barWidth: '60%',
                data:getRandomData(70,100,10),
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                }
            }
        ]
    };
    var option3 = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:['服务质量','服务态度','办事效率','业务素养','廉洁从政']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : ['参与单位1', '参与单位2', '参与单位3', '参与单位4', '参与单位5', '参与单位6', '参与单位7','参与单位8','参与单位9','参与单位10'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel: {
                    formatter: '{value}%'
                },
            }
        ],
        series : [
            {
                name:'服务质量',
                type:'bar',
                data:getRandomData(70,100,10)
            },
            {
                name:'服务态度',
                type:'bar',
                data:getRandomData(70,100,10)
            },
            {
                name:'办事效率',
                type:'bar',
                data:getRandomData(70,100,10)
            },
            {
                name:'业务素养',
                type:'bar',
                data:getRandomData(70,100,10)
            },
            {
                name:'廉洁从政',
                type:'bar',
                data:getRandomData(70,100,10)
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
    myChart2.setOption(option2);
    myChart3.setOption(option3);


    

    sideBar();

    var data = getRandomRankData(60,100,10);
    var newData = {
        count:[],
        zhiliang:[],
        taidu:[],
        xiaolv:[],
        suyang:[],
        lianjie:[]
    };
    for (var i = 0; i < data.length; i++) {
        newData['count'].push({
            id:data[i].id,
            name:data[i].name,
            type:'count',
            value:data[i].count
        });
        newData['zhiliang'].push({
            id:data[i].id,
            name:data[i].name,
            type:'zhiliang',
            value:data[i].zhiliang
        });
        newData['taidu'].push({
            id:data[i].id,
            name:data[i].name,
            type:'taidu',
            value:data[i].taidu
        });
        newData['xiaolv'].push({
            id:data[i].id,
            name:data[i].name,
            type:'xiaolv',
            value:data[i].xiaolv
        });
        newData['suyang'].push({
            id:data[i].id,
            name:data[i].name,
            type:'suyang',
            value:data[i].suyang
        });
        newData['lianjie'].push({
            id:data[i].id,
            name:data[i].name,
            type:'lianjie',
            value:data[i].lianjie
        });
    }
    render(newData);
    var rankSwiper = new Swiper('.swiper-container', {
        autoplay: 5000,//可选选项，自动滑动
        pagination : '.swiper-pagination',
        prevButton:'.swiper-button-prev',
        nextButton:'.swiper-button-next',
    });

    function render(newData) {
        var tbody = '';
        for (var key in newData) {
            if(key == 'count'){
                var html = template('sortrank-count',{
                    data:sortRank('value',newData[key])
                });
                tbody = '.rank .rank-table .rank-table-count tbody';
                $(tbody).append(html);
                $(tbody).find('tr').each(function (i,e) {
                    if(i%2 !=0){
                        $(e).css({
                            'backgroundColor':'#f0f0f0'
                        })
                    }
                })
            }else{
                var html = template('sortrank-type',{
                    data:sortRank('value',newData[key])
                });
                tbody = '.rank .rank-table .rank-table-'+key+' tbody';
                $(tbody).append(html);
                $(tbody).find('tr').each(function (i,e) {
                    if(i%2 !=0){
                        $(e).css({
                            'backgroundColor':'#f0f0f0'
                        })
                    }
                })
            }
        }
    }
    function getRandomData(min,max,index) {
        var data = [];
        for (var i = 0; i < index; i++) {
            data.push(Math.floor(Math.random()*(max-min+1)+min))
        }
        return data;
    }
    function getRandomRankData(min,max,index) {
        var data = [];
        for (var i = 0; i < index; i++) {
            data.push(
                {
                    id:i+1,
                    name:'单位名称'+(i+1),
                    count:Math.floor(Math.random()*(20000-1000+1)+1000),
                    zhiliang:Math.floor(Math.random()*(max-min+1)+min),
                    taidu:Math.floor(Math.random()*(max-min+1)+min),
                    xiaolv:Math.floor(Math.random()*(max-min+1)+min),
                    suyang:Math.floor(Math.random()*(max-min+1)+min),
                    lianjie:Math.floor(Math.random()*(max-min+1)+min)
                }
            )
        }
        return data;
    }
    function sortRank(odds,data) {
        var newData = data.sort(function (a,b) {
            return b[odds] - a[odds]
        })
        return newData
    }
})