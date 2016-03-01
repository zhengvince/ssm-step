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
        <br>
    <a href="${pageContext.request.contextPath}/learn/cn">使用@ResponseBody时，产生乱码的解决</a>

  </body>
</html>
