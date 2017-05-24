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

<link rel="stylesheet" href="${contextPath}/statics/wx/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/statics/wx/lib/swiper/swiper-3.4.2.min.css">
    <link rel="stylesheet" href="${contextPath}/statics/wx/css/common.css">
    <link rel="stylesheet" href="${contextPath}/statics/wx/css/activity_ranking.css">
    
</head>
<body>
	<!--header-->
<header id="header" class="header"></header>

<main>
    <div class="item evcount-rank">
        <div class="item-top">
            <h3>
                <span class="fa fa-bar-chart-o"></span>
                单位评价次数排行
            </h3>
        </div>
        <div class="item-content">
            <div class="chart"></div>
            <div class="rank">
                <ul>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>

                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="lineshadow"></div>
        </div>
    </div>
    <div class="item evcount-haoping">
        <div class="item-top">
            <h3>
                <span class="fa fa-bar-chart-o"></span>
                单位好评排行
            </h3>
        </div>
        <div class="item-content">
            <div class="chart"></div>
            <div class="rank">
                <ul>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>

                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a class="clearfix" href="">
                            <div class="pull-left clearfix">
                                <i class="pull-left">1</i>
                                <span class="pull-left">市委办</span>
                            </div>
                            <div class="pull-right clearfix">
                                <span class="mr15 pull-left">评价次数:</span>
                                <span class="pull-right">20</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="lineshadow"></div>
        </div>
    </div>
    <div class="item evcount-zonghe">
        <div class="item-top">
            <h3>
                <span class="fa fa-bar-chart-o"></span>
                平均项目好评率
            </h3>
        </div>
        <div class="item-content">
            <div class="chart"></div>
            <div class="rank ">
                <div class="rank-table">
                    <div class="swiper-container">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide">
                                <div class="rank-table-title">
                                    <span class="vtline"></span>
                                    <span>评价次数排行</span>
                                </div>
                                <table class="rank-table-count" width="">
                                    <!--<colgroup width="50px"></colgroup>-->
                                    <!--<colgroup width="180px"></colgroup>-->
                                    <thead>
                                    <tr>
                                        <td>排行</td>
                                        <td>单位名称</td>
                                        <td class="re-rank" odds="count">评价次数<span class="fa fa-caret-up"></span></td>
                                        <!--<td class="re-rank" odds="zhiliang">服务质量<span class="fa fa-caret-up"></span></td>-->
                                        <!--<td class="re-rank" odds="taidu">服务态度<span class="fa fa-caret-up"></span></td>-->
                                        <!--<td class="re-rank" odds="xiaolv">办事效率<span class="fa fa-caret-up"></span></td>-->
                                        <!--<td class="re-rank" odds="suyang">业务素养<span class="fa fa-caret-up"></span></td>-->
                                        <!--<td class="re-rank" odds="lianjie">廉洁从政<span class="fa fa-caret-up"></span></td>-->
                                    </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>
                            </div>
                            <div class="swiper-slide">
                                <div class="rank-table-title">
                                    <span class="vtline"></span>
                                    <span>服务质量排行</span>
                                </div>
                                <table class="rank-table-zhiliang" width="">
                                    <!--<colgroup width="50px"></colgroup>-->
                                    <!--<colgroup width="180px"></colgroup>-->
                                    <thead>
                                    <tr>
                                        <td>排行</td>
                                        <td>单位名称</td>
                                        <td class="re-rank" odds="zhiliang">服务质量<span class="fa fa-caret-up"></span></td>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>
                            </div>
                            <div class="swiper-slide">
                                <div class="rank-table-title">
                                    <span class="vtline"></span>
                                    <span>服务态度排行</span>
                                </div>
                                <table class="rank-table-taidu" width="">
                                    <!--<colgroup width="50px"></colgroup>-->
                                    <!--<colgroup width="180px"></colgroup>-->
                                    <thead>
                                    <tr>
                                        <td>排行</td>
                                        <td>单位名称</td>
                                        <td class="re-rank" odds="taidu">服务态度<span class="fa fa-caret-up"></span></td>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>
                            </div>
                            <div class="swiper-slide">
                                <div class="rank-table-title">
                                    <span class="vtline"></span>
                                    <span>办事效率排行</span>
                                </div>
                                <table class="rank-table-xiaolv" width="">
                                    <!--<colgroup width="50px"></colgroup>-->
                                    <!--<colgroup width="180px"></colgroup>-->
                                    <thead>
                                    <tr>
                                        <td>排行</td>
                                        <td>单位名称</td>
                                        <td class="re-rank" odds="xiaolv">办事效率<span class="fa fa-caret-up"></span></td>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>
                            </div>
                            <div class="swiper-slide">
                                <div class="rank-table-title">
                                    <span class="vtline"></span>
                                    <span>业务素养排行</span>
                                </div>
                                <table class="rank-table-suyang" width="">
                                    <!--<colgroup width="50px"></colgroup>-->
                                    <!--<colgroup width="180px"></colgroup>-->
                                    <thead>
                                    <tr>
                                        <td>排行</td>
                                        <td>单位名称</td>
                                        <td class="re-rank" odds="suyang">业务素养<span class="fa fa-caret-up"></span></td>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>
                            </div>
                            <div class="swiper-slide">
                                <div class="rank-table-title">
                                    <span class="vtline"></span>
                                    <span>廉洁从政排行</span>
                                </div>
                                <table class="rank-table-lianjie" width="">
                                    <!--<colgroup width="50px"></colgroup>-->
                                    <!--<colgroup width="180px"></colgroup>-->
                                    <thead>
                                    <tr>
                                        <td>排行</td>
                                        <td>单位名称</td>
                                        <td class="re-rank" odds="zhiliang">廉洁从政<span class="fa fa-caret-up"></span></td>
                                    </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="swiper-button-prev fa fa-chevron-left"></div>
                        <div class="swiper-button-next fa fa-chevron-right"></div>
                        <div class="swiper-pagination"></div>
                    </div>
                    <div class="swiper-tip">可以左右滑动查看各项排行情况</div>
                </div>
            </div>
            <div class="lineshadow"></div>
        </div>
    </div>

</main>

<!--footer-->
<section class="footer">
    <img class="" src="imgs/u89.png" alt="">
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


<script src="${contextPath}/statics/wx/lib/zepto/zepto.js"></script>
<script src="${contextPath}/statics/wx/lib/zepto/touch.js"></script>
<script src="${contextPath}/statics/wx/lib/zepto/fx.js"></script>
<script src="${contextPath}/statics/wx/lib/swiper/swiper-3.4.2.jquery.min.js"></script>
<script src="${contextPath}/statics/wx/lib/template.js"></script>
<script src="${contextPath}/statics/wx/lib/echarts.common.min.js"></script>
<script src="${contextPath}/statics/wx/js/common.js"></script>
<script src="${contextPath}/statics/wx/js/activity_ranking.js"></script>
</body>
</html>
</html>