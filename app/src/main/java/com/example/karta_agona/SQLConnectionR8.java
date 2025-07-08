package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLConnectionR8 implements Runnable {
    private ArrayList<TeamR8> tList = new ArrayList<>();
    private String ip;

    public SQLConnectionR8(String ip) {
        this.ip = ip;
    }

    public void run() {
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");

            // Replace the 1st argument with the public IP of your PC -- see ipconfig from CMD
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");
            try{
                String sql;
                sql = "SELECT team_stat_card_id, team_name, games_played, points, made2p, attempted2p, made3p, attempted3p, madeft, attemptedft, off_rebs, def_rebs, assist, blocks, blocks_on, steals, turnovers, fouls_drawn, fouls_commited FROM team_stat_card";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    tList.add(new TeamR8(rs.getInt("team_stat_card_id"), rs.getString("team_name"), rs.getInt("games_played"), rs.getInt("points"),rs.getInt("made2p"),rs.getInt("attempted2p"),rs.getInt("made3p"),rs.getInt("attempted3p"),rs.getInt("madeft"),rs.getInt("attemptedft"),rs.getInt("off_rebs"),rs.getInt("def_rebs"),rs.getInt("assist"),rs.getInt("blocks"),rs.getInt("blocks_on"),rs.getInt("steals"),rs.getInt("turnovers"),rs.getInt("fouls_drawn"),rs.getInt("fouls_commited")));
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
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<TeamR8> gettList(){
        return tList;
    }

}

