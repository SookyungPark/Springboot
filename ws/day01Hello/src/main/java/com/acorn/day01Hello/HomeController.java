package com.acorn.day01Hello;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping           ("/hello")
    public String  hello(Model  model){
        model.addAttribute("data" ,"spring boot  ^^");
        return "hello";
    }
}
