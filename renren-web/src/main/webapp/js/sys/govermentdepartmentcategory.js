$(function () {
    $("#jqGrid").jqGrid({
        url: '../govermentdepartmentcategory/list',
        datatype: "json",
        colModel: [			
			{ label: '单位类别', name: 'categoryName', index: 'category_name', width: 80 }	
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
		q:{
			categoryName: null
		},
		showList: true,
		title: null,
		govermentDepartmentCategory: {}
	},
	
	
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.govermentDepartmentCategory = {};
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
			var url = vm.govermentDepartmentCategory.id == null ? "../govermentdepartmentcategory/save" : "../govermentdepartmentcategory/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.govermentDepartmentCategory),
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
				    url: "../govermentdepartmentcategory/delete",
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
			$.get("../govermentdepartmentcategory/info/"+id, function(r){
                vm.govermentDepartmentCategory = r.govermentDepartmentCategory;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'categoryName': vm.q.categoryName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});