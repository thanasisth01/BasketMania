package com.example.karta_agona;

import java.util.ArrayList;

public class R5_MyConnection {

    // This class sets the connection between the application and the server.

    private R5_GameData aGame;                   // the game that returns from the MySQLConnection
    private String myIP;                         // the IP given from the MainActivity
    private int game_id;                         // the game we want the data from

    // Constructor (setting the IP from the parameter)
    public R5_MyConnection(String myIP,int game_id) {
        this.myIP = myIP;
        this.game_id = game_id;
    }

    // We get the last game that was added to our table in the server and we set it
    // in our local variable aGame.

    // The StartConnectionToGetData sets the aGame from the data from the database.
    // Through the R5_SQLConnData we get the game data we want.

    public void StartConnectionToGetData() {

        R5_SQLConnData conn = new R5_SQLConnData(myIP,game_id);
        Thread t = new Thread(conn);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        aGame = conn.getTheGame();
    }

    //  The method returns the game that we asked for through game_id
    public R5_GameData getTheGame() {
        return aGame;
    }
}
