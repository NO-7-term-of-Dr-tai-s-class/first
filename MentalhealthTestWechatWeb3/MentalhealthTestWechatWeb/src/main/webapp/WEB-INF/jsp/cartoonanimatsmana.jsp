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
<title>用户管理</title>

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
	location.href="cartoonanimatsmana?currentPage="+page;
}

$(function(){
	   UE.getEditor('myAddEditor');
	});

function updateInfo(aid){
	$("#userid1").val(aid);
	
	$.ajax({
		url:"getCartoonanimatsInfoByJId",
		type:"get",
		data:{id:aid},
		dataType:"json",
		success:function(data){
			
			$("#uCtitle").val(data.obj["ctitle"]);
			$("#uCjianjie").val(data.obj["cjianjie"]);
			$("#uCauthor").val(data.obj["cauthor"]);
			
			var ue = UE.getEditor('myUpEditor');
		    ue.addListener("ready", function () {
	        ue.setContent(data.obj["ccont"]);
	        
		     });
		    //ue.setContent(data.obj["ccont"]);
		    
		    //alert($.trim(data.obj["cflag"]))
		    
		    $("input[name='uCflag']").each(function(){
				if( $.trim($(this).val()) == $.trim(data.obj["cflag"]) ){
					$(this).attr("checked",true);
				}
			});
			
		}
	});
}

function deleteById(aid){
	if(confirm("是否删除"))
	    window.location="deleteCartoonanimatsById?Id="+aid;
}

$(function(){
	
	  $("input[name='Cflag']").each(function(){
			if( $.trim($(this).val()) == $.trim("1") ){
				$(this).attr("checked",true);
			}
		});
	
	$("#save").click(function () {
		
		var Ctitle = $("#Ctitle").val();
		var Cjianjie = $("#Cjianjie").val();
		var Cauthor = $("#Cauthor").val();
		var Cimg = $("#filepath").val();
		var Cpath = $("#filevideopath").val();
		var Cflag = $("input[name='Cflag']:checked").val();
		
		var ue = UE.getEditor('myAddEditor');
		var Ccont = ue.getContent();
		Ccont = Ccont.replace(new RegExp("<","g"),"<").replace(new RegExp(">","g"),">").replace(new RegExp('\"',"g"),'"');
		
		if(isEmpty(Ctitle) || isEmpty(Cimg) || isEmpty(Cpath)){
			alert("请先添加标题以及图片和视频");
			return;
		}
		
		$.ajax({
			url:"AddCartoonanimatsToDB",
			type:"get",
			data : {
				"Ctitle":Ctitle,
				"Cpath":Cpath,
				"Cjianjie":Cjianjie,
				"Cauthor":Cauthor,
				"Cimg":Cimg,
				"Ccont":Ccont,
				"Cflag":Cflag
				},
			success:function(msg){
				$('#addCartoonanimatsInfoModal').modal('hide');
				 history.go(0);
				 alert(msg.msg);
			}
		}); 
	});
	
	
	$("#vuserup").click(function () {
		var aid = $("#userid1").val();
		
		var Ctitle = $("#uCtitle").val();
		var Cjianjie = $("#uCjianjie").val();
		var Cauthor = $("#uCauthor").val();
		var Cimg = $("#ufilepath").val();
		var Cpath = $("#ufilevideopath").val();
		var Cflag = $("input[name='uCflag']:checked").val();
		
		var ue = UE.getEditor('myUpEditor');
		var Ccont = ue.getContent();
		Ccont = Ccont.replace(new RegExp("<","g"),"<").replace(new RegExp(">","g"),">").replace(new RegExp('\"',"g"),'"');
		
		if(isEmpty(Ctitle)){
			alert("请先添加标题");
			return;
		}
		
		$.ajax({
			url:"UpCartoonanimatsToDB",
			type:"get",
			data : {
				"aid": aid,
				"Ctitle":Ctitle,
				"Cpath":Cpath,
				"Cjianjie":Cjianjie,
				"Cauthor":Cauthor,
				"Cimg":Cimg,
				"Ccont":Ccont,
				"Cflag":Cflag
				},
			success:function(msg){
				 $('#upCartoonanimatsInfoModal').modal('hide');
				 history.go(0);
				 alert(msg.msg);
			}
		}); 
	});
});


function selectClick(){
	var name = encodeURI(encodeURI($("#inputMateName").val())); 
	window.location="SelectCartoonanimatsByendname?name="+name;
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
									<h5 style="color: red">业务管理 >> 漫画动画信息管理</h5>
								</div>
								<div class="ibox-content">
								
									<div  style="margin-left:30px; float: left; width: 100px; ">
										<a  class="btn btn-success" href="javascript:void(0)" data-toggle="modal" 
											data-target="#addCartoonanimatsInfoModal">添加</a>
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
												<th class="textalign">添加日期</th>
												<th class="textalign">作者</th>
												<th class="textalign">简介</th>
												<th class="textalign">类型</th>
												<th class="textalign">管理</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<CartoonanimatsBean> deps = (List<CartoonanimatsBean>) request.getAttribute("cartoonanimatsmana");
												SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
												for (int i = 0; i < deps.size(); i++) {
												
											%>
											<tr class="gradeA">
												<td class="textalign">
													<img src="/upload<%= deps.get(i).getCimg()  %>" width="50px" height="30px;" >
												</td>
												<td class="textalign"><%=deps.get(i).getCtitle() %></td>
												<td class="textalign"> <%= dateformat2.format(deps.get(i).getCdate()) %> </td>
												<td class="textalign"><%=deps.get(i).getCauthor() %></td>
												<td class="textalign"><%=deps.get(i).getCjianjie() %></td>
												
												<%
												    if(deps.get(i).getCflag() == 1){
												%>
													<td class="textalign">漫画</td>
												<%}else{ %>
													<td class="textalign">动画</td>
												<%}%>

												<td class="textalign"><a href="javascript:void(0)"
													data-toggle="modal" data-target="#upCartoonanimatsInfoModal"
													onclick="updateInfo(<%=deps.get(i).getCid()%> )">编辑</a> <a
													href="javascript:void(0)"
													onclick="deleteById(<%=deps.get(i).getCid()%> )">删除</a></td>
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


		<jsp:include page="cartoonanimats_add.jsp" />
		<jsp:include page="cartoonanimats_update.jsp" />
</body>
</html>