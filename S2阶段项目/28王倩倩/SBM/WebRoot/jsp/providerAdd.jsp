<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>

<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">添加用户商&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="providerAdd.jsp" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
<input name="flag" value="doAdd" type="hidden">
			<table class="box">

			<tbody>
				<tr>
					<td class="field">供应商姓名：</td>
					<td><input name="providerName" id="textfield2" class="text" type="text"> <font color="red">*</font></td>

				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td><textarea name="proDesc" id="proDesc" cols="45" rows="5"></textarea></td>
				</tr>
				<tr>
					<td class="field">供应商联系：</td>

					<td><input name="contact" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name="phone" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商传真：</td>

					<td><input name="fax" id="textfield2" value="" class="text" type="text"></td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="address" id="textfield2" value="" class="text" type="text"></td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" value="提交" class="input-button" type="submit"> 
			<input name="button" id="button" onclick="window.location='providerAdmin.jsp';" value="返回" class="input-button" type="button"> 
		</div>
	</form>
</div>
</body>
</html>
