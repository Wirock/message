<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>微信公众号</title>
	<!--讨论区滚动条begin-->
	<link rel="stylesheet" type="text/css" href="<%= basePath %>resources/css/jscrollpane1.css" />
	<script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js" type="text/javascript"></script>
	<!-- the mousewheel plugin -->
	<script type="text/javascript" src="<%= basePath %>resources/js/common/jquery.mousewheel.js"></script>
	<!-- the jScrollPane script -->
	<script type="text/javascript" src="<%= basePath %>resources/js/common/jquery.jscrollpane.min.js"></script>
	<script type="text/javascript" src="<%= basePath %>resources/js/common/scroll-startstop.events.jquery.js"></script>
	<!--讨论区滚动条end-->
	<script type="text/javascript" src="<%= basePath %>resources/js/talk.js"></script>
	</head>
	<body>
		<input type="hidden" value="<%= basePath %>" id="basePath"/>
		<br/>
		<div class="talk">
			<div class="talk_title"><span>正在与公众号对话</span></div>
			<div class="talk_record">
				<div id="jp-container" class="jp-container">
					
				</div>
			</div>
			
			<div class="talk_word">
				&nbsp;
				<input class="add_face" id="facial" type="button" title="添加表情" value="" />
				<input id="content" class="messages emotion"   />
				<input class="talk_send" onclick="send();" type="button" title="发送" value="发送" />
			</div>
		</div>
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
	</body>
</html>