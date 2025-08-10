package de.itwerkstatt.radiopi.services;

import de.itwerkstatt.radiopi.entities.RadioStation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RadiostationService {
    public List<RadioStation> getRadiostations() {
        return List.of(
                new RadioStation("Radio Pi", "radio-pi.png"),
                new RadioStation("Radio Pi 2", "radio-pi-2.png"),
                new RadioStation("Radio Pi 3", "radio-pi-3.png"),
                new RadioStation("Radio Pi 4", "radio-pi-4.png"),
                new RadioStation("Radio Pi 5", "radio-pi-5.png")
        );
    }
}
