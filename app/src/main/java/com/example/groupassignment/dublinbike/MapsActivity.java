package com.example.groupassignment.dublinbike;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        LatLng smithfield = new LatLng(53.337307, -6.260554);
        LatLng parnellSquare = new LatLng(53.353462,-6.265305);
        LatLng jamesHospital = new LatLng(53.339983,-6.295594);
        LatLng clonmelStreet = new LatLng(53.336021,-6.26298);
        LatLng portbello = new LatLng(53.330091,-6.268044);
        LatLng fownes = new LatLng(53.344603,-6.263371);
        LatLng fenian = new LatLng(53.341428,-6.2467);
        mMap.addMarker(new MarkerOptions().position(smithfield).title("Marker in smithfield"));
        mMap.addMarker(new MarkerOptions().position(parnellSquare).title("Marker in parnellSquare"));
        mMap.addMarker(new MarkerOptions().position(jamesHospital).title("Marker in jamesHospital"));
        mMap.addMarker(new MarkerOptions().position(clonmelStreet).title("Marker in clonmelStreet"));
        mMap.addMarker(new MarkerOptions().position(portbello).title("Marker in portbello"));
        mMap.addMarker(new MarkerOptions().position(fownes).title("Marker in fownes"));
        mMap.addMarker(new MarkerOptions().position(fenian).title("Marker in fenian"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(smithfield, 13));
    }

}