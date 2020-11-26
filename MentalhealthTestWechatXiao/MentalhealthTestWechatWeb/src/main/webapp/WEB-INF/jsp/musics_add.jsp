<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="modal fade" id= "addMusicsInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		     	<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
						<h4 class="panel-title">
							<span>添加音乐信息
								<span style="color:red;">*</span>
							</span>
						</h4>
		 			</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form">
						
						<div class="form-group">		
							<label class="col-sm-2 control-label">标题:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="Mtitle" placeholder="请输入标题">
							   	</div>
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">演唱者:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="Msinger" placeholder="请输入演唱者">
							   	</div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						    <label class="col-sm-2 control-label">类型:</label>
						    <div class="col-sm-10">
						        <select class="form-control selectpicker" id="addVTypeSelector" title="请选择类型">
								</select>
						    </div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						      <label class="col-sm-2 control-label">选择图片:</label>
						    <div class="col-sm-10" id="preview">
						   	     <input id="myFilePh" type="file" name="myFile" class="fileloading">
						   	     <input type="hidden" id="filepath">
						    </div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						      <label class="col-sm-2 control-label">选择音乐:</label>
						    <div class="col-sm-10" id="preview">
						   	     <input id="myVideoFilePh" type="file" name="myFile" class="fileloading">
						   	     <input type="hidden" id="filevideopath">
						    </div>
						</div>
					
					</form>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-success" id="save">确认</button>
			      	</div>
				</div>
		    </div>
		</div>
	</div>
	
	<script type="text/javascript">
	    $("#myFilePh").fileinput({
	    	language : 'zh',
	        uploadUrl : "uploadphoto",
	        maxFileCount : 1,
	        autoReplace : true,
	        browseClass : "btn btn-primary",
            previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
	    }).on("fileuploaded", function(e, data) {
	        var res = data.response;
	        var imgpath = res.success;
	        document.querySelector('#filepath').value  = imgpath;
	    })
    </script>
    
    <script type="text/javascript">
	    $("#myVideoFilePh").fileinput({
	    	language : 'zh',
	        uploadUrl : "uploadphoto",
	        maxFileCount : 1,
	        autoReplace : true,
	        browseClass : "btn btn-primary",
            previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
	    }).on("fileuploaded", function(e, data) {
	        var res = data.response;
	        var imgpath = res.success;
	        document.querySelector('#filevideopath').value  = imgpath;
	    })
    </script>
	