#!/bin/bash
#Stoppen des Streams durch killen des Screens
screen -X -S webradio-player kill

#Info, dass das Radio aus ist in die Stream-Datei
#echo "<i>Radio ist derzeit aus</i>" > /home/webradio/streams/live.stream  