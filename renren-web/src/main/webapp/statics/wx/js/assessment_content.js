/**
 * Created by meng on 2017/5/17.
 */
$(function() {
	sideBar();
	var header = $('.header'), evaluate = $('.evaluate'), suggestion = $('.suggestion'), subBtn = $('.evaluate-sub button'), tip = $('.evaluate-item .tip');

	header.css({
		'height' : header.width() * 0.366
	});
	suggestion.on('keyup', function(e) {
		surplusWord(140);
	});


	// 评价提交成功
	function subSuccess() {
		window.location.href = 'after_evaluate.html';

	}

	// 评价提交失败
	function subFail(errorTip) {
		$('.evaluate-tip').html(errorTip)
	}

	/**
	 * 
	 * @param total
	 *            总字数
	 */
	function surplusWord(total) {
		if (total - suggestion.val().length >= 0) {
			tip.find('span').html(total - suggestion.val().length);
		} else {
			tip.html('字数超出<span>' + (suggestion.val().length - total)
					+ '</span>个')
		}

	}

});


function doSubmit() {
	var id=$('#id1').val();
	var departId=$('#departId').val();
	var departName=$('#departName').val();
	$.ajax({
		type : "POST",
		url : ctx + "/voteactivityresult/save",
		data : $('#commentform').serialize(),
		async : false,
		error : function(request) {
			alert("评论失败,请刷新页面重试！");
			return false;
		},
		success : function(r) {
			var json = JSON.parse(r)
			// 接收后台返回的结果
			if (json.code == 0) {
				window.open("after_evaluate.html?id="+id+"&departId="+departId+"&departName="+departName,"_self");
			} else {
				alert(json.msg);
				return false;
			}
		}
	});
}