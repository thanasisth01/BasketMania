package com.example.karta_agona;

import java.sql.Timestamp;

public class R4Event {

    private int gameID;
    private String playerName;
    private String eventType;
    private String opponentsName;
    private Timestamp eventTime;

    public R4Event(int gameID, String playerName, String eventType, String opponentsName,Timestamp eventTime) {
        this.gameID = gameID;
        this.playerName = playerName;
        this.eventType = eventType;
        this.opponentsName= opponentsName;
        this.eventTime = eventTime;
    }

    public int getGameID() {
        return gameID;
    }

    public Timestamp getEventTime() { return eventTime; }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getOpponentsName() {
        return opponentsName;
    }

    public void setOpponentsName(String opponentsName) {
        this.opponentsName = opponentsName;
    }


}
