package pers.hanchao.interceptor.time;

import org.apache.log4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 请求信息拦截器：获取Controller名、method名、请求参数、URI、耗时等信息。
 * 此拦截器需要HttpServletRequestBodyWrapper和HttpServletRequestBodyWrapperFilter的配合
 * Created by 韩超 on 2018/1/23.
 */
public class RequestInfoHandlerInterceptor extends HandlerInterceptorAdapter {

    private final static Logger LOGGER = Logger.getLogger(RequestInfoHandlerInterceptor.class);

    //用ThreadLocal，保障线程安全
    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * <p>Title: 在Handler正式handle之前，获取Controller名、method名、请求参数、URI信息以及当时的系统时间</p>
     * @author 韩超@bksx 2018/1/24 17:46
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //如果是处理方法，才记录时间。记录静态资源等信息没有意义
        if (handler instanceof HandlerMethod){
            startTime.set(System.currentTimeMillis());

            //拦截器中无法直接实现读取POST参数，因为request.getInputSteam只能读取一次，
            // 如果在这里读取了，则在controller中无法获取body参数
            //可以通过HttpServletRequestWrapper对request body进行包装，实现多次使用，在filter中进行，

            //创建reader读取request.getInputStream()
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
            //创建requestBody存储body参数
            StringBuilder requestBody = new StringBuilder ();
            //循环遍历，读取request.getInputStream()
            String line;
            while ((line = reader.readLine()) != null)
                requestBody.append (line);
            //转换成字符串
            String parmeters = requestBody.toString() + "\n";

            //打印其他请求信息
            StringBuffer sb = new StringBuffer();
            sb.append("\n--------------------------------------------------------------------------------");
            //格式化当前日期
            sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(startTime.get())));
            sb.append("--------------------------------------------------------------------------------\n");
            //获取Handler的方法，具体来说，就是Controller的method
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取方法所属bean的class，也就是Controller的名字
            sb.append("----------Controller   :").append(handlerMethod.getBean().getClass().getName()).append("\n");
            //获取方法名，包括返回值与参数的全路径
            sb.append("----------Method       :[").append(handlerMethod.getMethod()).append("\n");
            //设置参数
            sb.append("----------Parameters   :").append(parmeters);
            //通过request获取请求URI，和请求类型，如POST、GET、POST等等
            sb.append("----------URI          :[").append(request.getRequestURI()).append("],method=[").append(request.getMethod()).append("]").append("\n");
            sb.append("--------------------------------------------------------------------------------");
            sb.append("-------------------");
            sb.append("--------------------------------------------------------------------------------");
            LOGGER.info(sb.toString());
        }
        return true;

    }
    /**
     * <p>Title:在Handler完成 handle之后，获取此时的系统时间，计算出整个handle用时 </p>
     * @author 韩超@bksx 2018/1/24 17:45
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex){
        //如果是处理方法，才记录时间。记录静态资源等信息没有意义
        if (handler instanceof HandlerMethod){
            Long useTime = System.currentTimeMillis() - startTime.get();
            StringBuffer sb = new StringBuffer();
            //格式化当前日期
            sb.append("========{").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(startTime.get())));
            //通过request获取请求URI，和请求类型，如POST、GET、POST等等
            sb.append(",URI = [").append(request.getRequestURI()).append("],method = ").append(request.getMethod()).append(",");
            //打印应用耗时
            sb.append("Use Time : ").append(useTime).append(" 毫秒}\n");
            LOGGER.info(sb.toString());
        }
    }
}
