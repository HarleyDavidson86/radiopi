from django.db import models

class RadioStation(models.Model):
    short_name = models.CharField(max_length=10)
    name = models.CharField(max_length=50)
    url = models.URLField()
    logo = models.ImageField()
