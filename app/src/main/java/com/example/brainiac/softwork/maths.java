package com.example.brainiac.softwork;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class maths extends AppCompatActivity {
    Button btn_play;
    VideoView vView;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        //btn_play = (Button) findViewById(R.id.play_btn);
        vView = (VideoView) findViewById(R.id.video_view);
        MediaController videoController = new MediaController(this);
        videoController.setMediaPlayer(vView);
        final Button mainPlay = (Button) findViewById(R.id.playMain);
        vView.setMediaController(videoController);
        //btn_play.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        vView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(maths.this, "The video has completed", Toast.LENGTH_SHORT).show();
                vView.stopPlayback();
                mainPlay.setVisibility(View.VISIBLE);
            }
        });
       /* btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isPlaying == false) {
                    String videoPath = "android.resource://com.example.brainiac.softwork/"+R.raw.playvid;
                    Uri uri = Uri.parse(videoPath);
                    vView.setVideoURI(uri);
                    vView.start();
                    isPlaying = true;
                } else {
                    vView.pause();
                }
            }
        });*/
        mainPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoPath = "android.resource://com.example.brainiac.softwork/"+R.raw.playvid;
                Uri uri = Uri.parse(videoPath);
                vView.setVideoURI(uri);
                vView.start();
                mainPlay.setVisibility(View.INVISIBLE);
                mainPlay.setVisibility(View.GONE);
            }
        });
    }
}
