package com.example.groupassignment.dublinbike;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class FavouriteTrip extends AppCompatActivity{



    //firebase objects
    private StorageReference storageReference;
    private DatabaseReference mDatabase;

    private String userChoosenTask;
    private Button buttonAddTrip;
    private Bitmap bp;
    private byte[] photo;
    private ImageView imageView;
    Context context;
    EditText editTextTripName, editTextStartName, editTextEndName, editTextComment,editTextTripDate;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        context = this;

        editTextTripName = findViewById(R.id.editTextTripName);
        editTextStartName = findViewById(R.id.editTextStartName);
        editTextEndName = findViewById(R.id.editTextEndName);
        editTextComment = findViewById(R.id.editTextComment);
        editTextTripDate = findViewById(R.id.editTextTripDate);


        buttonAddTrip = (Button) findViewById(R.id.buttonAddTrip);
        buttonAddTrip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v) {
                addTrip();
            }
        });

    }


    private void addTrip () {
        String TripName = editTextTripName.getText().toString().trim();
        editTextTripName.getText().clear();
        String StartName = editTextStartName.getText().toString().trim();
        editTextStartName.getText().clear();
        String EndName = editTextEndName.getText().toString().trim();
        editTextEndName.getText().clear();
        String Comment = editTextComment.getText().toString().trim();
        editTextComment.getText().clear();
        String TripDate = editTextTripDate.getText().toString().trim();
        editTextTripDate.getText().clear();

        //validating the inptus
        if(TripName.isEmpty() || StartName.isEmpty() || EndName.isEmpty() || Comment.isEmpty() || TripDate.isEmpty()){
            Toast.makeText(this, "Invalid Data to Proceed!", Toast.LENGTH_SHORT).show();
        }else {
            DatabaseOperation databaseOperation = new DatabaseOperation(context);
            databaseOperation.insert(databaseOperation,TripName, StartName, EndName, Comment, TripDate);
            Toast.makeText(this, "Record Added Successfully", Toast.LENGTH_SHORT).show();
        }

    }

}
