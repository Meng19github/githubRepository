package com.example.demolastss.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String home(){
        return "redirect:/home/index";
    }
    @RequestMapping(value = "/home/index")
    public String homedisplay(){return "home/index";
    }
}
