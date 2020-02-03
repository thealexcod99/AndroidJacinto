package com.alejandro.proyectoservicios03;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

public class MiIntentService extends IntentService {

    public static final String ACTION_PROGRESO =
            "net.sgoliver.intent.action.PROGRESO";
    public static final String ACTION_FIN =
            "net.sgoliver.intent.action.FIN";

    public MiIntentService() {
        super("MiIntentService");
    }

    @Override
    protected void onHandleIntent( Intent intent) {

        SystemClock.sleep(5000);
        int contador = intent.getIntExtra("Contador", 0);
        Toast.makeText(getApplicationContext(), "Contador: " + contador, Toast.LENGTH_LONG).show();
    }

    private void tareaLarga()
    {

    }
}