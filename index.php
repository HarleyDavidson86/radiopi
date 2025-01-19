<!DOCTYPE html>
<html lang="de">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PiRadio</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }

        .container {
            display: flex;
            flex-flow: row wrap;
            justify-content: center;
        }

        .kachel {
            width: 200px;
            height: 200px;
            cursor: pointer;
            margin: 10px;
            transition: transform 0.3s;
            border: none;
        }

        .kachel img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 10px;
        }

        .kachel:hover {
            transform: scale(1.1);
            background: inherit;
        }
    </style>
</head>

<body>
    <h1 style="text-align: center;font-size: 20pt;">PiRadio</h1>
    <p style="text-align: center;font-size: 10pt;">
        <?php
        $message = file_get_contents("infomessage");
        //If no message exist, put an empty string
        if (!$message) {
            $message = "&nbsp;";
        }
        echo $message;
        ?>
    </p>
    <div class="container">
    <form action="radio-off.php" method=post> 
        <button type="submit" class="kachel" name="sender" value="radio-off">
            <img src="img/off.png" alt="Radio off">
        </button>
    </form>
    <?php if (file_exists("lastsender")) { ?>
    <form action="radio-on.php" method=post> 
        <button type="submit" class="kachel" name="sender" value="radio-on">
            <img src="img/play.png" alt="Radio on">
        </button>
    </form>
    <?php } //end if file exists?>
    <form action="change-sender.php" method=post>
        <?php
        //Get all txtfiles from "radiostations"
        foreach (glob("./radiostations/*.txt") as $txtfile) {
            // Basename without fileextension for value
            $basename = pathinfo($txtfile, PATHINFO_FILENAME);
            $pngfile = str_replace(".txt", ".png", $txtfile);
            $txtcontent = explode(";", file_get_contents($txtfile));
            $displayname = $txtcontent[0];
            $url = $txtcontent[1];

            echo '<button type="submit" class="kachel" name="sender" value="'.$basename.'">';
            echo '<img src="'.$pngfile.'" alt="'.$displayname.'">';
            echo '</button>';
        }
        ?>
    </form>
    </div>
</body>

</html>