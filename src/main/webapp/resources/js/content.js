/**
 * 删除当前项
 */
function deleteContent(path){
	if(confirm("确定要删除此项？")){
		alert("删除成功！");
		var obj = document.getElementById("mainForm");
		obj.action=path;
		obj.submit();
	}
}
/**
 * 批量删除
 */
function deleteBatch(path){
	if(confirm("确定要删除选中的所有项？")){
		alert("删除成功！");
		var obj = document.getElementById("mainForm");
		obj.action=path;
		obj.submit();
	}
}
/**
 * 增加一项
 */
function　addOne(size){
	var obj1 = document.getElementById("add");
	var obj2 = document.getElementById("commandName");
	obj1.style.display="";
	obj2.rowSpan=size;
}

/**
 * 确认添加
 */
function confirmAdd(path){
	var con = document.getElementById("newContent");
	if(con.value!=null&&con.value!=""){
		if(confirm("确定增加当前内容？")){
			var obj = document.getElementById("mainForm");
			obj.action = path;
			obj.submit();
		}
	}else{
		alert("请输入内容");
	}
}

/**
 * 取消添加
 */
function undoAdd(){
	var obj = document.getElementById("add");
		obj.style.display="none";
}
/**
 * 切换修改状态
 */
function updateContent(id,updateId){
	var obj1 = document.getElementById(id);
	obj1.style.display="none";
	var obj2 = document.getElementById(updateId);
	obj2.style.display="";
}

/**
 * 退出修改状态
 */
function undoUpdate(id,updateId){
	var obj1 = document.getElementById(id);
	obj1.style.display="";
	var obj2 = document.getElementById(updateId);
	obj2.style.display="none";
}

/**
 * 确认修改并提交
 */
function confirmUpdate(path,contentId){
	var con = document.getElementById(contentId);
	if(con.value!=null&&con.value!=""){
		if(confirm("确定修改当前项？")){
			con.name="updateContent";
			var obj = document.getElementById("mainForm");
			obj.action = path;
			obj.submit();
		}
	}else{
		alert("内容不能为空");
	}
}