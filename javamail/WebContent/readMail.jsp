<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="/taglibs.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>读取邮件</title>
</head>
<body>
<div align="center">
<strong>读取邮件 </strong>
<table width="485"	border="1">
<tr><td colspan="2" align="center">
	<a href="#" onclick="javascript:history.back()">返回</a>
	<a href="replyMail.do?emailID=${ email.emailID }">回复</a>
	<a href="fowardMail.do?emailID=${ email.emailID }">转发</a>
	</td></tr>
	<c:if test="${ email!=null }">
		<tr><td width="100">时间 </td>
		<td width="369">${email.mailDate}&nbsp;</td>
		</tr>
		<tr><td>发信人</td><td>${ email.from }&nbsp;</td></tr>
		<tr><td>主题</td><td>${ email.title }&nbsp;</td></tr>
		<tr><td>附件</td>
		<td><c:if test="${ email.attFilePath!=null }">
		<a href="getAttFile.do?emailID=${ email.emailID }">下载</a>
		</c:if>
		<c:if test="${ email.attFilePath=='' }">无</c:if></td></tr>
		<tr><td colspan="2">${ email.content }&nbsp;</td></tr>
	</c:if>
	<c:if test="${ email==null }">
	<tr><td colspan="2">邮件不存在</td></tr>
	</c:if>
</table></div>
</body>
</html>