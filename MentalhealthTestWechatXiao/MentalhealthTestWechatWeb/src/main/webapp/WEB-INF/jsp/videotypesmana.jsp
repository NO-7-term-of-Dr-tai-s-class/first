<%@page import="com.MentalhealthTestWechatWeb.entity.VideoTypesBean"%>
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
<title>电影类型管理</title>

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
	location.href="videotypesmana?currentPage="+page;
}

function updateInfo(aid,vname){
	$("#userid1").val(aid);
	$("#uVtname").val(vname);
	
}

function deleteById(aid){
	if(confirm("是否删除"))
	    window.location="deleteVideoTypesById?Id="+aid;
}

$(function(){
	
	$("#save").click(function () {
		
		var Vtname = $("#Vtname").val();
	
		if(isEmpty(Vtname)){
			alert("请先添加标题");
			return;
		}
		
		$.ajax({
			url:"AddVideoTypesToDB",
			type:"get",
			data : {
				"Vtname":Vtname
				},
			success:function(msg){
				$('#addVideotypesInfoModal').modal('hide');
				 history.go(0);
				 alert(msg.msg);
			}
		}); 
	});
	
	
	$("#update").click(function () {
		var aid = $("#userid1").val();
		
		var Vtname = $("#uVtname").val();
		
		if(isEmpty(Vtname)){
			alert("请先添加标题");
			return;
		}
		
		$.ajax({
			url:"upVideoTypesToDB",
			type:"get",
			data : {
				"aid": aid,
				"Vtname":Vtname
				},
			success:function(msg){
				 $('#upVideotypesInfoModal').modal('hide');
				 history.go(0);
				 alert(msg.msg);
			}
		}); 
	});
});

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
									<h5 style="color: red">业务管理 >> 电影类型信息管理</h5>
								</div>
								<div class="ibox-content">
								
									<div  style="margin-left:30px; float: left; width: 100px; ">
										<a  class="btn btn-success" href="javascript:void(0)" data-toggle="modal" 
											data-target="#addVideotypesInfoModal">添加</a>
									</div>
									
									<table style="margin-top: 45px;"
										class="table table-striped table-bordered table-hover dataTables-example">
										<thead>
											<tr>
												<th class="textalign">类型名称</th>
												<th class="textalign">管理</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<VideoTypesBean> deps = (List<VideoTypesBean>) request.getAttribute("videotypesmana");
												SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
												for (int i = 0; i < deps.size(); i++) {
												
											%>
											<tr class="gradeA">
												<td class="textalign"><%=deps.get(i).getVtname() %></td>

												<td class="textalign"><a href="javascript:void(0)"
													data-toggle="modal" data-target="#upVideotypesInfoModal"
													onclick="updateInfo(
														<%=deps.get(i).getVtid() %>,
														'<%=deps.get(i).getVtname() %>'
													 )">编辑</a> <a
													href="javascript:void(0)"
													onclick="deleteById(<%=deps.get(i).getVtid()%> )">删除</a></td>
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


		<jsp:include page="videotypes_add.jsp" />
		<jsp:include page="videotypes_update.jsp" />
</body>
</html>