<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
%>

<link href="static/css/left3/style.css" type="text/css"
	rel="stylesheet">

<div id="wrapper-250">
	
	<div class="nav-top">
		<div id="mini" style="background: #eee; font-size:20px;
			 height: 60px; text-align: center; line-height: 60px; color: #000 ">
			心理健康在线测试小程序后台系统
		</div>
	</div>

  <ul class="accordion">
    <li id="one" class="files"> <a href="#one">用户管理</a>
      <ul class="sub-menu">
        <li><a href='<%=path%>/adminoneselfmana'><em>01</em>个人信息管理</a></li>
        <li><a href='<%=path%>/usersmana'><em>02</em>用户管理</a></li>
      </ul>
    </li>
    <li id="two" class="mail"> <a href="#two">业务相关管理</a>
      <ul class="sub-menu">
        <li><a href='<%=path%>/cartoonanimatsmana'><em>01</em>漫画动画信息管理</a></li>
        <li><a href='<%=path%>/videotypesmana'><em>02</em>电影类型信息管理</a></li>
        <li><a href='<%=path%>/videosmana'><em>03</em>电影信息管理</a></li>
        <li><a href='<%=path%>/musictypesmana'><em>04</em>音乐类型信息管理</a></li>
        <li><a href='<%=path%>/musicsmana'><em>05</em>音乐信息管理</a></li>
      </ul>
    </li>
    <li id="four" class="sign"> <a href="#four">退出登录</a>
      <ul class="sub-menu">
        <li><a href='<%=path%>/userLogin'><em>01</em>退出登录</a></li>
      </ul>
    </li>
  </ul>
</div>

<script type="text/javascript">
		$(document).ready(function() {
			var accordion_head = $('.accordion > li > a'),
				accordion_body = $('.accordion li > .sub-menu');
	
			//accordion_head.first().addClass('active').next().slideDown('normal');
		
			accordion_head.on('click', function(event) {
		
				event.preventDefault();
			
				if ($(this).attr('class') != 'active'){
					accordion_body.slideUp('normal');
					$(this).next().stop(true,true).slideToggle('normal');
					accordion_head.removeClass('active');
					$(this).addClass('active');
				}
			});
		});
	</script>

