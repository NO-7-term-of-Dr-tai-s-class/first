<%@page import="com.MentalhealthTestWechatWeb.entity.AdminBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息管理</title>
 
<jsp:include page="import_js_css.jsp" />

<script type="text/javascript">
 
function updateOneInfo(aid){
	$("#userid").val(aid);
	
	$.ajax({
		url:"getAdminUserInfoByAId",
		type:"get",
		data:{id:aid},
		dataType:"json",
		success:function(data){
			$("#uaUserName").val(data.obj["aname"]);
			$("#uauserpwd").val(data.obj["apwd"]);
			$("#uainputtel").val(data.obj["atel"]);
		}
	});
}

	$(function(){
		
		$("#userup").click(function () {
			var uname = $("#uaUserName").val();
			var upwd = $("#uauserpwd").val();
		    var utel = $("#uainputtel").val();
			
			if(isEmpty(utel)){
				alert("电话不能为空，请确认一下！");
				return;
			}
			
			$.ajax({
				url:"upAdminOneselfToDB",
				type:"get",
				data : {
					uname: uname,
					upwd: upwd,
					utel: utel
					},
				success:function(msg){
					 $('#upAdminUserInfoModal').modal('hide');
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

<input type="hidden" id="userid" >

	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation"
			style="background:#0371D0; width:300px">
			<div class="sidebar-collapse" style="height: 100%;">
				<jsp:include page="left/left3.jsp" />
				<script type="text/javascript">
					$(".accordion > li:eq(0) > a").first().addClass('active').next().slideDown('normal');
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
									<h5 style="color:red">用户管理 >> 个人信息管理</h5>
								</div>
								<div class="ibox-content">
									<table
										class="table table-striped table-bordered table-hover dataTables-example">
										<thead>
											<tr>
												<th class="textalign">姓名</th>
												<th class="textalign">登录密码</th>
												<th class="textalign">电话</th>
												<th class="textalign">管理</th>
											</tr>
										</thead>
										<tbody>
											<%
												AdminBean s2 = (AdminBean) request.getAttribute("requestadminuser");
											%>
											<tr class="gradeA">
												<td class="textalign"><%=s2.getAname() %></td>
												<td class="textalign"><%=s2.getApwd() %></td>
												<td class="textalign"><%=s2.getAtel() %></td>

												<td class="textalign">
													<a href="javascript:void(0)" data-toggle="modal" data-target="#upAdminUserInfoModal" 
														onclick="updateOneInfo(
															<%=s2.getAid() %> 
													)">编辑</a>
												</td>
											</tr>

										</tbody>
									</table>



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
			
			<jsp:include page="admin_users_update.jsp" />

</body>
</html>