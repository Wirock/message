<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%=request.getContextPath() %>/resources/css/content.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/content.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%=request.getContextPath() %>/servlet/ListServlet" id="mainForm" method="post">
			<input type="hidden" name="token" value="${sessionScope.token}"/>
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn" href="javascript:addOne(${contentList.size()+1 });">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn" href="javascript:deleteBatch(&quot;<%=request.getContextPath() %>/content/multideletion?commandId=${commandId}&quot;);">删 除</a></p>
					
					<div class="main">
						<table class="tab">
							<tbody>
								<tr>
									<th class="name">指令名称</th>
								    <th class="box"></th>
								    <th class="number">序号</th>
								    <th class="content">内容</th>
								    <th class="operation">操作</th>
								</tr>
		
								<c:forEach items="${contentList}" var="commandContent" varStatus="status">
									<tr id="content${status.index+1}" <c:if test="${status.index%2==0}">style="background-color:#ECF6EE;"</c:if>>	
										<c:if test="${status.index==0}">
											<td id="commandName" rowspan="${contentList.size()}">${command}</td>
										</c:if>
										<td><input type="checkbox" name="ids" value="${commandContent.id}"/></td>
										<td>${status.index+1}</td>
										<td>${commandContent.content}</td>
										<td>
											<a href="javascript:updateContent('content${status.index+1}','update${status.index+1}');">修改</a>&nbsp;&nbsp;&nbsp;
											<a href="javascript:deleteContent(&quot;<%=request.getContextPath() %>/content/deletion?contentId=${commandContent.id}&commandId=${commandId}&quot;);">删除</a>&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									
									<tr id="update${status.index+1}" style="background-color:#ECF6EE;display:none;">
									<c:if test="${status.index==0}">
											<td id="updateCommandName" rowspan="${contentList.size()}">${command}</td>
									</c:if>
									<td style="color:red;">update</td>
									<td>${status.index+1}</td>
									<td height="80px"><textarea id="updateContent${status.index+1}" rows="4" cols="60" >${commandContent.content}</textarea></td>
									<td style="border-left:1px solid #ddd;">
										<a href= "javascript:confirmUpdate('<%=request.getContextPath() %>/content/update?updateId=${commandContent.id }&commandId=${commandContent.commandId }','updateContent${status.index+1}');">确认</a>&nbsp;&nbsp;&nbsp;
										<a href= "javascript:undoUpdate('content${status.index+1}','update${status.index+1}');">取消</a>
									</td>
									</tr>
								</c:forEach>
								
								<tr id="add" style="background-color:#ECF6EE;display:none;">
								<c:if test="${contentList.size()==0}">
									<td >${command}</td>
								</c:if>
								<td style="color:red;">new</td>
								<td>${contentList.size()+1 }</td>
								<td><textarea rows="4" cols="70" name="newContent" id="newContent" style="border:1px solid grey;margin:0;"></textarea></td>
								<td style="border-left:1px solid #ddd;"><a href="javascript:confirmAdd(&quot;<%=request.getContextPath() %>/content/addition?commandId=${commandId}&quot;);">确认</a>&nbsp;&nbsp;&nbsp;<a href= "javascript:undoAdd();">取消</a></td>
								</tr>
								
							</tbody>
						</table>
						
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>