package com.example.karta_agona;

import java.util.ArrayList;
import java.util.List;

public class GameWeekListR1 {

    private ArrayList<GameWeekR1> gameWeekList;
    private String ip;

    public GameWeekListR1(String ip) {
        MySQLConnectionMatchSelectionR1 mySQLConnection = new MySQLConnectionMatchSelectionR1(ip);
        Thread t = new Thread(mySQLConnection);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gameWeekList = mySQLConnection.getGameWeekList();
    }

    public List<Integer> getAllGameWeeks() {
        List<Integer> temp = new ArrayList<Integer>();
        for (int i=0; i<gameWeekList.size(); i++) {
            temp.add(gameWeekList.get(i).getGame_week_number());
        }
        return temp;
    }

}
