package com.study.controller;

import com.study.model.User;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listUser", userService.getAll());
        return "index";
    }

    @GetMapping("/newUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "newUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/formForUpdateUser/{id}")
    public String showFormForUpdateUser(@PathVariable(value = "id") Integer id, Model model) {
        User user = userService.findById(id);

        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
