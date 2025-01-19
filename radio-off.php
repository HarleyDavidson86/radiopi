<?php
#Radio ausschalten
shell_exec("./cmd/webradio-stop.sh");  
#Info Message fuer Hauptseite
file_put_contents("infomessage", "Radio ist aus.");
#Benutzerausgabe und Weiterleitung auf die index.php
echo "Radio wurde ausgeschaltet, du wirst wieder auf die Startseite weitergeleitet!";  
header("Refresh: 2; index.php");  
?>