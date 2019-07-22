package pl.gregsApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/")
    public String login(){
        return "mainPage";
    }

    @GetMapping("/mainPage")
    public String mainPage(){
        return "mainPage";
    }
    @GetMapping("/mainPageAfterLogin")
    public String mainPageAfterLogin(){
        return "mainPageafterLogin";
    }
}
