
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm</title>
</head>

<body>

<h3>------------ step-05 EHCache-------------------------------</h3>
<a href="${pageContext.request.contextPath}/learn/ehcache/get/1">用户1</a>&nbsp;|&nbsp;
<a href="${pageContext.request.contextPath}/learn/ehcache/get/2">用户2</a>&nbsp;|&nbsp;
<a href="${pageContext.request.contextPath}/learn/ehcache/get/3">用户3</a>&nbsp;|&nbsp;

<h3>------------ step-04 log4j-------------------------------</h3>
<a href="${pageContext.request.contextPath}/learn/log">log</a>&nbsp;|&nbsp;
<a href="${pageContext.request.contextPath}/learn/log/debug">debug</a>&nbsp;|&nbsp;
<a href="${pageContext.request.contextPath}/learn/log/error">error</a>&nbsp;|&nbsp;


<h3>------------ step-03 REST风格的url映射-------------------</h3>

<div style="float: left;clear: both">

    <a href="${pageContext.request.contextPath}/learn/rest/1"> 获取</a>&nbsp;|&nbsp;

    <form action="${pageContext.request.contextPath}/learn/rest/1" method="get">
        <button type="submit" >获取-get</button>
    </form>
    <form action="${pageContext.request.contextPath}/learn/rest/" method="post">
        <button type="submit">新增POST</button>
    </form>
    <form action="${pageContext.request.contextPath}/learn/rest/1" method="post">
        <input type="hidden" name="_method" value="put"/>
        <button type="submit">修改PUT</button>
    </form>
    <form action="${pageContext.request.contextPath}/learn/rest/1" method="post">
        <input type="hidden" name="_method" value="delete"/>
        <button type="submit">删除DELETE</button>
    </form>
</div>

<div style="float: left;clear: both">
    <h3>------------ step-02 mvc---------------------------------</h3>
    <a href="${pageContext.request.contextPath}/learn/mvc/json"> 直接返回json</a>&nbsp;|&nbsp;

    <a href="${pageContext.request.contextPath}/learn/mvc/cn">产生乱码的解决</a>&nbsp;|&nbsp;

    <a href="${pageContext.request.contextPath}/learn/mvc/learnMap">传参</a>&nbsp;|&nbsp;
</div>

</body>
</html>
