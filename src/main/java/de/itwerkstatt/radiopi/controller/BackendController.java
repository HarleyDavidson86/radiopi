package de.itwerkstatt.radiopi.controller;

import de.itwerkstatt.radiopi.services.RadiostationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BackendController {

    private final RadiostationService radiostationService;

    Logger logger = LogManager.getLogger(BackendController.class);

    public BackendController(RadiostationService radiostationService) {
        this.radiostationService = radiostationService;
    }

    @RequestMapping("/radiostation/play/{id}")
    public ResponseEntity<Void> playSender(@PathVariable("id") String id) {
        if (radiostationService.playSender(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping("/radiostation/stop")
    public ResponseEntity<Void> stopPlaying() {
        //TODO
        return ResponseEntity.noContent().build();
    }
}
