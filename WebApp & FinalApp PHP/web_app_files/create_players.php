<doctype! html>
<html>
    <head> 
        <meta charset="utf-8">
        <title>Δημιουργία Παίκτη</title>
        <link rel="stylesheet" href="android_style.css">
    </head>

    <body>     

            <h1>Δημιουργία Παίκτη</h1>

            <p> Η σελίδα αυτήν δίνεται για να γίνεται εκχώρηση του παίκτη στην βάση δεδομένων. 
                Για κάθε παίκτη πρέπει να δωθούν οι εξής πληροφορίες για να αποθηκευτεί στην βάση.
                Διαφορετικά η εισαγωγή δεν πραγματοποιείται. <p>

            <?php
                $name=$position=$team_name=$photo_path="";
                $demand_name=$demand_position=$demand_team_name=$demand_photo_path="";

                if ($_SERVER['REQUEST_METHOD'] == "POST") {
                    
                    if (empty($_POST['name'])) {
                        $demand_name="*Υποχρεωτική εισαγωγή ονόματος*";
                    }
                    else {
                        $name = $_POST['name'];
                        $name = check_strings($name);
                        if (!check_name($name)) {
                            $demand_name="*Λάθος εισαγωγή, χρήση μόνο γραμμάτων και κενών*";
                        }
                    }

                    if (empty($_POST['position'])) {
                        $demand_position="*Υποχρεωτική εισαγωγή θέσης παίκτη*";
                    }
                    else {
                        $position = $_POST['position'];
                        $position = check_strings($position);
                        if (!check_position($position)) {
                            $demand_position="*Λάθος εισαγωγή, χρήση σωστών θέσεων των παικτών ή μόνο γραμμάτων και κενών*";
                        }
                    }

                    if (empty($_POST['team_name'])) {
                        $demand_team_name = "*Υποχρεωτική εισαγωγή ονόματος ομάδας*";
                    }
                    else {
                        $team_name = $_POST['team_name'];
                        $team_name = check_strings($team_name);
                        if (!check_name($team_name)) {
                            $demand_team_name="*Λάθος εισαγωγή, χρήση σωστών ονομάτων των ομάδων*";
                        }
                    }

                    if (empty($_POST['photo_path'])) {
                        $demand_photo_path = "*Υποχρεωτική εισαγωγή φωτογραφίας*";
                    }
                    else {
                        $photo_path = $_POST['photo_path'];
                        $photo_path = check_strings($photo_path);
                        if (!check_url($photo_path)) {
                            $demand_photo_path="*Λάθος εισαγωγή, χρήση σωστού URL της φωτογραφίας*";
                        }
                    }
                }
            ?>      

            <form id="form_screen" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="post">
                
                <input type="text" id="name" name="name" value="" placeholder="Όνομα"></input>
                <span name="demand_name" class="errors"> <?php echo $demand_name; ?> </span> 
                <br>

                <input type="text" id="position" name="position" value="" placeholder="Θέση"></input>
                <span name="demand_position" class="errors"> <?php echo $demand_position; ?> </span>
                <br>

                <input type="text" id="team_name" name="team_name" value="" placeholder="Όνομα Ομάδας"></input>
                <span name="demand_team_name" class="errors"> <?php echo $demand_team_name; ?> </span>
                <br>

                <input type="text" id="photo_path" name="photo_path" value="" placeholder="Σύνδεσμος Φωτογραφίας"></input>
                <span name="demand_photo_path" class="errors"> <?php echo $demand_photo_path; ?> </span>

                <input type="submit" id="submit_button" name="submit_button" value="Πρσθήκη Παίκτη"></input>

            </form>

            <?php

                $servername = "localhost";
                $username = "root";
                $password = "";

                $connection = new mysqli($servername,$username,$password,"basket_data");
            
                if ($connection->connect_error)
                    die ("Failed connection: ".$connection->connect_error."<br>");
                
                if (check_demands($demand_name,$demand_position,$demand_team_name,$demand_photo_path,$name)) {

                    $stmt = "INSERT INTO player (name,position,team_name,photo_path) VALUES ('$_POST[name]','$_POST[position]','$_POST[team_name]','$_POST[photo_path]')";

                    if (!$connection->multi_query($stmt)===TRUE) { 
                        echo "Error: " . $stmt . "<br>" . $connection->error;
                    } else {
                        echo "<p>New Player Added!</p>";
                    }
                }

                $connection->close();

                function check_strings($aString) {
                    $aString=trim($aString);
                    $aString=stripslashes($aString);
                    $aString=htmlspecialchars($aString);

                    return $aString;
                }

                function check_name($aName) {

                    $outcome=preg_match("/^[A-Za-z ]*$/",$aName);

                    return $outcome;
                }

                function check_url($aURL) {
                    $outcome = preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$aURL);

                    return $outcome;
                }

                function check_position($aPosition) {
                    
                    if ($aPosition=="Point Guard" || $aPosition=="Shooting Guard" || $aPosition=="Small Forward" || $aPosition=="Power Forward" || $aPosition=="Center")
                        $outcome = true;
                    else 
                        $outcome = false;

                    return $outcome;
                }

                function check_demands($demand_name,$demand_position,$demand_team_name,$demand_photo_path,$full_name) {

                    if ($demand_name=="" && $demand_position=="" && $demand_team_name=="" && $demand_photo_path=="" && $full_name!="")
                        $value = true;
                    else 
                        $value = false;

                    return $value;
                }

            ?>

            
            <p>Σημείωση: Οι θέσεις οι οποίες μπορούν να εκχωρηθούν στον παίκτη δίνονται από τις εξής ονομασίες:
                Point Guard, Shooting Guard, Small Forward, Power Forward και Center. <br>Κάθε όνομα θέσης πρέπει
                να εκχωρηθεί όπως δίνεται παραπάνω, διαφορετικά δεν θα γίνει εισαγωγή στην βάση.</p>

    </body>

</html>