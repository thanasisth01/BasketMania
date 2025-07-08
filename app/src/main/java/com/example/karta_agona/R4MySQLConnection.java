package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class R4MySQLConnection implements Runnable {
    private ArrayList<R4BasketGame> basketGames = new ArrayList<>();
    private ArrayList<R4Event> events = new ArrayList<>();
    private String ip;

    public R4MySQLConnection(String ip) {
        this.ip=ip;
    }

    @Override
    public void run() {
        System.out.println("Manage the Basket Data from the MySQL Database!");

        //Connection for Game
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Class for name");
            // Replace the 1st argument with the public IP of your PC -- see ipconfig from CMD
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");
            System.out.println("Connection established");
            try{
                String sql;
                sql="SELECT game_id, team_name1, team_name2,date , points1, points2, finished_game FROM basket_game";
                PreparedStatement preparedStatement2 = con.prepareStatement(sql);
                ResultSet rs = preparedStatement2.executeQuery();

                while (rs.next()){
                    basketGames.add( new R4BasketGame (rs.getInt("game_id"), rs.getString("team_name1"), rs.getString("team_name2"), rs.getTime("date"), rs.getInt("points1"),rs.getInt("points2"), rs.getInt("finished_game")));
                }

                preparedStatement2.close();
                con.close();
            }

            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
                s.printStackTrace();

            }finally {
                con.close();
            }
        }
        catch (Exception e){
            System.out.println("SQL statement is not executed!");
            e.printStackTrace();
        }

        //Connection For events
        Connection con2;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Class for name");
            // Replace the 1st argument with the public IP of your PC -- see ipconfig from CMD
            con2 = DriverManager.getConnection("jdbc:mariadb://"+ip+"/basket_data","test","test");
            System.out.println("Connection established");
            try{
                String sql;
                sql=" SELECT game_id,player_name,event_type, opponent_name,timestamp FROM event";
                PreparedStatement preparedStatement2 = con2.prepareStatement(sql);
                ResultSet rs = preparedStatement2.executeQuery();

                while (rs.next()){
                    events.add(new R4Event(rs.getInt("game_id"), rs.getString("player_name"),rs.getString("event_type"),rs.getString("opponent_name"), rs.getTimestamp("timestamp")));
                }

                preparedStatement2.close();
                con2.close();
            }

            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
                s.printStackTrace();

            }finally {
                con2.close();
            }
        }
        catch (Exception e){
            System.out.println("SQL statement is not executed!");
            e.printStackTrace();
        }
    }

    public ArrayList<R4BasketGame> getR4BasketGames() {
        return basketGames;
    }

    public ArrayList<R4Event> getR4Events(){
        return events;
    }
}
