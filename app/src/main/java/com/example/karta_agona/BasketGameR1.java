package com.example.karta_agona;

public class BasketGameR1 {

    private int id;
    private String teamName1;
    private String teamName2;
    private int points1;
    private int points2;
    private int game_week_number;


    public BasketGameR1(int id, String teamName1, String teamName2, int points1, int points2, int game_week_number) {
        this.id = id;
        this.teamName1 = teamName1;
        this.teamName2 = teamName2;
        this.points1 = points1;
        this.points2 = points2;
        this.game_week_number = game_week_number;
    }

    public boolean isInGameWeek(int b) {
        return (this.game_week_number==b);
    }

    public int getId() { return id; }

    public String getTeamName1() {
        return teamName1;
    }

    public String getTeamName2() {
        return teamName2;
    }

    public int getPoints1() {
        return points1;
    }

    public int getPoints2() {
        return points2;
    }

    public int getGame_week_number() {
        return game_week_number;
    }
}
