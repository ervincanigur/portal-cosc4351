package uh.edu.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping("/")
	public String greeting(Model model) {
        model.addAttribute("errorMessage", "");
        return "login"; // what mapping we will (str format)
	}
}
