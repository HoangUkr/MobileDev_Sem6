package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;
import android.widget.Button;

public class Video_Activity extends AppCompatActivity {
    VideoView videoPlayer;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    Button home;
    Button button2;
    private int choice = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_);
        Intent intent = getIntent();
        videoPlayer = (VideoView)findViewById(R.id.videoView);
        Button btn_play = (Button)findViewById(R.id.play);
        Button btn_pause = (Button)findViewById(R.id.pause);
        Button btn_stop = (Button)findViewById(R.id.stop);
        radio1 = (RadioButton)findViewById(R.id.brunomars);
        radio2 = (RadioButton)findViewById(R.id.maroon5);
        radio3 = (RadioButton)findViewById(R.id.ariana);
        home = (Button)findViewById(R.id.home);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        button2 = (Button)findViewById(R.id.button2);
        btn_play.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(radio1.isChecked())
                {
                    Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bru);
                    videoPlayer.setVideoURI(myVideoUri);
                }
                else if(radio2.isChecked())
                {
                    Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mar);
                    videoPlayer.setVideoURI(myVideoUri);
                }
                else{
                    Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aria);
                    videoPlayer.setVideoURI(myVideoUri);
                }
                Play(v);
            }
        });
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
        btn_pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Pause(v);
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Stop(v);
            }
        });
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Home(v);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                videoPlayer.setVideoPath("http://video.ch9.ms/ch9/507d/71f4ef0f-3b81-4d2c-956f-c56c81f9507d/AndroidEmulatorWithMacEmulator.mp4");
                Play(v);
            }
        });

    }
    public void Play (View view){
        videoPlayer.start();
    }
    public void Pause(View view){
        videoPlayer.pause();
    }
    public void Stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
    public void Home(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
