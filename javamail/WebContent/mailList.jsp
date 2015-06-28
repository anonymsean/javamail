<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ include file="/taglibs.inc.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>邮件列表</title>
</head>
<body>
	<div align="center">
	<strong>邮件列表</strong>
	<table width="695" border="0">
	<tr><th width="172" bgcolor="#CCFFFF" scope="col">发信人</th>
			<th width="270" bgcolor="#CCFFFF" scope="col">主题</th>
			<th width="156" bgcolor="#CCFFFF" scope="col">时间</th>
			<th width="89" bgcolor="#CCFFFF" scope="col">删除</th></tr>
	<c:if test="${eMailList!=null}">
	<c:forEach items="${eMailList}" var="mail">
	<tr><td>${mail.from}</td>
	<td><a href="readMail.do?emailID=${mail.emailID}">${mail.title}</a></td>
	<td>${mail.mailDate}</td>
	<td><a href="killMail.do?emailID=${mail.emailID}">删除</a></td></tr>
	</c:forEach>
	</c:if>	
	<c:if test="${ eMailList==null }">
	<tr><td align="center" colspan="4">没有邮件 !</td></tr>	</c:if>	
	</table>
	</div>
</body>
</html>