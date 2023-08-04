package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({"","/index"})
    public String index(){

        return "index";
    }

    @GetMapping("/shop")
    public String shop(){

        return "shop";
    }

    @GetMapping("/admin")
    public String admin(){

        return "admin";
    }

}
