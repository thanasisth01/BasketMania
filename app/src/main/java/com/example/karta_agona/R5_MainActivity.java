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

public class R5_MainActivity extends AppCompatActivity {

    private R5_MyConnection myConnection;           // the variable we set to make a connection and have a list of games
    private R5_GameData theGame;                    // the game whose data we want to show
    private String myIP="";                         // the IP we get the data from
    private int game_id;                            // the game we want to show data from
    private Button refresh_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r5_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        Intent myIntent = getIntent();
        refresh_button = findViewById(R.id.refresh_btn);

        myIP = myIntent.getStringExtra("IP");
        game_id = myIntent.getIntExtra("game_id", 1);






        getData();

        // With the refresh button we connect to the database everytime the user
        // presses the button and set them to the TextViews
        refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();
            }
        });

        Button backButton = findViewById(R.id.back_btnR6);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(R5_MainActivity.this,UserMenuActivity.class);
                intentBack.putExtra("game_id",game_id);
                intentBack.putExtra("IP", myIP);
                startActivity(intentBack);
                finish();
            }
        });
    }

    public void getData(){

        // Setting the TextViews from activity_main.xml.
        ImageView img_1 = findViewById(R.id.team_1_img);
        ImageView img_2 = findViewById(R.id.team_2_img);

        TextView header = findViewById(R.id.header_txt);
        TextView team_name_1 = findViewById(R.id.team_name_1_txt);
        TextView team_name_2 = findViewById(R.id.team_name_2_txt);
        //Button refresh_button = findViewById(R.id.refresh_btn);
        TextView points = findViewById(R.id.points_txt);

        TextView points_2_1 = findViewById(R.id.points_2_1_txt);
        TextView points_2_2 = findViewById(R.id.points_2_2_txt);

        TextView points_3_1 = findViewById(R.id.points_3_1_txt);
        TextView points_3_2 = findViewById(R.id.points_3_2_txt);

        TextView ft_1 = findViewById(R.id.ft_1_txt);
        TextView ft_2 = findViewById(R.id.ft_2_txt);

        TextView ass_1 = findViewById(R.id.ass_1_txt);
        TextView ass_2 = findViewById(R.id.ass_2_txt);

        TextView or_1 = findViewById(R.id.or_1_txt);
        TextView or_2 = findViewById(R.id.or_2_txt);

        TextView dr_1 = findViewById(R.id.dr_1_txt);
        TextView dr_2 = findViewById(R.id.dr_2_txt);

        TextView bl_1 = findViewById(R.id.bl_1_txt);
        TextView bl_2 = findViewById(R.id.bl_2_txt);

        TextView st_1 = findViewById(R.id.st_1_txt);
        TextView st_2 = findViewById(R.id.st_2_txt);

        TextView tur_1 = findViewById(R.id.tur_1_txt);
        TextView tur_2 = findViewById(R.id.tur_2_txt);

        TextView f_1 = findViewById(R.id.f_1_txt);
        TextView f_2 = findViewById(R.id.f_2_txt);

        TextView points_2 = findViewById(R.id.points_2_txt);
        TextView points_3 = findViewById(R.id.points_3_txt);
        TextView ft = findViewById(R.id.ft_txt);
        TextView assists = findViewById(R.id.ass_txt);
        TextView off_reb = findViewById(R.id.or_txt);
        TextView def_reb = findViewById(R.id.dr_txt);
        TextView blocks = findViewById(R.id.bl_txt);
        TextView steals = findViewById(R.id.st_txt);
        TextView turnovers = findViewById(R.id.tur_txt);
        TextView fouls = findViewById(R.id.f_txt);

        points_2_1.setText("-");
        points_2_2.setText("-");

        points_3_1.setText("-");
        points_3_2.setText("-");

        ft_1.setText("-");
        ft_2.setText("-");

        ass_1.setText("-");
        ass_2.setText("-");

        or_1.setText("-");
        or_2.setText("-");

        dr_1.setText("-");
        dr_2.setText("-");

        bl_1.setText("-");
        bl_2.setText("-");

        st_1.setText("-");
        st_2.setText("-");

        tur_1.setText("-");
        tur_2.setText("-");

        f_1.setText("-");
        f_2.setText("-");
        // We set a new R5_MyConnection with the IP and the game_id we want
        System.out.println("Game id before crash is" + game_id);
        myConnection = new R5_MyConnection(myIP,game_id);

        myConnection.StartConnectionToGetData();

        // We get the data of the game with the given id
        theGame = myConnection.getTheGame();

        // Here we set the TextViews/Images with the data that we got from the Database.

        // If the game is not finished (=0) then we show the data on the screen, otherwise (=1)
        // we show a text message that the game is finished.
        if (theGame.getFinishedGame()==0) {

            header.setText("Match " + theGame.getGame_id()+ ": Live Statistics");

            team_name_1.setText(theGame.getTeam_name_1());
            team_name_2.setText(theGame.getTeam_name_2());
            String img1 = theGame.getTeam_image_1();
            String img2 = theGame.getTeam_image_2();
            Picasso.with(getApplicationContext()).load(Uri.parse(img1)).resize(100,100).into(img_1);
            Picasso.with(getApplicationContext()).load(Uri.parse(img2)).resize(100,100).into(img_2);



            points.setText(theGame.getPoints());

            String po_2_1 = theGame.get2P_1()+"%";
            String po_2_2 = theGame.get2P_2()+"%";

            points_2_1.setText(po_2_1);
            points_2_2.setText(po_2_2);

            String po_3_1 = theGame.get3P_1()+"%";
            String po_3_2 = theGame.get3P_2()+"%";

            points_3_1.setText(po_3_1);
            points_3_2.setText(po_3_2);

            String free_t_1 = theGame.getFT_1()+"%";
            String free_t_2 = theGame.getFT_2()+"%";

            ft_1.setText(free_t_1);
            ft_2.setText(free_t_2);

            ass_1.setText(theGame.getAss_1());
            ass_2.setText(theGame.getAss_2());

            or_1.setText(theGame.getOr_1());
            or_2.setText(theGame.getOr_2());

            dr_1.setText(theGame.getDr_1());
            dr_2.setText(theGame.getDr_2());

            bl_1.setText(theGame.getBl_1());
            bl_2.setText(theGame.getBl_2());

            st_1.setText(theGame.getSt_1());
            st_2.setText(theGame.getSt_2());

            tur_1.setText(theGame.getTur_1());
            tur_2.setText(theGame.getTur_2());

            f_1.setText(theGame.getF_1());
            f_2.setText(theGame.getF_2());

        } else {

            // in this else the game is finished (=1) and we no longer want to get data every 5 seconds from
            // the database.

            refresh_button.setVisibility(View.INVISIBLE);

            header.setText("Match " + theGame.getGame_id() + ": Live Statistics");

            img_1.setVisibility(View.INVISIBLE);
            img_2.setVisibility(View.INVISIBLE);

            points.setText("The game is finished.");
            points.setTextSize(20);

            points_2.setVisibility(View.INVISIBLE);
            points_3.setVisibility(View.INVISIBLE);
            ft.setVisibility(View.INVISIBLE);
            assists.setVisibility(View.INVISIBLE);
            off_reb.setVisibility(View.INVISIBLE);
            def_reb.setVisibility(View.INVISIBLE);
            blocks.setVisibility(View.INVISIBLE);
            steals.setVisibility(View.INVISIBLE);
            turnovers.setVisibility(View.INVISIBLE);
            fouls.setVisibility(View.INVISIBLE);

            team_name_1.setVisibility(View.INVISIBLE);
            team_name_2.setVisibility(View.INVISIBLE);

            points_2_1.setVisibility(View.INVISIBLE);
            points_2_2.setVisibility(View.INVISIBLE);

            points_3_1.setVisibility(View.INVISIBLE);
            points_3_2.setVisibility(View.INVISIBLE);

            ft_1.setVisibility(View.INVISIBLE);
            ft_2.setVisibility(View.INVISIBLE);

            ass_1.setVisibility(View.INVISIBLE);
            ass_2.setVisibility(View.INVISIBLE);

            or_1.setVisibility(View.INVISIBLE);
            or_2.setVisibility(View.INVISIBLE);

            dr_1.setVisibility(View.INVISIBLE);
            dr_2.setVisibility(View.INVISIBLE);

            bl_1.setVisibility(View.INVISIBLE);
            bl_2.setVisibility(View.INVISIBLE);

            st_1.setVisibility(View.INVISIBLE);
            st_2.setVisibility(View.INVISIBLE);

            tur_1.setVisibility(View.INVISIBLE);
            tur_2.setVisibility(View.INVISIBLE);
            f_1.setVisibility(View.INVISIBLE);
            f_2.setVisibility(View.INVISIBLE);
        }
    }
}
