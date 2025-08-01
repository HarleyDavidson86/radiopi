# RadioPi

Turn your Raspberry Pi into an internet radio client with a modern web interface.

## 📻 About

RadioPi is a Spring Boot web application designed to transform your Raspberry Pi into a fully functional internet radio. The application provides an intuitive web interface with tiles for easy navigation and control.

## 🚀 Features

- **Modern Web Interface**: Responsive design optimized for touch screens
- **Radio Controls**: Easy-to-use tile-based navigation
- **Mobile Friendly**: Responsive design that works on phones and tablets
- **Touch Optimized**: Large buttons and tiles for easy touch interaction
- **Rest API**: API for controlling the radio

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.5.4
- **Frontend**: Thymeleaf templates with HTML5/CSS3
- **Java Version**: 21
- **Build Tool**: Maven
- **Template Engine**: Thymeleaf

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

## 🔧 Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd radiopi
   ```

2. **Build the application**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   Or run the JAR file:
   ```bash
   java -jar target/radiopi-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application**:
   Open your web browser and navigate to `http://localhost:8080`

## 🖥️ Usage

### Main Interface

The application provides a tile-based interface with the following sections:

- TBD

### Features

- **Station Info**: Shows currently playing radio station
- **Settings**: Access system configuration via the settings button (⚙️)

## 🏗️ Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── de/itwerkstatt/radiopi/
│   │       ├── RadioPiApplication.java          # Main application class
│   │       ├── controller/
│   │       │   └── MainController.java          # Web controllers
│   │       └── entities/
│   │           └── RadioStation.java            # Data models
│   └── resources/
│       ├── application.properties               # Configuration
│       ├── static/
│       │   ├── css/
│       │   │   └── style.css                   # Styling
│       │   └── images/
│       │       └── radio.png                   # Assets
│       └── templates/
│           ├── index.html                      # Main page
│           └── currenttime.html                # Time component
└── test/
    └── java/
        └── de/itwerkstatt/radiopi/
            └── RadioPiApplicationTests.java     # Tests
```

## 🔧 Configuration

The application can be configured through `application.properties`:

```properties
spring.application.name=RadioPi
# Add additional configuration as needed
```

## 🎨 Customization

### Adding Radio Stations

Radio stations are defined using the `RadioStation` record:

```java
public record RadioStation(String name, String imagePath) {
}
```

### Styling

The interface can be customized by modifying `src/main/resources/static/css/style.css`. The design is responsive and includes:

- Mobile-first approach
- Touch-friendly buttons
- Dark theme top and bottom bars
- Clean tile-based layout

## 🧪 Testing

Run the test suite:

```bash
mvn test
```

## 📱 Responsive Design

The application includes responsive breakpoints:

- **Desktop/Tablet**: Full-sized tiles and larger fonts
- **Mobile** (≤600px): Smaller tiles and optimized layout

## 🔄 Development

For development with hot reload:

```bash
mvn spring-boot:run
```

The application includes Spring Boot DevTools for automatic restart during development.

## 📄 API Endpoints

- `GET /` - Main application interface

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the [MIT License](LICENSE) - see the LICENSE file for details.

## 🔮 Future Enhancements

- [ ] Audio streaming integration
- [ ] Radio station management
- [ ] Volume control implementation
- [ ] System status monitoring
- [ ] User preferences storage

## 🐛 Troubleshooting

### Common Issues

1. **Port already in use**: Change the port in `application.properties`:
   ```properties
   server.port=8081
   ```

2. **Build failures**: Clean and rebuild:
   ```bash
   mvn clean install
   ```