package com.example.karta_agona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnectionR2_R3 implements Runnable{

    private String sql;
    private String ip;
    private int placeHolderCounter;

    //R3: below are listed the variables used for the finish button
    private String namePlaceHolder;
    private String idPlaceHolder;

    private int iqueryValue;
    private String squeryValue;

    //Constructor for R3 queries executed on table player_game_stat_card
    // when finish button gets pressed.
    public MySQLConnectionR2_R3(String sql, String ip, String nph, String iph, int phc) {
        this.sql = sql;
        this.ip = ip;
        this.namePlaceHolder = nph;
        this.idPlaceHolder = iph;
        this.placeHolderCounter = phc;
    }

    //Constructor for R3 queries executed on tables player_stat_card and team_stat_card
    // when finish button gets pressed.
    public MySQLConnectionR2_R3(String sql, String ip, String nph, int phc) {
        this.sql = sql;
        this.ip = ip;
        this.namePlaceHolder = nph;
        this.placeHolderCounter = phc;
    }


    //Constructor for R2 and some one-line R3 queries:
    public MySQLConnectionR2_R3(String sql, String ip) {
        this.sql = sql;
        this.ip = ip;
    }

    public String getNamePlaceHolder() {return this.namePlaceHolder;}

    public void setNamePlaceHolder(String nph) {this.namePlaceHolder = nph;}

    public void run() {
        //System.out.println("Manage the Basket Data from the MySQL Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://"+ip+":3306/basket_data","test","test");
            //System.out.println("Connection established");
            try{
                //R3: Depending on the array column that is due to change, the appropriate values are
                //passed on to the query's placeholders.
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                if ((sql.contains("points =") || sql.contains("tendex =") || sql.contains("MPG =")) && (sql.contains("team_stat_card") || sql.contains("player_stat_card"))) {
                    System.out.println("Inside 1st iff");
                    for (int i=1; i<=placeHolderCounter; i++) {
                        preparedStatement.setString(i, namePlaceHolder);
                    }
                } else if (sql.contains("points =") && sql.contains("player_game_stat_card")) {
                    for(int i=1; i<=placeHolderCounter; i++) {
                        if (i%2!=0) {
                            preparedStatement.setString(i, namePlaceHolder);
                        } else {
                            preparedStatement.setString(i, idPlaceHolder);
                        }
                    }
                } else if (((sql.contains("points =") || sql.contains("tendex ="))) && (sql.contains("player_stat_card"))) {
                    for (int i=1; i<=placeHolderCounter; i++) {
                        preparedStatement.setString(i, namePlaceHolder);
                    }
                }else if (sql.contains("tendex =") && sql.contains("player_game_stat_card")) {
                    for(int i=1; i<=placeHolderCounter; i++) {
                        if (i%2!=0) {
                            preparedStatement.setString(i, idPlaceHolder);
                        } else {
                            preparedStatement.setString(i, namePlaceHolder);
                        }
                    }
                }


                if (!(sql.contains("UPDATE "))) {
                    //R3: the code below is used to calculate and update the basket_game table's winning_team field
                    ResultSet result = preparedStatement.executeQuery();
                    result.next();
                    if (sql.contains("points1")) {setIntQueryValue(result.getInt("points1"));}
                    else if (sql.contains("points2")) {setIntQueryValue(result.getInt("points2"));}
                    else if (sql.contains("winning_team_name")) {setStringQueryValue(result.getString("winning_team_name"));}
                }else {
                    preparedStatement.executeQuery();
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
            System.out.println("SQL statement is not executed!");
            e.printStackTrace();
        }
    }

    public void setIntQueryValue(int i) {this.iqueryValue = i;}

    public int getIntQueryValue() {return this.iqueryValue;}

    public void setStringQueryValue(String s) {this.squeryValue = s;}

    public String getStringQueryValue() {return this.squeryValue;}

}
