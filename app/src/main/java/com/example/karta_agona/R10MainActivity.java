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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class R10MainActivity extends AppCompatActivity {

    private Button button;
    private R10PlayersList Playerlist;
    private ArrayList<Integer> GWN;
    public static ArrayList<Integer> GWNArr;
    public static ArrayList<R10Player> selectedR10Players;
    public static ArrayList<R10Player> selectedPosition1R10Players;
    public static ArrayList<R10Player> selectedPosition2R10Players;
    public static ArrayList<R10Player> selectedPosition3R10Players;
    public static ArrayList<R10Player> selectedPosition4R10Players;
    public static ArrayList<R10Player> selectedPosition5R10Players;
    public String ip;
    public int game_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Intent intent = getIntent();
        ip = intent.getStringExtra("IP");
        game_id = intent.getIntExtra("game_id", 1);

        Playerlist = new R10PlayersList(ip);
        GWNArr = new ArrayList<>();
        selectedR10Players = new ArrayList<>();
        selectedPosition1R10Players = new ArrayList<>();
        selectedPosition2R10Players = new ArrayList<>();
        selectedPosition3R10Players = new ArrayList<>();
        selectedPosition4R10Players = new ArrayList<>();
        selectedPosition5R10Players = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r10_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        for (int i = 0; i < Playerlist.r10Players.size(); i++) {
            if(Playerlist.r10Players.size()<1)
                GWNArr.add(Playerlist.r10Players.get(i).getGame_week_number());
            else {
                if(GWNArr.contains(Playerlist.r10Players.get(i).getGame_week_number()) == false) {
                    GWNArr.add(Playerlist.r10Players.get(i).getGame_week_number());
                }
            }
        }

        for(int i=0; i<GWNArr.size(); i++){

            System.out.println("Players AARRRRRR++++++++++++++++++++++++++++++++++++++++" + GWNArr.get(i));
        }




        List<String> spinnerArray =  new ArrayList<String>();
        //GWN = mySQLConnection.getGWN();
        for(int i=0; i<GWNArr.size(); i++) {
            String item = Integer.toString(GWNArr.get(i));
            //String item = Integer.toString(Playerlist.players.get(i).getGame_week_number());

            spinnerArray.add(item);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.gwnspinner);
        sItems.setAdapter(adapter);

        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                Toast.makeText(parent.getContext(),
                        "SelectedGameWeek : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                // An item was selected. You can retrieve the selected item using parent.getItemAtPosition(pos)
                //System.out.println(parent.getItemAtPosition(pos));

                //δημιουργειται ενας πινακας με ολους τους παικτες που υπαρχουν στο επιλεγμενο game week number
                for (int i = 0; i < Playerlist.r10Players.size(); i++) {
                    String gwn = Integer.toString(Playerlist.r10Players.get(i).getGame_week_number());

                    if (parent.getItemAtPosition(pos).toString().equals(gwn) == true) {
                        selectedR10Players.add(Playerlist.r10Players.get(i));
                    }

                }


                //Ελεγχος με βάση την θέση position==1 και δημιουργια λιστας παικτων μονο με θέση 1
               /* for (int i = 0; i < selectedR10Players.size(); i++) {
                    if (selectedR10Players.get(i).getPosition().equals("point-guard")==true) {
                        selectedPosition1R10Players.add(selectedR10Players.get(i));

                    }
                }*/
                //Για καθε θεση δημιουργειται ενας πινακας με παικτες ανα θεση ωστε να εφαρμοστει μεθοδος tendex
                SelectedPlayersList(selectedPosition1R10Players, "Point Guard");
                SelectedPlayersList(selectedPosition2R10Players, "Shooting Guard");
                SelectedPlayersList(selectedPosition3R10Players, "Small Forward");
                SelectedPlayersList(selectedPosition4R10Players, "Power Forward");
                SelectedPlayersList(selectedPosition5R10Players, "Center");




                //Συμπληρωση των TextView
                TextView txtViewpos1 = (TextView) findViewById(R.id.pos1id);
                TextView txtViewpos2 = (TextView) findViewById(R.id.pos2id);
                TextView txtViewpos3 = (TextView) findViewById(R.id.pos3id);
                TextView txtViewpos4 = (TextView) findViewById(R.id.pos4id);
                TextView txtViewpos5 = (TextView) findViewById(R.id.pos5id);



                //Συμπληρωση textviews για καθε θεση με ονομα καλυτερου παικτη
                if (selectedPosition1R10Players.size() > 0){
                    txtViewpos1.setText(FindBestPlayer(selectedPosition1R10Players).getPlayer_name());
                }
                if(selectedPosition2R10Players.size()>0) {
                    txtViewpos2.setText(FindBestPlayer(selectedPosition2R10Players).getPlayer_name());
                }
                if(selectedPosition3R10Players.size()>0) {
                    txtViewpos3.setText(FindBestPlayer(selectedPosition3R10Players).getPlayer_name());
                }
                if(selectedPosition4R10Players.size()>0) {
                    txtViewpos4.setText(FindBestPlayer(selectedPosition4R10Players).getPlayer_name());
                }
                if(selectedPosition5R10Players.size()>0) {
                    txtViewpos5.setText(FindBestPlayer(selectedPosition5R10Players).getPlayer_name());
                }

                selectedR10Players.clear();
                selectedPosition1R10Players.clear();
                selectedPosition2R10Players.clear();
                selectedPosition3R10Players.clear();
                selectedPosition4R10Players.clear();
                selectedPosition5R10Players.clear();




            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        Button buttonBack = (Button) findViewById(R.id.back_btnR6);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(R10MainActivity.this, UserMenuActivity.class);
                intentBack.putExtra("game_id", game_id);
                intentBack.putExtra("IP", ip);
                startActivity(intentBack);
                finish();
            }
        });


    }
    //Υπολογισμος λιστας με τους παικτες της αγωνιστικης που εχουν ως θεση την θεση του ορισματος position_number
    public void SelectedPlayersList(ArrayList <R10Player> positionPlayersList, String pos) {
        for(int i = 0; i< selectedR10Players.size(); i++){
            if(selectedR10Players.get(i).getPosition().equals(pos)==true){
                positionPlayersList.add(selectedR10Players.get(i));

            }
        }
    }

    //υπολογισμος καλυτερου παικτη με βαση τον δεικτη tendex και επιστροφη παικτη
    public R10Player FindBestPlayer(ArrayList <R10Player> positionPlayersList){
        int best_player_index = 0;
        float max = 0;
        for(int i = 0; i< positionPlayersList.size(); i++){
            if(positionPlayersList.get(i).getTendex()>max) {
                max = positionPlayersList.get(i).getTendex();
                best_player_index = i;
            }
        }
        return positionPlayersList.get(best_player_index);
    }


}