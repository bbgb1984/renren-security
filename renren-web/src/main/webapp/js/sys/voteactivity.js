$(function () {
    $("#jqGrid").jqGrid({
        url: '../voteactivity/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '评价活动名称', name: 'voteName', index: 'vote_name', width: 80 }, 			
			{ label: '评价活动描述', name: 'voteDesc', index: 'vote_desc', width: 80 }, 			
			{ label: '开始时间', name: 'beginTime', index: 'begin_time', width: 80 }, 			
			{ label: '开始时间', name: 'endTime', index: 'end_time', width: 80 }, 			
			{ label: '状态 1：生效；0：无效', name: 'status', index: 'status', width: 80 }, 			
			{ label: '个人最多可评价单位个数', name: 'maxNum', index: 'max_num', width: 80 }, 			
			{ label: '创建者', name: 'createUser', index: 'create_user', width: 80 }			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		voteActivity: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.voteActivity = {};
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
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
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
		getInfo: function(id){
			$.get("../voteactivity/info/"+id, function(r){
                vm.voteActivity = r.voteActivity;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});