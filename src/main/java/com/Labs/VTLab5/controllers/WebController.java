package com.Labs.VTLab5.controllers;

import com.Labs.VTLab5.models.Table;
import com.Labs.VTLab5.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

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

    //Обрабатывает форму добавления снизу таблицы в "/"
    @PostMapping("/")
    public String tableSubmitAdd(@RequestParam String name, @RequestParam int vtmark,
                              @RequestParam int econmark, @RequestParam int tvimsmark,
                              @RequestParam int oopmark, Model model) {
        /*Если студент с заданным именем есть,
        * будет обновлена запись */
        Iterable<Table> tables = tableRepository.findAll();
        for(Table x : tables) {
            if(name.equals(x.getStudentName())) {
                Table table = tableRepository.findById(x.getId()).orElseThrow();
                x.setMarks(vtmark, tvimsmark, econmark, oopmark);
                tableRepository.save(table);
                return "redirect:/";
            }
        }
        /*Если студента с заданным именем нет,
        * создать новую запись*/
        Table table = new Table(name, vtmark, tvimsmark, econmark, oopmark);
        tableRepository.save(table);
        return "redirect:/";
    }

    /*Обрабатывает форму редактирования записи.
    * id - динамический параметр, передается из "/" */
    @GetMapping("/{id}/edit")
    public String studentEdit(@PathVariable(value = "id") Long id, Model model) {
        //Если записи с искомым id не существует, возврат на главную страницу
        if(!tableRepository.existsById(id)) {
            return "redirect:/";
        }
        Optional<Table> table = tableRepository.findById(id);
        ArrayList<Table> tableArr = new ArrayList<>();
        table.ifPresent(tableArr::add);
        model.addAttribute("table", table);
        return "edit";
    }

    //Обрабатывает форму обновления записи
    @PostMapping("/{id}/edit")
    public String studentUpdate(@PathVariable(value = "id") Long id, @RequestParam String name, @RequestParam int vtmark,
                              @RequestParam int econmark, @RequestParam int tvimsmark,
                              @RequestParam int oopmark, Model model) {
        Table table = tableRepository.findById(id).orElseThrow();
        table.setStudentName(name);
        table.setMarks(vtmark, tvimsmark, econmark, oopmark);
        tableRepository.save(table);
        return "redirect:/";
    }

    //Обрабатывает удаление записи
    @PostMapping("/{id}/del")
    public String studentUpdate(@PathVariable(value = "id") Long id, Model model) {
        Table table = tableRepository.findById(id).orElseThrow();
        tableRepository.delete(table);
        return "redirect:/";
    }
}