package com.example.karta_agona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class R9_SQLgetTeamNames implements Runnable{



    public ArrayList<String> teamNames = new ArrayList<>(); //To store team names
    public String ip;

    public R9_SQLgetTeamNames(String ip){
        this.ip = ip;
    }
    @Override
    public void run() {
        System.out.println("Read the players from the MySQL Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");

            //Establishing a connection to get all the team names from the database
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");

            try {
                String sql;
                sql = "SELECT name FROM team";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                    teamNames.add(rs.getString("name"));
                }
                System.out.println("Teams size is: " + teamNames.size());
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

    public ArrayList<String> getTeamNames() {
        return teamNames;
    }

}