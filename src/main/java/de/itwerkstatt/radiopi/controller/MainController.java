package de.itwerkstatt.radiopi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name, Model model) {
        // This method returns the name of the view to be rendered
        model.addAttribute("name", name); // Add the name attribute to the model
        return "index"; // The view name is "greeting", which corresponds to greeting.html in the templates directory
    }

    @GetMapping("/currenttime")
    public String currentTime(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        return "currenttime";
    }
}
