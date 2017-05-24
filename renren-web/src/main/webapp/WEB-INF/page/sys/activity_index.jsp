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
	href="${contextPath}/js/front/lib/font-awesome-4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${contextPath}/statics/css/front/common.css">
<link rel="stylesheet" href="${contextPath}/statics/css/front/index.css">
</head>
<body>
	<div class="main box-center">
		<!--header-->
		<div class="header"></div>

		<!--activetop-->
		<div class="activetop">
			<div class="active-title clearfix">
				<div class="active-title-left pull-left">
					<h1>${voteActivityEntity.voteName}</h1>
					<p class="activetime">
						<span>开始时间：${voteActivityEntity.beginTime }</span><span>结束时间：${voteActivityEntity.endTime }</span>
					</p>
					<p class="activebtn">
						<a href="${contextPath}/activity_ranking.html?id=${id}" target="_blank">查看活动排行</a>
					</p>
				</div>
				<div class="active-title-right pull-right clearfix">
					<table class="pull-left" width="345">
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
					<div class="erweima ml15 pull-right">
						<img src="imgs/u11.png" alt="">
					</div>
				</div>
			</div>
			<div class="active-info">
				<p>${voteActivityEntity.voteDesc }</p>
			</div>
		</div>

		<!--units-->
		<div class="units">
			<div class="units-title">
				<h1>参与单位</h1>
			</div>
			<div class="units-category clearfix">
				<div class="pull-left">
					<c:forEach items="${categoryList }" var="items">
						<a
							href="${contextPath}/activity_index.html?id=${id }&searchName=${searchName}&categoryId=${items.id}">${items.categoryName}</a>
					</c:forEach>
				</div>
				<div class="pull-right">
					<i class="fa fa-search"></i> 
					<input type="hidden" name="id" id="id"
						value="${id}">
					<input type="hidden" name="flag" id="flag"
						value="${flag}">
						 <input id="units-search" type="text"
						value="${searchName}" placeholder="请输入关键字搜索">
				</div>
			</div>
			<div class="units-details clearfix">
				<c:forEach items="${queryAllList }" var="items">
					<a class="units-details-item clearfix pull-left">
						<div class="udi-img pull-left">
							<img src="imgs/default.jpg" alt="">
						</div>
						<div class="udi-title">
							<p unit-id="${items.id}">${items.name }</p>
						</div>
					</a>
				</c:forEach>
			</div>
		</div>


		<!--footer-->
		<div class="footer">
			<p class="footer-line1 clearfix box-center">
				<img class="pull-left" src="imgs/u89.png" alt=""> <span
					class="pull-right clearfix"> <a href="">中国政府网</a>| <a
					href="">关于本网</a>| <a href="">网站声明</a>| <a href="">网站地图</a>| <a
					href="">联系我们</a>| <a href="">网站纠错</a>
				</span>
			</p>
			<p class="footer-line2">
				<span class="clearfix"> 主办单位：<a href="">新沂市机关工委</a> <a
					href="">新沂市作风办</a> <a href="">新沂市广播电视台</a>| <a href="">ICP备案:豫ICP备15030292号-5
				</a>
				</span>
			</p>
		</div>
	</div>


	<script id="login-tem" type="text/html">
        <div class="login">
            <div class="loginwrap">
                <i class="login-close fa fa-close"></i>
                <h2>用户登录</h2>
                <div class="login-erweima">
                    <img src="${contextPath}/barcode.jpg" alt="" >
                </div>
                <div class="login-btn">
                    <button>扫码登录</button>
                </div>
            </div>
        </div>
    </script>
	<script id="evaluate-tem" type="text/html">
        <!---->
        <div class="evaluate">
<form id="commentform">
            <div class="evaluate-wrap">
                <div class="evaluate-wrap-title">
                    <h3 unit-id = "{{id}}">{{name}}</h3>
                    <p></p>
                </div>
                <div class="evaluate-wrap-detals">
                    <ul>
					<c:forEach items="${paramList }" var="items" varStatus="i">
                        <li class="clearfix">
                            <div class="pull-left">
                                <span>${i.index+1}、</span>
                                <span>${items.paramName}</span>
                            </div>
                            <div class="pull-right">
                                <input id="${items.id}" name="${items.id}" type="radio" value="1" checked="checked">满意
                                <input id=${items.id}" name="${items.id}" type="radio" value="2">比较满意
                                <input id="${items.id}" name="${items.id}" type="radio" value="3">不满意
                            </div>
                        </li>
					</c:forEach>
                       
                        <li class="">
                            <div class="">
                                <span>${fn:length(paramList)+1}、</span>
                                <span>对该单位的其他意见或建议</span>
                            </div>
                            <div>
                                <textarea class="suggestion" name="suggestion" id="suggestion" cols="" rows=""></textarea>
                            </div>
                        </li>
                    </ul>
                </div>
	
                <div class="evaluate-wrap-sub">
<input type="hidden" name="id1" id="id1" value="${id}"/>
<input type="hidden" name="departId" id="departId" value="{{id}}"/>
<button>提交评价</button>
                </div>
                <div class="fa fa-close"></div>
            </div>
</form>
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
	<script src="${contextPath}/js/front/lib/jquery-1.12.3.min.js"></script>
	<script src="${contextPath}/js/front/lib/template.js"></script>
	<script src="${contextPath}/js/front/index.js"></script>
	<script src="${contextPath}/statics/plugins/jquery.validate.min.js"></script>
</body>
</html>