package com.example.karta_agona;

import android.media.Image;

import java.util.ArrayList;

public class R5_GameData {

    // the important fields we want to show in our screen.

    private int game_id;

    private String team_image_1;
    private String team_image_2;
    private String team_name_1;
    private String team_name_2;
    private int p_1;
    private int p_2;

    private int made_2p_1;
    private int made_2p_2;
    private int attempted_2p_1;
    private int attempted_2p_2;

    private int made_3p_1;
    private int made_3p_2;
    private int attempted_3p_1;
    private int attempted_3p_2;

    private int made_ft_1;
    private int made_ft_2;
    private int attempted_ft_1;
    private int attempted_ft_2;

    private int or_1;
    private int or_2;
    private int dr_1;
    private int dr_2;

    private int ass_1;
    private int ass_2;
    private int bl_1;
    private int bl_2;
    private int st_1;
    private int st_2;
    private int tur_1;
    private int tur_2;
    private int f_1;
    private int f_2;

    private int finished_game;

    // Constructor
    public R5_GameData() { }


    // We use the methods below to set our data we got from the database

    // Method to set the ID, Points and Team Names for both teams.
    public void set_ID_P_TN(int game_id, int points_1, int points_2, String t_n_1, String t_n_2) {

        this.game_id = game_id;

        this.p_1 = points_1;
        this.p_2 = points_2;

        this.team_name_1 = t_n_1;
        this.team_name_2 = t_n_2;
    }

    // Method to set the Made 2 and 3 points, the attempted 2 and 3 points for both teams.
    public void set_2_3_Points(int m_2p_1, int at_2p_1, int m_3p_1, int at_3p_1,
                               int m_2p_2, int at_2p_2, int m_3p_2, int at_3p_2) {

        this.made_2p_1 = m_2p_1;
        this.made_2p_2 = m_2p_2;

        this.made_3p_1 = m_3p_1;
        this.made_3p_2 = m_3p_2;

        this.attempted_2p_1 = at_2p_1;
        this.attempted_2p_2 = at_2p_2;

        this.attempted_3p_1 = at_3p_1;
        this.attempted_3p_2 = at_3p_2;
    }

    // Method to set the made and attempted free throws for both teams.
    public void setFT(int m_ft_1, int m_ft_2, int at_ft_1, int at_ft_2) {

        this.made_ft_1 = m_ft_1;
        this.made_ft_2 = m_ft_2;

        this.attempted_ft_1 = at_ft_1;
        this.attempted_ft_2 = at_ft_2;
    }

    // Method to set the offensive and defensive rebounds for both teams.
    public void setRebounds(int or_1, int or_2, int dr_1, int dr_2) {

        this.or_1 = or_1;
        this.or_2 = or_2;

        this.dr_1 = dr_1;
        this.dr_2 = dr_2;
    }

    // Method to set the assists and the blocks for both teams.
    public void set_Ass_Bl(int ass_1, int ass_2, int bl_1, int bl_2) {

        this.ass_1 = ass_1;
        this.ass_2 = ass_2;

        this.bl_1 = bl_1;
        this.bl_2 = bl_2;
    }

    // Method to set the steals, turnovers and the fouls for both teams.
    public void set_St_Tur_F(int st_1, int st_2, int tur_1, int tur_2,
                             int f_1, int f_2) {

        this.st_1 = st_1;
        this.st_2 = st_2;

        this.tur_1 = tur_1;
        this.tur_2 = tur_2;

        this.f_1 = f_1;
        this.f_2 = f_2;
    }


    // Method to set the state of the game (finish_game=0 not finished, finish_game=1 finished)
    public void setFinishedGame(int finished_game) {

        this.finished_game = finished_game;
    }

    // Getters

    public int getGame_id() { return game_id; }

    public String getTeam_name_1() {
        return team_name_1;
    }

    public String getTeam_name_2() {
        return team_name_2;
    }

    public String getPoints() {
        return p_1 + " - "+ p_2;
    }

    public String getTeam_image_1() {
        return team_image_1;
    }

    public String getTeam_image_2() {
        return team_image_2;
    }


    public String get2P_1() {

        double p2 = (made_2p_1/(double)attempted_2p_1)*100;
        int int_p2 = (int) p2;
        return int_p2+"";
    }

    public String get2P_2() {
        double p2 = (made_2p_2/(double)attempted_2p_2)*100;
        int int_p2 = (int) p2;
        return int_p2+"";
    }

    public String get3P_1() {
        double p3 = made_3p_1/(double) attempted_3p_1*100;
        int int_p3 = (int) p3;
        return int_p3+"";
    }

    public String get3P_2() {
        double p3 = made_3p_2/(double) attempted_3p_2*100;
        int int_p3 = (int) p3;
        return int_p3+"";
    }

    public String getFT_1() {
        double fr_t = made_ft_1/(double) attempted_ft_1*100;
        int int_fr_t = (int) fr_t;
        return int_fr_t+"";
    }

    public String getFT_2() {
        double fr_t = made_ft_2/(double) attempted_ft_2*100;
        int int_fr_t = (int) fr_t;
        return int_fr_t+"";
    }

    public String getOr_1() {
        return or_1+"";
    }

    public String getOr_2() {
        return or_2+"";
    }

    public String getDr_1() {
        return dr_1+"";
    }

    public String getDr_2() {
        return dr_2+"";
    }

    public String getAss_1() {
        return ass_1+"";
    }

    public String getAss_2() {
        return ass_2+"";
    }

    public String getBl_1() {
        return bl_1+"";
    }

    public String getBl_2() {
        return bl_2+"";
    }

    public String getSt_1() {
        return st_1+"";
    }

    public String getSt_2() {
        return st_2+"";
    }

    public String getTur_1() {
        return tur_1+"";
    }

    public String getTur_2() {
        return tur_2+"";
    }

    public String getF_1() {
        return f_1+"";
    }

    public String getF_2() {
        return f_2+"";
    }

    public int getFinishedGame() {
        return finished_game;
    }

    public void setTeamImage1(String img1) {
        this.team_image_1 = img1;
    }

    public void setTeamImage2(String img2) {
        this.team_image_2 = img2;
    }
}