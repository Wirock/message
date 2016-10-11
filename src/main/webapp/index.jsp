<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>welcome</title>
	</head>
	<body>
		<a href="<%=request.getContextPath() %>/init/talk">自定义聊天</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/list">命令列表</a>
		<br/>
		<a href="<%=request.getContextPath() %>/turing/talk">图灵机器人聊天</a>
	</body>
</html>
