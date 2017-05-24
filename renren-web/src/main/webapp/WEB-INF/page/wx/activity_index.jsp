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
<link rel="stylesheet" href="${contextPath}/statics/wx/css/index.css">

</head>
<body>
	<!--header-->
	<header id="header" class="header"></header>

	<main> <!--activetop-->
	<section class="activetop">
		<div class="active-title clearfix">
			<div class="active-title-left ">
				<h1>${voteActivityEntity.voteName}</h1>
				<p class="activetime">
					<span>开始时间：${voteActivityEntity.beginTime }</span><span>结束时间：${voteActivityEntity.endTime }</span>
				</p>
			</div>

			<div class="active-title-right clearfix">
				<div class="pull-left">
					<table class="">
						<thead>
							<tr>
								<td>参与单位</td>
								<td>评价人数</td>
								<td>浏览量</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${departNum }</td>
								<td>${totalCommentNum }</td>
								<td>${voteActivityEntity.exploreNum}</td>
							</tr>
						</tbody>
					</table>
					<p class="activebtn">
						<a href="activity_ranking.html">查看活动排行</a>
					</p>
				</div>
				<div class="erweima pull-right">
					<img src="${contextPath}/statics/wx/imgs/u11.png" alt="">
				</div>
			</div>
		</div>
		<div class="active-info">
			<p>${voteActivityEntity.voteDesc }</p>
		</div>
	</section>

	<section class="units">
		<div class="units-top">
			<h3>
				<span class="fa fa-institution"></span> 参与机构
			</h3>
		</div>
		<div class="units-items">
		<c:forEach items="${queryAllList }" var="items">
			<a href="activity_assessment.html?id=${voteActivityEntity.id}&departId=${items.id}&departName=${items.name}" class="units-item">
				<div class="units-item-name">
					${items.name } <span class="fa fa-chevron-right"></span>
				</div>
			</a> 
			</c:forEach>
			
		</div>
		<div class="lineshadow"></div>
	</section>

	</main>

	<!--footer-->
	<section class="footer">
		<img class="" src="${contextPath}/statics/wx/imgs/u89.png" alt="">
		<p class="footer-line1 clearfix box-center">
			<a href="">中国政府网</a>| <a href="">关于本网</a>| <a href="">网站声明</a>| <a
				href="">网站地图</a>| <a href="">联系我们</a>| <a href="">网站纠错</a>
		</p>
		<p class="footer-line2">
			<span class="clearfix"> 主办单位：<a href="">新沂市机关工委</a> <a href="">新沂市作风办</a>
				<a href="">新沂市广播电视台</a>| <a href="">ICP备案:豫ICP备15030292号-5 </a>
			</span>
		</p>
	</section>

	<script src="${contextPath}/statics/wx/lib/zepto/zepto.js"></script>
	<script src="${contextPath}/statics/wx/lib/zepto/touch.js"></script>
	<script src="${contextPath}/statics/wx/lib/zepto/fx.js"></script>
	<script src="${contextPath}/statics/wx/lib/template.js"></script>
	<script src="${contextPath}/statics/wx/js/common.js"></script>
	<script src="${contextPath}/statics/wx/js/index.js"></script>
</body>
</html>
</html>