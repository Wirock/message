<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>命令列表页面</title>
<link href="<%=request.getContextPath()%>/resources/css/all.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/command.js"></script>
</head>
<body style="background: #e1e9eb;">
	<div class="right">
		<div class="current">
			当前位置：<a href="javascript:void(0);" style="color: #6E6E6E;">内容管理</a>
			&gt; 内容列表
		</div>
		<div class="rightCont">
			<p class="g_title fix">
				命令列表 <a class="btn03" href="javascript:addOne();">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
					class="btn03"
					href="javascript:deleteBatch(&quot;<%=request.getContextPath()%>/command/multideletion&quot;);">删
					除</a>
			</p>
			<table class="tab1">
				<tbody>
					<tr>
						<td width="90" align="right">指令名称：</td>
						<td><input name="commandName" type="text" class="allInput"
							value="${commandName}" /></td>
						<td width="90" align="right">描述：</td>
						<td><input name="description" type="text" class="allInput"
							value="${description}" /></td>
						<td width="85" align="right"><input type="button"
							class="tabSub"  value="查 询" onclick="javascript:query();"/></td>
					</tr>
				</tbody>
			</table>
			<form action="" id="mainForm" method="post">
				<input type="hidden" name="token" value="${sessionScope.token}"/>
				<div class="zixun fix">
					<table class="tab2">
						<tbody>
							<tr>
								<th></th>
								<th>序号</th>
								<th>指令名称</th>
								<th>描述</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${commandList}" var="commandBean"
								varStatus="status">
								<tr id="message${status.index+page.offsetIndex+1}"
									<c:if test="${status.index%2==0}">style="background-color:#ECF6EE;"</c:if>>
									<td><input type="checkbox" name="ids"
										value="${commandBean.id}" /></td>
									<td>${status.index+page.offsetIndex+1}</td>
									<td>${commandBean.name}</td>
									<td>${commandBean.description}</td>
									<td><a
										href="javascript:update('message${status.index+1}','update${status.index+1}');">修改</a>&nbsp;&nbsp;&nbsp;
										<a
										href="javascript:deleteOne(&quot;<%=request.getContextPath() %>/command/deletion?commandId=${commandBean.id}&quot;);">删除</a>&nbsp;&nbsp;&nbsp;

										<input type="hidden" name="contentList${commandBean.id}"
										value="${contentList }" /> <input type="hidden"
										name="commandName${commandBean.id}"
										value="${commandBean.name }" /> <a
										href="<%=request.getContextPath() %>/${commandBean.id }/content">查看内容</a>
									</td>
								</tr>

								<tr class="update${status.index+1}"
									style="background-color: #ECF6EE; display: none;">
									<td style="color: red;">update</td>
									<td>${status.index+1}</td>
									<td><input id="updateCommand${status.index+1}" type="text"
										style="border: 1px solid grey;" value="${commandBean.name}" /></td>
									<td><input type="text"
										id="updateDescription${status.index+1}"
										style="border: 1px solid grey;"
										value="${commandBean.description}" /></td>
									<td style="border-left: 1px solid #ddd;"><a
										href="javascript:confirmUpdate(&quot;<%=request.getContextPath() %>/command/update?updateId=${commandBean.id }&quot;,'updateCommand${status.index+1}','updateDescription${status.index+1}');">确认</a>&nbsp;&nbsp;&nbsp;<a
										href="javascript:undoUpdate('message${status.index+1}','update${status.index+1}');">取消</a></td>
								</tr>
							</c:forEach>

							<tr id="add" style="background-color: #ECF6EE; display: none;">
								<td style="color: red;">new</td>
								<td>${commandList.size()+1 }</td>
								<td><input id="addName" type="text" name="addName"
									style="border: 1px solid grey; margin: 0;" /></td>
								<td><input type="text" name="addDescription"
									style="border: 1px solid grey; margin: 0;" /></td>
								<td style="border-left: 1px solid #ddd;"><a
									href="javascript:confirmAdd(&quot;<%=request.getContextPath()%>/command/addition&quot;);">确认</a>&nbsp;&nbsp;&nbsp;<a
									href="javascript:undoAdd();">取消</a></td>
							</tr>
						</tbody>
					</table>

					<div class='page fix'>
						共 <b>${page.totalCount}</b> 条 <a href='<%=request.getContextPath() %>/${page.totalCount}/page1?commandName=${commandName }&description=${description}' class='first'>首页</a> <a href='<%=request.getContextPath() %>/${page.totalCount}/page${page.currentPage-1}?commandName=${commandName }&description=${description}'
							class='pre'>上一页</a> 当前第<span>${page.currentPage }/${page.totalPages }</span>页 <a href='<%=request.getContextPath() %>/${page.totalCount}/page${page.currentPage+1}?commandName=${commandName }&description=${description}'
							class='next'>下一页</a> <a href='<%=request.getContextPath() %>/${page.totalCount}/page${page.totalPages}?commandName=${commandName }&description=${description}' class='last'>末页</a> 跳至&nbsp;<input
							type='text' value='1' id="goToPage" class='allInput w28' />&nbsp;页&nbsp; <a
							href='javascript:goToPage("<%=request.getContextPath() %>/${page.totalCount}/page","${commandName }","${description }")' class='go'>GO</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>