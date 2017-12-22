package com.nrobillard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response, 
      Object handler) throws Exception {
        /*if (request.getSession().getAttribute("login") == null)
        {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }
        else*/
            return true;
    }
    
    /*@Override
    public void postHandle(
      HttpServletRequest request, 
      HttpServletResponse response,
      Object handler, 
      ModelAndView modelAndView) throws Exception {
        request.getSession().setAttribute("login", "admin");
    }*/
}
