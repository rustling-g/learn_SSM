package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * @author gg
 * @create 2020-11-28 下午6:46
 */

public class Interceptor implements HandlerInterceptor {
    @Override
    //预处理，controller执行前
    //return true 放行，执行下一个拦截器/ controller中的方法
    //return false 跳转页面
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法执行了");
        return true;
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        return false;
    }

    @Override
    //后处理方法，controller执行后，success.jsp执行前 也可以跳别的页面
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法执行了......");
    }

    @Override
    //最后执行方法，success.jsp执行后 跳不了别的页面
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法执行了！！！！！");
    }
}
