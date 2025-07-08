package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLConnectionPlayerSelectionR1 implements Runnable {
    private ArrayList<PlayerR1> players = new ArrayList<>();
    private String team_name;
    private String ip;

    public MySQLConnectionPlayerSelectionR1(String team_name, String ip) {
        this.team_name = team_name;
        this.ip = ip;
    }

    @Override
    public void run() {
        System.out.println("Read the Players Data of Team " + team_name + " from the MySQL Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");
            System.out.println("Connection established");
            try{
                String sql;
                sql = "SELECT id, name, team_name, position FROM player WHERE team_name=?";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, team_name);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    players.add(new PlayerR1(rs.getInt("id"), rs.getString("name"), rs.getString("team_name"), rs.getString("position")));
                }
                preparedStatement.close();

                con.close();
            }
            catch (SQLException s){
                System.out.println("SQL statement is not executed!");
                s.printStackTrace();

            }finally {
                con.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PlayerR1> getPlayersList() {
        return players;
    }

}

