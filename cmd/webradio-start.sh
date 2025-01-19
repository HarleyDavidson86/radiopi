#!/bin/bash
#Test ob Parameter fuer Stream uebergeben wurde
if [ -v $1 ] ; then
        echo "Usage: webradio-start.sh <stream-name>"  
        exit 1
fi

#Test ob es den Stream also die Datei auch gibt
# if [ ! -e /home/webradio/streams/$1 ] ; then
#         echo "Non-existent Stream!"  
#         exit 2
# fi

#Setzen der Variable STRURL, die die Internetadresse des Streams beinhaltet
# STRURL=`cat /home/webradio/streams/$1`
STRURL=$1

#Starten des Streams im Screen
screen -dmS webradio-player mplayer $STRURL

#Schreiben des Stream-Namens in die Stream-Datei
# echo $1 > /home/webradio/streams/live.stream