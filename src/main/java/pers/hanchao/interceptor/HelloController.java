package pers.hanchao.interceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 韩超 on 2018/1/23.
 */
@Controller
public class HelloController {
    private final static Logger LOGGER = Logger.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(Model model){
        LOGGER.info("/hello....");
        model.addAttribute("hello", "Hello World!");
        return "interceptor/hello";
    }

    @PostMapping("/world")
    @ResponseBody
    public JsonResult world(){
        JsonResult jsonResult = new JsonResult();
        LOGGER.info("/world....");
        return jsonResult;
    }
}
