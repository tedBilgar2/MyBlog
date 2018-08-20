package system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.model.User;

@Controller
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMain(){
        return "index";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String getRegistration(){
        return "registration";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }
}
