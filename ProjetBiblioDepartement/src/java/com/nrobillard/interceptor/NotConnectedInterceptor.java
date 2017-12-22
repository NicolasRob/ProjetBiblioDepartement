package com.nrobillard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//Intercepteur utilisé pour protéger l'accès au page qui requiert
//que l'utilisateur ne soit pas connecté.
public class NotConnectedInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response, 
      Object handler) throws Exception {
        if (request.getSession().getAttribute("User") != null)
        {
            response.sendRedirect(request.getContextPath() + "/book/catalogue");
            return false;
        }
        else
            return true;
    }
}
