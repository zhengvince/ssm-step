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
<h1>learn.index.jsp</h1>
<a href="${pageContext.request.contextPath}/learn/json">使用 @ResponseBody 直接返回json</a>
<br><br>
<a href="${pageContext.request.contextPath}/learn/cn">使用@ResponseBody时，产生乱码的解决</a>
<br><br>
<a href="${pageContext.request.contextPath}/learn/learnMap">传参</a>

<p></p>
--------------------------------------------------------------------------
<p> REST风格的url映射</p>

<p> 获取: /rest/1 GET</p>
<p> 新增: /rest POST</p>
<p> 修改: /rest/1 PUT</p>
<p> 删除: /rest/1 DELETE</p>
--------------------------------------------------------------------------
<br>
<br>
<a href="${pageContext.request.contextPath}/learn/rest/1">获取-get</a>
<br>
<br>

<form action="${pageContext.request.contextPath}/learn/rest" method="post">
    <button type="submit">新增POST</button>
</form>
<br>

<form action="${pageContext.request.contextPath}/learn/rest/1" method="post">
    <input type="hidden" name="_method" value="put"/>
    <button type="submit">修改PUT</button>
</form>
<br>

<form action="${pageContext.request.contextPath}/learn/rest/1" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <button type="submit">删除DELETE</button>
</form>
<br>
</body>
</html>
