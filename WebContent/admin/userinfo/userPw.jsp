<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
            function check()
            {
                 var userPwReal="${sessionScope.user.userPw}";
                 if(document.formPw.userPw.value !=userPwReal)
                 {
                     alert("原密码不正确");
                     return ;
                 }
                 
                 if(document.formPw.userPw1.value =="")
                 {
                     alert("新密码不能空");
                     return ;
                 }
                 document.getElementById("indicator").style.display="block";
                 //loginService.adminPwEdit(document.formPw.userPw1.value,callback);
                 var a=document.getElementById("userPw1").value;
                 window.location.href="<%=path %>/adminPwEdit?userPw1="+a;
            }
            function callback(data)
            {
                document.getElementById("indicator").style.display="none";
                alert("修改成功");
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form method="post" name="formPw">
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;修改密码&nbsp;</td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         登录名：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="text" value="${sessionScope.user.userName }" name="userName" size="20" disabled="disabled"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        原密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" name="userPw" id="userPw" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				         新密码：
				    </td>
				    <td width="75%" bgcolor="#FFFFFF">
				        <input type="password" id="userPw1" name="userPw1" size="22"/>
				    </td>
				</tr>
				<tr bgcolor="#FFFFFF">
				    <td width="25%" bgcolor="#FFFFFF" align="right">
				        &nbsp;
				    </td>
			        <td width="75%" bgcolor="#FFFFFF">
			             <input type="button" value="修改" onclick="check()"/>
			             &nbsp;&nbsp;&nbsp;
			             <input type="reset" value="重置"/>
			             <img id="indicator" src="<%=path %>/img/loading.gif" alt="Loading..." style="display:none"/>
			        </td>
				</tr>
			</table>
			</form>
			
			
   </body>
</html>
