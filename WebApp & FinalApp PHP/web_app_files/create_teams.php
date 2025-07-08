<doctype! html>
<html>
    <head> 
        <meta charset="utf-8">
        <title>Δημιουργία Ομαδών</title>
        <link rel="stylesheet" href="android_style.css">
    </head>

    <body>     
            
            <h1>Δημιουργία Ομάδας</h1>

            <p>Η σελίδα αυτήν χρησιμοποιείται για να δημιουργούνται οι ομάδες
                που θέλουμε να εισαχθούν στη βάση δεδομένων.Για κάθε ομάδα
                πρέπει να δωθούν οι εξής πληροφορίες για να αποθηκευτεί στην βάση.
                Διαφορετικά η εισαγωγή δεν πραγματοποιείται.
            </p>

            <?php
                $name=$city=$photo_path="";
                $demand_name=$demand_city=$demand_photo_path="";

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

                    if (empty($_POST['city'])) {
                        $demand_city="*Υποχρεωτική εισαγωγή ονόματος πόλης*";
                    }
                    else {
                        $city = $_POST['city'];
                        $city = check_strings($city);
                        if (!check_name($city)) {
                            $demand_city="*Λάθος εισαγωγή, χρήση μόνο γραμμάτων και κενών*";
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

                <input type="text" id="city" name="city" value="" placeholder="Πόλη"></input>
                <span name="demand_position" class="errors"> <?php echo $demand_city; ?> </span>
                <br>

                <input type="text" id="photo_path" name="photo_path" value="" placeholder="Σύνδεσμος Φωτογραφίας"></input>
                <span name="demand_photo_path" class="errors"> <?php echo $demand_photo_path; ?> </span>
                <br>

                <input type="submit" id="submit_button" name="submit_button" value="Πρσθήκη Ομάδας"></input>

            
            </form>

            <?php

                $servername = "localhost";
                $username = "root";
                $password = "";

                $connection = new mysqli($servername,$username,$password,"basket_data");
            
                if ($connection->connect_error)
                    die ("Failed connection: ".$connection->connect_error."<br>");
                
                if (check_demands($demand_name,$demand_city,$demand_photo_path,$name)) {

                    $stmt = "INSERT INTO team (name,city,icon_path) VALUES ('$_POST[name]','$_POST[city]','$_POST[photo_path]')";

                    if (!$connection->multi_query($stmt) === TRUE) { 
                        echo "Error: " . $stmt . "<br>" . $connection->error;
                    } else {
                        echo "<p>New Team Added!</p>";
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
                    $outcome=preg_match("/^[a-zA-Z ]*$/",$aName);

                    return $outcome;
                }

                function check_url($aURL) {
                    $outcome = preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$aURL);

                    return $outcome;
                }

                function check_demands($demand_full_name,$demand_city,$demand_photo_path,$full_name) {

                    if ($demand_full_name=="" && $demand_city=="" && $demand_photo_path=="" && $full_name!="")
                        $value = true;
                    else 
                        $value = false;

                    return $value;
                }

            ?>
    </body>

</html>