package com.example.karta_agona;
import java.util.ArrayList;

public class R4BasketGameList {

    private ArrayList<R4BasketGame> basketGames;

    public R4BasketGameList(String ip){

        R4MySQLConnection myConnection = new R4MySQLConnection(ip);
        Thread rs = new Thread(myConnection);
        try {
            rs.start();
            rs.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        basketGames = myConnection.getR4BasketGames();
    }

    public ArrayList<R4BasketGame> getR4BasketGames() {
        return basketGames;
    }
}