package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class R6_MainActivity extends AppCompatActivity {
    private String firstTeamImage, secondTeamImage;
    /**
     * url to the ESAKE logo
     */
    private String imageurl="https://play-lh.googleusercontent.com/5QgCZCua8KtaOHyfNR_AgoiPJy9PB_wATWK0qqE5s_yIJmvVveb_-9Quj1EdQdiNzhZo";
    private String IP;
    int game_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r6_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        /**
         * Creates a new connection to the basket_data database
         */
        Intent intent=getIntent();
        IP= intent.getStringExtra("IP");
        game_id= intent.getIntExtra("game_id", 1);

        R6_MySQLConnection r6MySQLConnection=new R6_MySQLConnection(IP, game_id);
        Thread t=new Thread(r6MySQLConnection);
        try {
            t.start();
            t.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        /**
         * Creates TextViews and ImageViews that will be displayed on the screen
         */
        TextView match=(TextView) findViewById(R.id.r6_match_name);
        ImageView applogo=(ImageView) findViewById(R.id.R6_applogo);
        TextView team_1=(TextView) findViewById(R.id.r6_team_1);
        TextView team_2=(TextView) findViewById(R.id.r6_team_2);
        ImageView image1=(ImageView) findViewById(R.id.R6_image1);
        ImageView image2=(ImageView) findViewById(R.id.R6_image2);
        TextView total_1=(TextView) findViewById(R.id.r6_total_1);
        TextView total_2=(TextView) findViewById(R.id.r6_total_2);
        TextView points2_1=(TextView) findViewById(R.id.r6_points2_1);
        TextView points2_2=(TextView) findViewById(R.id.r6_points2_2);
        TextView points3_1=(TextView) findViewById(R.id.r6_points3_1);
        TextView points3_2=(TextView) findViewById(R.id.r6_points3_2);
        TextView freeshots_1=(TextView) findViewById(R.id.r6_freeshots_1);
        TextView freeshots_2=(TextView) findViewById(R.id.r6_freeshots_2);
        TextView assists_1=(TextView) findViewById(R.id.r6_assists_1);
        TextView assists_2=(TextView) findViewById(R.id.r6_assists_2);
        TextView offreb_1=(TextView) findViewById(R.id.r6_offreb_1);
        TextView offreb_2=(TextView) findViewById(R.id.r6_offreb_2);
        TextView defreb_1=(TextView) findViewById(R.id.r6_defreb_1);
        TextView defreb_2=(TextView) findViewById(R.id.r6_defreb_2);
        TextView blocks_1=(TextView) findViewById(R.id.r6_blocks_1);
        TextView blocks_2=(TextView) findViewById(R.id.r6_blocks_2);
        TextView steals_1=(TextView) findViewById(R.id.r6_steals_1);
        TextView steals_2=(TextView) findViewById(R.id.r6_steals_2);
        TextView turnover_1=(TextView) findViewById(R.id.r6_turnover_1);
        TextView turnover_2=(TextView) findViewById(R.id.r6_turnover_2);
        TextView foul_1=(TextView) findViewById(R.id.r6_fouls_1);
        TextView foul_2=(TextView) findViewById(R.id.r6_fouls_2);

        /**
         * Initialize the TextViews and the ImageViews with the help of the R6_MySQLConnection class methods
         */
        String matchNumber;
        matchNumber=r6MySQLConnection.getMatch_name();
        match.setText("Match " + matchNumber+ " - Statistics");
        Picasso.with(getApplicationContext()).load(Uri.parse(imageurl)).into(applogo);
        team_1.setText(r6MySQLConnection.getTeam1());
        team_2.setText(r6MySQLConnection.getTeam2());
        /**
         * firstTeamImage contains the url to the team logo for the team which statistics are displayed on the left
         * while secondTeamImage contains the url to the team logo which data are displayed on the right
         */
        firstTeamImage= r6MySQLConnection.getImage1();
        secondTeamImage= r6MySQLConnection.getImage2();
        Picasso.with(getApplicationContext()).load(Uri.parse(firstTeamImage)).into(image1);
        Picasso.with(getApplicationContext()).load(Uri.parse(secondTeamImage)).into(image2);
        total_1.setText(r6MySQLConnection.getTotal1());
        total_2.setText(r6MySQLConnection.getTotal2());
        points2_1.setText(r6MySQLConnection.getPoints2_1());
        points2_2.setText(r6MySQLConnection.getPoints2_2());
        points3_1.setText(r6MySQLConnection.getPoints3_1());
        points3_2.setText(r6MySQLConnection.getPoints3_2());
        freeshots_1.setText(r6MySQLConnection.getFreeshots1());
        freeshots_2.setText(r6MySQLConnection.getFreeshots2());
        assists_1.setText(r6MySQLConnection.getAssists1());
        assists_2.setText(r6MySQLConnection.getAssists2());
        offreb_1.setText(r6MySQLConnection.getOffreb1());
        offreb_2.setText(r6MySQLConnection.getOffreb2());
        defreb_1.setText(r6MySQLConnection.getDefreb1());
        defreb_2.setText(r6MySQLConnection.getDefreb2());
        blocks_1.setText(r6MySQLConnection.getBlocks1());
        blocks_2.setText(r6MySQLConnection.getBlocks2());
        steals_1.setText(r6MySQLConnection.getSteals1());
        steals_2.setText(r6MySQLConnection.getSteals2());
        turnover_1.setText(r6MySQLConnection.getTurnovers1());
        turnover_2.setText(r6MySQLConnection.getTurnovers2());
        foul_1.setText(r6MySQLConnection.getFouls1());
        foul_2.setText(r6MySQLConnection.getFouls2());


        Button buttonBack = (Button) findViewById(R.id.back_btnR6);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(R6_MainActivity.this, UserMenuActivity.class);
                intentBack.putExtra("game_id", game_id);
                intentBack.putExtra("IP", IP);
                startActivity(intentBack);
                finish();
            }
        });

    }
}