from django.urls import path

from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('inforightbottom/', views.inforightbottom, name='inforightbottom'),
    path('infoleftbottom/', views.infoleftbottom, name='infoleftbottom'),
    path('api/radiostation/play/<int:station_id>/', views.changeRadiostation, name='change_station'),
]
