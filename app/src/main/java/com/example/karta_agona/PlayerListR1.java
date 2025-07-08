package com.example.karta_agona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerListR1 implements Serializable {
    private ArrayList<PlayerR1> playersList;
    private String team_name;

    public PlayerListR1(String team_name, String ip) {
        this.team_name=team_name;
        MySQLConnectionPlayerSelectionR1 mySQLConnection = new MySQLConnectionPlayerSelectionR1(team_name, ip);
        Thread t = new Thread(mySQLConnection);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        playersList = mySQLConnection.getPlayersList();
    }

    public PlayerR1 getPlayer(String name){
        for(int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getName().equals(name)){
                return playersList.get(i);
            }
        }
        return null;
    }

    public int getPlayerId(String name){
        for(int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getName().equals(name)){
                return playersList.get(i).getId();
            }
        }
        return 0;
    }

    public int getPlayerTime(String name){
        for(int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getName().equals(name)){
                return playersList.get(i).getTimeInGame();
            }
        }
        return 0;
    }

    public List<PlayerR1> getAllPlayers(String team_name) {
        List<PlayerR1> temp = new ArrayList<>();
        for (int i=0; i<playersList.size(); i++) {
            if(playersList.get(i).getTeam_name().equals(team_name)) {
                temp.add(playersList.get(i));
            }
        }
        return temp;
    }

    public void whenPlayerIsChosen(String name){
        for(int i=0; i<playersList.size(); i++){
            if(playersList.get(i).getName().equals(name)){
                if(playersList.get(i).isIn_game())
                    playersList.get(i).setIn_game(false);
                else
                    playersList.get(i).setIn_game(true);
            }
        }
    }

    public void setPlayerOUTTime(String name, int timeOfExit) {
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getName().equals(name)) {
                int timeAlreadyIN = playersList.get(i).getTimeInGame();
                int timeofLastEntrance = playersList.get(i).getTimeofEntrance();
                playersList.get(i).setTimeInGame(timeOfExit - timeofLastEntrance + timeAlreadyIN);
            }
        }
    }

    public void setPlayerINTime(String name, int timeOfEntrance){
        for(int i=0; i<playersList.size(); i++) {
            if (playersList.get(i).getName().equals(name)) {
                playersList.get(i).setTimeofEntrance(timeOfEntrance);
            }
        }
    }
}
