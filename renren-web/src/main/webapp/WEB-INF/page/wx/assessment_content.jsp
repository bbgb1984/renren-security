<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>新沂市作风建设实时评价监督平台</title>
<link rel="shortcut icon" href="${contextPath}/favicon.ico">
<meta name="keywords" content="新沂市, 作风建设, 监督平台, 评价系统" />
<meta name="description"
	content="评议人可对所有上线单位工作作风进行投票评议，评议人在年度内可对每单位评议投票3次。本平台由新沂市机关工委、新沂市作风办联合新沂市广播电视台开发维护，评议活动严禁一切后台刷票行为，一经发现将取消本年度评议资格，监督举报电话：" />

<link rel="stylesheet"
	href="${contextPath}/statics/wx/lib/font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${contextPath}/statics/wx/css/common.css">
    <link rel="stylesheet" href="${contextPath}/statics/wx/css/assessment_content.css">

</head>
<body>
	<!--header-->
<header id="header" class="header"></header>

<main>
    <div class="evaluate">
        <div class="evalutate-top">
            <h3>
                <span class="fa fa-institution"></span>
                参与机构
            </h3>
        </div>
        <div class="evalutate-content">
		<form id="commentform">
			<c:forEach items="${paramList }" var="items" varStatus="i">
				<div class="evaluate-item">
					<h3>
						<span>${i.index+1}.</span> <span>${items.paramName}</span>
					</h3>
					<div class="evaluate-opt">
						<input id="${items.id}" name="${items.id}" type="radio" value="1"
							checked="checked">满意 <input id=${items.id
							}" name="${items.id}" type="radio" value="2">比较满意 <input
							id="${items.id}" name="${items.id}" type="radio" value="3">不满意
					</div>
				</div>
			</c:forEach>
            
            <div class="evaluate-item">
                <h3>
                    <span>${fn:length(paramList)+1}.</span>
                    <span>对该单位的其他意见或建议</span>
                </h3>
                <div>
                    <textarea class="suggestion" name="suggestion" id="suggestion" cols="" rows=""></textarea>
                </div>
            </div>
            <div class="evaluate-tip ">
            </div>
            <div class="evaluate-sub">
                <input type="hidden" name="id1" id="id1" value="${id}"/>
				<input type="hidden" name="departId" id="departId" value="${departId }"/>
				<input type="hidden" name="departName" id="departName" value="${departName }"/>
				<button type="button" onclick="doSubmit()">提交评价</button>
            </div>
            </form>
        </div>
    </div>

</main>

<!--footer-->
<section class="footer">
    <img class="" src="${contextPath }/statics/wx/imgs/u89.png" alt="">
    <p class="footer-line1 clearfix box-center">
        <a href="">中国政府网</a>|
        <a href="">关于本网</a>|
        <a href="">网站声明</a>|
        <a href="">网站地图</a>|
        <a href="">联系我们</a>|
        <a href="">网站纠错</a>
    </p>
    <p class="footer-line2">
                <span class="clearfix">
                    主办单位：<a href="">新沂市机关工委</a>
                    <a href="">新沂市作风办</a>
                    <a href="">新沂市广播电视台</a>|
                    <a href="">ICP备案:豫ICP备15030292号-5    </a>
                </span>
    </p>
</section>





<script id="unitrank-tem" type="text/html">
    <div class="unitrank">
        <div class="statistics">
            <p>当前机构内办事单位评价统计</p>
            <table width="940">
                <colgroup width="50px"></colgroup>
                <colgroup width="180px"></colgroup>
                <thead>
                <tr>
                    <td>排行</td>
                    <td>单位名称</td>
                    <td>评价次数</td>
                    <td class="re-rank">服务质量</td>
                    <td class="re-rank">服务态度</td>
                    <td class="re-rank">办事效率</td>
                    <td class="re-rank">业务素养</td>
                    <td class="re-rank">廉洁从政</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>单位名称1</td>
                    <td>850</td>
                    <td>85%</td>
                    <td>85%</td>
                    <td>85%</td>
                    <td>85%</td>
                    <td>85%</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="rank">
            <p>评价排行</p>
            <table width="940">
                <colgroup width="50px"></colgroup>
                <colgroup width="180px"></colgroup>
                <thead>
                <tr>
                    <td>排行</td>
                    <td>单位名称</td>
                    <td class="re-rank" odds="count">评价次数<span class="fa fa-caret-up"></span></td>
                    <td class="re-rank" odds="zhiliang">服务质量<span class="fa fa-caret-up"></span></td>
                    <td class="re-rank" odds="taidu">服务态度<span class="fa fa-caret-up"></span></td>
                    <td class="re-rank" odds="xiaolv">办事效率<span class="fa fa-caret-up"></span></td>
                    <td class="re-rank" odds="suyang">业务素养<span class="fa fa-caret-up"></span></td>
                    <td class="re-rank" odds="lianjie">廉洁从政<span class="fa fa-caret-up"></span></td>
                </tr>
                </thead>
                <tbody>


                </tbody>
            </table>
        </div>
    </div>
</script>
<script id="sortrank-tem" type="text/html">
    {{each data as v i}}
    <tr>
        <td>{{i+1}}</td>
        <td>{{v.name}}</td>
        <td class="count">{{v.count}}</td>
        <td class="zhiliang">{{v.zhiliang}}%</td>
        <td class="taidu">{{v.taidu}}%</td>
        <td class="xiaolv">{{v.xiaolv}}%</td>
        <td class="suyang">{{v.suyang}}%</td>
        <td class="lianjie">{{v.lianjie}}%</td>
    </tr>
    {{/each}}
</script>

   <script type="text/javascript">
    var ctx = "${contextPath}";
	</script>
	
	<script src="${contextPath}/statics/wx/lib/zepto/zepto.js"></script>
	<script src="${contextPath}/statics/wx/lib/zepto/touch.js"></script>
	<script src="${contextPath}/statics/wx/lib/zepto/fx.js"></script>
	<script src="${contextPath}/statics/wx/lib/template.js"></script>
	<script src="${contextPath}/statics/wx/js/common.js"></script>
	<script src="${contextPath}/statics/wx/js/assessment_content.js"></script>
</body>
</html>
</html>