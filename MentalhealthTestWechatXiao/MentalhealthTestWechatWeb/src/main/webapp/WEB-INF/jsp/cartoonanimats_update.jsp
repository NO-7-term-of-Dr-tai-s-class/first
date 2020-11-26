<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="modal fade" id= "upCartoonanimatsInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		<div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		     	<div class="panel panel-default">
					<div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
						<h4 class="panel-title">
							<span>修改漫画或者动画信息
								<span style="color:red;">*</span>
							</span>
						</h4>
		 			</div> 
					<div class="panel-body">
						<form class="form-horizontal" role="form">
						
						<div class="form-group">		
							<label class="col-sm-2 control-label">标题:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uCtitle" placeholder="请输入标题">
							   	</div>
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">作者:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uCauthor" placeholder="请输入作者">
							   	</div>
						</div>
						
						<div class="form-group">	
							<label class="col-sm-2 control-label">简介:</label>
							 <div class="col-sm-10">
							   	<input type="text" class="col-sm-9" id="uCjianjie" placeholder="请输入简介">
							   	</div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						    <label class="col-sm-2 control-label">选择类型:</label>
						    <div class="col-sm-10">
							    <label class="radio" style="margin-left: 15px;">
							    <input type="radio" name="uCflag" value="1">漫画</label>
							     <label class="radio" style="margin-left: 15px;">
							    <input type="radio" name="uCflag" value="2">动画</label>
						    </div>
						</div>
						
						<div class="form-group" style="margin-top: 5px;">
						      <label class="col-sm-2 control-label">选择文件:</label>
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
						
						<div class="form-group">
						    <label class="col-sm-2 control-label">内容:</label>
						    <div class="col-sm-10">
						       <TEXTAREA id="myUpEditor" name="mycontent" readonly="readonly"></TEXTAREA> 
						    </div>
						</div>
					
					</form>
					</div>
					<div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-success" id="vuserup">确认</button>
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
	