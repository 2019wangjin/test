function reload(){
	window.location.reload();
}
function help(msg){
	alert('��ӭʹ��'+msg);
}

function to(url){
	window.location.href=url;
}
function back(){
	history.go(-1);
}
function save(url){
	alert('����ɹ���');
	to(url);
}
function add(url){
	alert('�½��ɹ���');
	to(url);
}
function del(msg){
	if (window.confirm("ȷ��ɾ��"+msg+"��")){
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
url:����·��
params:�������
headers:��Ⱦͷ������
grid����Ⱦ��table
}
 */
function datagrid(obj){
	//����ajax��ȡ����
	
	obj.params = "page="+obj.page+"&"+"rows="+obj.rows;
	
	$.post(
			obj.url,//
			obj.params,
		function(data){
			var result = data.rows;
			var content="";
			//�ж��Ƿ������Ⱦ����
			if(result == null || result.length == 0){
				obj.grid.empty();
				obj.grid.append("<tr><td style='text-align:center'>û�в�ѯ�����ʵ�����</td></tr>");
				return ;
			}
			
			//���˷���
			result = obj.onFilter(result);
			//����ͷ��
			content+="<thead>";
			obj.headers.forEach(function(header){
				content+="<th>";
				content+=header.column;
				content+="</th>";
			})
			content+="</thead>";
			//�������ݲ���
			result.forEach(function(role){
				content+="<tr>";
				//����ͷ��������code��ȡ��Ӧ��ֵ
				obj.headers.forEach(function(header){
					content+="<td>";
					content+=role[header.code];
					content+="</td>";
				})	
				content+="</tr>";
			})
			//��table �ĵײ���ӷ�ҳ
			var p = data.total%obj.rows == 0 ?  data.total/obj.rows : data.total/obj.rows+1;
			
			content +="<tfoot><tr><td colspan="+obj.headers.length+">�� "+data.total+" ����¼ ÿҳ "+obj.rows+" �� ��"+obj.page+" ҳ/�� "+p+" ҳ ��һҳ <a id='lastpage'>��һҳ</a> <a id='nextpage' >��һҳ</a> ���һҳ ת��  ҳ  GO</td></tr> </tfoot>"
			
			
			obj.grid.empty();
			obj.grid.append(content);
			//��һҳ
			$("#nextpage").click(function(){
				obj.page=obj.page+1;
				datagrid(obj);
			})
			//��һҳ
			$("#lastpage").click(function(){
				obj.page=obj.page-1;
				datagrid(obj);
			})
		},
		"json"
	)
}