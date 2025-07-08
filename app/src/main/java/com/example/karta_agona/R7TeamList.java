package com.example.karta_agona;
import java.util.ArrayList;
import java.util.List;

public class R7TeamList {

    private ArrayList<R7TeamData> getR7Teams;

    public R7TeamList(String ip){

        R7MySQLConnection r7mySQLConnection = new R7MySQLConnection(ip);
        Thread r7t = new Thread(r7mySQLConnection);
        try {
            r7t.start();
            r7t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getR7Teams = r7mySQLConnection.getR7TeamList();
    }

    public ArrayList<R7TeamData> getGetR7Teams() {
        return getR7Teams;
    }
}
