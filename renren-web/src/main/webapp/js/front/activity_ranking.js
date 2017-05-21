/**
 * Created by meng on 2017/5/15.
 */
$(function () {
	var commentTopTen_title = [];  
    var commentTopTen_data = [];  
    
    var highRateTopTen_title = [];  
    var highRateTopTen_data = [];  
    
	 // 同步执行  
    $.ajaxSettings.async = false;  
      
    var id = $('#id').val();
    // 加载数据  
    $.getJSON(ctx+'/commentTopTen.html?id='+id, function (json) {  
    	json=JSON.parse(json)
        commentTopTen_title = json.commentTopTen_title;  
    	commentTopTen_data = json.commentTopTen_data;  
    });  
    
    // 加载数据  
    $.getJSON(ctx+'/highRateTopTen.html?id='+id, function (json) {  
    	json=JSON.parse(json)
    	highRateTopTen_title = json.highRateTopTen_title;  
    	highRateTopTen_data = json.highRateTopTen_data;  
    });  
    
    var legend_name=[];
    var depart_name=[];
    var paramResult;
    // 加载数据  
    $.getJSON(ctx+'/queryCommentResultDetail.html?id='+id, function (json) {  
    	json=JSON.parse(json)
    	legend_name=json.legend;
    	depart_name=json.departLst;
    	paramResult=json.result;
    });  
    
    var charts = $('.chart');
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
                data : commentTopTen_title,
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
                name:'评价次数',
                type:'bar',
                barWidth: '60%',
                data:commentTopTen_data,
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
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
                data : highRateTopTen_title,
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
//                barWidth: '60%',
                data:highRateTopTen_data,
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
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
            data:legend_name
//        data:['服务质量','服务态度','办事效率','业务素养']
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
                data : depart_name,
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
        ]
    };

    $.each(paramResult,function(key,values){     

    	  var item= {
    	        name:key,
    	        type:'bar',
    	        data:values,
    	        markPoint : {
    	            data : [
    	                {type : 'max', name: '最大值'},
    	                {type : 'min', name: '最小值'}
    	            ]
    	        },
    	        markLine : {
    	            data : [
    	                {type : 'average', name: '平均值'}
    	            ]
    	        }
    	    }    
    	  option3.series.push(item);
    	 });   

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
    myChart2.setOption(option2);
    myChart3.setOption(option3);

    var averageRankTbody = $('.average-rank table tbody');
    var data = getRandomRankData(60,100,10);
    averageRankTbody.html(template('sortrank-tem',{data:sortRank('count',data)}));
    setRankStyle('count',data);
    var reRank = $('.average-rank .re-rank');
    $(reRank[0]).css({
        'backgroundColor':'#C61000'
    }).find('.fa').removeClass('fa-caret-up').addClass('fa-caret-down');
    reRank.on('click', function () {
        reRank.find('.fa').removeClass('fa-caret-down').addClass('fa-caret-up');
        reRank.css({
            'backgroundColor':'#A60D00'
        });
        $(this).find('.fa').removeClass('fa-caret-up').addClass('fa-caret-down');
        $(this).css({
            'backgroundColor':'#C61000'
        });
        setRankStyle($(this).attr('odds'),data);
    })


    function getRandomData(min,max,index) {
        var data = [];
        for (var i = 0; i < index; i++) {
            data.push(Math.floor(Math.random()*(max-min+1)+min))
        }
        return data;
    }

    function setRankStyle(odds,data) {
        $('.average-rank table tbody td').attr('style','');
        $('.average-rank table tbody').html(template('sortrank-tem',{data:sortRank(odds,data)}));
        $('.'+ odds).each(function (i,e) {
            if(i%2 !=0){
                $(e).css({
                    'backgroundColor':'#e0e0e0'
                })
            }else{
                $(e).css({
                    'backgroundColor':'#f9f9f9'
                })
            }
        });
        var unitrankTable = $('.average-rank table tbody tr');
        unitrankTable.each(function (i,e) {
            if(i%2 !=0){
                $(e).css({
                    'backgroundColor':'#f0f0f0'
                })
            }
        });
    }

    function subFail(errorTip) {
        $('.evaluate-wrap-title').find('p').html(errorTip)
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

    //从大到小
    function sortNumber(a,b) {
        return b - a;
    }


})