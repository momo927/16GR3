<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  
  <body>
  <c:if test="${!empty param.loginMsg }">
  <script type="text/javascript">
  alert("用户名或密码错误，请重新登录！");
  </script>
  </c:if>
    <div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form id="fromLogin" method="post" action="user?cmd=login">
			<dl>
				<dt>用户名：</dt>
				<dd><input id="userName" type="text" name="userName" class="input-text" /></dd>
				<dt>密　码：</dt>
				<dd><input id="passWord" type="password" name="passWord" class="input-text" /></dd>
			</dl>
			<div class="buttons">
				<input type="submit" name="submit" value="登录系统" class="input-button" onclick="fromCheck()" />
				<input type="reset" name="reset" value="注　　册" class="input-button" />
			</div>
		</form>
	</div>
</div>
    <script type="text/javascript">
    function fromCheck(){
    //获取表格id，用户id，密码id
    var fromLogin=document.getElementById("fromLogin");
    var userName=document.getElementById("userName");
    var passWord=document.getElementById("passWord");
    //判断用户名和密码是否为空
    if(userName != null && passWord != null && userName != "" && passWord != ""){
   		//不为空提交
   		 	fromLogin.submit();
    }else{
    	//空，弹框
    		alert("用户名或密码不能为空，请重新登录！");
    }
    }
    </script>
  </body>
</html>
