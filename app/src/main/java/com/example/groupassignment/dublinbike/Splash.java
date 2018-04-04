package com.example.groupassignment.dublinbike;

import android.content.Intent;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class Splash extends AwesomeSplash{
    @Override
    public void initSplash(ConfigSplash configSplash) {
        try {
            configSplash.setBackgroundColor(R.color.btn1); //any color you want form colors.xml
            configSplash.setAnimCircularRevealDuration(2000); //int ms
            configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
            configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP
            //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default
            //Customize Logo
            configSplash.setLogoSplash(R.drawable.index); //or any other drawable
            configSplash.setAnimLogoSplashDuration(2000); //int ms
            configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)
            //Customize Title
            configSplash.setTitleSplash("DUBLIN BIKES");
            configSplash.setTitleTextColor(R.color.white);
            configSplash.setTitleTextSize(32f); //float value
            configSplash.setAnimTitleDuration(1000);
            configSplash.setAnimTitleTechnique(Techniques.FlipInX);
            //configSplash.setTitleFont("fonts/"); //provide string to your font located in assets/fonts/
        }catch (Exception e){
            Toast.makeText(this, "Error : " + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void animationsFinished() {
        try {
            //startActivity(new Intent(Splash.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            startActivity(new Intent(Splash.this,Welcome.class));
        }catch (Exception e){
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
        }
    }
}
