<%@ page language="java" pageEncoding="UTF-8"%>
普通用户可访问<a href="<%=request.getContextPath()%>/mydemo/getUserInfo" target="_blank">用户信息页面</a>
<br/>
<br/>
管理员可访问<a href="<%=request.getContextPath()%>/admin/listUser.jsp" target="_blank">用户列表页面</a>
<br/>
<br/>
<a href="<%=request.getContextPath()%>/mydemo/logout" target="_blank">Logout</a>  