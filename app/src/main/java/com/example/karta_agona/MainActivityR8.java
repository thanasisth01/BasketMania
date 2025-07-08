package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.model.TableColumnDpWidthModel;

public class MainActivityR8 extends AppCompatActivity {

    private TeamListR8 tl;
    private String ip;
    private int game_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r8_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        Intent intent = getIntent();
        ip = intent.getStringExtra("IP");
        game_id = intent.getIntExtra("game_id", 1);

        String[] header= {"Team","GP","P","PPG","2PM-A","3PM-A","FTM-A","REBS","D.REBS","O.REBS","AST","BLK","BLK-ON","STL","TO","FOULS F","FOULS M"};

        tl=new TeamListR8(ip);

        SortableTableView tableView = findViewById(R.id.tableView);

        //Creation of Header
        tableView.setHeaderAdapter(new TeamTableHeaderR8(this, header));

        //Creation of Table
        tableView.setDataAdapter(new TeamTableDataAdapterR8(this, tl.tList , tableView));

        TableColumnDpWidthModel columnModel = new TableColumnDpWidthModel(this, 17, 80);
        columnModel.setColumnWidth(0, 120);
        tableView.setColumnModel(columnModel);

        //Comparators for sorting
        tableView.setColumnComparator(0, TeamComparatorsR8.getTeamNameComparator() );
        tableView.setColumnComparator(1, TeamComparatorsR8.getGPComparator() );
        tableView.setColumnComparator(2, TeamComparatorsR8.getPointsComparator() );
        tableView.setColumnComparator(3, TeamComparatorsR8.getPPGComparator() );
        tableView.setColumnComparator(4, TeamComparatorsR8.getTwoPMComparator() );
        tableView.setColumnComparator(5, TeamComparatorsR8.getThreePMComparator() );
        tableView.setColumnComparator(6, TeamComparatorsR8.getFTMComparator() );
        tableView.setColumnComparator(7, TeamComparatorsR8.getRebsComparator() );
        tableView.setColumnComparator(8, TeamComparatorsR8.getDRebsComparator() );
        tableView.setColumnComparator(9, TeamComparatorsR8.getORebsComparator() );
        tableView.setColumnComparator(10, TeamComparatorsR8.getASTComparator() );
        tableView.setColumnComparator(11, TeamComparatorsR8.getBLKComparator() );
        tableView.setColumnComparator(12, TeamComparatorsR8.getBLK_onComparator() );
        tableView.setColumnComparator(13, TeamComparatorsR8.getSTLComparator() );
        tableView.setColumnComparator(14, TeamComparatorsR8.getTURNComparator() );
        tableView.setColumnComparator(15, TeamComparatorsR8.getFOULSFComparator() );
        tableView.setColumnComparator(16, TeamComparatorsR8.getFOULSMComparator() );
        //tableView.setColumnComparator(17, TeamComparatorsR8.getRANKComparator() );


        Button buttonBack = (Button) findViewById(R.id.buttonBackR8);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(MainActivityR8.this, UserMenuActivity.class);
                intentBack.putExtra("game_id", game_id);
                intentBack.putExtra("IP", ip);
                startActivity(intentBack);
                finish();
            }
        });
    }

}