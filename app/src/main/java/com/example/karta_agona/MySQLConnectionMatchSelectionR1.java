package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLConnectionMatchSelectionR1 implements Runnable{
    private ArrayList<BasketGameR1> games = new ArrayList<>();
    private ArrayList<GameWeekR1> game_week_numbers = new ArrayList<>();
    private String ip;

    public MySQLConnectionMatchSelectionR1(String ip) {
        this.ip = ip;
    }

    public void run() {
        System.out.println("Read the Basket Data from the MySQL Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":3306/basket_data","test","test");
            System.out.println("Connection established");
            try{
                String sql;
                sql = "SELECT game_id, team_name1, team_name2, game_week_number, points1, points2 FROM basket_game";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    games.add(new BasketGameR1(rs.getInt("game_id"), rs.getString("team_name1"), rs.getString("team_name2"), rs.getInt("points1"), rs.getInt("points2"), rs.getInt("game_week_number")));
                }
                preparedStatement.close();


                String sql1;
                sql1 = "SELECT game_week_number FROM game_week";
                PreparedStatement preparedStatement1 = con.prepareStatement(sql1);
                ResultSet res1 = preparedStatement1.executeQuery();
                while(res1.next()){
                    game_week_numbers.add(new GameWeekR1(res1.getInt("game_week_number")));
                }
                preparedStatement1.close();
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
            e.printStackTrace();
        }
    }

    public ArrayList<GameWeekR1> getGameWeekList() {
        return game_week_numbers;
    }

    public ArrayList<BasketGameR1> getGames() {
        return  games;
    }

}