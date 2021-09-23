package com.example.birthday;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class music_service2 extends Service {

    private MediaPlayer player_1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player_1=MediaPlayer.create(getApplicationContext(),R.raw.song_1);
        player_1.setLooping(true);
        player_1.start();
        AudioManager manager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        manager.setStreamVolume(AudioManager.STREAM_MUSIC,manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)/2,0);
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        player_1.stop();
        player_1.release();
        super.onDestroy();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
