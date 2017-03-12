package com.example.www.xceptions;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private CameraPosition cameraPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng kcg = new LatLng(12.922354,80.241095);
        mMap.addMarker(new MarkerOptions().position(kcg).title("Marker in kcg"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kcg));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(12.922354,80.241095)).zoom(16).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Location.this,MainActivity.class);
        startActivity(intent);
        finish();
    }


}
