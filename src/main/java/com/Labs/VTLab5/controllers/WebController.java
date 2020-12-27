package com.Labs.VTLab5.controllers;

import com.Labs.VTLab5.models.Table;
import com.Labs.VTLab5.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private TableRepository tableRepository;

    //Отображает файл home.html по адресу localhost:8080/
    @GetMapping("/")
    public String home(Model model) {
        //model.addAttribute("Title", "Лабораторная работа №5");
        Iterable<Table> tables = tableRepository.findAll();
        model.addAttribute("tables", tables);
        return "home";
    }

    @GetMapping("/add")
    public String tableAdd(Model model) {
        return "add";
    }

    @PostMapping("/add")
    public String tableSubmitAdd(@RequestParam String name, @RequestParam int vtmark,
                              @RequestParam int econmark, @RequestParam int tvimsmark,
                              @RequestParam int oopmark, Model model) {
        Table table = new Table(name, vtmark, tvimsmark, econmark, oopmark);
        tableRepository.save(table);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String tableEdit(Model model) {
        return "edit";
    }


}