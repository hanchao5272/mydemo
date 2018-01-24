package pers.hanchao.filter;

import org.apache.log4j.Logger;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 创建一个包装类，用来存储request的getInputStream信息
 * Created by 韩超 on 2018/1/24.
 */
public class HttpServletRequestBodyWrapper extends HttpServletRequestWrapper {
    //用来存储request请求的body参数
    private byte[] requestBody;

    private final static Logger LOGGER = Logger.getLogger(HttpServletRequestBodyWrapper.class);

    /**
     * <p>Title: 读取request.getInputStream信息，保存到requestBody数组中</p>
     * @author 韩超@bksx 2018/1/24 17:49
     */
    public HttpServletRequestBodyWrapper(HttpServletRequest request) {
        super(request);
        try {
            requestBody = StreamUtils.copyToByteArray(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("URI=" + request.getRequestURI() + ",method=[" + request.getMethod() + "],无法获取请求参数！");
        }
    }

    /**
     * <p>Title: 重写getInputStream，返回requestBody数组中的信息</p>
     * @author 韩超@bksx 2018/1/24 17:49
     */
    @Override
    public ServletInputStream getInputStream(){
        if (null == requestBody){
            requestBody = new byte[0];
        }
        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    /**
     * <p>Title: 重写getReader，返回已经重写的ServletInputStream</p>
     * @author 韩超@bksx 2018/1/24 17:50
     */
    @Override
    public BufferedReader getReader(){
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }



}
