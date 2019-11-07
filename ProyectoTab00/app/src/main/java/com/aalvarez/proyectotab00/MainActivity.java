package com.aalvarez.proyectotab00;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityGroup;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);

        tabs.setup(getLocalActivityManager());

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");

        Intent specIntent1 = new Intent(this, Tab1.class);
        spec.setIndicator("TAB1", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        spec.setContent(specIntent1);
        tabs.addTab(spec);

        Intent specIntent2 = new Intent(this, Tab2.class);
        spec = tabs.newTabSpec("mitab2");
        spec.setIndicator("TAB2", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        spec.setContent(specIntent2);
        tabs.addTab(spec);
/*
        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("TAB3", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("TAB4", res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);*/
    }
}
