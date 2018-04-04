package com.example.groupassignment.dublinbike;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class ListAdapter extends ArrayAdapter <JSONObject> {
    String longitude;
    String latitude;

    int vg;
    ArrayList<JSONObject> list;

    Context context;

    public ListAdapter (@NonNull Context context, int vg, int number, ArrayList<JSONObject> list ) {
        super(context, vg, number, list);
        this.context= context;
        this.vg = vg;
        this.list = list;
    }


    public View getView(int position , View convertView , ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);


        View  itemView  = inflater.inflate(vg,parent,false);
        TextView textName = (TextView)itemView.findViewById(R.id.txtname);
        TextView textNumber = (TextView)itemView.findViewById(R.id.txtnumber);
        TextView textAddress = (TextView)itemView.findViewById(R.id.txtaddress);
        TextView textLong = (TextView)itemView.findViewById(R.id.txtlong);
        TextView textLat = (TextView)itemView.findViewById(R.id.txtlat);

        try {

            textName.setText(list.get(position).getString("name"));
            textNumber.setText(list.get(position).getString("number"));
            textLat.setText(list.get(position).getString("latitude"));
            textLong.setText(list.get(position).getString("longitude"));
            textAddress.setText(list.get(position).getString("address"));
            longitude = textLong.getText().toString();
            latitude = textLat.getText().toString();



        }catch (JSONException e) {

            e.printStackTrace();

        }

        return itemView;
    }


}
