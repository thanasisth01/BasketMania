package com.example.karta_agona;

import java.util.*;

public class R10PlayersList {
    ArrayList<R10Player> r10Players = new ArrayList<R10Player>();

    public R10PlayersList(String ip) {
        R10MySQLConnection mySQLConnection = new R10MySQLConnection(ip);
        Thread t = new Thread(mySQLConnection);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        r10Players = mySQLConnection.getPlayers();
    }

    public ArrayList<R10Player> getPlayers(){
        return r10Players;
    }


}
