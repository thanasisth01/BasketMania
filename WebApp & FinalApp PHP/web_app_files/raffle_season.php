<doctype! html>
<html>
    <head> 
        <meta charset="utf-8">
        <title>Κλήρωση Αγωνιστικών</title>
    </head>

    <body>     
            <h1>Κλήρωση Αγωνιστικών</h1>

            <style>
                <?php include 'android_style.css'; ?>
            </style>

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

                $num_of_seasons = $total_teams-1;
                $num_games_per_season = $total_teams/2;

                $total_games = $num_games_per_season*$num_of_seasons;

                echo "<p>Μόλις έγινε η κλήρωση των αγωνιστικών και προστέθηκαν στη βάση δεδομένων! </p> <br>";

                echo "<p>Ο συνολικός αριθμός των ομάδων είναι ".$total_teams.". Αυτό σημαίνει ότι:</p> <br>";

                echo "<p>Ο συνολικός αριθμός αγωνιστικών του πρωταθλήματος είναι: ".$num_of_seasons."</p>";
                
                echo "<p>Ο αριθμός αγώνων κάθε αγωνιστικής είναι: ".$num_games_per_season."</p>";

                echo "<p>Ο συνολικός αριθμός αγώνων σε όλο το πρωτάθλημα είναι: ".$total_games."</p><br>";

                echo "<p>Παρακάτω δίνονται όλοι αγώνες κάθε αγωνιστικής μεταξύ των ομάδων και για όλο το πρωτάθλημα: </p><br>";

                $agon=1;
                $i=0;
                while ($i<$total_games){

                    echo "<h3>ΑΓΩΝΙΣΤΙΚΗ ".$agon."</h3>";

                    echo "<table> <tr> <th>ΑΡΙΘΜΟΣ ΠΑΙΧΝΙΔΙΟΥ</th> <th>ΟΝΟΜΑ 1ΗΣ ΟΜΑΔΑΣ</th> <th>ΟΝΟΜΑ 2ΗΣ ΟΜΑΔΑΣ</th> </tr>";
    
                    for($j=0; $j<$total_teams; $j+=2){
                        $i++;
                        echo "<tr> <td>".$i."</td><td>".$team_names[$j]."</td><td>".$team_names[$j+1]."</td> </tr>";
                        $get_teams = "INSERT INTO basket_game (game_id,team_name1,team_name2,game_week_number) VALUES ('".$i."','".$team_names[$j]."','".$team_names[$j+1]."','".$agon."');";
                        $result = mysqli_query($connection, $get_teams);
                    }

                    echo "</table><br><br>";

                    $agon++;
    
                    for($k = $total_teams-1; $k>1; $k--){
                        $temp = $team_names[$k];
                        $team_names[$k] = $team_names[$k-1];
                        $team_names[$k-1] = $temp; 
                    }
    
                }

                $connection->close();
            ?>

    </body>

</html>