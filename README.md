# RadioPi - Internet Radio Player

RadioPi is a Django-based web application designed to control and display internet radio stations, particularly optimized for Raspberry Pi devices. The application provides a clean, touch-friendly interface for selecting radio stations and displays real-time information.

## Features

- **Modern Web Interface**: Responsive design optimized for touch devices
- **Radio Station Management**: Easy-to-configure radio stations via text files
- **Real-time Updates**: Auto-refreshing information display every 10 seconds
- **German Localization**: Interface and time zone configured for Germany
- **Touch-Optimized**: Large buttons and clear interface for touch interaction

## Project Structure

```
radiopi/
├── mainapp/                    # Main Django application
│   ├── static/                 # Static files (CSS, JS, images)
│   ├── templates/              # HTML templates
│   ├── views.py                # View logic
│   └── urls.py                 # URL routing
├── radiopi/                    # Django project configuration
│   ├── settings.py             # Django settings
│   └── urls.py                 # Root URL configuration
├── manage.py                   # Django management script
├── db.sqlite3                  # SQLite database
└── requirements.txt            # Python dependencies (to be created)
```

## Installation

### Prerequisites

- Python 3.8 or higher
- pip (Python package installer)
- Git (optional, for cloning)

### Setup Instructions

1. **Clone or download the project**:
   ```bash
   git clone <repository-url>
   cd radiopi
   ```

2. **Create a virtual environment** (recommended):
   ```bash
   # Optional: Install pipenv
   sudo apt install pipenv
   # Activate / Enter virtual environment
   pipenv shell

   # Exit virtual environment
   exit
   
   ```

3. **Install Modules in virtual environment**:
   ```bash
   pipenv install -e .
   ```

4. **Run database migrations**:
   ```bash
   python manage.py migrate
   ```

5. **Create a superuser** (optional):
   ```bash
   python manage.py createsuperuser
   ```

6. **Start the development server**:
   ```bash
   python manage.py runserver
   ```

7. **Access the application**:
   Open your web browser and go to `http://127.0.0.1:8000/`

## Configuration

tbd

### Django Settings

Key settings in `radiopi/settings.py`:

- **Language**: Set to German (`LANGUAGE_CODE = 'de-de'`)
- **Timezone**: Set to Europe/Berlin (`TIME_ZONE = 'Europe/Berlin'`)
- **Database**: SQLite (suitable for Raspberry Pi)
- **Debug Mode**: Currently enabled (disable for production)

## API Endpoints

The application provides several endpoints:

- `/` - Main interface
- `/inforightbottom/` - Current time and status info
- `/infoleftbottom/` - Current radio station info  
- `/api/radiostation/play/<station_id>/` - Change radio station

## Frontend Features

### Auto-Refresh System

The interface automatically updates every 10 seconds using JavaScript:
- Current time display
- Radio station status
- Connection status

### Radio Station Control

JavaScript function `changeRadiostation()` handles station switching:
```javascript
function changeRadiostation(stationId) {
    fetch('api/radiostation/play/' + stationId)
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            getData(); // Refresh display
        })
        .catch(err => console.error('Error changing radio station:', err));
}
```

## Deployment

### For Raspberry Pi

tbd

## Development

### Running Tests

```bash
python manage.py test
```

### Static Files

Static files are served from `mainapp/static/`:
- CSS: `css/style.css`
- JavaScript: `js/autoRefresh.js`, `js/changeRadiostation.js`
- Images: `images/radio.png`

### Adding Features

1. Models: Add to `mainapp/models.py`
2. Views: Add to `mainapp/views.py`
3. URLs: Add to `mainapp/urls.py`
4. Templates: Add to `mainapp/templates/mainapp/`

## Troubleshooting

### Common Issues

1. **Import Error**: Make sure Django is installed and virtual environment is activated
2. **Static Files Not Loading**: Run `python manage.py collectstatic` for production
3. **Database Issues**: Run `python manage.py migrate`
4. **Port Already in Use**: Use `python manage.py runserver 8080` to use a different port

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test your changes
5. Submit a pull request

## Support

For issues and questions, please create an issue in the project repository.
