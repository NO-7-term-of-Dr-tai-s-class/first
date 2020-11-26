<%@page import="com.MentalhealthTestWechatWeb.entity.MusicsBean"%>
<%@page import="com.MentalhealthTestWechatWeb.entity.VideosBean"%>
<%@page import="com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean"%>
<%@page import="com.MentalhealthTestWechatWeb.entity.UserBean"%>
<%@page import="com.MentalhealthTestWechatWeb.entity.AdminBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String abasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐管理</title>

<jsp:include page="import_js_css.jsp" />

 <!-- 富文本编辑器 -->
<script src="static/ueditor.config.js" type="text/javascript"></script>
  <script src="static/ueditor.all.js" type="text/javascript"></script>
  <script src="static/lang/zh-cn/zh-cn.js" type="text/javascript"></script>

<style type="text/css">
	.textalign{
		text-align: center;
	}
</style>

<script type="text/javascript">

function goPage(page){
	location.href="musicsmana?currentPage="+page;
}

function updateInfo(aid){
	$("#userid1").val(aid);

	$.ajax({
		url:"getMusicsInfoByJId",
		type:"get",
		data:{id:aid},
		dataType:"json",
		success:function(data){
			
			$("#uMtitle").val(data.obj["mtitle"]);
			$("#uMsinger").val(data.obj["msinger"]);
			
			var obj=document.getElementById("upVTypeSelector");
			for(var i =0; i<obj.options.length; i++){
				if($.trim(obj.options[i].value) == $.trim(data.obj["mtname"]))
					obj.options[i].selected=true;
			} 
		}
	});
}

function deleteById(aid){
	if(confirm("是否删除"))
	    window.location="deleteMusicsById?Id="+aid;
}

$(function(){
	
	$.ajax({
		url:"getMusicsTypeInfo",
		type:"get",
		data:{},
		dataType:"json",
		success:function(data){
			var srtEleadd  =  document.getElementById("addVTypeSelector"); 
			var srtEleup  =  document.getElementById("upVTypeSelector"); 
			
		    	for(var i = 0 ;i < data.obj.length;i ++ ) {   
					var option  =  document.createElement("option");   
					var text  =  document.createTextNode(data.obj[i]["mtname"]);   
					option.appendChild(text);   
					option.value = data.obj[i]["mtname"];   
					srtEleadd.appendChild(option); 
		    	}
		    	
		    	for(var j = 0 ;j < data.obj.length;j ++ ) {   
					var option1  =  document.createElement("option");   
					var text1  =  document.createTextNode(data.obj[j]["mtname"]);   
					option1.appendChild(text1);   
					option1.value = data.obj[j]["mtname"];   
					srtEleup.appendChild(option1); 
		    	}
		    	
		    	$("#vtypexiala").val(data.obj[0]["mtname"]);
		    	
		    	srtEleadd.onchange = function(){
		    		var index = srtEleadd.options.selectedIndex;
		    		var value = srtEleadd.options[index].value;
		    		$("#vtypexiala").val(value);
		    		
		    	}
		    	
		    	srtEleup.onchange = function(){
		    		var index = srtEleup.options.selectedIndex;
		    		var value = srtEleup.options[index].value;
		    		$("#vtypexiala").val(value);
		    		
		    	}
			
		}
	});
	
	
	$("#save").click(function () {
		
		var Mtitle = $("#Mtitle").val();
		var Msinger = $("#Msinger").val();
		var filevideopath = $("#filevideopath").val();
		var filepath = $("#filepath").val();
		var vtype = $("#vtypexiala").val();
		
		if(isEmpty(Mtitle) || isEmpty(filevideopath) || isEmpty(filepath)){
			alert("请先添加标题以及图片和视频");
			return;
		}
		
		$.ajax({
			url:"AddMusicsToDB",
			type:"get",
			data : {
				"Mtitle":Mtitle,
				"Msinger":Msinger,
				"filevideopath":filevideopath,
				"filepath":filepath,
				"vtype": vtype
				},
			success:function(msg){
				$('#addMusicsInfoModal').modal('hide');
				 history.go(0);
				 alert(msg.msg);
			}
		}); 
	});
	
	
	$("#update").click(function () {
		var aid = $("#userid1").val();
		
		var Mtitle = $("#uMtitle").val();
		var Msinger = $("#uMsinger").val();
		var filevideopath = $("#ufilevideopath").val();
		var filepath = $("#ufilepath").val();
		var vtype = $("#vtypexiala").val();
		
		if(isEmpty(Mtitle)){
			alert("请先添加标题");
			return;
		}
		
		$.ajax({
			url:"UpMusicsToDB",
			type:"get",
			data : {
				"aid": aid,
				"Mtitle":Mtitle,
				"Msinger":Msinger,
				"filevideopath":filevideopath,
				"filepath":filepath,
				"vtype": vtype
				},
			success:function(msg){
				 $('#upMusicsInfoModal').modal('hide');
				 history.go(0);
				 alert(msg.msg);
			}
		}); 
	});
	

});


function selectClick(){
	var name = encodeURI(encodeURI($("#inputMateName").val())); 
	window.location="SelectMusicsByendname?name="+name;
}

function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}
</script>

</head>
<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<input type="hidden" id="userid1">
	<input type="hidden" id="vtypexiala">
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation"
			style="background:#0371D0; width:300px">
		<div class="sidebar-collapse" style="height: 100%;">
				<jsp:include page="left/left3.jsp" />
				<script type="text/javascript">
					$(".accordion > li:eq(1) > a").first().addClass('active').next().slideDown('normal');
				</script>
		</div>
		</nav>

		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top">
				<div
					style="float: right; line-height: 60px; margin-right: 20px; cursor: pointer;">

					<%
					AdminBean adminBean = null;
						if (session.getAttribute("adminuser") != null) 
							adminBean = (AdminBean) session.getAttribute("adminuser");
					%>

					欢迎:
					<%=adminBean.getAname()%>

				</div>
				</nav>

				<div class="wrapper wrapper-content animated fadeInRight">
					<div class="row" style="margin-left: 60px; margin-top: -20px;">
						<div class="col-sm-12" style="background-size: 100%;">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<h5 style="color: red">业务管理 >> 音乐信息管理</h5>
								</div>
								<div class="ibox-content">
								
									<div  style="margin-left:30px; float: left; width: 100px; ">
										<a  class="btn btn-success" href="javascript:void(0)" data-toggle="modal" 
											data-target="#addMusicsInfoModal">添加</a>
									</div>
									
									<%
										String selectTMName = (String) request.getAttribute("selectName");
									%>

									<div style="margin-bottom: 8px; float: right; width: 30%; height: 20px;">
										<%
											if (!selectTMName.equals("")) {
										%>
										<input type="text" class="form-control" id="inputMateName"
											style="width: 75%; float: left; height: 35px;"
											placeholder="<%=selectTMName%>">
										<%
											} else {
										%>
										<input type="text" class="form-control" id="inputMateName"
											style="width: 75%; float: left; height: 35px;" placeholder="请输入关键字">
										<%
											}
										%>

										<a class="btn btn-success"
											onclick="selectClick()"
											style="float: right; margin-right: 10px; line-height: 20px; ">查询</a>
									</div>

									<table style="margin-top: 45px;"
										class="table table-striped table-bordered table-hover dataTables-example">
										<thead>
											<tr>
												<th class="textalign">图片</th>
												<th class="textalign">名称</th>
												<th class="textalign">演唱者</th>
												<th class="textalign">音乐类型</th>
												<th class="textalign">管理</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<MusicsBean> deps = (List<MusicsBean>) request.getAttribute("musicsmana");
												SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
												for (int i = 0; i < deps.size(); i++) {
												
											%>
											<tr class="gradeA">
												<td class="textalign">
													<img src="/upload<%= deps.get(i).getMimg()  %>" width="50px" height="30px;" >
												</td>
												<td class="textalign"><%=deps.get(i).getMtitle() %></td>
												<td class="textalign"><%=deps.get(i).getMsinger() %></td>
												<td class="textalign"><%=deps.get(i).getMtname() %></td>

												<td class="textalign">
												<a href="javascript:void(0)"
													data-toggle="modal" data-target="#upMusicsInfoModal"
													 onclick="updateInfo(<%=deps.get(i).getMid()%> )">编辑</a> 
												<a
													href="javascript:void(0)"
													onclick="deleteById(<%=deps.get(i).getMid()%> )">删除</a></td>
											</tr>
											<%}%>

										</tbody>
									</table>

								<jsp:include page="importpagingpage.jsp" />

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>




		<!-- 全局js -->
		<script src="static/js/left4/bootstrap.min.js" rel="stylesheet"
			type="text/javascript"></script>
		<script src="static/js/left4/jquery.jeditable.js" rel="stylesheet"
			type="text/javascript"></script>
		<script src="static/js/left4/jquery.dataTables.js" rel="stylesheet"
			type="text/javascript"></script>
		<script src="static/js/left4/dataTables.bootstrap.js" rel="stylesheet"
			type="text/javascript"></script>
		<script src="static/js/left4/content.js" rel="stylesheet"
			type="text/javascript"></script>
		<script src="static/js/left4/layer.min.js" rel="stylesheet"
			type="text/javascript"></script>


		<jsp:include page="musics_add.jsp" />
		<jsp:include page="musics_update.jsp" />
</body>
</html>