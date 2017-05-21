$(function () {
    $("#jqGrid").jqGrid({
        url: '../voteactivity/list',
        datatype: "json",
        colModel: [			
			{ label: '评价活动名称', name: 'voteName', index: 'vote_name', width: 80 }, 			
			{ label: '开始时间', name: 'beginTime', index: 'begin_time', width: 80 }, 			
			{ label: '截止时间', name: 'endTime', index: 'end_time', width: 80 }	,
			{ label: '状态', name: 'status', index: 'status', width: 80 }	,
			 {    name : '操作',
                width : 40,
                align : "center",
                formatter: function (value, grid, rows, state) {
                return '<a target="parent" onclick="viewComments('+rows.id+')">查看排名</a>'
//                return '<a target="parent" onclick="viewComments('+rows.id+')">'+rows.voteName+'</a>'
                ; }
            }

        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
    
   
});
function delRow(obj,id){
	if(id=='-1'){
		$(obj).parent().parent().remove(); 
	}else{
		$.get("../voteactivityparam/delete/"+id, function(r){
			if(r.code == 0){
				alert('操作成功', function(index){
					$(obj).parent().parent().remove(); 
				});
			}else{
				alert(r.msg);
			}
        });
	}
}
function viewComments(id){
	window.open("voteactivityresult.html?id="+id,"_self");
}
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			voteName: null
		},
		showList: true,
		showList2: true,
		title: null,
		voteActivity: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.showList2 = true;
			vm.title = "新增";
			vm.voteActivity = {};
		},
		config: function(){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = true;
			vm.showList2 = false;
			vm.title = "配置活动选项";
			vm.getconfig(id);
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			vm.voteActivity.beginTime=$("#beginTime").val();
			var url = vm.voteActivity.id == null ? "../voteactivity/save" : "../voteactivity/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.voteActivity),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		stop: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定停选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../voteactivity/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		start: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要启中的记录？', function(){
				$.ajax({
					type: "POST",
					url: "../voteactivity/delete?flag=1",
					data: JSON.stringify(ids),
					success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../voteactivity/info/"+id, function(r){
                vm.voteActivity = r.voteActivity;
            });
		},
		addColumn: function(){
			var id = getSelectedRows();
			if(id == null){
				return ;
			}
			var table=$("#tabs");
			var tr=$("<tr></tr>");
	        tr.appendTo(table);
	           var td=$("<td><input type='text' id='id' style='display:none'/><input style='display:none' type='text' id='voteActivityId' value='"
	        		   +id+"'></input><input type='text'  class='form-control input-lg' ></td>");
	           
//	           var td=$("<td><input type='text' style='display:none' id='id' value="
//	        		   +obj.id+"></input><input type='text' style='display:none' id='voteActivityId' value="
//	        		   +id+"></input></div><input type='text' id='name' value="
//	        		   +obj.paramName+"  class='form-control input-lg' ></input><input type='button'  onclick='delRow(this,"+obj.id+")' class='btn btn-primary' value='删除'/></td>");
	           var td2=$("<td></input><input type='button'  onclick='delRow(this,-1)' class='btn btn-primary' value='删除'/></td>");
	           td.appendTo(tr);
	           td2.appendTo(tr);
		},
		saveColumn: function(){
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var arrObj=new Array();
		        $('#tabs').find('tr').each(function () {  
		            $(this).find('td').each(function () { 
		            	var html = '';  
		            	var obj=new Object();
		            	$(this).find('input[type="text"]').each(function(){
		            		html=html+$(this).val()+',';
		            	});
						if (html != '') {
							obj.id = html.split(',')[0];
							obj.voteActivityId = html.split(',')[1];
							obj.paramName = html.split(',')[2];
							arrObj.push(obj);
						}
		            })  
		        });
		       var url = "../voteactivityparam/save";
				$.ajax({
					type: "POST",
				    url: url,
				    data: JSON.stringify(arrObj),
				    success: function(r){
				    	if(r.code === 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
		},
		getconfig: function(id){
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			$("#tabs  tr:not(:first)").empty("");
			
			$.get("../voteactivityparam/list/"+ids, function(r){
				$.each(r.list, function(i, obj) {
					var table=$("#tabs");
					var tr=$("<tr></tr>");
			        tr.appendTo(table);
			           var td=$("<td nowrap='nowrap'><input type='text' style='display:none' id='id' value='"
			        		   +obj.id+"'></input><input type='text' style='display:none' id='voteActivityId' value='"
			        		   +id+"'></input></div><input type='text' id='name' value='"+obj.paramName+"'  class='form-control input-lg' ></input></td>");
			           var td2=$("<td><input type='button'  onclick='delRow(this,"+obj.id+")' class='btn btn-primary' value='删除'/></td>");
			           td.appendTo(tr);
			           td2.appendTo(tr);
	            });
			});
		},
		reload: function (event) {
			vm.showList = true;
			vm.showList2 = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'voteName': vm.q.voteName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});