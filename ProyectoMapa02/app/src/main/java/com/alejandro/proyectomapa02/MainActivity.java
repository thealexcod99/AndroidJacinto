package com.alejandro.proyectomapa02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;
    private Button button;
    private Boolean cambio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox Access token
        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull final MapboxMap mapboxMap) {
                mapboxMap.addMarker(new MarkerOptions().setPosition(
                        new LatLng(37.777353, -3.784390)
                ).title("Casa").snippet("Casa"));
                mapboxMap.addMarker(new MarkerOptions().setPosition(
                        new LatLng(37.776608, -3.788724)
                ).title("Instituto").snippet("Instituto"));

                mapboxMap.setStyle(Style.SATELLITE_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        // Map is set up and the style has loaded. Now you can add data or make other map adjustments


                    }
                });

                final CameraPosition miPositionCasa = new CameraPosition.Builder().target(new LatLng(37.777353, -3.784390)).zoom(17).tilt(30).build();
                final CameraPosition miPositionInsti = new CameraPosition.Builder().target(new LatLng(37.776608, -3.788724)).zoom(17).tilt(30).build();

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cambio) {
                            mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(miPositionCasa));
                            cambio = !cambio;
                        } else {
                            mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(miPositionInsti));
                            cambio = !cambio;
                        }
                    }
                });

            }
        });



    }
}