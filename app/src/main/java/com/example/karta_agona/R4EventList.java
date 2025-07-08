package com.example.karta_agona;
import java.util.ArrayList;

public class R4EventList {

    private ArrayList<R4Event> events;

    public R4EventList(String ip){

        R4MySQLConnection myConnection = new R4MySQLConnection(ip);
        Thread rs = new Thread(myConnection);
        try {
            rs.start();
            rs.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        events = myConnection.getR4Events();
    }

    public ArrayList<R4Event> getR4Events() {
        return events;
    }
}