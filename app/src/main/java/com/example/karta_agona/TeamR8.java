package com.example.karta_agona;

import java.util.*;

public class TeamR8 {

    private int id;
    private String name;
    private int games_played;
    private int points;
    private int made2p;
    private int made3p;
    private int attempted2p;
    private int attempted3p;
    private int madeft;
    private int attemptedft;
    private int off_rebs;
    private int def_rebs;
    private int assist;
    private int blocks;
    private int blocks_on;
    private int steals;
    private int turnovers;
    private int fouls_drawn;
    private int fouls_commited;
    //private int rank;

    public TeamR8(int id, String name, int games_played, int points, int made2p, int made3p, int attempted2p, int attempted3p, int madeft, int attemptedft, int off_rebs, int def_rebs, int assist, int blocks, int blocks_on, int steals, int turnovers, int fouls_drawn, int fouls_commited) {
        this.id = id;
        this.name = name;
        this.games_played = games_played;
        this.points = points;
        this.made2p = made2p;
        this.made3p = made3p;
        this.attempted2p = attempted2p;
        this.attempted3p = attempted3p;
        this.madeft = madeft;
        this.attemptedft = attemptedft;
        this.off_rebs = off_rebs;
        this.def_rebs = def_rebs;
        this.assist = assist;
        this.blocks = blocks;
        this.blocks_on = blocks_on;
        this.steals = steals;
        this.turnovers = turnovers;
        this.fouls_drawn = fouls_drawn;
        this.fouls_commited = fouls_commited;
        //this.rank = made2p+made3p;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGames_played() {
        return games_played;
    }

    public int getPoints() {
        return points;
    }

    public int getMade2p() {
        return made2p;
    }

    public int getMade3p() {
        return made3p;
    }

    public int getAttempted2p() {
        return attempted2p;
    }

    public int getAttempted3p() {
        return attempted3p;
    }

    public int getMadeft() {
        return madeft;
    }

    public int getAttemptedft() {
        return attemptedft;
    }

    public int getOff_rebs() {
        return off_rebs;
    }

    public int getDef_rebs() {
        return def_rebs;
    }

    public int getAssist() {
        return assist;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getBlocks_on() {
        return blocks_on;
    }

    public int getSteals() {
        return steals;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public int getFouls_drawn() {
        return fouls_drawn;
    }

    public int getFouls_commited() {
        return fouls_commited;
    }

}
