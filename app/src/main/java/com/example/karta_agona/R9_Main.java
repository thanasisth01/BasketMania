package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class R9_Main extends AppCompatActivity {


    public Spinner playerMenu;
    public Spinner teamMenu;
    public String teamname;
    public ArrayAdapter<String> arrayAdapter;
    public String ip="";
    private int game_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r9_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        Intent intent = getIntent();
        ip = intent.getStringExtra("IP");
        game_id = intent.getIntExtra("game_id", 1);

        R9_SQLgetTeamNames sqlgetTeamNamesR9 = new R9_SQLgetTeamNames(ip); //For fetching the team names from the database
        Thread t = new Thread(sqlgetTeamNamesR9);
        try {
            t.start();
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        teamMenu = findViewById(R.id.teamMenu); //Updating the team dropdown menu with the team names
        ArrayAdapter<String> arrayAdapter2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        sqlgetTeamNamesR9.getTeamNames());
        playerMenu = findViewById(R.id.playerMenu);

        teamMenu.setAdapter(arrayAdapter2);
        teamMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(teamMenu.getSelectedItem().toString());
                teamname = teamMenu.getSelectedItem().toString();
                System.out.println(teamname);

                updateDropdown(teamname); //Updating the player dropdown menu with the players from the chosen team



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                teamname = teamMenu.getItemAtPosition(0).toString(); //Choosing the first team from the start so that the menus won't be empty
            }

        });

        playerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(playerMenu.getSelectedItem().toString());
                R9_Player currPlayerR9 = R9_Player.teamPlayerR9.get(playerMenu.getSelectedItemPosition());
                updateTextViews(currPlayerR9);



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println(playerMenu.getItemAtPosition(0).toString());
            }
        });

        Button buttonBack = (Button) findViewById(R.id.buttonBackR9);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(R9_Main.this, UserMenuActivity.class);
                intentBack.putExtra("game_id", game_id);
                intentBack.putExtra("IP", ip);
                startActivity(intentBack);
                finish();
            }
        });


    }

    public void updateDropdown (String teamname){

        R9_MySQLConnection sqlGetPlayers = new R9_MySQLConnection(ip);
        Thread p = new Thread(sqlGetPlayers);
        try {

            p.start();
            sqlGetPlayers.teamname = teamname;
            p.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        R9_Player.getPlayerNames());
        playerMenu.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged(); //For updating purposes

    }

    public void updateTextViews (R9_Player currPlayerR9){

        TextView games_played;
        TextView total_time;
        TextView points;
        TextView made2p;
        TextView attempted2p;
        TextView made3p;
        TextView attempted3p;
        TextView madeft;
        TextView attemptedft;
        TextView off_rebs;
        TextView def_rebs;
        TextView assist;
        TextView blocks;
        TextView blocks_on;
        TextView steals;
        TextView turnovers;
        TextView fouls_drawn;
        TextView fouls_commited;
        TextView tendex;
        TextView position;
        ImageView playerImage;

        //Link variables with components
        playerImage = findViewById(R.id.playerImagee);
        position = findViewById(R.id.positionV);
        games_played = findViewById(R.id.games_playedV);
        total_time = findViewById(R.id.total_timeV);
        points = findViewById(R.id.pointsV);
        made2p = findViewById(R.id.made2pV);
        attempted2p = findViewById(R.id.attempted2pV);
        made3p = findViewById(R.id.made3pV);
        attempted3p = findViewById(R.id.attempted3pV);
        madeft = findViewById(R.id.madeFtV);
        attemptedft = findViewById(R.id.attemptedftV);
        off_rebs = findViewById(R.id.off_reboundsV);
        def_rebs = findViewById(R.id.def_reboundsV);
        assist = findViewById(R.id.assistsV);
        blocks = findViewById(R.id.blocksV);
        blocks_on = findViewById(R.id.blocks_onV);
        steals = findViewById(R.id.stealsV);
        turnovers = findViewById(R.id.turnoversV);
        fouls_drawn = findViewById(R.id.fouls_drawnV);
        fouls_commited = findViewById(R.id.fouls_commitedV);
        tendex = findViewById(R.id.tendexV);

        //Set values
        Picasso.with(getApplicationContext()).load(Uri.parse(currPlayerR9.photo_path)).into(playerImage);
        position.setText(currPlayerR9.position);
        games_played.setText(String.valueOf(currPlayerR9.games_played));
        total_time.setText(String.valueOf(currPlayerR9.total_time));
        points.setText(String.valueOf(currPlayerR9.points));
        made2p.setText(String.valueOf(currPlayerR9.made2p));
        attempted2p.setText(String.valueOf(currPlayerR9.attempted2p));
        made3p.setText(String.valueOf(currPlayerR9.made3p));
        attempted3p.setText(String.valueOf(currPlayerR9.attempted3p));
        madeft.setText(String.valueOf(currPlayerR9.madeft));
        attemptedft.setText(String.valueOf(currPlayerR9.attemptedft));
        off_rebs.setText(String.valueOf(currPlayerR9.off_rebs));
        def_rebs.setText(String.valueOf(currPlayerR9.def_rebs));
        assist.setText(String.valueOf(currPlayerR9.assist));
        blocks.setText(String.valueOf(currPlayerR9.blocks));
        blocks_on.setText(String.valueOf(currPlayerR9.blocks_on));
        steals.setText(String.valueOf(currPlayerR9.steals));
        turnovers.setText(String.valueOf(currPlayerR9.turnovers));
        fouls_drawn.setText(String.valueOf(currPlayerR9.fouls_drawn));
        fouls_commited.setText(String.valueOf(currPlayerR9.fouls_commited));
        tendex.setText(String.valueOf(currPlayerR9.tendex));

    }
}