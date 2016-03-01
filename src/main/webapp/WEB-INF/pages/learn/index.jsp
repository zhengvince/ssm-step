<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 16/2/29
  Time: 下午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm</title>
</head>
<body>
<h1>------------ step-02 mvc---------------------------------</h1>
<a href="${pageContext.request.contextPath}/learn/json">使用 @ResponseBody 直接返回json</a>
<br><br>
<a href="${pageContext.request.contextPath}/learn/cn">使用@ResponseBody时，产生乱码的解决</a>
<br><br>
<a href="${pageContext.request.contextPath}/learn/learnMap">传参</a>

<h1>------------ step-03 rest-------------------------------</h1>
<p> REST风格的url映射</p>
获取: /rest/1 GET<br>
<a href="${pageContext.request.contextPath}/learn/rest/1">获取-get</a>
<br>
<br>
新增: /rest POST
<form action="${pageContext.request.contextPath}/learn/rest" method="post">
    <button type="submit">新增POST</button>
</form>
<br>
修改: /rest/1 PUT
<form action="${pageContext.request.contextPath}/learn/rest/1" method="post">
    <input type="hidden" name="_method" value="put"/>
    <button type="submit">修改PUT</button>
</form>
<br>
删除: /rest/1 DELETE
<form action="${pageContext.request.contextPath}/learn/rest/1" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <button type="submit">删除DELETE</button>
</form>
<br>
<h1>------------ step-04 log4j-------------------------------</h1>
<a href="${pageContext.request.contextPath}/learn/log">log</a>
<a href="${pageContext.request.contextPath}/learn/log/debug">debug</a>
<a href="${pageContext.request.contextPath}/learn/log/error">error</a>
</body>
</html>
