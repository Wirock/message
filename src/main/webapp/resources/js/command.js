function query(){
	var commandName = document.getElementsByName("commandName")[0].value;
	var description = document.getElementsByName("description")[0].value;
	window.location.href="/autorespond/query?commandName="+commandName+"&description="+description;
}
/**
 * 删除当前项
 */
function deleteOne(path){
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
 * 显示增加一项的填写框
 */
function　addOne(){
	var obj = document.getElementById("add");
	obj.style.display="";
}
/**
 * 确认添加
 */
function confirmAdd(path){
	var com = document.getElementById("addName");
	if(com.value!=null&&com.value!=""){
		if(confirm("确定增加当前项？")){
			var obj = document.getElementById("mainForm");
			obj.action = path;
			obj.submit();
		}
	}else{
		alert("请输入命令名称");
	}
}

/**
 * 取消添加
 */
function undoAdd(){
	var obj = document.getElementsByClassName("add");
	for(var i=0;i<obj.length;i++){
		obj[i].style.display="none";
	}
}

/**
 * 切换修改状态
 */
function update(id,className){
	var obj1 = document.getElementById(id);
	obj1.style.display="none";
	var obj2 = document.getElementsByClassName(className);
	for(var i=0;i<obj2.length;i++){
		obj2[i].style.display="";
	}
}

/**
 * 退出修改状态
 */
function undoUpdate(id,className){
	var obj1 = document.getElementById(id);
	obj1.style.display="";
	var obj2 = document.getElementsByClassName(className);
	for(var i=0;i<obj2.length;i++){
		obj2[i].style.display="none";
	}
}

/**
 * 确认修改并提交
 */
function confirmUpdate(path,commandId,descriptionId){
	var com = document.getElementById(commandId);
	if(com.value!=null&&com.value!=""){
		if(confirm("确定修改当前项？")){
			com.name="updateName";
			document.getElementById(descriptionId).name="updateDescription";
			var obj = document.getElementById("mainForm");
			obj.action = path;
			obj.submit();
		}
	}else{
		alert("命令名称不能为空");
	}
}
/**
 * 跳转页面
 */
function goToPage(path,commandName,description){
	var num = document.getElementById("goToPage").value;
	window.location.href=path+num+"?commandName="+commandName+"&description="+description;
}