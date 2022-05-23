package com.example.appmovies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;


public class VideoPlayerActivity extends AppCompatActivity {

    private PlayerView videoPlayer;
    private SimpleExoPlayer simpleExoPlayer;
    private static final String FILE_URL="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoPlayer = findViewById(R.id.exo_player);

    }

    private void setUpExoPlayer(String url){

        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this);
    }
}