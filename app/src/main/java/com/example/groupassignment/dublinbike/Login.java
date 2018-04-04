package com.example.groupassignment.dublinbike;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.groupassignment.dublinbike.R.id.forgetPassword;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Context ctx;
    ArrayList<String> usernames, passwords;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);

        findViewById(forgetPassword).setOnClickListener(this);


        ctx = this;
        usernames = new ArrayList<String>();
        passwords = new ArrayList<String>();


    }

    public void login (View view) {
        String name, pass;
        name = username.getText().toString();
        pass = password.getText().toString();
        Boolean loggedin = false;

        if (name.isEmpty() || pass.isEmpty()) {
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
                    if (usernames.get(i).equalsIgnoreCase(name) && passwords.get(i).equalsIgnoreCase(pass)) {
                        loggedin = true;
                        break;
                    }
                }

                if (loggedin) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    Toast.makeText(ctx, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick (View view) {
        switch (view.getId()) {

            case R.id.forgetPassword:
                startActivity(new Intent(this, ForgetPassword.class));

                break;
        }
    }
}