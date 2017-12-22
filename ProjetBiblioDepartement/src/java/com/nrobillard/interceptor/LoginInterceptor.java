package com.nrobillard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//Intercepteur utilisé pour protéger l'accès aux pages qui requierent
//que l'utilisateur soit connecté.
public class LoginInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response, 
      Object handler) throws Exception {
        if (request.getSession().getAttribute("User") == null)
        {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }
        else
            return true;
    }
}
