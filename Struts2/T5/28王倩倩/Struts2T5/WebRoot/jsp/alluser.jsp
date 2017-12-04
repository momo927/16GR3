<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alluser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	
	</style>
  </head>
  <body>
 <center>
 	<div>
 		<h2>用户信息列表</h2>
<!--  		<a href="jsp/addUser.jsp">添加用户</a> -->
 		<s:form action="jsp/addUser.jsp" method="post">
 			<table border="1">
 			<tr>
	 			<td>编    号</td>
	 			<td>用户名</td>
	 			<td>密    码</td>
	 			<td>出生日期</td>
	 			<td>联系电话</td>
	 			<td>性   别</td>
	 			<td>是否启用</td>
	 			<td>操   作</td>
 			</tr>
 			<s:iterator value="userlist" var="user">
 			<tr>
	 			<td><s:property value="#user.id"/></td>
	 			<td><s:property value="#user.uname"></s:property></td>
	 			<td><s:property value="#user.upwd"/></td>
	 			<td><s:property value="#user.birthday"/></td>
	 			<td><s:property value="#user.phone"/></td>
	 			<td>
		 			<s:if test='#user.sex == "1"'>
		 				男
		 			</s:if>
		 			<s:else>
		 				女
		 			</s:else>
	 			</td>
	 			<td>
	 			<s:if test='#user.sex == "1"'>
		 				是
		 			</s:if>
		 			<s:else>
		 				否
		 			</s:else>
		 			</td>
	 			<td>
			<a href="toUpdateUser?user.id=${user.id}">修改</a>
			<a href="delectUser?user.id=${user.id}">删除</a>
				</td>
 			</tr>
 			</s:iterator>
 			
 			</table>
 			<a href="jsp/addUser.jsp">添加用户信息</a>
 		</s:form>
 		
 	</div>
</center>
  </body>
</html>
