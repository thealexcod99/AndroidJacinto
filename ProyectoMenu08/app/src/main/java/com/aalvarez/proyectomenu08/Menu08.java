package com.aalvarez.proyectomenu08;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Menu08 extends AppCompatActivity {

    private static final int MnuOpc1 = 1;
    private static final int MnuOpc2 = 2;
    private static final int MnuOpc3 = 3;
    private static final int MnuOpc4 = 4;

    private static final int SubMen1 = 31;
    private static final int SubMen2 = 32;

    private static final int GRUPO_MENU_1 = 101;

    private int opcionSeleccionada = 0;

    private CheckBox MCompleto;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu08);
        mensaje = (TextView)findViewById(R.id.Mensaje);
        MCompleto = (CheckBox)findViewById(R.id.MCompleto);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        construirMenu(menu, false);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        if(MCompleto.isChecked())
            construirMenu(menu, true);
        else
            construirMenu(menu, false);
        return super.onPrepareOptionsMenu(menu);
    }

    private void construirMenu(Menu menu, boolean extendido)
    {
        menu.add(Menu.NONE, MnuOpc1, Menu.NONE, "OPCIÓN DE MENÚ 1")
                .setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, MnuOpc2, Menu.NONE, "OPCIÓN DE MENÚ 2")
                .setIcon(android.R.drawable.ic_menu_compass);
        SubMenu smnu = menu.addSubMenu(Menu.NONE, MnuOpc3, Menu.NONE, "OPCIÓN DE MENÚ 3")
                .setIcon(android.R.drawable.ic_menu_agenda);
        smnu.add(GRUPO_MENU_1, SubMen1, Menu.NONE, "SUBOPCIÓN 3-1");
        smnu.add(GRUPO_MENU_1, SubMen2, Menu.NONE, "SUBOPCIÓN 3-2");
        smnu.setGroupCheckable(GRUPO_MENU_1, true, true);
        if(extendido)
            menu.add(Menu.NONE, MnuOpc4, Menu.NONE, "OPCIÓN DE MENÚ 4")
                    .setIcon(android.R.drawable.ic_menu_camera);
        if(opcionSeleccionada == 1)
            smnu.getItem(0).setChecked(true);
        else if(opcionSeleccionada == 2)
            smnu.getItem(1).setChecked(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MnuOpc1:
                mensaje.setText("OPCIÓN A PULSADA");
                return true;
            case MnuOpc2:
                mensaje.setText("OPCIÓN B PULSADA");
                return true;
            case MnuOpc3:
                mensaje.setText("OPCIÓN C PULSADA");
                return true;
            case SubMen1:
                mensaje.setText("OPCIÓN C-1 PULSADA");
                opcionSeleccionada = 1;
                item.setChecked(true);
                return true;
            case SubMen2:
                mensaje.setText("OPCIÓN C-2 PULSADA");
                opcionSeleccionada = 2;
                item.setChecked(true);
                return true;
            case MnuOpc4:
                mensaje.setText("OPCIÓN D PULSADA");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


