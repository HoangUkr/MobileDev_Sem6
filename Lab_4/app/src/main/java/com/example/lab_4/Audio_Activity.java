package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

public class Audio_Activity extends AppCompatActivity {
    private TextView textView;
    private Button btn_play;
    private Button home;
    private Button btn_pause;
    private Button btn_stop;
    private SeekBar seekBar;
    private  Button forward;
    private Button afterward;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioGroup rgd;
    private MediaPlayer mediaPlayer;
    private Handler threadHandler = new Handler();
    private Uri link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_);
        Intent intent = getIntent();
        btn_play = (Button)findViewById(R.id.play);
        home = (Button)findViewById(R.id.home);
        btn_pause = (Button)findViewById(R.id.pause);
        btn_stop = (Button)findViewById(R.id.stop);
        textView = (TextView)findViewById(R.id.current);
        forward = (Button)findViewById(R.id.forward);
        afterward = (Button)findViewById(R.id.afterward);
        radio1 = (RadioButton)findViewById(R.id.bru);
        radio2 = (RadioButton)findViewById(R.id.mar);
        radio3 = (RadioButton)findViewById(R.id.aria);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        mediaPlayer = new MediaPlayer();
        this.seekBar.setClickable(true);
        rgd = (RadioGroup)findViewById(R.id.radioGroup2);
        btn_play.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Pause(view);
                if(radio1.isChecked())
                {
                    link = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.brun);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), link);
                }
                else if(radio2.isChecked())
                {
                    link = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.maroon);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), link);
                }
                else{
                    link = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.arian);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), link);
                }
                Play(view);
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pause(v);
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Stop(v);
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forward(v);
            }
        });
        afterward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                afterward(v);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home(v);
            }
        });
    }
    private String milisecondtoString(int milisecond)
    {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long)milisecond);
        long seconds = TimeUnit.MILLISECONDS.toSeconds((long)milisecond);

        return minutes + ":" + seconds;
    }
    public void Home(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Play(View view){
        int duration = this.mediaPlayer.getDuration();
        int current = this.mediaPlayer.getCurrentPosition();
        if(current == 0){
            this.seekBar.setMax(duration);
        }
        else if(current == duration)
        {
            this.mediaPlayer.reset();
        }
        this.mediaPlayer.start();
        UpdateSeekBarThread updateSeekBarThread = new UpdateSeekBarThread();
        threadHandler.postDelayed(updateSeekBarThread, 50);
    }
    public void Pause(View view){
        this.mediaPlayer.pause();
    }
    public void Stop(View view) {
        this.mediaPlayer.stop();
        this.mediaPlayer.reset();
    }
    public void forward(View view){
        int current = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        int subtract = 5000;
        if (current - subtract > 0){
            this.mediaPlayer.seekTo(current - subtract);
        }
    }
    public void afterward(View view){
        int current = this.mediaPlayer.getCurrentPosition();
        int duration = this.mediaPlayer.getDuration();
        int add = 5000;
        if(current + add <duration){
            this.mediaPlayer.seekTo(current + add);
        }
    }
    class UpdateSeekBarThread implements Runnable{
        public void run(){
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = milisecondtoString(currentPosition);
            textView.setText(currentPositionStr);
            seekBar.setProgress(currentPosition);
            threadHandler.postDelayed(this, 50);
        }
    }
}
