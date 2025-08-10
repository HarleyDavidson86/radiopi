package de.itwerkstatt.radiopi.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BackendController {

    Logger logger = LogManager.getLogger(BackendController.class);

    @RequestMapping("/radiostation/play/{id}")
    public ResponseEntity<Void> playSender(@PathVariable("id") String id) {
        //TODO
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/radiostation/stop")
    public ResponseEntity<Void> stopPlaying() {
        //TODO
        return ResponseEntity.noContent().build();
    }
}
