package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class R7MySQLConnection implements Runnable {
    private ArrayList<R7TeamData> r7TeamDataArrayList = new ArrayList<>();
    private String ip;

    public R7MySQLConnection(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        System.out.println("Read the Basket Data from the MySQL Database!");
        Connection r7con;
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // Replace the 1st argument with the public IP of your PC -- see ipconfig from CMD
            r7con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data", "test", "test");
            System.out.println("Connection established");

            try {
                String r7sql;
                r7sql = "SELECT team_stat_card_id, team_name, games_played, rank_points, wins, losses FROM team_stat_card ORDER BY rank_points DESC";
                PreparedStatement preparedStatement = r7con.prepareStatement(r7sql);
                ResultSet r7rs = preparedStatement.executeQuery();

                //Inserting Data in r7TeamDataArrayList
                while (r7rs.next()) {
                    r7TeamDataArrayList.add(new R7TeamData(r7rs.getInt("team_stat_card_id"), r7rs.getString("team_name"), r7rs.getInt("games_played"),
                            r7rs.getInt("rank_points"), r7rs.getInt("wins"), r7rs.getInt("losses")));
                }
                preparedStatement.close();
                r7con.close();

            } catch (SQLException e) {
                System.out.println("Connection Failed!");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
        for(int i=0; i<r7TeamDataArrayList.size(); i++){
            System.out.println(r7TeamDataArrayList.get(i).getR7team_name() + " with " + r7TeamDataArrayList.get(i).getR7points() + " points, played " + r7TeamDataArrayList.get(i).getR7gamesplayed() +
                    " games, collected " + r7TeamDataArrayList.get(i).getR7points() + ", they won " + r7TeamDataArrayList.get(i).getR7wins() + " games, and lost " + r7TeamDataArrayList.get(i).getR7loses() + " times");
        }
    }

    public ArrayList<R7TeamData> getR7TeamList() {
        return r7TeamDataArrayList;
    }
}

