package com.example.birthday;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class Favo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favo);
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.gali);
        mediaPlayer.start();
    }
}