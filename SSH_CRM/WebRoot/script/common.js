function reload(){
	window.location.reload();
}
function help(msg){
	alert('欢迎使用'+msg);
}

function to(url){
	window.location.href=url;
}
function back(){
	history.go(-1);
}
function save(url){
	alert('保存成功！');
	to(url);
}
function add(url){
	alert('新建成功！');
	to(url);
}
function del(msg){
	if (window.confirm("确认删除"+msg+"？")){
		reload();
	}
}
function setCurTime(oid){
	var now=new Date();
	var year=now.getFullYear();
	var month=now.getMonth();
	var day=now.getDate();
	var hours=now.getHours();
	var minutes=now.getMinutes();
	var seconds=now.getSeconds();
	var timeString = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
	var oCtl = document.getElementById(oid);
	oCtl.value = timeString;
}

/*
 * 
{
url:请求路径
params:请求参数
headers:渲染头部内容
grid：渲染的table
}
 */
function datagrid(obj){
	//发送ajax获取数据
	
	obj.params = "page="+obj.page+"&"+"rows="+obj.rows;
	
	$.post(
			obj.url,//
			obj.params,
		function(data){
			var result = data.rows;
			var content="";
			//判断是否存在渲染数据
			if(result == null || result.length == 0){
				obj.grid.empty();
				obj.grid.append("<tr><td style='text-align:center'>没有查询到合适的数据</td></tr>");
				return ;
			}
			
			//过滤方法
			result = obj.onFilter(result);
			//构建头部
			content+="<thead>";
			obj.headers.forEach(function(header){
				content+="<th>";
				content+=header.column;
				content+="</th>";
			})
			content+="</thead>";
			//构建内容部分
			result.forEach(function(role){
				content+="<tr>";
				//遍历头部，根据code获取对应的值
				obj.headers.forEach(function(header){
					content+="<td>";
					content+=role[header.code];
					content+="</td>";
				})	
				content+="</tr>";
			})
			//在table 的底部添加分页
			var p = data.total%obj.rows == 0 ?  data.total/obj.rows : data.total/obj.rows+1;
			
			content +="<tfoot><tr><td colspan="+obj.headers.length+">共 "+data.total+" 条记录 每页 "+obj.rows+" 条 第"+obj.page+" 页/共 "+p+" 页 第一页 <a id='lastpage'>上一页</a> <a id='nextpage' >下一页</a> 最后一页 转到  页  GO</td></tr> </tfoot>"
			
			
			obj.grid.empty();
			obj.grid.append(content);
			//上一页
			$("#nextpage").click(function(){
				obj.page=obj.page+1;
				datagrid(obj);
			})
			//下一页
			$("#lastpage").click(function(){
				obj.page=obj.page-1;
				datagrid(obj);
			})
		},
		"json"
	)
}