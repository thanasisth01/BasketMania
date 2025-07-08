package com.example.karta_agona;
import java.sql.Time;

public class R4BasketGame {

    private int game_id;
    private String team_1;
    private String team_2;
    private Time startingTime;
    private int score1;
    private int score2;
    private int finished_game;

    public R4BasketGame(int game_id, String team_1, String team_2, Time startingTime, int score1, int score2,int finished_game) {
        this.game_id = game_id;
        this.team_1 = team_1;
        this.team_2 = team_2;
        this.startingTime = startingTime;
        this.score1 = score1;
        this.score2 = score2;
        this.finished_game =finished_game;
    }


    public Time getStartingTime() { return startingTime; }

    public int getGame_id() {
        return game_id;
    }

    public String getTeam_1() {
        return team_1;
    }

    public String getTeam_2() {
        return team_2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getFinishedGame() {
        return finished_game;
    }
}
