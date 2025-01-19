<?php
#Neuen Sender in Variable einlesen
$sender = $_POST['sender'];
#Aktuellen Sender in Datei speichern
file_put_contents("lastsender", $sender);
#Infos aus Datei holen
$txtcontent = explode(";", file_get_contents("./radiostations/".$sender.".txt"));
$displayname = $txtcontent[0];
$url = $txtcontent[1];
#Info Message fuer Hauptseite
file_put_contents("infomessage", "Aktuell läuft: '".$displayname."'");
#Aktuellen Stream stoppen
shell_exec("./cmd/webradio-stop.sh");  
#Neuen Stream Starten
shell_exec("./cmd/webradio-start.sh $url");  
#Benutzerausgabe und Weiterleitung auf die index.php
echo "Neuer Sender '".$displayname."' wurde eingestellt, du wirst wieder auf die Startseite weitergeleitet!";  
header("Refresh: 2; index.php");  
?>