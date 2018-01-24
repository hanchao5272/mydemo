package pers.hanchao.interceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 韩超 on 2018/1/23.
 */
@Controller
public class HelloController {
    private final static Logger LOGGER = Logger.getLogger(HelloController.class);

    /**
     * <p>Title: 演示了一个返回视图的Get请求</p>
     * @author 韩超@bksx 2018/1/24 17:54
     */
    @GetMapping("/hello")
    public String hello(Model model){
        LOGGER.info("/hello....");
        model.addAttribute("hello", "Hello World!");
        return "interceptor/hello";
    }

    /**
     * <p>Title: 演示了一个返回对象的POST请求，适用于ajax请求</p>
     * @author 韩超@bksx 2018/1/24 17:54
     */
    @PostMapping("/world")
    @ResponseBody
    public JsonResult world(@RequestBody User user){
        JsonResult jsonResult = new JsonResult();
        LOGGER.info(user.getUsername() + ",hello!");
        return jsonResult;
    }
}
