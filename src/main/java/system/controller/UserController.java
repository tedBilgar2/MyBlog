package system.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.model.User;
import system.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addUser(){
        User user = new User("papa149@mail.ru","123456");
        userService.addUser(user);
        return "index";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getUser(){
        //User user = new User("papa149@mail.ru","123456");
        logger.info(userService.loadUserById("1"));
        return "index";
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateUser(){
        User user = userService.loadUserById("1");
        user.setEmail("denis.urakanov@yandex.ru");
        userService.updateUser(user);
        return "index";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteUser(){
        userService.deleteUserById("1");
        return "index";
    }
}
