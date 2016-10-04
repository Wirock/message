package org.myproject.interceptor;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myproject.token.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * ∑¿÷π÷ÿ∏¥Ã·Ωª¿πΩÿ∆˜
 * @author Czw
 *
 */
public class ModificationInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("utf-8");
		if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if(method.isAnnotationPresent(Token.class)){
            	Token token = method.getAnnotation(Token.class);
            	if(token.save()){
            		request.getSession(false).setAttribute("token",UUID.randomUUID().toString());
            		return true;
            	}
            	if(token.remove()){
            		if(isRepeatSubmit(request)){
            			response.sendRedirect(request.getContextPath()+"/list");
            			return false;
            		}
            		request.getSession(false).removeAttribute("token");
            	}
            }
		}
        return true;
	}
	private boolean isRepeatSubmit(HttpServletRequest request){
		String serverToken = (String) request.getSession(false).getAttribute("token");
		if(serverToken == null){
			return true;
		}
		String clientToken = request.getParameter("token");
		if(clientToken == null||!clientToken.equals(serverToken)){
			return true;
		}
		return false;
	}
}
