package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayersSelectionActivityR1 extends AppCompatActivity {

    private int game_id;
    private String team_name1;
    private String team_name2;
    private String source;
    private PlayerListR1 playerList1; //getAllPlayers
    private PlayerListR1 playerList2; //getAllPlayers
    ArrayList<String> playernames1; //spinner
    ArrayList<String> playernames2; //spinner
    ArrayList<String> listPlayers1;//ListView
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter2;
    ArrayAdapter<String> arrayAdapter3;
    ArrayAdapter<String> arrayAdapter4;
    private String ip;


    private ArrayList<PlayerR1> players1IN = new ArrayList<>();
    private ArrayList<PlayerR1> players1OUT = new ArrayList<>();
    private ArrayList<PlayerR1> players2IN = new ArrayList<>();
    private ArrayList<PlayerR1> players2OUT = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_selection_r1);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        //Intent
        Intent intent = getIntent();
        game_id = intent.getIntExtra("game_id", 1);
        source = intent.getStringExtra("source");
        String idString = String.valueOf(game_id);
        team_name1 = intent.getStringExtra("name1");
        team_name2 = intent.getStringExtra("name2");
        ip = intent.getStringExtra("IP");

        //initialize lists
        listPlayers1 = new ArrayList<>();
        playerList1 = new PlayerListR1(team_name1, ip);
        playerList2 = new PlayerListR1(team_name2, ip);
        playernames1 = new ArrayList<>();
        playernames2 = new ArrayList<>();


        Spinner spinnerStarter1 = (Spinner) findViewById(R.id.spinnerStarter1);
        Spinner spinnerStarter2 = (Spinner) findViewById(R.id.spinnerStarter2);
        Spinner spinnerStarter3 = (Spinner) findViewById(R.id.spinnerStarter3);
        Spinner spinnerStarter4 = (Spinner) findViewById(R.id.spinnerStarter4);
        Spinner spinnerStarter5 = (Spinner) findViewById(R.id.spinnerStarter5);


        List<PlayerR1> players1 = playerList1.getAllPlayers(team_name1);
        for(int i=0; i<players1.size(); i++){
            playernames1.add(players1.get(i).getName());
        }

        arrayAdapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, playernames1);

        spinnerStarter1.setAdapter(arrayAdapter1);
        spinnerStarter2.setAdapter(arrayAdapter1);
        spinnerStarter3.setAdapter(arrayAdapter1);
        spinnerStarter4.setAdapter(arrayAdapter1);
        spinnerStarter5.setAdapter(arrayAdapter1);

        Spinner spinnerSub1 = (Spinner) findViewById(R.id.spinnerSub1);
        Spinner spinnerSub2 = (Spinner) findViewById(R.id.spinnerSub2);
        Spinner spinnerSub3 = (Spinner) findViewById(R.id.spinnerSub3);
        Spinner spinnerSub4 = (Spinner) findViewById(R.id.spinnerSub4);
        Spinner spinnerSub5 = (Spinner) findViewById(R.id.spinnerSub5);

        arrayAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, playernames1);

        spinnerSub1.setAdapter(arrayAdapter2);
        spinnerSub2.setAdapter(arrayAdapter2);
        spinnerSub3.setAdapter(arrayAdapter2);
        spinnerSub4.setAdapter(arrayAdapter2);
        spinnerSub5.setAdapter(arrayAdapter2);


        Spinner spinnerStarter6 = (Spinner) findViewById(R.id.spinnerStarter6);
        Spinner spinnerStarter7 = (Spinner) findViewById(R.id.spinnerStarter7);
        Spinner spinnerStarter8 = (Spinner) findViewById(R.id.spinnerStarter8);
        Spinner spinnerStarter9 = (Spinner) findViewById(R.id.spinnerStarter9);
        Spinner spinnerStarter10 = (Spinner) findViewById(R.id.spinnerStarter10);

        List<PlayerR1> players2 = playerList2.getAllPlayers(team_name2);
        for(int i=0; i<players2.size(); i++){
            playernames2.add(players2.get(i).getName());
        }

        arrayAdapter3 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, playernames2);

        spinnerStarter6.setAdapter(arrayAdapter3);
        spinnerStarter7.setAdapter(arrayAdapter3);
        spinnerStarter8.setAdapter(arrayAdapter3);
        spinnerStarter9.setAdapter(arrayAdapter3);
        spinnerStarter10.setAdapter(arrayAdapter3);

        Spinner spinnerSub6 = (Spinner) findViewById(R.id.spinnerSub6);
        Spinner spinnerSub7 = (Spinner) findViewById(R.id.spinnerSub7);
        Spinner spinnerSub8 = (Spinner) findViewById(R.id.spinnerSub8);
        Spinner spinnerSub9 = (Spinner) findViewById(R.id.spinnerSub9);
        Spinner spinnerSub10 = (Spinner) findViewById(R.id.spinnerSub10);

        arrayAdapter4 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, playernames2);

        spinnerSub6.setAdapter(arrayAdapter4);
        spinnerSub7.setAdapter(arrayAdapter4);
        spinnerSub8.setAdapter(arrayAdapter4);
        spinnerSub9.setAdapter(arrayAdapter4);
        spinnerSub10.setAdapter(arrayAdapter4);

        Button backButton = (Button) findViewById(R.id.buttonBackR1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(PlayersSelectionActivityR1.this, SelectMatchActivityR1.class);
                intentBack.putExtra("IP", ip);
                startActivity(intentBack);
                finish();
            }
        });


        //keep the selected players
        Button buttonDone = (Button) findViewById(R.id.buttonGo);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //draw the selected player names from spinner
                String startplayer1team1 = spinnerStarter1.getSelectedItem().toString();
                String startplayer2team1 = spinnerStarter2.getSelectedItem().toString();
                String startplayer3team1 = spinnerStarter3.getSelectedItem().toString();
                String startplayer4team1 = spinnerStarter4.getSelectedItem().toString();
                String startplayer5team1 = spinnerStarter5.getSelectedItem().toString();
                String startplayer1team2 = spinnerStarter6.getSelectedItem().toString();
                String startplayer2team2 = spinnerStarter7.getSelectedItem().toString();
                String startplayer3team2 = spinnerStarter8.getSelectedItem().toString();
                String startplayer4team2 = spinnerStarter9.getSelectedItem().toString();
                String startplayer5team2 = spinnerStarter10.getSelectedItem().toString();
                String subplayer1team1 = spinnerSub1.getSelectedItem().toString();
                String subplayer2team1 = spinnerSub2.getSelectedItem().toString();
                String subplayer3team1 = spinnerSub3.getSelectedItem().toString();
                String subplayer4team1 = spinnerSub4.getSelectedItem().toString();
                String subplayer5team1 = spinnerSub5.getSelectedItem().toString();
                String subplayer1team2 = spinnerSub6.getSelectedItem().toString();
                String subplayer2team2 = spinnerSub7.getSelectedItem().toString();
                String subplayer3team2 = spinnerSub8.getSelectedItem().toString();
                String subplayer4team2 = spinnerSub9.getSelectedItem().toString();
                String subplayer5team2 = spinnerSub10.getSelectedItem().toString();

                //setup if player is IN-GAME
                playerList1.whenPlayerIsChosen(startplayer1team1);
                playerList1.whenPlayerIsChosen(startplayer2team1);
                playerList1.whenPlayerIsChosen(startplayer3team1);
                playerList1.whenPlayerIsChosen(startplayer4team1);
                playerList1.whenPlayerIsChosen(startplayer5team1);
                playerList2.whenPlayerIsChosen(startplayer1team2);
                playerList2.whenPlayerIsChosen(startplayer2team2);
                playerList2.whenPlayerIsChosen(startplayer3team2);
                playerList2.whenPlayerIsChosen(startplayer4team2);
                playerList2.whenPlayerIsChosen(startplayer5team2);

                //setup player Lists for Substitution screen
                players1IN.add(playerList1.getPlayer(startplayer1team1));
                players1IN.add(playerList1.getPlayer(startplayer2team1));
                players1IN.add(playerList1.getPlayer(startplayer3team1));
                players1IN.add(playerList1.getPlayer(startplayer4team1));
                players1IN.add(playerList1.getPlayer(startplayer5team1));

                players2IN.add(playerList2.getPlayer(startplayer1team2));
                players2IN.add(playerList2.getPlayer(startplayer2team2));
                players2IN.add(playerList2.getPlayer(startplayer3team2));
                players2IN.add(playerList2.getPlayer(startplayer4team2));
                players2IN.add(playerList2.getPlayer(startplayer5team2));

                players1OUT.add(playerList1.getPlayer(subplayer1team1));
                players1OUT.add(playerList1.getPlayer(subplayer2team1));
                players1OUT.add(playerList1.getPlayer(subplayer3team1));
                players1OUT.add(playerList1.getPlayer(subplayer4team1));
                players1OUT.add(playerList1.getPlayer(subplayer5team1));

                players2OUT.add(playerList2.getPlayer(subplayer1team2));
                players2OUT.add(playerList2.getPlayer(subplayer2team2));
                players2OUT.add(playerList2.getPlayer(subplayer3team2));
                players2OUT.add(playerList2.getPlayer(subplayer4team2));
                players2OUT.add(playerList2.getPlayer(subplayer5team2));

                //Intent for Substitution Activity
                Intent intent2 = new Intent(PlayersSelectionActivityR1.this, SubstitutionActivityR1.class);
                intent2.putExtra("game_id", game_id);
                intent2.putExtra("name1", team_name1);
                intent2.putExtra("name2", team_name2);
                intent2.putExtra("players1IN", (Serializable) players1IN);
                intent2.putExtra("players1OUT", (Serializable) players1OUT);
                intent2.putExtra("players2IN", (Serializable) players2IN);
                intent2.putExtra("players2OUT", (Serializable) players2OUT);
                intent2.putExtra("playerList1", (Serializable) playerList1);
                intent2.putExtra("playerList2", (Serializable) playerList2);
                intent2.putExtra("IP", ip);
                finish();

                startActivity(intent2);

            }
        });

    };
}