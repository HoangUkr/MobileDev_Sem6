package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Button btn_audio = (Button)findViewById(R.id.audio_button);
        btn_audio.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                OpenActivityAudio(v);
            }
        });
        Button btn_video = (Button)findViewById(R.id.video_button);
        btn_video.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                OpenActivityVideo(v);
            }
        });
    }
    public void OpenActivityAudio(View view)
    {
        Intent intent = new Intent(this, Audio_Activity.class);
        startActivity(intent);
    }
    public void OpenActivityVideo(View view)
    {
        Intent intent = new Intent(this, Video_Activity.class);
        startActivity(intent);
    }

}
