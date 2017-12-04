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
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
   	<h2>添加用户信息</h2>
   	<s:form action="addUser" namespace="/" method="post">
   	<s:textfield label="用户名" name="user.uname" required="true"></s:textfield>
   	<s:password label="密   码" name="user.upwd" required="true"></s:password>
   	<s:textfield label="出生日期" name="user.birthday" required="true"></s:textfield>
   	<s:textfield label="联系电话" name="user.phone" required="true"></s:textfield>
   	<s:radio label="性   别" name="user.birthday" list="#{1:'男',0:'女'}" value="1"></s:radio>
   	<s:checkbox label="是否启动" name="user.active" fieldValue="true"></s:checkbox>
   	<s:submit value="提  交"></s:submit>
   	<a href="getAllUser">返回用户列表</a>
   	</s:form>
   	</div>
   	</center>
  </body>
</html>
