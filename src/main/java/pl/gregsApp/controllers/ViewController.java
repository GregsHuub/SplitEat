package pl.gregsApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.gregsApp.pdfMaker.PdfCreate;

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
