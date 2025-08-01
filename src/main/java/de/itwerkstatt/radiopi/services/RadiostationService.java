package de.itwerkstatt.radiopi.services;

import de.itwerkstatt.radiopi.entities.Radiostation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RadiostationService {
    public List<Radiostation> getRadiostations() {
        return List.of(
                new Radiostation("Radio Pi", "radio-pi.png"),
                new Radiostation("Radio Pi 2", "radio-pi-2.png"),
                new Radiostation("Radio Pi 3", "radio-pi-3.png"),
                new Radiostation("Radio Pi 4", "radio-pi-4.png"),
                new Radiostation("Radio Pi 5", "radio-pi-5.png")
        );
    }
}
