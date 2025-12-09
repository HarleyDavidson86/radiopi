from django.shortcuts import render
from django.http import HttpResponse
from datetime import datetime
from .models import RadioStation

# Create your views here.
def index(request):
    stations = RadioStation.objects.all()
    return render(request, "mainapp/index.html", {"stations": stations})

def inforightbottom(request):
    current_time = datetime.now().strftime("%H:%M")
    context = {"time": current_time}
    return render(request, "mainapp/inforightbottom.html", context)

def infoleftbottom(request):
    context = {"sendername": "Radio Klassik"}
    return render(request, "mainapp/infoleftbottom.html", context)

def changeRadiostation(request, station_id):
    # Logic to change the radio station
    print("Changing radio station to:", station_id)
    return HttpResponse("Radio station changed to: " + str(station_id))