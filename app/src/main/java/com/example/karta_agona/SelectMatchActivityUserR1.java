package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SelectMatchActivityUserR1 extends AppCompatActivity {
    private BasketGameListR1 bglist;
    private GameWeekListR1 gwlist;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> basketGames;
    private String ip;

    public void ShowGamesOnClick(View v) {
        Spinner dropDown = (Spinner) findViewById(R.id.teams_id);
        int c = Integer.valueOf((Integer) dropDown.getSelectedItem());
        List<BasketGameR1> allGames = bglist.getAllGames(c);
        basketGames = new ArrayList<>();

        listView = findViewById(R.id.gamesList);
        for(int i=0; i<allGames.size(); i++){
            basketGames.add(allGames.get(i).getTeamName1() + " - " + allGames.get(i).getTeamName2() + "\n"
                    + allGames.get(i).getPoints1() + " - " + allGames.get(i).getPoints2());
        }
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, basketGames);
        listView.setAdapter(adapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int game_id = allGames.get(i).getId();
                //intent
                Intent intent1 = new Intent(SelectMatchActivityUserR1.this, UserMenuActivity.class);
                intent1.putExtra("game_id", game_id);
                intent1.putExtra("IP", ip);
                startActivity(intent1);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_match_user_r1);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        ImageView imgView = (ImageView)findViewById(R.id.imageLogo);
        imgView.setBackgroundResource(R.drawable.esake_logo);

        Intent intent = getIntent();
        ip = intent.getStringExtra("IP");
        bglist = new BasketGameListR1(ip);
        gwlist = new GameWeekListR1(ip);

        //populating spinner with game week numbers
        Spinner dropDown = (Spinner) findViewById(R.id.teams_id);
        ArrayAdapter<Integer> arrayAdapter =
                new ArrayAdapter<Integer>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        gwlist.getAllGameWeeks());
        dropDown.setAdapter(arrayAdapter);

    }

    protected void onDestroy() {
        super.onDestroy();
    }



}