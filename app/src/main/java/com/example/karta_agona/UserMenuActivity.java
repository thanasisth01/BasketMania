package com.example.karta_agona;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import android.os.Bundle;

public class UserMenuActivity extends AppCompatActivity {
    Button r4, r5, r6, r7, r8, r9, r10;
    ImageView image;
    String imageurl="https://play-lh.googleusercontent.com/5QgCZCua8KtaOHyfNR_AgoiPJy9PB_wATWK0qqE5s_yIJmvVveb_-9Quj1EdQdiNzhZo";
    String IP;
    int game_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_color)));

        Intent intent = getIntent();
        game_id = intent.getIntExtra("game_id", 1);
        IP = intent.getStringExtra("IP");

        r4=(Button) findViewById(R.id.button_r4);
        r5=(Button) findViewById(R.id.button_r5);
        r6=(Button) findViewById(R.id.button_r6);
        r7=(Button) findViewById(R.id.button_r7);
        r8=(Button) findViewById(R.id.button_r8);
        r9=(Button) findViewById(R.id.button_r9);
        r10=(Button) findViewById(R.id.button_r10);

        image=(ImageView) findViewById(R.id.applogo);
        Picasso.with(getApplicationContext()).load(imageurl).into(image);

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, R4MainActivity.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });
        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, R5_MainActivity.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });

        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, R6_MainActivity.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });
        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, R7MainActivity.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });
        r8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, MainActivityR8.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });
        r9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, R9_Main.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });
        r10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserMenuActivity.this, R10MainActivity.class);
                intent.putExtra("IP", IP);
                intent.putExtra("game_id", game_id);
                startActivity(intent);
                finish();
            }
        });
        Button backButton = (Button) findViewById(R.id.buttonBackUserMenu);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(UserMenuActivity.this, SelectMatchActivityUserR1.class);
                intentBack.putExtra("IP", IP);
                startActivity(intentBack);
                finish();
            }
        });
    }

}