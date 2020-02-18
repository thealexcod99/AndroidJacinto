package com.alejandro.proyectogeopo01;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private LocationManager MiGestorLocalizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);
        MiGestorLocalizacion = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> misProveedores = MiGestorLocalizacion.getAllProviders();



        for (String proveedor : misProveedores) {

            LocationProvider info = MiGestorLocalizacion.getProvider(proveedor);
            texto.append("Nombre: " + info.getName() + "\n");
            texto.append("Satelite: " + info.requiresSatellite() + "\n");
            texto.append("Cell: " + info.requiresCell() + "\n");
            texto.append("Network: " + info.requiresNetwork() + "\n");
            texto.append("Pago: " + info.hasMonetaryCost() + "\n");
            texto.append("Altitude: " + info.supportsAltitude() + "\n");
            texto.append("Dirección: " + info.supportsBearing() + "\n");
            texto.append("Velocidad: " + info.supportsSpeed() + "\n" + "\n");
        }

    }
}
