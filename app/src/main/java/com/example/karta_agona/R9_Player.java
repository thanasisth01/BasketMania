package com.example.karta_agona;

import java.util.ArrayList;

public class R9_Player {

    public static ArrayList<R9_Player> teamPlayerR9 = new ArrayList<>();

    public int id;
    public String name;
    public String position;
    public String teamname;
    public String photo_path;
    public int games_played;
    public int total_time;
    public int points;
    public int made2p;
    public int attempted2p;
    public int made3p;
    public int attempted3p;
    public int madeft;
    public int attemptedft;
    public int off_rebs;
    public int def_rebs;
    public int assist;
    public int blocks;
    public int blocks_on;
    public int steals;
    public int turnovers;
    public int fouls_drawn;
    public int fouls_commited;
    public int tendex;

    public R9_Player(int id, String name, String position, String teamname, String photo_path, int games_played, int total_time, int points, int made2p, int attempted2p, int made3p, int attempted3p, int madeft, int attemptedft, int off_rebs, int def_rebs, int assist, int blocks, int blocks_on, int steals, int turnovers, int fouls_drawn, int fouls_commited, int tendex){
        this.id = id;
        this.name = name;
        this.position = position;
        this.teamname = teamname;
        this.photo_path = photo_path;
        this.games_played = games_played;
        this.total_time = total_time;
        this.points = points;
        this.made2p = made2p;
        this.attempted2p = attempted2p;
        this.made3p = made3p;
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
        this.tendex = tendex;



    }
    public static ArrayList<R9_Player> getTeamPlayers(){
        return teamPlayerR9;
    }

    public static ArrayList<String> getPlayerNames() {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < teamPlayerR9.size(); i++) {
            temp.add(teamPlayerR9.get(i).name);
        }
        return temp;
    }


}
