package com.aalvarez.proyectomenu01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static TextView etiqueta;
    private static TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etiqueta = (TextView) findViewById(R.id.mensaje);
        respuesta = (TextView) findViewById(R.id.respuesta);
        registerForContextMenu(etiqueta);
    }

    private static final int menu_opcion1=1;
    private static final int menu_opcion1A=11;
    private static final int menu_opcion1B=12;
    private static final int menu_opcion2=2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        /*SubMenu smenu1 = menu.addSubMenu(Menu.NONE, menu_opcion1, Menu.NONE, "Opcion 1 desde Java")
                .setIcon(android.R.drawable.ic_menu_preferences);
            smenu1.add(Menu.NONE, menu_opcion1A, Menu.NONE, "Opcion 1A desde Java")
                    .setIcon(android.R.drawable.ic_menu_preferences);
            smenu1.add(Menu.NONE, menu_opcion1B, Menu.NONE, "Opcion 1B desde Java")
                    .setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, menu_opcion2, Menu.NONE, "Opcion 2 desde Java")
                .setIcon(android.R.drawable.ic_menu_preferences);*/


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensaje="";
        switch (item.getItemId()) {
            case R.id.identificador1:
                mensaje="Opcion 1 pulsada";
                Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
                return true;



            case R.id.identificador3:
                mensaje="Opcion 3 pulsada";
                Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
                return true;

            case R.id.identificador4:
                String url = "http://www.iesvirgendelcarmen.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.identificador3:
                respuesta.setText(respuesta.getText()+" Tocado opcion 2");
                return true;

            default:
                return super.onContextItemSelected(item);
        }


    }
}
