package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class R9_MySQLConnection implements Runnable{

    public String teamname;
    public String ip;

    public R9_MySQLConnection(String ip){
        this.ip = ip;
    }

    public void run() {
        System.out.println("Read the players from the MySQL Database!");
        R9_Player.teamPlayerR9.removeAll(R9_Player.getTeamPlayers());
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");

            // Replace the 1st argument with the public IP of your PC -- see ipconfig from CMD
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");

            try {
                //Establishing a connection to get all players of the given team with their statistics, and storing them in objects of type Player for later use
                String sql;
                sql = "SELECT * FROM (SELECT * FROM player_stat_card LEFT JOIN player ON player_stat_card.player_id = player.id UNION SELECT * FROM player_stat_card RIGHT JOIN player ON player_stat_card.player_id = player.id) H WHERE H.team_name = '" + teamname + "';";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getInt("id"));
                    R9_Player.teamPlayerR9.add(new R9_Player(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("position"),
                            rs.getString("team_name"),
                            rs.getString("photo_path"),
                            rs.getInt("games_played"),
                            rs.getInt("total_time"),
                            rs.getInt("points"),
                            rs.getInt("made2p"),
                            rs.getInt("attempted2p"),
                            rs.getInt("made3p"),
                            rs.getInt("attempted3p"),
                            rs.getInt("madeft"),
                            rs.getInt("attemptedft"),
                            rs.getInt("off_rebs"),
                            rs.getInt("def_rebs"),
                            rs.getInt("assist"),
                            rs.getInt("blocks"),
                            rs.getInt("blocks_on"),
                            rs.getInt("steals"),
                            rs.getInt("turnovers"),
                            rs.getInt("fouls_drawn"),
                            rs.getInt("fouls_commited"),
                            rs.getInt("tendex")));
                }
                System.out.println("Allplayers size is: " + R9_Player.teamPlayerR9.size());
                preparedStatement.close();

                con.close();
            } catch (SQLException s) {
                System.out.println("SQL statement is not executed!");
                s.printStackTrace();

            } finally {
                con.close();
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}