package de.itwerkstatt.radiopi.controller;

import de.itwerkstatt.radiopi.services.RadiostationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {

    private final RadiostationService service;

    public MainController(RadiostationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showMainView(Model model) {
        model.addAttribute("radiostations", service.getRadiostations());
        return "index"; // The view name is "index", which corresponds to index.html in the templates directory
    }

    @GetMapping("/inforightbottom")
    public String inforightbottomData(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        return "inforight";
    }

    @GetMapping("/infoleftbottom")
    public String infoleftbottomData(Model model) {
        model.addAttribute("sendername", service.getCurrentSenderName());
        return "infoleft";
    }
}
