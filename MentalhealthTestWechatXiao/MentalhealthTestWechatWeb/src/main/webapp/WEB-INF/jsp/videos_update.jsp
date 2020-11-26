<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="modal fade" id= "upVideosInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		     	<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
						<h4 class="panel-title">
							<span>修改电影信息
								<span style="color:red;">*</span>
							</span>
						</h4>
		 			</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form">
						
						<div class="form-group">		
							<label class="col-sm-2 control-label">标题:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uVtitle" placeholder="请输入标题">
							   	</div>
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">演员:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uVperformers" placeholder="请输入演员">
							   	</div>
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">评分:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uVscores" placeholder="请输入评分">
							   	</div>
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">简介:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uVjianjie" placeholder="请输入简介">
							   	</div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						    <label class="col-sm-2 control-label">电影类型:</label>
						    <div class="col-sm-10">
						        <select class="form-control selectpicker" id="upVTypeSelector" title="请选择电影类型">
								</select>
						    </div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						      <label class="col-sm-2 control-label">选择图片:</label>
						    <div class="col-sm-10" id="preview">
						   	     <input id="umyFilePh" type="file" name="myFile" class="fileloading">
						   	     <input type="hidden" id="ufilepath">
						    </div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						      <label class="col-sm-2 control-label">选择视频:</label>
						    <div class="col-sm-10" id="preview">
						   	     <input id="umyVideoFilePh" type="file" name="myFile" class="fileloading">
						   	     <input type="hidden" id="ufilevideopath">
						    </div>
						</div>
					
					</form>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-success" id="update">确认</button>
			      	</div>
				</div>
		    </div>
		</div>
	</div>
	
	<script type="text/javascript">
	    $("#umyFilePh").fileinput({
	    	language : 'zh',
	        uploadUrl : "uploadphoto",
	        maxFileCount : 1,
	        autoReplace : true,
	        browseClass : "btn btn-primary",
            previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
	    }).on("fileuploaded", function(e, data) {
	        var res = data.response;
	        var imgpath = res.success;
	        document.querySelector('#ufilepath').value  = imgpath;
	    })
    </script>
    
    <script type="text/javascript">
	    $("#umyVideoFilePh").fileinput({
	    	language : 'zh',
	        uploadUrl : "uploadphoto",
	        maxFileCount : 1,
	        autoReplace : true,
	        browseClass : "btn btn-primary",
            previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
	    }).on("fileuploaded", function(e, data) {
	        var res = data.response;
	        var imgpath = res.success;
	        document.querySelector('#ufilevideopath').value  = imgpath;
	    })
    </script>
	