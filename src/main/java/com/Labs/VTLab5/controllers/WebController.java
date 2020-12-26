package com.Labs.VTLab5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    //Отображает файл home.html по адресу localhost:8080/
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("Title", "Main page");
        return "home";
    }

}