package uh.edu.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uh.edu.portal.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("errorMessage", "");
        return "login";
    }

    @PostMapping("/login")
    public String welcomePage(@RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "password", required = true) String password, Model model) {
        if (service.validateLogin(username, password)) {
            return "redirect:/welcome?username=" + username;
        } else {
            model.addAttribute("errorMessage", "Invalid Credentials");
            return "login";
        }
    }
}