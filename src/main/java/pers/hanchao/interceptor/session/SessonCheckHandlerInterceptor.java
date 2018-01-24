package pers.hanchao.interceptor.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pers.hanchao.interceptor.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by 韩超 on 2018/1/23.
 */
public class SessonCheckHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session信息
        String username = (String) request.getSession().getAttribute("username");
        //如果session为空，则返回登录页面
        if (null == username || "".equals(username)){
            //request.header中X-Requested-With  XMLHttpRequest  //表明是AJax异步
            //获取请求头信息
            String ajaxHeader = request.getHeader("X-Requested-With");
            //如果是ajax请求，则应该返回ajax形式
            if ("XMLHttpRequest".equals(ajaxHeader)){
                JsonResult jsonResult = new JsonResult(-1,"会话过期！");
                ObjectMapper objectMapper = new ObjectMapper();
                String strResutl = objectMapper.writeValueAsString(jsonResult);
                PrintWriter pw = response.getWriter();
                pw.write(strResutl);
                pw.flush();
                pw.close();
                return false;
            }else{//如果是普遍请求，则调整页面
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
        return true;
    }
}
