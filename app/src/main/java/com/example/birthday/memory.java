package com.example.birthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class memory extends AppCompatActivity {
    SharedPreferences wordscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        MediaPlayer song_fav=MediaPlayer.create(this,R.raw.song_fav);
        song_fav.setLooping(true);
        song_fav.start();
        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), words.class);
                startActivity(intent);
                song_fav.stop();
                finish();
            }
        });
    }
}