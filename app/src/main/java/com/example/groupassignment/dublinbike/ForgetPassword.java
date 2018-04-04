package com.example.groupassignment.dublinbike;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class ForgetPassword extends AppCompatActivity{
    EditText forget_username;
    TextView forget_password;
    Button searchPassword;
    Context ctx;
    ArrayList<String> usernames, passwords;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forget_username = (EditText) findViewById(R.id.forget_username);
        forget_password = (TextView) findViewById(R.id.forget_password);

        searchPassword = (Button) findViewById(R.id.searchPassword);

        searchPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                forget();
            }
        });


        ctx = this;
        usernames = new ArrayList<String>();
        passwords = new ArrayList<String>();
    }

    public void forget () {
        String name, pass;
        name = forget_username.getText().toString();
        forget_username.getText().clear();
        Boolean loggedin = false;

        if (name.isEmpty()) {
            Toast.makeText(this, "Invalid Data to Proceed!", Toast.LENGTH_SHORT).show();
        } else {
            try {
                DatabaseOperation dop = new DatabaseOperation(ctx);
                Cursor cr = dop.getRecord(dop);
                cr.moveToFirst();
                do {
                    usernames.add(cr.getString(0));
                    passwords.add(cr.getString(1));
                } while (cr.moveToNext());

                for (int i = 0; i < usernames.size(); i++) {
                    if (usernames.get(i).equalsIgnoreCase(name)) {
                        forget_password.setText(passwords.get(i));
                        loggedin = true;
                        break;
                    }
                }

                if (loggedin) {
                    Toast.makeText(ctx, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
