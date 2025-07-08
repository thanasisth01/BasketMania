package com.example.karta_agona;

public class R7TeamData {
    //R7TeamData elements
    private int r7teamid;
    private String r7team_name;
    private int r7gamesplayed;
    private int r7points;
    private int r7wins;
    private int r7loses;



    public R7TeamData(int r7teamid, String r7team_name, int r7gamesplayed, int r7points, int r7wins, int r7loses) {
        this.r7teamid = r7teamid;
        this.r7team_name = r7team_name;
        this.r7gamesplayed = r7gamesplayed;
        this.r7points = r7points;
        this.r7wins = r7wins;
        this.r7loses = r7loses;
    }

    public int getR7teamid() {
        return r7teamid;
    }

    public String getR7team_name() {
        return r7team_name;
    }

    public int getR7gamesplayed() {
        return r7gamesplayed;
    }

    public int getR7points() {
        return r7points;
    }

    public int getR7wins() {
        return r7wins;
    }

    public int getR7loses() {
        return r7loses;
    }
}
