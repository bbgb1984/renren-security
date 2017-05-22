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
    <link rel="stylesheet" href="${contextPath}/statics/tips/css/login.css">
</head>
<body>
 <section class="logo">
        <div class="logo-img"><img src="${contextPath}/statics/tips/imgs/logo.png" alt=""></div>
    </section>
    <section class="title">
        <h1>新沂市作风建设实时评价监督平台</h1>
    </section>
    <section class="tip">
        <p>即将登陆新沂市作风建设实时评价监督平台，请确认是本人操作</p>
        <p><span></span>使用你的账号登录该应用</p>
    </section>
    <section class="buttons">
        <button  class="confirm">确认登录</button>
        <button  class="cancel">取消</button>
    </section>

    <script src="${contextPath}/statics/tips/lib/zepto/zepto.js"></script>
    <script>
    var ctx = "${contextPath}";
        $(function () {
            $('.confirm').on('click', function () {
               window.open(ctx+"/appLogin.html?cusNo=${cusNo}&accessToken=${accessToken}","_self");

            });

        })
    </script>
</body>
</html>
</html>