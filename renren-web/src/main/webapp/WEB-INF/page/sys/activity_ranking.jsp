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
    <link rel="stylesheet" href="${contextPath}/js/front/lib/font-awesome-4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/statics/css/front/common.css">
    <link rel="stylesheet" href="${contextPath}/statics/css/front/activity_ranking.css">
</head>
<body>
    <div class="main box-center">
        <!--header-->
        <div class="header"></div>

        <!--content-->
        <div class="content">
            <div class="content-item clearfix">
                <div class="pull-left">
                    <div class="active-title">
                        <h1>单位评价次数排行</h1>
                    </div>
                    <input type="hidden" id="commentTopTen_title" value="${commentTopTen_title }">
                    <input type="hidden" id="commentTopTen_data" value="${commentTopTen_data }">
                    <div class="active-rank">
                        <ul>
                        <c:forEach items="${commentTopTen}" var="item">
                            <li>
                                <a class="clearfix" href="">
                                    <div class="pull-left clearfix">
                                        <i class="pull-left">1</i>
                                        <span class="pull-left">${item.departName}</span>
                                    </div>
                                    <div class="pull-right clearfix">
                                        <span class="mr15 pull-left">评价次数:</span>
                                        <span class="pull-right">${item.commentNum}</span>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                            
                        </ul>
                    </div>
                </div>
                <div class="pull-right">
                    <div class="chart"></div>
                </div>
            </div>
            <div class="content-item clearfix">
                <div class="pull-left">
                    <div class="active-title">
                        <h1>单位好评排行</h1>
                    </div>
                    <input type="hidden" id="highRateTopTen_title" value="${highRateTopTen_title }">
                    <input type="hidden" id="highRateTopTen_data" value="${highRateTopTen_data }">
                    <div class="active-rank">
                        <ul>
                        <c:forEach items="${highRateTopTen}" var="item" varStatus="i">
                            <li>
                                <a class="clearfix" href="">
                                    <div class="pull-left clearfix">
                                        <i class="pull-left">${i.index+1}</i>
                                        <span class="pull-left">${item.departName }</span>
                                    </div>
                                    <div class="pull-right clearfix">
                                        <span class="mr15 pull-left">好评率:</span>
                                        <span class="pull-right">${item.totalRate}%</span>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>

                        </ul>
                    </div>
                </div>
                <div class="pull-right">
                    <div class="chart"></div>
                </div>
            </div>
            <div class="content-item">
               <div class="average">
                   <div class="active-title">
                       <h1>单位好评排行</h1>
                   </div>
                   <div class="chart">

                   </div>
                   <div class="average-rank">
                       <table width="960">
                           <colgroup width="50px"></colgroup>
                           <colgroup width="180px"></colgroup>
                           <thead>
                           <tr>
                               <td>排行</td>
                               <td>单位名称</td>
                               <td class="re-rank" odds="count">评价次数</td>
                               <c:forEach items="${paramList }" var="item">
                               <td class="re-rank" odds="${item.id }">${item.paramName }</td>
                               
                               </c:forEach>
                           </tr>
                           </thead>
                           <tbody>
                           <c:if test=""></c:if>
                           <c:forEach items="${resultList }" var="item" varStatus="step">
							<tr <c:if test="${step.index%2 eq 1 }"> style="background-color: rgb(240, 240, 240);"</c:if>>
                               <td>${step.index+1 }</td>
                               <c:forEach items="${item }" var="sub_item">
                               <td >${sub_item}</td>
                               </c:forEach>
                           </tr>
						</c:forEach>
                           </tbody>
                       </table>
                   </div>

               </div>
            </div>
        </div>
<input type="hidden" id="id" value=${id }>
        <!--footer-->
        <div class="footer">
            <p class="footer-line1 clearfix box-center">
                <img class="pull-left" src="imgs/u89.png" alt="">
                <span class="pull-right clearfix">
                    <a href="">中国政府网</a>|
                    <a href="">关于本网</a>|
                    <a href="">网站声明</a>|
                    <a href="">网站地图</a>|
                    <a href="">联系我们</a>|
                    <a href="">网站纠错</a>
                </span>
            </p>
            <p class="footer-line2">
                <span class="clearfix">
                    主办单位：<a href="">新沂市机关工委</a>
                    <a href="">新沂市作风办</a>
                    <a href="">新沂市广播电视台</a>|
                    <a href="">ICP备案:豫ICP备15030292号-5    </a>
                </span>
            </p>
        </div>
    </div>


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
    <script src="${contextPath}/js/front/lib/echarts.common.min.js"></script>
    <script src="${contextPath}/js/front/activity_ranking.js"></script>
</body>
</html>