package pers.hanchao.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 韩超 on 2018/1/23.
 */
@Controller
public class LoginController {
    /**
     * <p>Title: 模拟造数，用于登录session</p>
     * @author 韩超@bksx 2018/1/24 17:54
     */
    @ModelAttribute
    public User init(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("password");
        return user;
    }


    /**
     * <p>Title: 简单的登录演示</p>
     * @author 韩超@bksx 2018/1/24 17:55
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request,@ModelAttribute User user, Model model){
        request.getSession().setAttribute("username",user.getUsername());
        model.addAttribute("username",user.getUsername());
        return "/index";
    }

    /**
     * <p>Title: 简单的登出演示</p>
     * @author 韩超@bksx 2018/1/24 17:55
     */
    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("username","");
        return "/login";
    }
}
