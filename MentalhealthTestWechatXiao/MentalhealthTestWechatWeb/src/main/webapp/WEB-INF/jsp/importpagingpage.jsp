<%@page import="com.MentalhealthTestWechatWeb.entity.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% PageBean paging = (PageBean) request.getAttribute("paging"); %>
	
	<div style="text-align:center; margin-top:40px" id="venderfen">
      		  当前第<%=paging.getCurrentPage() %>页/共<%=paging.getTotalPage() %>页
        <c:choose>
            <c:when test="<%=paging.getCurrentPage()==1 && paging.getTotalPage() == 0 %>"></c:when>
            <c:when test="<%=paging.getCurrentPage()==1 && paging.getTotalPage() == 1 %>"></c:when>
            <c:when test="<%=paging.getCurrentPage()==2 && paging.getTotalPage() == 2 %>">
                <input type="button" value="首页" onclick="goPage(1)" />
                <input type="button" value="上一页"
                    onclick="goPage(<%=paging.getCurrentPage() %>)" />
            </c:when> 
            <c:when test="<%=paging.getCurrentPage() ==1 %>">
          	    <input type="button" value="上一页"/>
                <input type="button" value="下一页" onclick="goPage(<%=paging.getCurrentPage()+1 %>)" />
                <input type="button" value="末页" onclick="goPage(<%=paging.getTotalPage() %>)" />
            </c:when>
            <c:when test="<%=paging.getCurrentPage() == paging.getTotalPage() %>">
                <input type="button" value="首页" onclick="goPage(1)" />
                <input type="button" value="上一页" onclick="goPage(<%=paging.getCurrentPage()-1 %>)" />
            </c:when>
            <c:otherwise>
                <input type="button" value="首页" onclick="goPage(1)" />
                <input type="button" value="上一页" onclick="goPage(<%=paging.getCurrentPage()-1 %>)" />
                <input type="button" value="下一页" onclick="goPage(<%=paging.getCurrentPage()+1 %>)" />
                <input type="button" value="末页" onclick="goPage(<%=paging.getTotalPage() %>)" />
            </c:otherwise>
        </c:choose>
       </div> 