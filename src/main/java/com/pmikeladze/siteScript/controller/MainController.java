package com.pmikeladze.siteScript.controller;

import com.pmikeladze.siteScript.entity.Numbers;
import com.pmikeladze.siteScript.repository.NumbersRepos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private NumbersRepos numbersRepos;
    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("graphs",numbersRepos.findAll());
        System.out.println(numbersRepos.findAll());
        model.addAttribute("number",new Numbers());
        return "start_page";
    }

    @PostMapping
    public String summingNumbers(@ModelAttribute() Numbers numbers){
        numbersRepos.save(numbers);
        log.info(numbers.getSumma().toString());
        return "redirect:/";
    }
}
