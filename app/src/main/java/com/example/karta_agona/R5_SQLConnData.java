package com.example.karta_agona;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Handler;

public class R5_SQLConnData implements Runnable{

    private R5_GameData theGame = new R5_GameData();             // a game that we store our data from the database
    private final String myIP;                                   // the IP, it gets its value from the constructor
    private int game_id;                                         // the game we want the data from

    // Constructor (sets the IP of the server we want to connect to and the game_id)
    public R5_SQLConnData(String myIP,int game_id) {
        this.myIP = myIP;
        this.game_id = game_id;
    }

    // We run this method to get the data we want for the game, from the basket_game table.
    @Override
    public void run() {
        Connection conn;

        try {

            Class.forName("org.mariadb.jdbc.Driver");

            // to connect to the server with IP we want to the 3306 port and with the given username and password.
            conn=DriverManager.getConnection("jdbc:mariadb://"+myIP+":3306/basket_data", "test","test");

            try {
                String sql1="SELECT game_id, team_name1, team_name2, points1, points2,made2p_1, attempted2p_1, made3p_1, attempted3p_1, madeft_1, attemptedft_1, made2p_2, attempted2p_2," +
                        " made3p_2, attempted3p_2,madeft_2, attemptedft_2, off_rebs1, def_rebs1, off_rebs2, def_rebs2, assist1, assist2, blocks1, blocks2, steals1, steals2, turnovers1, turnovers2, " +
                        "fouls1, fouls2, finished_game FROM basket_game WHERE game_id="+game_id+";";

                PreparedStatement stmt1 = conn.prepareStatement(sql1);
                ResultSet result = stmt1.executeQuery();

                while (result.next()) {

                    theGame.set_ID_P_TN(result.getInt("game_id"),result.getInt("points1"),
                            result.getInt("points2"),result.getString("team_name1"),
                            result.getString("team_name2"));

                    theGame.set_2_3_Points(result.getInt("made2p_1"),result.getInt("attempted2p_1"),
                            result.getInt("made3p_1"),result.getInt("attempted3p_1"),
                            result.getInt("made2p_2"),result.getInt("attempted2p_2"),
                            result.getInt("made3p_2"),result.getInt("attempted3p_2"));

                    theGame.setFT(result.getInt("madeft_1"),result.getInt("attemptedft_1"),result.getInt("madeft_2"),result.getInt("attemptedft_2"));


                    theGame.setRebounds(result.getInt("off_rebs1"),result.getInt("def_rebs1"),result.getInt("off_rebs2"),result.getInt("def_rebs2"));

                    theGame.set_Ass_Bl(result.getInt("assist1"), result.getInt("assist2"), result.getInt("blocks1"), result.getInt("blocks2"));

                    theGame.set_St_Tur_F(result.getInt("steals1"),result.getInt("steals2"),result.getInt("turnovers1"),result.getInt("turnovers2"),
                            result.getInt("fouls1"),result.getInt("fouls2"));

                    theGame.setFinishedGame(result.getInt("finished_game"));

                }
                stmt1.close();

                String sql2 = "SELECT icon_path FROM team WHERE name='"+theGame.getTeam_name_1()+"' OR name='"+theGame.getTeam_name_2()+"';";

                PreparedStatement stmt2 = conn.prepareStatement(sql2);

                ResultSet result2 = stmt2.executeQuery();
                //System.out.println("Imageurl is");
                result2.next();
                String img1 = result2.getString("icon_path");

                result2.next();
                String img2 = result2.getString("icon_path");

                theGame.setTeamImage1(img1);
                theGame.setTeamImage2(img2);

                stmt2.close();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // returns to the R5_MyConnection the data of the game we want.
    public R5_GameData getTheGame() {
        return theGame;
    }
}