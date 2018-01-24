package pers.hanchao.multiviewresolver;


import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * Created by 韩超 on 2018/1/18.
 */
public class HtmlViewResolver extends InternalResourceView {

    /**
     * <p>Title: </p>
     * <p>Description:Todo </p>
     * @author 韩超@bksx 2018/1/18 19:14
     */
    @Override
    public boolean checkResource(Locale locale){
        File file=new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists(); //判断页面是否存在
    }
}
