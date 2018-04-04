package com.example.groupassignment.dublinbike;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.groupassignment.dublinbike.R.id.aboutButton;
import static com.example.groupassignment.dublinbike.R.id.menuButton;
import static com.example.groupassignment.dublinbike.R.id.addFavouriteTripButton;
import static com.example.groupassignment.dublinbike.R.id.showTrips;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(aboutButton).setOnClickListener(this);
        findViewById(menuButton).setOnClickListener(this);
        findViewById(addFavouriteTripButton).setOnClickListener(this);
        findViewById(showTrips).setOnClickListener(this);

    }
    @Override
    public void onClick (View view) {
        switch (view.getId()) {

            case R.id.menuButton:
                startActivity(new Intent(this, MapsActivity.class));

                break;

            case R.id.aboutButton:

                startActivity(new Intent(this, AboutClass.class));

                break;

            case R.id.addFavouriteTripButton:

                startActivity(new Intent(this, FavouriteTrip.class));

                break;

            case R.id.showTrips:

                startActivity(new Intent(this, ShowFavouriteClass.class));

                break;

        }

    }


}
