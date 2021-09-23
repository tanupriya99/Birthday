package com.example.birthday;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.logging.LogRecord;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class MainActivity extends AppCompatActivity {
    KonfettiView konfettiView;
    TextView bdayMsg;
    RelativeLayout layout0, layoutW;
    ViewSwitcher logo0,logo1,logo2,logo3,logow,logox,logoy,logoz;
    ImageButton imgbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgbtn=findViewById(R.id.imgbtn);
        logo0=findViewById(R.id.logo0);
        logo1=findViewById(R.id.logo1);
        logo2=findViewById(R.id.logo2);
        logo3=findViewById(R.id.logo3);
        logow=findViewById(R.id.logow);
        logox=findViewById(R.id.logox);
        logoy=findViewById(R.id.logoy);
        logoz=findViewById(R.id.logoz);
        bdayMsg=findViewById(R.id.bdayText);
        layout0=findViewById(R.id.layout0);
        layoutW=findViewById(R.id.layoutW);
        Animation rotation= AnimationUtils.loadAnimation(this,R.anim.anim_pic);
        logo0.setAnimation(rotation);
        logow.setAnimation(rotation);
        layoutOneView();
        konfettiView=findViewById(R.id.viewKonfetti);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),secret.class));

                finish();
            }
        });


        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)

                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 500000L);

    }


    private void layoutOneView() {
        layout0.setVisibility(View.VISIBLE);
        layoutW.setVisibility((View.GONE));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (logo0.getDisplayedChild()==0){
                    logo0.showNext();
                }
                else{
                    logo0.showPrevious();
                }
            }
        }, 10000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (logo1.getDisplayedChild()==0){
                    logo1.showNext();
                }
                else{
                    logo1.showPrevious();
                }
            }
        }, 20000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (logo2.getDisplayedChild()==0){
                    logo2.showNext();
                }
                else{
                    logo2.showPrevious();
                }
            }
        }, 30000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (logo3.getDisplayedChild()==0){
                    logo3.showNext();
                }
                else{
                    logo3.showPrevious();
                }
            }
        }, 40000);
        layoutTwoView();
    }

    private void layoutTwoView() {
        layout0.setVisibility(View.GONE);
        layoutW.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(logow.getDisplayedChild()==0){
                    logow.showNext();
                }
                else{
                    logow.showPrevious();
                }
            }
        },10000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(logox.getDisplayedChild()==0){
                    logox.showNext();
                }
                else{
                    logox.showPrevious();
                }
            }
        },20000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(logoy.getDisplayedChild()==0){
                    logoy.showNext();
                }
                else{
                    logoy.showPrevious();
                }
            }
        },30000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(logoz.getDisplayedChild()==0){
                    logoz.showNext();
                }
                else{
                    logoz.showPrevious();
                }
            }
        },40000);
    }

   @Override
    protected void onStart() {
        startService(new Intent(this,music_service.class));
       super.onStart();
   }

    @Override
    public void onBackPressed() {
        stopService(new Intent(this,music_service.class));
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        stopService(new Intent(this,music_service.class));
        super.onPause();
    }

}