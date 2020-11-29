package uh.edu.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String greeting(@RequestParam(name = "username", required = true) String username, Model model, String link1,
            String link2, String link3, String link4, String link5) {
        if (username.equals("support")) {
            link1 = "Manage User Accounts";
            link2 = "Assign Roles";
            link3 = "Help Desk";
            link4 = "";
            link5 = "";
        } else if (username.equals("finance")) {
            link1 = "Finance Reports";
            link2 = "Accounts Payable";
            link3 = "Accounts Recievable";
            link4 = "";
            link5 = "";
        } else if (username.equals("sales")) {
            link1 = "Sales";
            link2 = "Sales Leads";
            link3 = "Sales Demo";
            link4 = "";
            link5 = "";
        } else if (username.equals("hr")) {
            link1 = "New Hire On-boarding";
            link2 = "Benefits";
            link3 = "Payroll";
            link4 = "Off-boarding";
            link5 = "HR Reports";
        } else if (username.equals("technology")) {
            link1 = "Application Monitoring";
            link2 = "Tech Support";
            link3 = "App Development";
            link4 = "App Admin";
            link5 = "Release Management";
        }

        model.addAttribute("username", username);
        model.addAttribute("link1", link1);
        model.addAttribute("link2", link2);
        model.addAttribute("link3", link3);
        model.addAttribute("link4", link4);
        model.addAttribute("link5", link5);
        return "welcome";
    }
}
