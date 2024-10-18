package com.prothesbarai.sdf;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mursaat.extendedtextview.AnimatedGradientTextView;

public class SplashScreen extends AppCompatActivity {

    Animation Splash_top,Splash_bottom;
    RoundedImageView splash_logo;
    AnimatedGradientTextView splash_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(layoutParams);
        }

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        setContentView(R.layout.activity_splash_screen);

        splash_logo = findViewById(R.id.splash_logo);
        splash_name = findViewById(R.id.splash_name);

        Splash_top = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        Splash_bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        splash_logo.setAnimation(Splash_top);
        splash_name.setAnimation(Splash_bottom);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgress();
                goHomePage();
            }
        });

        thread.start();

    }


    public void startProgress(){
        try {
            Thread.sleep(4300,200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void goHomePage(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}