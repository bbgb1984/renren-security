/**
 * Created by meng on 2017/5/15.
 */
$(function () {
//	var submitBtn=$('#submitBtn');
//	submitBtn.on('click',function(e){
//		alert(1);
//	});
	
	var flag=$('#flag').val();
	if(flag=='1'){
		alert("恭喜你,评价成功！");
	}
    var unitsSearch = $('#units-search'),
        id = $('#id').val(),
        $w = $(window),
        $body = $(document.body),
        units = $('.units-details-item');
    unitsSearch.on('keyup', function (e) {
        if(e.key == 'Enter' && e.keyCode == 13){
            //   发送搜索信息
        	var searchData = $(this).val();
        	window.open("activity_index.html?id="+id+"&searchName="+searchData,"_self");
            // ...
        }
    });





    //弹出评价框
    units.on('click', function (e) {
        var evaluate,
            evaluateSub,
            evaluateClose;
        e.preventDefault();
        var nologinStatus=true;
        $.ajax({  
		    type: "get",  
			url:ctx+"/getAppLoginStatus.html?timestamps="+new Date(),  
			async: false,  
			error: function(request) {  
			},  
			success: function(r) { 
				alert(r);
				var json=JSON.parse( r )
			    //接收后台返回的结果  
				if(json.code==0){
					alert(11);
					nologinStatus=false;
				}
			}  
		});
        
        alert(nologinStatus);
        //判断登录
        if(nologinStatus){
            //登录前
            var login = $($('#login-tem').html()),
                loginCloseBtn = login.find('.fa-close'),
                saomaBtn = login.find('.login-btn').find('button');
            
            $body.append(login);
            login.css({
                'height':$w.height()
            });
            loginCloseBtn.on('click', function () {
                login.remove();
            });

            saomaBtn.on('click', function () {
                //登录后
                login.remove();
                var data = {
                    id:$(this).find('.udi-title p').attr('unit-id'),
                    name:$(this).find('.udi-title p').html()
                };
                evaluate = $(template('evaluate-tem',data));
                $body.append(evaluate);
                evaluate.css({
                    'height':$w.height()
                });

                //提交评论
                evaluateSub = $('.evaluate-wrap-sub button');
                
                evaluateSub.on('click', function () {
                    //虚拟数据
					$.ajax({  
					    type: "POST",  
						url:ctx+"/voteactivityresult/save",  
						data:$('#commentform').serialize(),  
						async: false,  
						error: function(request) {  
						    alert("评论失败,请刷新页面重试！");  
						    return false;
						},  
						success: function(r) { 
							var json=JSON.parse( r )
						    //接收后台返回的结果  
							if(json.code==0){
								alert("恭喜你，评价成功！");
								subSuccess(); //成功后执行
							}else{
								alert("评论失败,请刷新页面重试！");
								return false;
							}
						}  
					});
	            });

                //关闭评价框
                evaluateClose = evaluate.find('.fa-close');
                evaluateClose.on('click', function (e) {
                    console.log(1);
                    $(this).parent().parent().parent().remove();
                })
            })
        }else{
        	var data = {
                    id:$(this).find('.udi-title p').attr('unit-id'),
                    name:$(this).find('.udi-title p').html()
                };
                evaluate = $(template('evaluate-tem',data));
                $body.append(evaluate);
                evaluate.css({
                    'height':$w.height()
                });

//                提交评论
                evaluateSub = $('.evaluate-wrap-sub button');
                var flag=1;
                evaluateSub.on('click', function () {
	                    //虚拟数据
					$.ajax({  
					    type: "POST",  
						url:ctx+"/voteactivityresult/save",  
						data:$('#commentform').serialize(),  
						async: false,  
						error: function(request) { 
							flag=0;
						    alert("评论失败,请刷新页面重试！");  
						    return false;
						},  
						success: function(r) { 
							var json=JSON.parse( r )
						    //接收后台返回的结果  
							if(json.code==0){
								alert("恭喜你，评价成功！");
								subSuccess(); //成功后执行
							}else{
								flag=0;
								alert(json.msg);
								return false;
							}
						}  
					});
					if(flag==0){
						return false;
					}
                });
                //关闭评价框
                evaluateClose = evaluate.find('.fa-close');
                evaluateClose.on('click', function (e) {
                    console.log(1);
                    $(this).parent().parent().parent().remove();
                })
        }
    });


    function subSuccess(data) {
        var unitrankHtml = template('unitrank-tem',{data:sortRank('count',data)});
        $('.evaluate').remove();
        $('.units').remove();
        $('.activetop').after(unitrankHtml);
        setRankStyle('count',data);
        var reRank = $('.rank .re-rank');
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

    }

    function setRankStyle(odds,data) {
        $('.rank table tbody td').attr('style','');
        $('.rank table tbody').html(template('sortrank-tem',{data:sortRank(odds,data)}));
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
        var unitrankTable = $('.rank table tbody tr');
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


});