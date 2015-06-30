<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/taglibs.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>写信</title>
</head>
<body>
<form action="sendMail.do" enctype="multipart/form-data" metho="post">
<script type="text/javascript" language="javascript">
<!--
function adddContact(type){

var vReturnValue=window.showModalDialog("goselect.jsp",window,"dialogWidth=800px;dialogHeight=600px");
var theform=document.forms[0];
if(vReturnValue==undefined){
	vReturnValue="";
}
if(type=="to"){
	if(theform.txtTo.value==""){
		theform.txtTo.value=vReturnValue;
	}else{
		theform.txtTo.value+=","+vReturnValue;
	}
}else if(type=="cc"){
	if(theform.txtCC.value==""){
		theform.txtCC.value=vReturnValue;
	}else{
		theform.txtCC.value+=","+vReturnValue;
	}
}else{
	if(theform.txtBCC.value==""){
		theform.txtBCC.value=vReturnValue;
	}else{
		theform.txtBCC.value+=","+vReturnValue;
	}
}

}
//-->
</script>
<div align="center">
<strong>写信</strong></br>
<table width="500" border="1">
<tr><td width="150">收信人</td>
<td width="350">
<c:if test="${ groupMails!=null }">
<input type="text" name="txtTo" value="${ groupMails }" />
</c:if>
<c:if test="${ groupMails==null }">
<input type="text" name="txtTo" />
</c:if>
<input type="button" name="sbtAddTo" value="添加" onclick="addContact('to')" /></td></tr>
<tr><td>抄送</td><td><input type="text" name="txtCC" />
<input type="button" name="sbtAddTo" value="添加" onclick="addContact('cc')" /></td></tr>
<tr><td>密送</td><td><input type="text" name="txtBCC" />
<input type="button" name="sbtAddTo" value="密送" onclick="addContact('bcc')" /></td></tr>
<tr><td>附件</td><td><input type="file" name="fileAtt" /></td></tr>
<tr><td>标题</td><td><input type="text" name="txtTitle" /></td></tr>
<tr><td>内容</td><td><textarea name="txaContent" rows="5" cols="40" ></textarea></td></tr>
<tr><td colspan="2"	align="center"><input type="submit" name="sbtSend" value="发送" />
<input type="reset" name="Reset" value="重置" /></td></tr>
</table>
</div>
</form>
</body>
</html>