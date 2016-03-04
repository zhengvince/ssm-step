<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table {
	margin: 0 auto;
	margin-top: 130px;
	border: 1px solid black;
}

.title {
	text-align: center;
}

.left {
	text-align: right;
}

.center {
	text-align: center;
	padding-top: 5px;
	padding-bottom: 5px;
}

tr {
	border: 1px solid black;
}

td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<form action="./app/user/login" method="post">
		<table>
			<tr>
				<td colspan="2" class="title"><span>Test Page</span>
				</td>
			</tr>
			<tr>
				<td class="left">username:</td>
				<td><input type="text" name="username" />
				</td>
			</tr>
			<tr>
				<td class="left">password:</td>
				<td><input type="text" name="password" /></td>
			</tr>
            <tr>
                <td class="left">Remember Me</td>
                <%-- rememberMe，password，username字段名是shiro默认的--%>
                <td><input type="checkbox" name="rememberMe" value="true"/></td>
            </tr>
			<tr class="center">
				<td colspan="2"><input type="submit" value="submit" />&nbsp;&nbsp;&nbsp;
					<input type="reset" value="reset" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
