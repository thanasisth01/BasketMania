package com.example.karta_agona;

import java.util.ArrayList;
import java.util.List;

public class BasketGameListR1 {

    private ArrayList<BasketGameR1> gamesList;
    private String ip;

    public BasketGameListR1(String ip) {
        this.ip = ip;
        MySQLConnectionMatchSelectionR1 mySQLConnection = new MySQLConnectionMatchSelectionR1(ip);
        Thread t = new Thread(mySQLConnection);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gamesList = mySQLConnection.getGames();
    }

    public List<BasketGameR1> getAllGames() {
        List<BasketGameR1> temp = new ArrayList<BasketGameR1>();
        for (int i=0; i<gamesList.size(); i++) {
            temp.add(gamesList.get(i));
        }
        return temp;
    }

    public List<BasketGameR1> getAllGames(int b) {
        List<BasketGameR1> temp = new ArrayList<BasketGameR1>();
        for (int i=0; i<gamesList.size(); i++) {
            if(gamesList.get(i).isInGameWeek(b)) {
                temp.add(gamesList.get(i));
            }
        }
        return temp;
    }

    public List<String> getAllGameTeamNames(int b) {
        List<String> temp = new ArrayList<String>();
        for (int i=0; i<gamesList.size(); i++) {
            if(gamesList.get(i).isInGameWeek(b)) {
                temp.add(gamesList.get(i).getTeamName1() + " - " + gamesList.get(i).getTeamName2());
            }
        }
        return temp;
    }
}
