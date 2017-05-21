$(function () {
    $("#jqGrid").jqGrid({
        url: '../voteactivityresult/list',
        datatype: "json",
        colModel: [			
			{ label: '单位名称', name: 'departId', index: 'depart_id', width: 80 }, 			
			{ label: '评价项', name: 'voteActivityParamId', index: 'vote_activity_param_id', width: 80 }, 			
			{ label: '评价值', name: 'voteActivityParamVal', index: 'vote_activity_param_val', width: 80 }, 			
			{ label: '投票人', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '投票时间', name: 'voteTime', index: 'vote_time', width: 80 }			
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
		voteActivityResult: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.voteActivityResult = {};
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
			var url = vm.voteActivityResult.id == null ? "../voteactivityresult/save" : "../voteactivityresult/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.voteActivityResult),
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
				    url: "../voteactivityresult/delete",
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
			$.get("../voteactivityresult/info/"+id, function(r){
                vm.voteActivityResult = r.voteActivityResult;
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