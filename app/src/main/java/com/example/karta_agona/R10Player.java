package com.example.karta_agona;
public class R10Player {
    private int player_id, game_week_number, points, made2p, attempted2p, made3p, attempted3p, madeft, attemptedft, off_rebs, def_rebs, assist, blocks, blocks_on, steals, turnovers, fouls_commited, fouls_drawn, shots_rejected;
    private float tendex;
    private String player_name, position;
    private int missed_field_goals, missed_ft;


    public R10Player(int player_id, int game_week_number, String player_name, String position, int points , int made2p, int attempted2p, int made3p, int attempted3p, int madeft, int attemptedft, int off_rebs, int def_rebs, int assist, int blocks, int blocks_on, int steals, int turnovers, int fouls_commited, int fouls_drawn, int shots_rejected){

        this.player_id = player_id;
        this.game_week_number = game_week_number;
        this.player_name = player_name;
        this.points = points;
        this.position = position;
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
        this.fouls_commited = fouls_commited;
        this.fouls_drawn = fouls_drawn;
        this.shots_rejected = shots_rejected;
        this.missed_field_goals = (attempted2p - made2p) + (attempted3p - made3p);
        this.missed_ft = attemptedft - madeft;
        this.tendex = (points + off_rebs + def_rebs + assist + steals + blocks + fouls_drawn) - (this.missed_field_goals + this.missed_ft + turnovers + shots_rejected + fouls_commited);
    }

    public float getTendex() {
        return tendex;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public String getPlayer_name() {return player_name;}

    public int getGame_week_number() {
        return game_week_number;
    }

    public int getPoints() {
        return points;
    }

    public String getPosition() {return position; }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public void setGame_week_number(int game_week_number) {
        this.game_week_number = game_week_number;
    }

    public void setPlayer_name(String player_name) { this.player_name = player_name;}

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTendex(float tendex) {
        this.tendex = tendex;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}