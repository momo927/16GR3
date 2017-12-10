<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function checkit()
{
	//判断是否是数字的正则表达式
	return true;
}
</script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="user?cmd=uploadPic" enctype="multipart/form-data" onsubmit="return checkit();">
<input type="hidden" name="flag" value="doAdd">
		<div class="content">
			<table class="box"><font color="red"></font>
			<tr>
					<td class="field">用户姓名：</td>
					<td><input type="text" name="userName" id="userName" class="text"/>
					 <font color="red">*</font></td>

				</tr>
			<tr>
					<td class="field">用户密码：</td>
					<td><input type="text" name="passWord" class="text" id="userPassWord" /> 
					<font color="red">*</font></td>
				</tr>
				
			<tr>
					<td class="field">确认密码：</td>
					<td><input type="passWord" name="userPassWord2" id="userPassWord2" class="text"/> 
					<font color="red">*</font></td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
					<td><select name="userSex" id="userSex">
    <option selected=selected value="F">女</option>
    <option value="M">男</option>
  </select></td>
				</tr>

				<tr>
					<td class="field">用户年龄：</td>
					<td><input type="text" name="userAge" class="text" id="userAge"/>
					 <font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="phone" class="text" id="phone"/> 
					<font color="red">*</font></td>

				</tr>
				
				<tr>
					<td class="field">用户地址：</td>
					<td><textarea name="address" id="address" class="text" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="type" id="type" value="0" checked="checked"/>普通用户
					<input type="radio" name="type" id="type" value="1" />经理</td>
				</tr>
				<tr>
					<td class="field">用户头像：</td>
					<td><input type="button" value="选择头像" name="button" class="text" id="button"/> 
					<font color="red">*允许图片的格式为：png,jpg,jpeg,gif;最大值为5M</font></td>

				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="button" id="button" value="数据提交" class="input-button" onclick="checkForm();" />
			  <input type="button" name="button" id="button" onclick="window.location='userAdmin.jsp';" value="返回" class="input-button"/> 
		</div> 
		<script type="text/javascript">
		function checkForm() {
			var form1 = document.getElementById("form1");
			var userPassWord = document.getElementById("userPassWord").value;
			var userPassWord2 = document.getElementById("userPassWord2").value;
			if(
			check("userName") &&
			check("userPassWord") &&
			check("userPassWord2") &&
			check("userSex") &&
			check("userAge") &&
			check("phone") &&
			check("address") &&
			check("type") &&
			check("pic") 
			){
			if(userPassWord == userPassWord2){
				//密码验证通过
				from1.submit();
			}else{
				alert("输入密码不一致，请重新输入！");
			}
		}else{
			alert("请填入完整的信息！");
		}
		}
		function check(id){
			var suiyi=document.getElementById(id).value;
			if(suiyi != null && suiyi != ""){
				return true;
			}else{
			return false;
			}
		}
		</script>

	</form>
</div>
</body>
</html>
