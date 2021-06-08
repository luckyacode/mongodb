package com.praveen.extra;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//public class Sinterceptor implements HandlerInterceptor{
//	@Override
//	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler){
//		System.out.println("Pre Handle OK");
//		return true;
//	}
//	@Override
//	public void postHandle(HttpServletRequest req,HttpServletResponse res,Object handler,ModelAndView mv){
//		System.out.println("Post Handle OK");		
//	}
//	
//	public void afterCompletion(HttpServletRequest req, HttpServletResponse res,Object handler,Exception e)
//	throws Exception{
//		System.out.println("After pre and post completion");				
//	}
//	
//}
