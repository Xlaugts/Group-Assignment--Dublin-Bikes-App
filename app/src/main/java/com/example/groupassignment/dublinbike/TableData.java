package com.example.groupassignment.dublinbike;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Group Assignment
 * Hassan, Manmeet, Rajan, Henrique, Limoore
 */

public class TableData implements Serializable{
    int trip_id;
    String tripName,startName,endName,comment,tripDate;
    TableData(){
    }
    public static abstract class users implements BaseColumns {
        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String EMAIL = "EMAIL";
        public static final String DATABASE_NAME = "DublinBikes.db";
        public static final String TABLE_NAME = "users";
        public static final String TABLE_NAME_DATA = "data";
        public static final String TRIPNAME = "TRIPNAME";
        public static final String STARTNAME = "STARTNAME";
        public static final String ENDNAME = "ENDNAME";
        public static final String COMMENT = "COMMENT";
        public static final String TRIPDATE = "TRIPDATE";
    }

    public String getTripDate () {
        return tripDate;
    }

    public void setTripDate (String tripDate) {
        this.tripDate = tripDate;
    }

    public int getTrip_id () {
        return trip_id;
    }

    public void setTrip_id (int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTripName () {
        return tripName;
    }

    public void setTripName (String tripName) {
        this.tripName = tripName;
    }

    public String getStartName () {
        return startName;
    }

    public void setStartName (String startName) {
        this.startName = startName;
    }

    public String getEndName () {
        return endName;
    }

    public void setEndName (String endName) {
        this.endName = endName;
    }

    public String getComment () {
        return comment;
    }

    public void setComment (String comment) {
        this.comment = comment;
    }

    public TableData (int trip_id, String tripName, String startName, String endName, String comment, String tripDate) {
        this.trip_id = trip_id;
        this.tripName = tripName;
        this.startName = startName;
        this.endName = endName;
        this.comment = comment;
        this.tripDate = tripDate;
    }

}
