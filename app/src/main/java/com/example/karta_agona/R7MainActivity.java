package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.ArrayList;
import android.content.Intent;

import de.codecrafters.tableview.SortableTableView;

public class R7MainActivity extends AppCompatActivity {
    private ArrayList<R7TeamData> r7statsList;
    private String ip="";
    private int game_id;
    private R7TeamList r7teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r7_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));
        TableLayout r7table = findViewById(R.id.r7tablelayout);

        Intent intent = getIntent();
        ip = intent.getStringExtra("IP");
        game_id = intent.getIntExtra("game_id", 1);

        //Creating Header of r7table
        TableRow r7tr0 = new TableRow(this);
        TextView r7tv0 = new TextView(this);
        r7tv0.setText("TEAM");
        r7tv0.setTextSize(17);
        r7tv0.setGravity(Gravity.CENTER);
        r7tv0.setTypeface(null, Typeface.BOLD);
        r7tv0.setBackgroundColor(Color.parseColor("#1580BA"));
        r7tv0.setPadding(0, 10, 0, 10);
        r7tr0.addView(r7tv0);

        TextView r7tv1 = new TextView(this);
        r7tv1.setText("GP");
        r7tv1.setTextSize(17);
        r7tv1.setGravity(Gravity.CENTER);
        r7tv1.setBackgroundColor(Color.parseColor("#1580BA"));
        r7tv1.setPadding(70, 10, 0, 10);
        r7tv1.setTypeface(null, Typeface.BOLD);
        r7tr0.addView(r7tv1);

        TextView r7tv2 = new TextView(this);
        r7tv2.setText("RP");
        r7tv2.setTextSize(17);
        r7tv2.setGravity(Gravity.CENTER);
        r7tv2.setTypeface(null, Typeface.BOLD);
        r7tv2.setBackgroundColor(Color.parseColor("#1580BA"));
        r7tv2.setPadding(70, 10, 0, 10);
        r7tr0.addView(r7tv2);

        TextView r7tv3 = new TextView(this);
        r7tv3.setText("W");
        r7tv3.setTextSize(17);
        r7tv3.setTypeface(null, Typeface.BOLD);
        r7tv3.setGravity(Gravity.CENTER);
        r7tv3.setBackgroundColor(Color.parseColor("#1580BA"));
        r7tv3.setPadding(70, 10, 0, 10);
        r7tr0.addView(r7tv3);

        TextView r7tv4 = new TextView(this);
        r7tv4.setText("L");
        r7tv4.setTextSize(17);
        r7tv4.setTypeface(null, Typeface.BOLD);
        r7tv4.setGravity(Gravity.CENTER);
        r7tv4.setBackgroundColor(Color.parseColor("#1580BA"));
        r7tv4.setPadding(70, 10, 20, 10);
        r7tr0.addView(r7tv4);
        r7table.addView(r7tr0);

        //End of Creating Header

        r7teamList = new R7TeamList(ip);
        r7statsList = new ArrayList<>();
        r7statsList = r7teamList.getGetR7Teams();

        //Displaying r7statsList Data In Table
        for (int i = 0; i < r7statsList.size(); i++) {
            TableRow r7tableRow1 = new TableRow(this);

            TextView r7textView1 = new TextView(this);
            String r7team_name = r7statsList.get(i).getR7team_name();
            r7textView1.setText("#"+(i+1) + "   " + r7team_name);
            r7textView1.setTextSize(17);
            r7textView1.setPadding(10, 10, 50, 25);
            r7tableRow1.addView(r7textView1);

            TextView r7textView2 = new TextView(this);
            int r7GP = r7statsList.get(i).getR7gamesplayed();
            r7textView2.setText(Integer.toString(r7GP));
            r7textView2.setTextSize(17);
            r7textView2.setGravity(Gravity.CENTER);
            r7textView2.setPadding(60, 0, 0, 0);
            r7tableRow1.addView(r7textView2);

            TextView r7textView3 = new TextView(this);
            int r7rank_points = r7statsList.get(i).getR7points();
            r7textView3.setText(Integer.toString(r7rank_points));
            r7textView3.setGravity(Gravity.CENTER);
            r7textView3.setTextSize(17);
            r7textView3.setPadding(60, 0, 0, 0);
            r7tableRow1.addView(r7textView3);

            TextView r7textView4 = new TextView(this);
            int r7wins = r7statsList.get(i).getR7wins();
            r7textView4.setText(Integer.toString(r7wins));
            r7textView4.setGravity(Gravity.CENTER);
            r7textView4.setTextSize(17);
            r7textView4.setPadding(60, 0, 0, 0);
            r7tableRow1.addView(r7textView4);

            TextView r7textView5 = new TextView(this);
            int r7losses = r7statsList.get(i).getR7loses();
            r7textView5.setText(Integer.toString(r7losses));
            r7textView5.setGravity(Gravity.CENTER);
            r7textView5.setTextSize(17);
            r7textView5.setPadding(40, 0, 0, 0);
            r7tableRow1.addView(r7textView5);

            r7table.addView(r7tableRow1);

        }

        Button buttonBack = (Button) findViewById(R.id.buttonBackR7);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(R7MainActivity.this, UserMenuActivity.class);
                intentBack.putExtra("game_id", game_id);
                intentBack.putExtra("IP", ip);
                startActivity(intentBack);
                finish();
            }
        });
    }
}