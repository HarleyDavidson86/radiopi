package de.itwerkstatt.radiopi.services;

import de.itwerkstatt.radiopi.entities.RadioStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class RadiostationService {

    private final Path configurationPath;
    private final Logger logger;
    private final ArrayList<RadioStation> radiostations;

    private RadioStation currentRadioStation;

    public RadiostationService(@Value("${radiostation.configuration.path}") String configurationPath) {
        this.configurationPath = Path.of(configurationPath);
        this.logger = LogManager.getLogger(RadiostationService.class);
        this.radiostations = new ArrayList<>();
    }

    /**
     * Returns a list of radio stations. If the list is empty, it loads the radio stations from the configuration files.
     *
     * @return List of RadioStation objects
     */
    public List<RadioStation> getRadiostations() {
        if (radiostations.isEmpty()) {
            loadRadioStations();
        }
        return radiostations;
    }

    /**
     * Loads radio stations from configuration files in the specified directory.
     * Each configuration file should have a .txt extension and contain lines in the format:
     * displayName=Your Radio Name
     * url=http://your.radio.url
     * The corresponding image file should be named as <filename>.jpg.
     */
    private void loadRadioStations() {
        radiostations.clear();
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(configurationPath, "*.txt")) {
            for (Path txtFile : ds) {
                String imageFileName = txtFile.toAbsolutePath().toString().replace(".txt", ".jpg");
                String displayName = null;
                String url = null;
                for (String line : Files.readAllLines(txtFile)) {
                    if (line.startsWith("#")) {
                        continue; // Skip comments
                    }
                    String[] parts = line.trim().split("=");
                    if (parts.length < 2) {
                        logger.warn("Invalid line in configuration file '{}': {}", txtFile, line);
                        continue; // Skip invalid lines
                    }
                    switch (parts[0].trim().toLowerCase()) {
                        case "displayname":
                            displayName = parts[1].trim();
                            break;
                        case "url":
                            url = parts[1].trim();
                            break;
                    }
                }
                logger.debug("Adding radio station: displayName='{}', url='{}', imageFileName='{}'", displayName, url, imageFileName);
                Path imagePath = Path.of(imageFileName);
                byte[] imageByteArray;
                if (!Files.exists(imagePath)) {
                    //Load default image
                    try (InputStream is = getClass().getClassLoader().getResourceAsStream("default_radio_image.jpg")) {
                        assert is != null;
                        imageByteArray = is.readAllBytes();
                    }
                } else {
                    imageByteArray = Files.readAllBytes(imagePath);
                }
                if (displayName != null || url != null) {
                    radiostations.add(new RadioStation(displayName, Base64.getEncoder().encodeToString(imageByteArray)));
                } else {
                    logger.warn("Skipping incomplete radio station configuration for '{}'", txtFile.getFileName());
                }
            }
        } catch (IOException e) {
            logger.error("Error reading radio station configuration files", e);
        }
    }

    /**
     * Plays the radio station with the given ID.
     *
     * @param id The ID of the radio station to play
     * @return true if the station was successfully played, false otherwise
     */
    public boolean playSender(String id) {
        radiostations.stream().filter(rs -> rs.id().equals(id)).findFirst().ifPresentOrElse(
                radioStation -> {
                    logger.info("Playing radio station: {}", radioStation.name());
                    currentRadioStation = radioStation;
                },
                () -> logger.warn("Radio station with ID '{}' not found", id)
        );
        return true;
    }

    /**
     * Returns the name of the currently playing radio station.
     * If no station is currently playing, it returns "-".
     * @return The name of the current radio station or "-" if none is playing
     */
    public String getCurrentSenderName() {
        if (currentRadioStation != null) {
            return currentRadioStation.name();
        }
        return "-";
    }
}
