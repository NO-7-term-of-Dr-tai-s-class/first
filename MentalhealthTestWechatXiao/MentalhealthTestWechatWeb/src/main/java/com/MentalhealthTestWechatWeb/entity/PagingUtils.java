package com.MentalhealthTestWechatWeb.entity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PagingUtils {
	
	public static <T> void page8(PageBean page,HttpServletRequest request, List<T> objT) {
		if (page.getCurrentPage() == null){
	        page.setCurrentPage(1);
	    } else {
	        page.setCurrentPage(page.getCurrentPage());
	    }
	    
	    page.setPageSize(8);
	    page.setStar((page.getCurrentPage() - 1) * page.getPageSize());
	    int count = objT.size();
	    page.setTotalPage(count % 8 == 0 ? count / 8 : count / 8 + 1);
	    page.setDataList(objT.subList(page.getStar(),count-page.getStar()>page.getPageSize()?page.getStar()+page.getPageSize():count));
	    request.setAttribute("paging", page);  
	} 
	
	public static <T> void page15(PageBean page,HttpServletRequest request, List<T> objT) {
		if (page.getCurrentPage() == null){
	        page.setCurrentPage(1);
	    } else {
	        page.setCurrentPage(page.getCurrentPage());
	    }
	    
	    page.setPageSize(15);
	    page.setStar((page.getCurrentPage() - 1) * page.getPageSize());
	    int count = objT.size();
	    page.setTotalPage(count % 15 == 0 ? count / 15 : count / 15 + 1);
	    page.setDataList(objT.subList(page.getStar(),count-page.getStar()>page.getPageSize()?page.getStar()+page.getPageSize():count));
	    request.setAttribute("paging", page);  
	}
	
	public static <T> void page10(PageBean page,HttpServletRequest request, List<T> objT) {
		if (page.getCurrentPage() == null){
	        page.setCurrentPage(1);
	    } else {
	        page.setCurrentPage(page.getCurrentPage());
	    }
	    
	    page.setPageSize(10);
	    page.setStar((page.getCurrentPage() - 1) * page.getPageSize());
	    int count = objT.size();
	    page.setTotalPage(count % 10 == 0 ? count / 10 : count / 10 + 1);
	    page.setDataList(objT.subList(page.getStar(),count-page.getStar()>page.getPageSize()?page.getStar()+page.getPageSize():count));
	    request.setAttribute("paging", page);  
	}
	
	public static <T> void page20(PageBean page,HttpServletRequest request, List<T> objT) {
		if (page.getCurrentPage() == null){
	        page.setCurrentPage(1);
	    } else {
	        page.setCurrentPage(page.getCurrentPage());
	    }
	    
	    page.setPageSize(20);
	    page.setStar((page.getCurrentPage() - 1) * page.getPageSize());
	    int count = objT.size();
	    page.setTotalPage(count % 20 == 0 ? count / 20 : count / 20 + 1);
	    page.setDataList(objT.subList(page.getStar(),count-page.getStar()>page.getPageSize()?page.getStar()+page.getPageSize():count));
	    request.setAttribute("paging", page);  
	}

}
