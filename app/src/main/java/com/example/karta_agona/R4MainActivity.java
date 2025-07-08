package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;



public class R4MainActivity extends AppCompatActivity {

    private ArrayList<R4Event> showEvents;
    private RecyclerView recyclerView;
    private int game_id;
    private String ip;

    boolean isActive;

    TextView gameDate ;
    TextView team_1;
    TextView team_2;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r4_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        Intent intent = getIntent();
        ip = intent.getStringExtra("IP");
        game_id = intent.getIntExtra("game_id", 1);

        isActive = true;
        if(isActive){
        content();}

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(R4MainActivity.this, UserMenuActivity.class);
                intentBack.putExtra("game_id", game_id);
                intentBack.putExtra("IP", ip);
                startActivity(intentBack);
                finish();
            }
        });
    }

    private void content() {

        R4BasketGameList basketGames = new R4BasketGameList(ip);

        R4EventList events = new R4EventList(ip);
        //game_id=1;

        gameDate = findViewById(R.id.gameDate);
        team_1 = findViewById(R.id.team1);
        team_2 = findViewById(R.id.team2);
        score =findViewById(R.id.score_txt);
        recyclerView= findViewById(R.id.recyclerView);


        ArrayList<R4BasketGame> basketGamesList = basketGames.getR4BasketGames();
        ArrayList<R4Event> eventsList = events.getR4Events();


        // int x = 0;
        //R4BasketGame chosenGame = basketGamesList.get(x);

        for(int i=0; i<basketGamesList.size(); i++) {
            R4BasketGame chosenGame = basketGamesList.get(i);
            if (chosenGame.getGame_id() == game_id) {
                Time timeStart = chosenGame.getStartingTime();
                gameDate.setText("Game Started at: " + timeStart.toString() + " (GMT+3)");
                team_1.setText(chosenGame.getTeam_1());
                team_2.setText(chosenGame.getTeam_2());

                //If game is still playing
                if (chosenGame.getFinishedGame() == 0) {

                    String textScore = chosenGame.getScore1() + "-" + chosenGame.getScore2();
                    score.setText(textScore);

                } else if (chosenGame.getFinishedGame() == 1) {
                    //Stops Live
                    String textScore = "Game has finished";
                    score.setText(textScore);
                }

                showEvents = new ArrayList<>();
                for (int j = 0; j < eventsList.size(); j++) {
                    if (chosenGame.getFinishedGame() == 0) {
                        if (eventsList.get(j).getGameID() == chosenGame.getGame_id())
                            showEvents.add(eventsList.get(j));
                    }
                }
            }

        }
        setAdapter();
        if(isActive){
        refresh(5000);}
    }

    private void refresh(int milliseconds){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
        handler.postDelayed(runnable,milliseconds);
    }

    private void setAdapter() {
        R4recyclerAdapter adapter = new R4recyclerAdapter(showEvents);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

 @Override
    public void finish(){
        super.finish();
        isActive=false;
 }
}

