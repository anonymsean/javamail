<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/taglibs.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>回复与转发</title>
</head>
<body>
<form action="resMail.do" method="post">
<input type="hidden" name="emailID" value="${ email.emailID }" />
<div align="center">
<strong>回复转发</strong>
<table width="500" border="1">
<tr><td width="150">收信人</td><td width="350">
<input type="text" name="txtFrom" value="${ email.from }" /></td></tr>
<tr><td>标题</td>
<td><input type="text" name="txtTitle" value="${ email.title }" /></td>
</tr>
<tr><td>内容</td><td><textarea rows="5" cols="40" name="txaContent">${ email.content }</textarea></td></tr>
<tr><td colspan="2" align="center"><input type="submit" name="sbtReSend" value="发送"/>
<input type="reset" name="Reset" value="重置" /></td></tr>
</table>
</div>
</form>
</body>
</html>