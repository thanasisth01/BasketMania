package com.example.karta_agona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class R10MySQLConnection implements Runnable{
    public static ArrayList<R10Player> r10Players = new ArrayList<>();
    public static ArrayList<Integer> GWN = new ArrayList<>();
    public String ip;

    public R10MySQLConnection(String ip) {
        this.ip = ip;
    }

    @Override
    public void run() {
        System.out.println("Read the Player Stats from the MySQL Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");

            // Replace the 1st argument with the public IP of your PC -- see ipconfig from CMD
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");
            try{
                String sql;
                //sql = "SELECT DISTINCT game_week_number FROM player_game_stat_card";
                sql = "SELECT * FROM player_game_stat_card";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    //GWN.add(rs.getInt("game_week_number"));
                    r10Players.add(new R10Player(rs.getInt("player_id"), rs.getInt("game_week_number"), rs.getString("player_name"), rs.getString("position"), rs.getInt("points"), rs.getInt("made2p"), rs.getInt("attempted2p"),rs.getInt("made3p"),rs.getInt("attempted3p"),rs.getInt("madeft"),rs.getInt("attemptedft"),rs.getInt("off_rebs"),rs.getInt("def_rebs"),rs.getInt("assist"),rs.getInt("blocks"),rs.getInt("blocks_on"),rs.getInt("steals"),rs.getInt("turnovers"), rs.getInt("fouls_commited"),rs.getInt("fouls_drawn"), rs.getInt("shots_rejected")));

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

    public ArrayList<R10Player> getPlayers() {
        return r10Players;
    }
}
