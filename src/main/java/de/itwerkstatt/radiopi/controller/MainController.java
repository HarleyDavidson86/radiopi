package de.itwerkstatt.radiopi.controller;

import de.itwerkstatt.radiopi.services.RadiostationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {

    private final RadiostationService service;

    public MainController(RadiostationService service) {
        this.service = service; // Initialize the RadiostationService
    }

    @GetMapping("/")
    public String showMainView(Model model) {
        model.addAttribute("radiostations", service.getRadiostations());
        return "index"; // The view name is "index", which corresponds to index.html in the templates directory
    }

    @GetMapping("/inforight")
    public String currentTime(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        return "inforight";
    }
}
