package uh.edu.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String greeting(@RequestParam(name = "username", required = true) String username, Model model) {
        model.addAttribute("username", username);
        return "welcome";
    }
}