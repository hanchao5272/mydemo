package pers.hanchao.interceptor.time;

import org.apache.log4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 韩超 on 2018/1/23.
 */
public class HandleTimeHandlerInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOGGER = Logger.getLogger(HandleTimeHandlerInterceptor.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        startTime.set(System.currentTimeMillis());
        //如果是处理方法，才记录时间。记录静态资源等信息没有意义
        if (handler instanceof HandlerMethod){
            StringBuffer sb = new StringBuffer();
            sb.append("----------------------------------------{[");
            sb.append(request.getRequestURI()).append("],method=[").append(request.getMethod());
            sb.append("]}----------------------------------------\n");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            sb.append("Controller   :" + handlerMethod.getBean().getClass().getName());
            
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView){
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex){
        //如果是处理方法，才记录时间。记录静态资源等信息没有意义
        if (handler instanceof HandlerMethod){
            Long useTime = System.currentTimeMillis() - startTime.get();
            LOGGER.info("{[" + request.getRequestURI() + "],method=[" + request.getMethod() + "]},用时：" + useTime + "毫秒.");
        }
    }
}
