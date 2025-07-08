package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivityR2_R3 extends AppCompatActivity {
    private int game_id;
    private String team_name1, team_name2;
    private ArrayList<PlayerR1> team_1_players = new ArrayList<>();
    private ArrayList<PlayerR1> team_2_players = new ArrayList<>();
    private ArrayList<PlayerR1> team_1_playersOUT = new ArrayList<>();
    private ArrayList<PlayerR1> team_2_playersOUT = new ArrayList<>();
    private PlayerListR1 playerList1;
    private PlayerListR1 playerList2;
    //from Intent

    public Spinner playerMenu;
    public Spinner teamMenu;
    public Spinner opponentMenu;
    public ArrayAdapter<String> arrayAdapterPlayers;
    public ArrayAdapter<String> arrayAdapterOpponents;
    public String selectedTeam, selectedPlayer, selectedOpponent;
    public int selectedId, selectedOpponentId;
    public ArrayList<String> teamnames = new ArrayList<>();
    public List<PlayerR1> playersList1 = new ArrayList<>();
    public List<PlayerR1> playersList2 = new ArrayList<>();
    private String ip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_r2);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        //get from Intent
        Intent intent = getIntent();
        game_id = intent.getIntExtra("ok", 1);
        team_name1 = intent.getStringExtra("name1");
        team_name2 = intent.getStringExtra("name2");
        team_1_players = (ArrayList<PlayerR1>) intent.getSerializableExtra("players1IN");
        team_2_players = (ArrayList<PlayerR1>) intent.getSerializableExtra("players2IN");
        team_1_playersOUT = (ArrayList<PlayerR1>) intent.getSerializableExtra("players1OUT");
        team_2_playersOUT = (ArrayList<PlayerR1>) intent.getSerializableExtra("players2OUT");
        playerList1 = (PlayerListR1) intent.getSerializableExtra("playerList1");
        playerList2 = (PlayerListR1) intent.getSerializableExtra("playerList2");
        ip = intent.getStringExtra("IP");


        playersList1 = playerList1.getAllPlayers(team_name1);
        playersList2 = playerList2.getAllPlayers(team_name2);

        //setup Back Button
        Button buttonBack = (Button) findViewById(R.id.buttonBack2);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToR1 = new Intent(MainActivityR2_R3.this, SubstitutionActivityR1.class);
                intentToR1.putExtra("id", game_id);
                intentToR1.putExtra("name1", team_name1);
                intentToR1.putExtra("name2", team_name2);
                intentToR1.putExtra("players1IN", (Serializable) team_1_players);
                intentToR1.putExtra("players1OUT", (Serializable) team_1_playersOUT);
                intentToR1.putExtra("players2IN", (Serializable) team_2_players);
                intentToR1.putExtra("players2OUT", (Serializable) team_2_playersOUT);
                intentToR1.putExtra("playerList1", (Serializable) playerList1);
                intentToR1.putExtra("playerList2", (Serializable) playerList2);
                intentToR1.putExtra("IP", ip);
                startActivity(intentToR1);
            }
        });


        //setup teamMenu Spinner
        teamnames.add(team_name1);
        teamnames.add(team_name2);
        teamMenu = findViewById(R.id.team_menu_spinner);
        ArrayAdapter<String> arrayAdapterTeams = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, teamnames);
        teamMenu.setAdapter(arrayAdapterTeams);

        playerMenu = findViewById(R.id.player_menu_spinner);
        opponentMenu = findViewById(R.id.opponent_menu_spinner);

        teamMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedTeam = teamMenu.getSelectedItem().toString();
                ArrayList<String> playerNames = new ArrayList<>();
                ArrayList<String> opponentNames = new ArrayList<>();
                if(selectedTeam.equals(team_name1)){
                    for(int j=0; j<team_1_players.size(); j++) {
                        playerNames.add(team_1_players.get(j).getName());
                    }
                    for(int j=0; j<team_2_players.size(); j++) {
                        opponentNames.add(team_2_players.get(j).getName());
                    }
                }
                else if(selectedTeam.equals(team_name2)){
                    for(int j=0; j<team_2_players.size(); j++) {
                        playerNames.add(team_2_players.get(j).getName());
                    }
                    for(int j=0; j<team_1_players.size(); j++) {
                        opponentNames.add(team_1_players.get(j).getName());
                    }
                }

                updateDropdownPlayers(playerNames);
                updateDropdownOpponents(opponentNames);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println(playerMenu.getItemAtPosition(0).toString());
                System.out.println(opponentMenu.getItemAtPosition(0).toString());
            }
        });

        playerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPlayer = playerMenu.getSelectedItem().toString();
                if(selectedTeam.equals(team_name1)){
                    selectedId = playerList1.getPlayerId(selectedPlayer);
                } else if(selectedTeam.equals(team_name2)){
                    selectedId = playerList2.getPlayerId(selectedPlayer);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println(playerMenu.getItemAtPosition(0).toString());
            }
        });

        opponentMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedOpponent = opponentMenu.getSelectedItem().toString();
                if(selectedTeam.equals(team_name1)){
                    selectedOpponentId = playerList2.getPlayerId(selectedOpponent);
                } else if(selectedTeam.equals(team_name2)){
                    selectedOpponentId = playerList1.getPlayerId(selectedOpponent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println(opponentMenu.getItemAtPosition(0).toString());
            }
        });


        // UPDATE DATA

        //R2: Updating tables basket_game and event
        //R3: Updating tables player_game_stat_card, player_stat_card, team_game_card.


        //Notice: When updating "Attepted" columns the shots_rejected column gets updated as well
        // ATTEMPTED POINT 1
        Button button_attempted_point_1= (Button) findViewById(R.id.attempted_point_1);
        button_attempted_point_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //R2: Updating basket_game και event
                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET attemptedft_1 = attemptedft_1 + 1 WHERE game_id = " + game_id;// Για μετά σε όλα
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET attemptedft_2 = attemptedft_2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a1 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s1 = new Thread(a1);
                try{
                    s1.start();
                    s1.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'attempted freethrow', " + game_id + ")";

                MySQLConnectionR2_R3 b1 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t1 = new Thread(b1);
                try{
                    t1.start();
                    t1.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating attemptedft
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET attemptedft = attemptedft + 1 WHERE game_id = "+game_id+" AND player_id ="+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql4 = "";

                sql4 = "UPDATE player_game_stat_card SET shots_rejected = shots_rejected + 1 WHERE game_id = "+game_id+" AND player_id ="+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql4con = new MySQLConnectionR2_R3(sql4, ip);
                Thread sql4thread = new Thread(sql4con);
                try{
                    sql4thread.start();
                    sql4thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET attemptedft = attemptedft + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET attemptedft = attemptedft + 1 WHERE player_stat_card_id ="+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql7 = "";

                sql7 = "UPDATE player_stat_card SET shots_rejected = shots_rejected + 1 WHERE player_stat_card_id ="+selectedId+";";

                MySQLConnectionR2_R3 sql7con = new MySQLConnectionR2_R3(sql7, ip);
                Thread sql7thread = new Thread(sql7con);
                try{
                    sql7thread.start();
                    sql7thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // MADE POINT 1
        Button button_made_point_1= (Button) findViewById(R.id.made_point_1);
        button_made_point_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET madeft_1 = madeft_1 + 1, attemptedft_1 = attemptedft_1 + 1, points1 = points1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET madeft_2 = madeft_2 + 1, attemptedft_2 = attemptedft_2 +1, points2 = points2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a2 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s2 = new Thread(a2);
                try{
                    s2.start();
                    s2.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'made freethrow', " + game_id + ")";

                MySQLConnectionR2_R3 b2 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t2 = new Thread(b2);
                try{
                    t2.start();
                    t2.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating columns attemptedft and madeft
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET attemptedft = attemptedft + 1, madeft = madeft + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET attemptedft = attemptedft + 1, madeft = madeft + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET attemptedft = attemptedft + 1, madeft = madeft + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // ATTEMPTED POINTS 2
        Button button_attempted_points_2= (Button) findViewById(R.id.attempted_points_2);
        button_attempted_points_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET attempted2p_1 = attempted2p_1 + 1 WHERE game_id  = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET attempted2p_2 = attempted2p_2 + 1 WHERE game_id  = " + game_id;
                }

                MySQLConnectionR2_R3 a3 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s3 = new Thread(a3);
                try{
                    s3.start();
                    s3.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'attempted 2points', " + game_id + ")";

                MySQLConnectionR2_R3 b3 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t3 = new Thread(b3);
                try{
                    t3.start();
                    t3.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating column attemptedft and shots_rejected
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET attempted2p = attempted2p + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql4 = "";

                sql4 = "UPDATE player_game_stat_card SET shots_rejected = shots_rejected + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql4con = new MySQLConnectionR2_R3(sql4, ip);
                Thread sql4thread = new Thread(sql4con);
                try{
                    sql4thread.start();
                    sql4thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET attempted2p = attempted2p + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET attempted2p = attempted2p + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql7 = "";

                sql7 = "UPDATE player_stat_card SET shots_rejected = shots_rejected + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql7con = new MySQLConnectionR2_R3(sql7, ip);
                Thread sql7thread = new Thread(sql7con);
                try{
                    sql7thread.start();
                    sql7thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // MADE POINTS 2
        Button button_made_points_2= (Button) findViewById(R.id.made_points_2);
        button_made_points_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET made2p_1 = made2p_1 + 1, attempted2p_1 = attempted2p_1 + 1, points1 = points1 + 2 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET made2p_2 = made2p_2 + 1, attempted2p_2 = attempted2p_2 + 1, points2 = points2 + 2 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a4 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s4 = new Thread(a4);
                try{
                    s4.start();
                    s4.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'made 2points', " + game_id + ")";

                MySQLConnectionR2_R3 b4 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t4 = new Thread(b4);
                try{
                    t4.start();
                    t4.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating columns attemptedft and madeft
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET attempted2p = attempted2p + 1, made2p = made2p + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET attempted2p = attempted2p + 1, made2p = made2p + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET attempted2p = attempted2p + 1, made2p = made2p + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        });

        // ATTEMPTED POINTS 3
        Button button_attempted_points_3= (Button) findViewById(R.id.attempted_points_3);
        button_attempted_points_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET attempted3p_1 = attempted3p_1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET attempted3p_2 = attempted3p_2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a5 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s5 = new Thread(a5);
                try{
                    s5.start();
                    s5.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'attempted 3points', " + game_id + ")";

                MySQLConnectionR2_R3 b5 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t5 = new Thread(b5);
                try{
                    t5.start();
                    t5.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating column attempted3p
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET attempted3p = attempted3p + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql4 = "";

                sql4 = "UPDATE player_game_stat_card SET shots_rejected = shots_rejected + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+" AND player_name = '"+selectedPlayer+"';";

                MySQLConnectionR2_R3 sql4con = new MySQLConnectionR2_R3(sql4, ip);
                Thread sql4thread = new Thread(sql4con);
                try{
                    sql4thread.start();
                    sql4thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET attempted3p = attempted3p + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET attempted3p = attempted3p + 1 WHERE player_stat_card_id = "+selectedId +";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql7 = "";

                sql7 = "UPDATE player_stat_card SET shots_rejected = shots_rejected + 1 WHERE player_stat_card_id = "+selectedId +";";

                MySQLConnectionR2_R3 sql7con = new MySQLConnectionR2_R3(sql7, ip);
                Thread sql7thread = new Thread(sql7con);
                try{
                    sql7thread.start();
                    sql7thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // MADE POINTS 3
        Button button_made_points_3= (Button) findViewById(R.id.made_points_3);
        button_made_points_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET made3p_1 = made3p_1 + 1, attempted3p_1 = attempted3p_1 + 1, points1 = points1 + 3 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET made3p_2 = made3p_2 + 1, attempted3p_2 = attempted3p_2 + 1, points2 = points2 + 3 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a6 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s6 = new Thread(a6);
                try{
                    s6.start();
                    s6.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'made 3points', " + game_id + ")";

                MySQLConnectionR2_R3 b6 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t6 = new Thread(b6);
                try{
                    t6.start();
                    t6.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating columns made3p and attempted3p
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET attempted3p = attempted3p + 1, made3p = made3p + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET attempted3p = attempted3p + 1, made3p = made3p + 1 WHERE team_name = '"+selectedTeam+"'";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET attempted3p = attempted3p + 1, made3p = made3p + 1 WHERE player_stat_card_id = "+selectedId +";";

                MySQLConnectionR2_R3 sql6con478 = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread478 = new Thread(sql6con478);
                try{
                    sql6thread478.start();
                    sql6thread478.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        // OFFENSIVE REBOUNDS
        Button button_off_rebounds = (Button) findViewById(R.id.off_rebounds);
        button_off_rebounds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET off_rebs1 = off_rebs1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET off_rebs2 = off_rebs2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a7 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s7 = new Thread(a7);
                try{
                    s7.start();
                    s7.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'offensive rebound', " + game_id + ")";

                MySQLConnectionR2_R3 b7 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t7 = new Thread(b7);
                try{
                    t7.start();
                    t7.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating off_rebs
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET off_rebs = off_rebs + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET off_rebs = off_rebs + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET off_rebs = off_rebs + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // DEFENSIVE REBOUNDS
        Button button_def_rebounds = (Button) findViewById(R.id.def_rebounds);
        button_def_rebounds.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET def_rebs1 = def_rebs1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET def_rebs2 = def_rebs2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a8 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s8 = new Thread(a8);
                try{
                    s8.start();
                    s8.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'defensive rebound', " + game_id + ")";

                MySQLConnectionR2_R3 b8 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t8 = new Thread(b8);
                try{
                    t8.start();
                    t8.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating def_rebs
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET def_rebs = def_rebs + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET def_rebs = def_rebs + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET def_rebs = def_rebs + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // BLOCKS
        Button button_blocks= (Button) findViewById(R.id.blocks);
        button_blocks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET blocks1 = blocks1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET blocks2 = blocks2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a9 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s9 = new Thread(a9);
                try{
                    s9.start();
                    s9.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'block', " + game_id + ")";

                MySQLConnectionR2_R3 b9 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t9 = new Thread(b9);
                try{
                    t9.start();
                    t9.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating blocks
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET blocks = blocks + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET blocks = blocks + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET blocks = blocks + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // BLOCKS_ON
        Button button_blocks_on = (Button) findViewById(R.id.blocks_on);
        button_blocks_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET blocks_on1 = blocks_on1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET blocks_on2 = blocks_on2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a10 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s10 = new Thread(a10);
                try{
                    s10.start();
                    s10.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'block_on', " + game_id + ")";

                MySQLConnectionR2_R3 b10 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t10 = new Thread(b10);
                try{
                    t10.start();
                    t10.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating blocks_on
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET blocks_on = blocks_on + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET blocks_on = blocks_on + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET blocks_on = blocks_on + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // STEALS
        Button button_steals = (Button) findViewById(R.id.steals);
        button_steals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET steals1 = steals1 + 1, turnovers2 = turnovers2 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET steals2 = steals2 + 1, turnovers1 = turnovers1 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a11 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s11 = new Thread(a11);
                try{
                    s11.start();
                    s11.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'steal', " + game_id + ")";

                MySQLConnectionR2_R3 b11 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t11 = new Thread(b11);
                try{
                    t11.start();
                    t11.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating columns steals and turnovers
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET steals = steals + 1, turnovers = turnovers + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET steals = steals + 1, turnovers = turnovers + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET steals = steals + 1, turnovers = turnovers + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // TURNOVERS
        Button button_turnovers = (Button) findViewById(R.id.turnovers);
        button_turnovers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET turnovers1 = turnovers1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET turnovers2 = turnovers2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a12 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s12 = new Thread(a12);
                try{
                    s12.start();
                    s12.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'turnover', " + game_id + ")";

                MySQLConnectionR2_R3 b12 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t12 = new Thread(b12);
                try{
                    t12.start();
                    t12.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //R3: Updating turnovers
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET turnovers = turnovers + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET turnovers = turnovers + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET turnovers = turnovers + 1 WHERE player_stat_card_id = "+selectedId +";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // ASSISTS
        Button button_assists = (Button) findViewById(R.id.assists);
        button_assists.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET assist1 = assist1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET assist2 = assist2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a13 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s13 = new Thread(a13);
                try{
                    s13.start();
                    s13.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'assist', " + game_id + ")";

                MySQLConnectionR2_R3 b13 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t13 = new Thread(b13);
                try{
                    t13.start();
                    t13.join();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

                //R3: Updating assists
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET assist = assist + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET assist = assist + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET assist = assist + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        // FOULS
        Button button_fouls = (Button) findViewById(R.id.fouls);
        button_fouls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String sql1 = "";

                if (selectedTeam.equals(team_name1)) {
                    sql1 = "UPDATE basket_game SET fouls1 = fouls1 + 1 WHERE game_id = " + game_id;
                }
                else if (selectedTeam.equals(team_name2)) {
                    sql1 = "UPDATE basket_game SET fouls2 = fouls2 + 1 WHERE game_id = " + game_id;
                }

                MySQLConnectionR2_R3 a14 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s14 = new Thread(a14);
                try{
                    s14.start();
                    s14.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql2 = "";

                sql2 = "INSERT INTO event (team_name, player_name, event_type, game_id, opponent_name) VALUES ('" + selectedTeam + "', '" + selectedPlayer + "', 'foul', " + game_id + ", '" + selectedOpponent + "')";

                MySQLConnectionR2_R3 b14 = new MySQLConnectionR2_R3(sql2, ip);
                Thread t14 = new Thread(b14);
                try{
                    t14.start();
                    t14.join();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

                //R3: Updating column fouls_commited
                String sql3 = "";

                sql3 = "UPDATE player_game_stat_card SET fouls_commited = fouls_commited + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql3con = new MySQLConnectionR2_R3(sql3, ip);
                Thread sql3thread = new Thread(sql3con);
                try{
                    sql3thread.start();
                    sql3thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql5 = "";

                sql5 = "UPDATE team_stat_card SET fouls_commited = fouls_commited + 1 WHERE team_name = '"+selectedTeam+"';";

                MySQLConnectionR2_R3 sql5con = new MySQLConnectionR2_R3(sql5, ip);
                Thread sql5thread = new Thread(sql5con);
                try{
                    sql5thread.start();
                    sql5thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql6 = "";

                sql6 = "UPDATE player_stat_card SET fouls_commited = fouls_commited + 1 WHERE player_stat_card_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql6con = new MySQLConnectionR2_R3(sql6, ip);
                Thread sql6thread = new Thread(sql6con);
                try{
                    sql6thread.start();
                    sql6thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }


                //R3: Updating column fouls_drawn
                String opponentTeam = "";

                if (teamnames.get(0).equals(selectedTeam)) {
                    opponentTeam = teamnames.get(1);
                } else {
                    opponentTeam = teamnames.get(0);
                }
                String sql7 = "";

                sql7 = "UPDATE player_game_stat_card SET fouls_drawn = fouls_drawn + 1 WHERE game_id = "+game_id+" AND player_id = "+selectedId+";";

                MySQLConnectionR2_R3 sql7con = new MySQLConnectionR2_R3(sql7, ip);
                Thread sql7thread = new Thread(sql7con);
                try{
                    sql7thread.start();
                    sql7thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql9 = "";

                sql9 = "UPDATE team_stat_card SET fouls_drawn = fouls_drawn + 1 WHERE team_name = '"+opponentTeam+"';";
                MySQLConnectionR2_R3 sql9con = new MySQLConnectionR2_R3(sql9, ip);
                Thread sql9thread = new Thread(sql9con);
                try{
                    sql9thread.start();
                    sql9thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                String sql10 = "";

                sql10 = "UPDATE player_stat_card SET fouls_drawn = fouls_drawn + 1 WHERE player_stat_card_id = "+selectedOpponentId+";";

                MySQLConnectionR2_R3 sql10con = new MySQLConnectionR2_R3(sql10, ip);
                Thread sql10thread = new Thread(sql10con);
                try{
                    sql10thread.start();
                    sql10thread.join();
                }
                catch(Exception e){
                    e.printStackTrace();
                }


            }
        });

        // FINISH GAME
        Button button_finish_game = (Button) findViewById(R.id.finished_game);
        button_finish_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sql1;

                sql1 = "UPDATE basket_game SET finished_game = 1 WHERE game_id = " + game_id +  ";";

                MySQLConnectionR2_R3 a15 = new MySQLConnectionR2_R3(sql1, ip);
                Thread s15 = new Thread(a15);
                try {
                    s15.start();
                    s15.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //R3:
                // Updating points, tendex and time_played of table player_game_stat_card
                ArrayList<String> gamePlayerNames = new ArrayList<String>();
                int count1 = 0;
                int count2 = 0;
                for (int j = 0; j < (team_1_players.size() + team_2_players.size()); j++) {
                    if (count1 < team_1_players.size()) {
                        gamePlayerNames.add(team_1_players.get(count1).getName());
                        count1++;
                    } else {
                        if (count2 < team_2_players.size()) {
                            gamePlayerNames.add(team_2_players.get(count2).getName());
                            count2++;
                        }
                    }
                }

                String sql2;
                for (int i = 0; i < gamePlayerNames.size(); i++) {

                    //points column
                    sql2 = "UPDATE player_game_stat_card SET points = " +
                            "(SELECT madeft FROM player_game_stat_card WHERE player_name = ? AND game_id = ?) + " +
                            "2 * (SELECT made2p FROM player_game_stat_card WHERE player_name = ? AND game_id = ?) + " +
                            "3 * (SELECT made3p FROM player_game_stat_card WHERE player_name = ? AND game_id = ?) " +
                            "WHERE player_name = ? AND game_id = ?;";
                    MySQLConnectionR2_R3 b16 = new MySQLConnectionR2_R3(sql2, ip, gamePlayerNames.get(i), Integer.toString(game_id), 8);
                    Thread t16 = new Thread(b16);
                    try {
                        t16.start();
                        t16.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                /*tendex column:
                    Wiki's (European Tendex Rating) : (Points + Rebounds + Assists + Steals + Blocks + Fouls Drawn) -
                                                        (Missed Field Goals + Missed Free Throws + Turnovers + Shots Rejected + Fouls Committed)
                   tendex = (points + def_rebs + off_rebs + assists + steals + blocks + blocks_on + fouls_drawn) -
                            (((attemptedft + attempted2p + attempted3p) - points) - free_throws - turnovers - shots_rejected - fouls_commited)
                 */
                String sql3;
                for (int k = 0; k < gamePlayerNames.size(); k++) {
                    sql3 = "UPDATE player_game_stat_card SET tendex = " +
                            "(SELECT points FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT def_rebs FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT off_rebs FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT assist FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT steals FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT blocks FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT blocks_on FROM player_game_stat_card WHERE game_id = ?  AND player_name = ?) + " +
                            "(SELECT fouls_drawn FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) - " +
                            "(((SELECT attemptedft FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT attempted2p FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) + " +
                            "(SELECT attempted3p FROM player_game_stat_card WHERE game_id = ? AND player_name = ?)) - " +
                            "(SELECT points FROM player_game_stat_card WHERE game_id = ? AND player_name = ?)) - " +
                            "(SELECT madeft FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) - " +
                            "(SELECT turnovers FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) - " +
                            "(SELECT shots_rejected FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) - " +
                            "(SELECT fouls_commited FROM player_game_stat_card WHERE game_id = ? AND player_name = ?) " +
                            "WHERE game_id = ? AND player_name = ?;";
                    MySQLConnectionR2_R3 c17 = new MySQLConnectionR2_R3(sql3, ip, gamePlayerNames.get(k), Integer.toString(game_id), 34);
                    Thread y17 = new Thread(c17);
                    try {
                        y17.start();
                        y17.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //time_played

                String sql87;
                for(int i=0; i<playersList1.size(); i++){
                    int timePlayed = playerList1.getPlayerTime(playersList1.get(i).getName());

                    sql87 = "UPDATE player_game_stat_card SET time_played = "+timePlayed+" WHERE player_name = '" + playersList1.get(i).getName() + "';";
                    MySQLConnectionR2_R3 d87 = new MySQLConnectionR2_R3(sql87, ip);
                    Thread u87 = new Thread(d87);
                    try {
                        u87.start();
                        u87.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                String sql89;
                for(int i=0; i<playersList2.size(); i++){
                    int timePlayed = playerList2.getPlayerTime(playersList2.get(i).getName());

                    sql89 = "UPDATE player_game_stat_card SET time_played = "+timePlayed+" WHERE player_name = '" + playersList2.get(i).getName() + "';";
                    MySQLConnectionR2_R3 d89 = new MySQLConnectionR2_R3(sql89, ip);
                    Thread u89 = new Thread(d89);
                    try {
                        u89.start();
                        u89.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //Updating games_played, points, tendex and total_time of table player_stat_card

                //games_played column
                String sql4;
                for (int l = 0; l < gamePlayerNames.size(); l++) {

                    sql4 = "UPDATE player_stat_card SET games_played = games_played + 1 WHERE player_name = '" + gamePlayerNames.get(l) + "';";

                    MySQLConnectionR2_R3 d18 = new MySQLConnectionR2_R3(sql4, ip);
                    Thread u18 = new Thread(d18);
                    try {
                        u18.start();
                        u18.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //points
                String sql5;
                for (int i5 = 0; i5 < gamePlayerNames.size(); i5++) {

                    //points column
                    sql5 = "UPDATE player_stat_card SET points = points + " +
                            "(SELECT madeft FROM player_stat_card WHERE player_name = ?)" +
                            "+ 2 * (SELECT made2p FROM player_stat_card WHERE player_name = ?) " +
                            "+ 3 * (SELECT made3p FROM player_stat_card WHERE player_name = ?) " +
                            "WHERE player_name = ? ;";
                    MySQLConnectionR2_R3 e19 = new MySQLConnectionR2_R3(sql5, ip, gamePlayerNames.get(i5), 4);
                    Thread i19 = new Thread(e19);
                    try {
                        i19.start();
                        i19.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                /*tendex column:
                    Wiki's (European Tendex Rating) : (Points + Rebounds + Assists + Steals + Blocks + Fouls Drawn) -
                                                        (Missed Field Goals + Missed Free Throws + Turnovers + Shots Rejected + Fouls Committed)
                   tendex = (points + def_rebs + off_rebs + assists + steals + blocks + blocks_on + fouls_drawn) -
                            (((attemptedft + attempted2p + attempted3p) - points) - free_throws - turnovers - shots_rejected - fouls_commited)
                 */
                String sql6;
                for (int i6 = 0; i6 < gamePlayerNames.size(); i6++) {
                    sql6 = "UPDATE player_stat_card SET tendex = " +
                            "(SELECT points FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT def_rebs FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT off_rebs FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT assist FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT steals FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT blocks FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT blocks_on FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT fouls_drawn FROM player_stat_card WHERE player_name = ?) - " +
                            "(((SELECT attemptedft FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT attempted2p FROM player_stat_card WHERE player_name = ?) + " +
                            "(SELECT attempted3p FROM player_stat_card WHERE player_name = ?)) - " +
                            "(SELECT points FROM player_stat_card WHERE player_name = ?)) - " +
                            "(SELECT madeft FROM player_stat_card WHERE player_name = ?) - " +
                            "(SELECT turnovers FROM player_stat_card WHERE player_name = ?) - " +
                            "(SELECT shots_rejected FROM player_stat_card WHERE player_name = ?) - " +
                            "(SELECT fouls_commited FROM player_stat_card WHERE player_name = ?) " +
                            "WHERE player_name = ?;";
                    MySQLConnectionR2_R3 e20 = new MySQLConnectionR2_R3(sql6, ip, gamePlayerNames.get(i6), 17);
                    Thread o20 = new Thread(e20);
                    try {
                        o20.start();
                        o20.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //total_time column

                String sql88;
                for(int i=0; i<playersList1.size(); i++){
                    int timePlayed = playerList1.getPlayerTime(playersList1.get(i).getName());

                    sql88 = "UPDATE player_stat_card SET total_time = total_time + "+timePlayed+" WHERE player_name = '" + playersList1.get(i).getName() + "';";
                    MySQLConnectionR2_R3 d88 = new MySQLConnectionR2_R3(sql88, ip);
                    Thread u88 = new Thread(d88);
                    try {
                        u88.start();
                        u88.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                String sql90;
                for(int i=0; i<playersList2.size(); i++){
                    int timePlayed = playerList2.getPlayerTime(playersList2.get(i).getName());

                    sql90 = "UPDATE player_stat_card SET total_time = total_time + "+timePlayed+" WHERE player_name = '" + playersList2.get(i).getName() + "';";
                    MySQLConnectionR2_R3 d90 = new MySQLConnectionR2_R3(sql90, ip);
                    Thread u90 = new Thread(d90);
                    try {
                        u90.start();
                        u90.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //MPG (aka minutes per game)

                String sqlmpg1;
                for(int i=0; i<gamePlayerNames.size(); i++){
                    sqlmpg1 = "UPDATE player_stat_card SET MPG = " +
                            "(SELECT total_time FROM player_stat_card WHERE player_name = ?) / " +
                            "(SELECT games_played FROM player_stat_card WHERE player_name = ?) " +
                            "WHERE player_name = ? AND (SELECT games_played FROM player_stat_card WHERE player_name = ?) > 0;";
                    System.out.println("--------player name: "+gamePlayerNames.get(i));
                    MySQLConnectionR2_R3 sqlmpg1con = new MySQLConnectionR2_R3(sqlmpg1, ip, gamePlayerNames.get(i), 4);
                    Thread sqlmpg1t = new Thread(sqlmpg1con);
                    try {
                        sqlmpg1t.start();
                        sqlmpg1t.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                //Updating games_played, losses, wins, points, rank_points and points_per_game of table team_stat_card for both teams

                //games_played column
                String sql10;
                sql10 = "UPDATE team_stat_card SET games_played = games_played + 1 WHERE team_name = '" + team_name1 + "';";

                MySQLConnectionR2_R3 d24 = new MySQLConnectionR2_R3(sql10, ip);
                Thread u24 = new Thread(d24);
                try {
                    u24.start();
                    u24.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String sql11;
                sql11 = "UPDATE team_stat_card SET games_played = games_played + 1 WHERE team_name = '" + team_name2 + "';";

                MySQLConnectionR2_R3 d25 = new MySQLConnectionR2_R3(sql11, ip);
                Thread u25 = new Thread(d25);
                try {
                    u25.start();
                    u25.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //updating winning_team
                String winning_team_name="";
                String sql1204;
                sql1204 = "SELECT points1 FROM basket_game WHERE game_id = " + game_id + ";";
                MySQLConnectionR2_R3 d204 = new MySQLConnectionR2_R3(sql1204, ip);
                Thread u204 = new Thread(d204);
                try{
                    u204.start();
                    u204.join();
                } catch (Exception e){
                    e.printStackTrace();
                }

                int points1  = d204.getIntQueryValue();
                String sql1205;
                sql1205 = "SELECT points2 FROM basket_game WHERE game_id = " + game_id + ";";
                MySQLConnectionR2_R3 d205 = new MySQLConnectionR2_R3(sql1205, ip);
                Thread u205 = new Thread(d205);
                try{
                    u205.start();
                    u205.join();
                } catch (Exception e){
                    e.printStackTrace();
                }

                int points2  = d205.getIntQueryValue();
                //R3: Since draws are not taken into account for this project,
                // in case both teams' points are equal the first team gets recognised as "winning team".
                if((points1>=points2) && points2!=0){
                    winning_team_name = playersList1.get(1).getTeam_name();
                }else {
                    winning_team_name = playersList2.get(1).getTeam_name();
                }

                String sql1821;
                sql1821 = "UPDATE basket_game SET winning_team_name= '"+ winning_team_name + "' WHERE game_id = '" + game_id + "';";
                MySQLConnectionR2_R3 d1821 = new MySQLConnectionR2_R3(sql1821, ip);
                Thread u1821 = new Thread(d1821);
                try{
                    u1821.start();
                    u1821.join();
                } catch (Exception e){
                    e.printStackTrace();
                }


                //losses-wins columns
                String sql12;
                sql12 = "SELECT winning_team_name FROM basket_game WHERE game_id = " + game_id + ";";
                MySQLConnectionR2_R3 d26 = new MySQLConnectionR2_R3(sql12, ip);
                Thread u26 = new Thread(d26);
                try {
                    u26.start();

                    if (d26.getStringQueryValue() == team_name1) {
                        String sql13;
                        sql13 = "UPDATE team_stat_card SET wins = wins + 1 WHERE team_name = '" + team_name1 + "';";

                        MySQLConnectionR2_R3 d27 = new MySQLConnectionR2_R3(sql13, ip);
                        Thread u27 = new Thread(d27);
                        try {
                            u27.start();
                            u27.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String sql14;
                        sql14 = "UPDATE team_stat_card SET losses = losses + 1 WHERE team_name = '" + team_name2 + "';";

                        MySQLConnectionR2_R3 d28 = new MySQLConnectionR2_R3(sql14, ip);
                        Thread u28 = new Thread(d28);
                        try {
                            u28.start();
                            u28.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        String sql13;
                        sql13 = "UPDATE team_stat_card SET wins = wins + 1 WHERE team_name = '" + team_name2 + "';";
                        MySQLConnectionR2_R3 d27 = new MySQLConnectionR2_R3(sql13, ip);
                        Thread u27 = new Thread(d27);
                        try {
                            u27.start();
                            u27.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String sql14;
                        sql14 = "UPDATE team_stat_card SET losses = losses + 1 WHERE team_name = '" + team_name1 + "';";
                        MySQLConnectionR2_R3 d28 = new MySQLConnectionR2_R3(sql14, ip);
                        Thread u28 = new Thread(d28);
                        try {
                            u28.start();
                            u28.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    u26.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //points
                String sql15;
                sql15 = "UPDATE team_stat_card SET points = points + " +
                        "(SELECT madeft FROM team_stat_card WHERE team_name = ?)" +
                        "+ 2 * (SELECT made2p FROM team_stat_card WHERE team_name = ?)" +
                        "+ 3 * (SELECT made3p FROM team_stat_card WHERE team_name = ?) " +
                        "WHERE team_name = ?;";
                MySQLConnectionR2_R3 g29 = new MySQLConnectionR2_R3(sql15, ip, team_name1, 4);
                Thread l29 = new Thread(g29);
                try {
                    l29.start();
                    l29.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String sql16;
                sql16 = "UPDATE team_stat_card SET points = points + " +
                        "(SELECT madeft FROM team_stat_card WHERE team_name = ?) " +
                        "+ 2 * (SELECT made2p FROM team_stat_card WHERE team_name = ?) " +
                        "+ 3 * (SELECT made3p FROM team_stat_card WHERE team_name = ?) " +
                        "WHERE team_name = ?;";
                System.out.println("Team_stat_card -> 2 "+team_name2);
                MySQLConnectionR2_R3 g30 = new MySQLConnectionR2_R3(sql16, ip, team_name2, 4);
                Thread l30 = new Thread(g30);
                try {
                    l30.start();
                    l30.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //rank_points column
                String sql17;
                sql17 = "SELECT winning_team_name FROM basket_game WHERE game_id = " + game_id + ";";
                MySQLConnectionR2_R3 d31 = new MySQLConnectionR2_R3(sql17, ip);
                Thread u31 = new Thread(d26);
                try {
                    u31.start();
                    if (d31.getStringQueryValue() == team_name1) {
                        String sql18;
                        sql18 = "UPDATE team_stat_card SET rank_points = rank_points + 2 WHERE team_name = '" + team_name1 + "';";

                        MySQLConnectionR2_R3 d32 = new MySQLConnectionR2_R3(sql18, ip);
                        Thread u32 = new Thread(d32);
                        try {
                            u32.start();
                            u32.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String sql19;
                        sql19 = "UPDATE team_stat_card SET rank_points = rank_points + 1 WHERE team_name = '" + team_name2 + "';";

                        MySQLConnectionR2_R3 d33 = new MySQLConnectionR2_R3(sql19, ip);
                        Thread u33 = new Thread(d33);
                        try {
                            u33.start();
                            u33.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        String sql18;
                        sql18 = "UPDATE team_stat_card SET rank_points = rank_points + 2 WHERE team_name = '" + team_name1 + "';";

                        MySQLConnectionR2_R3 d32 = new MySQLConnectionR2_R3(sql18, ip);
                        Thread u32 = new Thread(d32);
                        try {
                            u32.start();
                            u32.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String sql19;
                        sql19 = "UPDATE team_stat_card SET rank_points = rank_points + 1 WHERE team_name = '" + team_name2 + "';";

                        MySQLConnectionR2_R3 d33 = new MySQLConnectionR2_R3(sql19, ip);
                        Thread u33 = new Thread(d33);
                        try {
                            u33.start();
                            u33.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    u31.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void updateDropdownPlayers (ArrayList<String> playerNames){

        arrayAdapterPlayers =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        playerNames);
        playerMenu.setAdapter(arrayAdapterPlayers);
        arrayAdapterPlayers.notifyDataSetChanged();

    }

    public void updateDropdownOpponents (ArrayList<String> opponentNames){

        arrayAdapterOpponents =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        opponentNames);
        opponentMenu.setAdapter(arrayAdapterOpponents);
        arrayAdapterOpponents.notifyDataSetChanged();

    }
}