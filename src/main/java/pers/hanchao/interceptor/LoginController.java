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
    @ModelAttribute
    public User init(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("password");
        return user;
    }


    @PostMapping("/login")
    public String login(HttpServletRequest request,@ModelAttribute User user, Model model){
        request.getSession().setAttribute("username",user.getUsername());
        model.addAttribute("username",user.getUsername());
        return "/index";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "/login";
    }
}
