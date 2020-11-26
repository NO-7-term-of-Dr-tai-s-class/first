<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="modal fade" id= "upAdminUserInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		     	<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
						<h4 class="panel-title">
							<span>修改个人信息
								<span style="color:red;">*</span>
							</span>
						</h4>
					</div> 
					<div class="panel-body">
			 			<form class="form-horizontal" role="form">
						
						<div class="form-group">		
							<label class="col-sm-2 control-label">姓名:</label>
							   	<input type="text" class="col-sm-9" id="uaUserName" placeholder="请输入村民姓名">
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">密码:</label>
							   	<input type="number" class="col-sm-9" id="uauserpwd" placeholder="请输入密码">
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">电话:</label>
							   	<input type="number" class="col-sm-9" id="uainputtel" placeholder="请输入电话">
						</div>
					
					</form>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-success" id="userup">确认</button>
			      	</div>
				</div>
		    </div>
		</div>
	</div>
	