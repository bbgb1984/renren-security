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
<link rel="stylesheet"
	href="${contextPath}/statics/wx/lib/swiper/swiper-3.4.2.min.css">
<link rel="stylesheet" href="${contextPath}/statics/wx/css/common.css">
<link rel="stylesheet"
	href="${contextPath}/statics/wx/css/after_evaluate.css">

</head>
<body>
	<!--header-->
	<header id="header" class="header"></header>
	<main>
	<section id="statistics" class="statistics">
		<div class="statistics-top">
			<h3>
				<span class="fa fa-institution"></span> { ${departName} }评价统计
			</h3>
		</div>
		<div class="statistics-table">
			<div class="totalrank">
				<span class="vtline"></span> <span class="fa fa-star"></span> <span>
					当前单位名称 </span> <span>总排行 ${curBank}</span> <span>评价数 ${comentNum }</span>
			</div>
			<table width="">
				<!--<colgroup width="50px"></colgroup>-->
				<!--<colgroup width="180px"></colgroup>-->
				<thead>
					<tr>
						<td>单项评价</td>
						<td>单项排行</td>
						<td>好评率</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${curDepartParmRank }" var="item">
						<tr>
							<td>${item.paramName }</td>
							<td>${item.commentNum }</td>
							<td>${item.totalRate}%</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="lineshadow"></div>

	</section>
	<section class="rank">
		<div class="rank-top">
			<h3>
				<span class="fa fa-bar-chart"></span> 评价排行
			</h3>
		</div>
		<div class="rank-table">
			<div class="swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<div class="rank-table-title">
							<span class="vtline"></span> <span>评价次数排行</span>
						</div>
						<table class="rank-table-count" width="">
							<!--<colgroup width="50px"></colgroup>-->
							<!--<colgroup width="180px"></colgroup>-->
							<thead>
								<tr>
									<td>排行</td>
									<td>单位名称</td>
									<td class="re-rank" odds="count">评价次数<span
										class="fa fa-caret-up"></span></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${commentTopTen }" var="item" varStatus="step" end="9">
									<tr
										<c:if test="${step.index%2 eq 1 }"> style="background-color: rgb(240, 240, 240);"</c:if>>

										<td>${step.index+1}</td>
										<td>${item.departName}</td>
										<td class="lianjie">${item.commentNum}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<c:forEach items="${totalDepartParmRank}" var="item" varStatus="step" >
					 	<c:forEach items="${item}" var="map">
						<div class="swiper-slide">
							<div class="rank-table-title">
								<span class="vtline"></span> <span>${map.key}</span>
							</div>
							<table class="rank-table-${step.index}" width="">
								<thead>
									<tr>
										<td>排行</td>
										<td>单位名称</td>
										<td class="re-rank" odds="count">评价次数<span
											class="fa fa-caret-up"></span></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${map.value}" var="sub" varStatus="steps" end="9">
										<tr
											<c:if test="${steps.index%2 eq 1 }"> style="background-color: rgb(240, 240, 240);"</c:if>>

											<td>${steps.index+1}</td>
											<td>${sub.departName}</td>
											<td class="lianjie">${sub.totalRate}%</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						</c:forEach>
					</c:forEach>
				</div>
				<div class="swiper-button-prev fa fa-chevron-left"></div>
				<div class="swiper-button-next fa fa-chevron-right"></div>
				<div class="swiper-pagination"></div>
			</div>
			<div class="swiper-tip">可以左右滑动查看各项排行情况</div>
		</div>

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


	<script id="sortrank-count" type="text/html">
    {{each data as v i}}
    <tr>
        <td>{{i+1}}</td>
        <td>{{v.name}}</td>
        <td class="{{v.type}}">{{v.value}}</td>
    </tr>
    {{/each}}
</script>
	<script id="sortrank-type" type="text/html">
    {{each data as v i}}
    <tr>
        <td>{{i+1}}</td>
        <td>{{v.name}}</td>
        <td class="{{v.type}}">{{v.value}}%</td>
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
	<script src="${contextPath}/statics/wx/js/after_evaluate.js"></script>
    <script src="${contextPath}/statics/wx/lib/swiper/swiper-3.4.2.jquery.min.js"></script>
</body>
</html>
