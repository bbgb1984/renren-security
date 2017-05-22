<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新沂市作风建设实时评价监督平台</title>
    <meta name="keywords" content="新沂市, 作风建设, 监督平台, 评价系统" />
    <meta name="description" content="评议人可对所有上线单位工作作风进行投票评议，评议人在年度内可对每单位评议投票3次。本平台由新沂市机关工委、新沂市作风办联合新沂市广播电视台开发维护，评议活动严禁一切后台刷票行为，一经发现将取消本年度评议资格，监督举报电话：" />
    <link rel="shortcut icon" href="${contextPath}/favicon.ico">
    <link rel="stylesheet" href="${contextPath}/statics/tips/css/fail.css">
</head>
<body>

<section class="check">
    <div class="check-img">
        <img src="${contextPath}/statics/tips/imgs/fail.png" alt="">
    </div>
</section>

<div class="text">
    <h3>登录失败</h3>
    <p>登录新沂市作风建设实时评价监督平台时遇到问题</p>
</div>

<section class="buttons">
    <button  class="resaoma">重新扫码</button>
    <button  class="gohome">返回首页</button>
</section>




<script src="${contextPath}/statics/tips/lib/zepto/zepto.js"></script>
</body>
</html>
</html>