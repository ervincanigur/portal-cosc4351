package uh.edu.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uh.edu.portal.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(@RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "password", required = true) String password, Model model) {
        if (service.validateLogin(username, password)) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "welcome";
        } else {
            model.addAttribute("errorMessage", "Invalid Credentials");
            return "login";
        }
    }
}