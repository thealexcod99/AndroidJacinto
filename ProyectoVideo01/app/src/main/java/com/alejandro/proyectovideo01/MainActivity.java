package com.alejandro.proyectovideo01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        //videoView.setVideoPath("/storage/emulated/0/download/Video.mp4");
        videoView.setVideoURI(Uri.parse("https://youtu.be/fP9r5u0BZww"));
        mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        videoView.requestFocus();

    }
}
