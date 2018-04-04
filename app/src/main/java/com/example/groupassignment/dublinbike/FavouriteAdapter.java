package com.example.groupassignment.dublinbike;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class FavouriteAdapter extends BaseAdapter{
    private DatabaseOperation databaseOperation;
    private TableData tableData;


    private Context context;
    private ArrayList<TableData> FavouriteTripArrayList;

    public FavouriteAdapter (Context context, ArrayList<TableData> FavouriteArrayList) {

        this.context = context;
        this.FavouriteTripArrayList = FavouriteArrayList;
    }

    @Override
    public int getCount () {
        return FavouriteTripArrayList.size();
    }

    @Override
    public Object getItem (int position) {
        return FavouriteTripArrayList.get(position);
    }

    @Override
    public long getItemId (int position) {
        return 0;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.favouritetrip_layout, null, true);

            holder.textViewTripName = (TextView) convertView.findViewById(R.id.textViewTripName);
            holder.textViewStartName = (TextView) convertView.findViewById(R.id.textViewStartName);
            holder.textViewEndName = (TextView) convertView.findViewById(R.id.textViewEndName);
            holder.textViewComment = (TextView) convertView.findViewById(R.id.textViewComment);
            holder.textViewTripDate = (TextView) convertView.findViewById(R.id.textViewTripDate);

            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textViewTripName.setText("TRIPNAME: " + FavouriteTripArrayList.get(position).getTripName());
        holder.textViewStartName.setText("STARTNAME: " + FavouriteTripArrayList.get(position).getStartName());
        holder.textViewEndName.setText("ENDNAME: " + FavouriteTripArrayList.get(position).getEndName());
        holder.textViewComment.setText("COMMENT: " + FavouriteTripArrayList.get(position).getComment());
        holder.textViewTripDate.setText("TRIPDATE: " + FavouriteTripArrayList.get(position).getTripDate());
      //  holder.imageViewImage.setImageBitmap(convertToBitmap(FavouriteTripArrayList.get(position).getImage()));

        return convertView;
    }


    private class ViewHolder {

        protected TextView textViewTripName, textViewStartName, textViewEndName, textViewComment, textViewTripDate, imageViewImage;
    }

    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }

}
