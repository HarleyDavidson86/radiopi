<?php
#Radio ausschalten
shell_exec("./cmd/webradio-stop.sh");
#Letzten Sender aus Datei lesen
$lastsender = file_get_contents("lastsender");
$txtcontent = explode(";", file_get_contents("./radiostations/".$lastsender.".txt"));
$displayname = $txtcontent[0];
$url = $txtcontent[1];
#Info Message fuer Hauptseite
file_put_contents("infomessage", "Aktuell läuft: '".$displayname."'");
#Neuen Stream Starten
shell_exec("./cmd/webradio-start.sh $url");  
#Benutzerausgabe und Weiterleitung auf die index.php
echo "Radio wieder eingeschaltet. Es läuft '".$displayname."'. Du wirst wieder auf die Startseite weitergeleitet!";  
header("Refresh: 2; index.php");  
?>