<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
	<form action="userlogin.lgn" method="post">
		<div align="center">
		<h1>用户登录</h1>
		<table width="300" border="1">
		<tr><td width="86">用户名</td>
		<td width="198"><input type="text" name="txtUserID" /></td>
		</tr>
		<tr><td>密码</td>
		<td><input type="password" name="pwdUserPWD" /></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" name="Submit" value="登录" />
		</td></tr>
		</table>
		</div>	
	</form>
</body>
</html>