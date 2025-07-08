package com.example.karta_agona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TeamListR8 {

    private String ip;
    ArrayList<TeamR8> tList= new ArrayList<>();

    public TeamListR8(String ip){
        this.ip = ip;
        SQLConnectionR8 mySQLConnection = new SQLConnectionR8(ip);
        Thread t = new Thread(mySQLConnection);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tList = mySQLConnection.gettList();

        //Default sort by POINTS
        Collections.sort(tList, new Comparator<TeamR8>() {
            @Override
            public int compare(TeamR8 o1, TeamR8 o2) {
                return o2.getPoints()-o1.getPoints();
            }
        });
    }

}
