package com.example.groupassignment.dublinbike;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class AboutClass extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        JSONArray jsonArray = getJSonData("Dublin.json");
        final ArrayList<JSONObject> listItems = getArrayListFromJSONArray(jsonArray);
        ListView listV = (ListView) findViewById(R.id.listview);
        ListAdapter adapter = new ListAdapter(this, R.layout.list_layout, R.id.txtnumber, listItems);
        listV.setAdapter(adapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AboutClass.this,MapsActivity.class);
                Bundle extras = new Bundle();
                try {
                    extras.putString("longitude",listItems.get(position).getString("longitude"));
                    extras.putString("latitude",listItems.get(position).getString("latitude"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    private JSONArray getJSonData (String fileName) {

        JSONArray jsonArray = null;
        try {

            InputStream is = getResources().getAssets().open(fileName);
            int size = is.available();
            byte[] data = new byte[size];
            is.read(data);
            is.close();
            String json = new String(data, "UTF-8");
            jsonArray = new JSONArray(json);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException je) {
            je.printStackTrace();

        }

        return jsonArray;

    }

    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){

        ArrayList<JSONObject> aList=new ArrayList<JSONObject>();

        try {

            if (jsonArray != null) {

                for (int i = 0; i < jsonArray.length(); i++) {

                    aList.add(jsonArray.getJSONObject(i));

                }

            }

        }catch (JSONException je){je.printStackTrace();}

        return  aList;

    }

}