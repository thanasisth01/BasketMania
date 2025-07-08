package com.example.karta_agona;

import java.io.Serializable;

public class PlayerR1 implements Serializable {

    private int id;
    private String name;
    private String team_name;
    private String position;
    private boolean in_game = false;
    private int timeInGame = 0;
    private int timeofEntrance = 0;

    public PlayerR1(int id, String name, String team_name, String position) {
        this.id = id;
        this.name = name;
        this.team_name = team_name;
        this.position = position;
    }

    public int getTimeofEntrance() {
        return timeofEntrance;
    }

    public void setTimeofEntrance(int timeofEntrance) {
        this.timeofEntrance = timeofEntrance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam_name() {
        return team_name;
    }

    public boolean isIn_game() {
        return in_game;
    }

    public int getTimeInGame() {
        return timeInGame;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setIn_game(boolean in_game) {
        this.in_game = in_game;
    }

    public void setTimeInGame(int timeInGame) {
        this.timeInGame = timeInGame;
    }
}
