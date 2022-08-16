package com.pmikeladze.siteScript.controller;


import com.pmikeladze.siteScript.entity.Role;
import com.pmikeladze.siteScript.entity.User;
import com.pmikeladze.siteScript.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public void addAttributes(Model model) {
        ArrayList<String> list=new ArrayList(Arrays.asList(Role.values()));
        model.addAttribute("roles", list);
        model.addAttribute("persons", userRepo.findAll());
    }

    @GetMapping("")
    public String getAllPerson() {

        return "person";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user) {

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam(value = "roles", required = false) List<String> role, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (role==null) {
            user.setRoles(Collections.singleton(Role.USER));
        } else {
            user.getRoles().clear();
            role.forEach(e -> user.getRoles().add(Role.valueOf(e)));
        }
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setActive(true);
        userRepo.save(user);
        return "redirect:/login";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        log.info("Delete");
        if (!userRepo.findById(id).get().getUsername().equals("Admin")) {
            userRepo.delete(userRepo.findById(id).get());
        }
        return "redirect:/user";
    }


    @GetMapping("/edit/{id}")
    public String saveUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", userRepo.findById(id).get());

        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("person") @Valid User person, BindingResult bindingResult, @RequestParam(value = "roles" , required = false) ArrayList<String> role, @PathVariable("id") Long id) {
        User user = userRepo.findById(person.getId()).get();
        if (!user.getUsername().equals("Admin") ) {
        if (bindingResult.hasErrors() || role==null) {
            return "edit";
        }
            user.getRoles().clear();role.forEach(e -> user.getRoles().add(Role.valueOf(e)));
            user.setActive(true);
            user.setUsername(person.getUsername());
            user.setPassword(person.getPassword());
            log.info("User" + user.getUsername().toString());
            userRepo.save(user);
        }
        return "redirect:/user";
    }
}
