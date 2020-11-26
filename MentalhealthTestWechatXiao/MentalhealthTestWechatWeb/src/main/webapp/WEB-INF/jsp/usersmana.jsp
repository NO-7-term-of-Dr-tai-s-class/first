<%@page import="com.MentalhealthTestWechatWeb.entity.UserBean"%>
<%@page import="com.MentalhealthTestWechatWeb.entity.AdminBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>

<jsp:include page="import_js_css.jsp" />

<script type="text/javascript">

function goPage(page){
	location.href="usersmana?currentPage="+page;
}

function updateInfo(aid){
	$("#userid1").val(aid);
	
	$.ajax({
		url:"getUserInfoByAId",
		type:"get",
		data:{id:aid},
		dataType:"json",
		success:function(data){
			
			$("#uaUserName").val(data.obj["uname"]);
			$("#uauserpwd").val(data.obj["upwd"]);
			$("#uainputtel").val(data.obj["utel"]);
			
		}
	});
}

function deleteById(aid){
	if(confirm("是否删除"))
	    window.location="deleteVUserById?Id="+aid;
}

$(function(){
	
	$("#vuserup").click(function () {
		var uname = $("#uaUserName").val();
		var upwd = $("#uauserpwd").val();
	    var utel = $("#uainputtel").val();
		var aid = $("#userid1").val();
		
		if(isEmpty(utel)){
			alert("电话不能为空，请确认一下！");
			return;
		}
		
		$.ajax({
			url:"upUserToDB",
			type:"get",
			data : {
				aid: aid,
				uname: uname,
				upwd: upwd,
				utel: utel
				},
			success:function(msg){
				 $('#upVUserInfoModal').modal('hide');
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
									<h5 style="color: red">用户管理 >> 用户信息管理</h5>
								</div>
								<div class="ibox-content">

									<table
										class="table table-striped table-bordered table-hover dataTables-example">
										<thead>
											<tr>
												<th class="textalign">头像</th>
												<th class="textalign">姓名</th>
												<th class="textalign">登录密码</th>
												<th class="textalign">电话</th>
												<th class="textalign">管理</th>
											</tr>
										</thead>
										<tbody>
											<%
												List<UserBean> users = (List<UserBean>) request.getAttribute("usersmana");
												SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
												for (int i = 0; i < users.size(); i++) {
												
											%>
											<tr class="gradeA">
												<td>
													<img src="<%= users.get(i).getUimg()  %>" width="50px" height="30px;" >
												</td>
												<td class="textalign"><%=users.get(i).getUname() %></td>
												<td class="textalign"><%=users.get(i).getUpwd() %></td>
												<td class="textalign"><%=users.get(i).getUtel() %></td>

												<td class="textalign"><a href="javascript:void(0)"
													data-toggle="modal" data-target="#upVUserInfoModal"
													onclick="updateInfo(<%=users.get(i).getUid()%> )">编辑</a> <a
													href="javascript:void(0)"
													onclick="deleteById(<%=users.get(i).getUid()%> )">删除</a></td>
											</tr>
											<%
												}
											%>

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

		<jsp:include page="users_update.jsp" />
</body>
</html>