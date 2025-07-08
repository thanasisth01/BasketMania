<doctype! html>
<html>
    <head> 
        <meta charset="utf-8">
        <title>Δημιουργία Πρωταθλήματος</title>
        <link rel="stylesheet" href="android_style.css">
    </head>

    <body>     
            <h1>Δημιουργία Πρωταθλήματος</h1>

            <p>Η σελίδα αυτήν χρησιμοποιείται για να παρουσιάζονται ποιες ομάδες
                συμμετέχουν στο πρωτάθλημα για να μπορέσει να διεξαχθεί πρωτάθλημα
                με ζυγό αριθμό ομάδων. <br> Αν δεν υπάρχει θέμα με τον αριθμό των ομάδων,
                αφού σιγουρευτείτε ότι εμπεριέχονται όλες οι ομάδες που θέλετε στην παρακάτω
                λίστα, πατήστε το κουμπί για την κλήρωση των αγωνιστικών του πρωταθλήματος.
            </p>

            <?php
                
                $servername = "localhost";
                $username = "root";
                $password = "";

                $connection = new mysqli($servername,$username,$password,"basket_data");
            
                if ($connection->connect_error)
                    die ("Failed connection: ".$connection->connect_error."<br>");

                $get_teams = "SELECT name FROM team";
                $result = mysqli_query($connection, $get_teams);
                $team_names = array();

                while ($row = mysqli_fetch_array($result)) {

                    $team_name = $row['name'];
                    array_push($team_names,$team_name);
                }

                $total_teams = sizeof($team_names);            

                if ($total_teams%2 == 0 ) {
                    // είναι ζυγός αριθμός ομαδών

                    echo "<h3>Οι ομάδες οι οποίες συμμετέχουν στο πρωτάθλημα είναι οι εξής:</h3>";

                    $mode = current($team_names);
                    echo "<p>".$mode."</p>";
                    
                    $total_teams = $total_teams-1;
                    
                    while ($total_teams>0) {
                        $mode = next($team_names);
                        echo "<p>".$mode."</p>";
                        $total_teams = $total_teams-1;
                    }

                    echo '<br> <div> <a href="raffle_season.php">Κλήρωση Αγωνιστικών</a> </div>';

                } else {
                    // είναι περιττός αριθμός ομαδών
                    echo "<p>Πρέπει να προσθέσεις ακόμα μία ομάδα! </p>";
                }

            ?>

            
    </body>

</html>