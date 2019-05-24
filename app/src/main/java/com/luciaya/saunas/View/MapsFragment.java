package com.luciaya.saunas.View;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {
    private GoogleApiClient client;
    private Location cureentLocation;
    private Location location;
    private GoogleMap map;
    private SupportMapFragment mFragment;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng voronezh = new LatLng(51.6720400, 39.1843000);
        LatLng lipetsk = new LatLng(52.610220, 39.594719);

        googleMap.addMarker(new MarkerOptions().position(voronezh).title("Вронеж").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        googleMap.addMarker(new MarkerOptions().position(lipetsk).title("Липецк").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(voronezh, 12));
    }
}
