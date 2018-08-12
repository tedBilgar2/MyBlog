package system.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getHomePage(){
        logger.info("Go to home");
        return "index";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndex(){
        logger.info("Go to index");
        return "index2";
    }
}
