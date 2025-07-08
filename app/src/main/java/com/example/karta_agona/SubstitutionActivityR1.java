package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubstitutionActivityR1 extends AppCompatActivity {
    private int game_id;
    private String team_name1;
    private String team_name2;
    private PlayerListR1 playerList1;
    private PlayerListR1 playerList2;
    private List<PlayerR1> players1;
    private List<PlayerR1> players2;
    private ArrayList<PlayerR1> players1IN;
    private ArrayList<PlayerR1> players1OUT;
    private ArrayList<PlayerR1> players2IN;
    private ArrayList<PlayerR1> players2OUT;
    private ArrayList<String> players1spinnerIN;
    private ArrayList<String> players1spinnerOUT;
    private ArrayList<String> players2spinnerOUT;
    private ArrayList<String> players2spinnerIN;
    private ArrayAdapter<String> arrayAdapter1;
    private ArrayAdapter<String> arrayAdapter2;
    private ArrayAdapter<String> arrayAdapter3;
    private ArrayAdapter<String> arrayAdapter4;
    private ArrayAdapter<String> arrayAdaptersub1;
    private ArrayAdapter<String> arrayAdaptersub2;
    private ArrayAdapter<String> arrayAdaptersub3;
    private ArrayAdapter<String> arrayAdaptersub4;
    private String ip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitution);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        //initialize Lists
        players1spinnerIN = new ArrayList<>();
        players1spinnerOUT = new ArrayList<>();
        players2spinnerIN = new ArrayList<>();
        players2spinnerOUT = new ArrayList<>();
        players1IN = new ArrayList<>();
        players2IN = new ArrayList<>();
        players1OUT = new ArrayList<>();
        players2OUT = new ArrayList<>();
        players1 = new ArrayList<>();
        players2 = new ArrayList<>();


        //receive Ιntent
        Intent intent = getIntent();
        game_id = intent.getIntExtra("game_id", 1);
        String idString = String.valueOf(game_id);
        team_name1 = intent.getStringExtra("name1");
        team_name2 = intent.getStringExtra("name2");
        players1IN = (ArrayList<PlayerR1>) intent.getSerializableExtra("players1IN");
        players1OUT = (ArrayList<PlayerR1>) intent.getSerializableExtra("players1OUT");
        players2IN = (ArrayList<PlayerR1>) intent.getSerializableExtra("players2IN");
        players2OUT = (ArrayList<PlayerR1>) intent.getSerializableExtra("players2OUT");
        playerList1 = (PlayerListR1) intent.getSerializableExtra("playerList1");
        playerList2 = (PlayerListR1) intent.getSerializableExtra("playerList2");
        players1 = playerList1.getAllPlayers(team_name1);
        players2 = playerList2.getAllPlayers(team_name2);
        ip = intent.getStringExtra("IP");

        //textViews
        TextView t1 = findViewById(R.id.textViewteam1);
        t1.setText(team_name1);
        TextView t2 = findViewById(R.id.textViewteam2);
        t2.setText(team_name2);


        //Substitution
        //fill Spinners
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);

        for (int i = 0; i < players1IN.size(); i++) {
            players1spinnerIN.add(players1IN.get(i).getName());
        }
        for (int i = 0; i < players1OUT.size(); i++) {
            players1spinnerOUT.add(players1OUT.get(i).getName());
        }
        for (int i = 0; i < players2IN.size(); i++) {
            players2spinnerIN.add(players2IN.get(i).getName());
        }
        for (int i = 0; i < players2OUT.size(); i++) {
            players2spinnerOUT.add(players2OUT.get(i).getName());
        }


        //setup ArrayAdapters
        arrayAdapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, players1spinnerIN);
        spinner1.setAdapter(arrayAdapter1);

        arrayAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, players1spinnerOUT);
        spinner2.setAdapter(arrayAdapter2);

        arrayAdapter3 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, players2spinnerIN);
        spinner3.setAdapter(arrayAdapter3);

        arrayAdapter4 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, players2spinnerOUT);
        spinner4.setAdapter(arrayAdapter4);


        Button buttonSub1 = (Button) findViewById(R.id.buttonSub1);
        buttonSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text1 = findViewById(R.id.editTextTime1);
                String timeString = String.valueOf(text1.getText());
                int time = Integer.parseInt(timeString);

                String playerIN = spinner1.getSelectedItem().toString();
                String playerOUT = spinner2.getSelectedItem().toString();
                playerList1.whenPlayerIsChosen(playerOUT);
                playerList1.whenPlayerIsChosen(playerIN);

                playerList1.setPlayerOUTTime(playerIN, time);
                playerList1.setPlayerINTime(playerOUT, time);

                int indexPlayerIN = 0;
                for(int i=0; i<players1IN.size(); i++){
                    if(players1IN.get(i).getName().equals(playerIN)){
                        indexPlayerIN = i;
                    }
                }

                int indexPlayerOUT = 0;
                for(int i=0; i<players1OUT.size(); i++){
                    if(players1OUT.get(i).getName().equals(playerOUT)){
                        indexPlayerOUT = i;
                    }
                }

                players1IN.add(playerList1.getPlayer(playerOUT));
                players1OUT.remove(indexPlayerOUT);

                players1IN.remove(indexPlayerIN);
                players1OUT.add(playerList1.getPlayer(playerIN));

                players1spinnerIN.clear();
                for (int i = 0; i < players1IN.size(); i++) {
                    players1spinnerIN.add(players1IN.get(i).getName());
                }
                players1spinnerOUT.clear();
                for (int i = 0; i < players1OUT.size(); i++) {
                    players1spinnerOUT.add(players1OUT.get(i).getName());
                }


                arrayAdaptersub1 = new ArrayAdapter(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, players1spinnerIN);
                arrayAdaptersub2 = new ArrayAdapter(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, players1spinnerOUT);

                spinner1.setAdapter(arrayAdaptersub1);
                spinner2.setAdapter(arrayAdaptersub2);

            }
        });

        Button buttonSub2 = (Button) findViewById(R.id.buttonSub2);
        buttonSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText text2 = findViewById(R.id.editTextTime2);
                String timeString = String.valueOf(text2.getText());
                int time = Integer.parseInt(timeString);

                String playerIN = spinner3.getSelectedItem().toString();
                String playerOUT = spinner4.getSelectedItem().toString();
                playerList2.whenPlayerIsChosen(playerOUT);
                playerList2.whenPlayerIsChosen(playerIN);

                playerList2.setPlayerOUTTime(playerIN, time);
                playerList2.setPlayerINTime(playerOUT, time);

                int indexPlayerIN = 0;
                for(int i=0; i<players2IN.size(); i++){
                    if(players2IN.get(i).getName().equals(playerIN)){
                        indexPlayerIN = i;
                    }
                }

                int indexPlayerOUT = 0;
                for(int i=0; i<players2OUT.size(); i++){
                    if(players2OUT.get(i).getName().equals(playerOUT)){
                        indexPlayerOUT = i;
                    }
                }

                players2IN.add(playerList2.getPlayer(playerOUT));
                players2OUT.remove(indexPlayerOUT);

                players2IN.remove(indexPlayerIN);
                players2OUT.add(playerList2.getPlayer(playerIN));

                players2spinnerIN.clear();
                for (int i = 0; i < players2IN.size(); i++) {
                    players2spinnerIN.add(players2IN.get(i).getName());
                }
                players2spinnerOUT.clear();
                for (int i = 0; i < players2OUT.size(); i++) {
                    players2spinnerOUT.add(players2OUT.get(i).getName());
                }

                arrayAdaptersub3 = new ArrayAdapter(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, players2spinnerIN);
                arrayAdaptersub4 = new ArrayAdapter(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, players2spinnerOUT);

                spinner3.setAdapter(arrayAdaptersub3);
                spinner4.setAdapter(arrayAdaptersub4);

            }
        });

        Button buttonManageGame = (Button) findViewById(R.id.buttonManageGame);
        buttonManageGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToR2 = new Intent(SubstitutionActivityR1.this, MainActivityR2_R3.class);
                intentToR2.putExtra("game_id", game_id);
                intentToR2.putExtra("name1", team_name1);
                intentToR2.putExtra("name2", team_name2);
                intentToR2.putExtra("players1IN", (Serializable) players1IN);
                intentToR2.putExtra("players1OUT", (Serializable) players1OUT);
                intentToR2.putExtra("players2IN", (Serializable) players2IN);
                intentToR2.putExtra("players2OUT", (Serializable) players2OUT);
                intentToR2.putExtra("playerList1", (Serializable) playerList1);
                intentToR2.putExtra("playerList2", (Serializable) playerList2);
                intentToR2.putExtra("IP", ip);
                startActivity(intentToR2);
                finish();
            }
        });
    }
}