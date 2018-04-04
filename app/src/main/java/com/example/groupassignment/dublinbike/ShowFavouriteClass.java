package com.example.groupassignment.dublinbike;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class ShowFavouriteClass extends AppCompatActivity {
    private ListView fvtlistView;
    private ArrayList<TableData> FavouriteTripArrayList;
    private FavouriteAdapter favouriteAdapter;
    private DatabaseOperation databaseOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite_listview);

        fvtlistView = (ListView) findViewById(R.id.fvtlistview);

        databaseOperation = new DatabaseOperation(this);

        FavouriteTripArrayList = databaseOperation.getAllUsers();


       favouriteAdapter = new FavouriteAdapter(this,FavouriteTripArrayList);
        fvtlistView.setAdapter(favouriteAdapter);

        fvtlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(ShowFavouriteClass.this,DetailFvtClass.class);
                intent.putExtra("data",FavouriteTripArrayList.get(position));
                startActivity(intent);
            }
        });
    }


}
