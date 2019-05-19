package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment_One.OneFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onButtonClick(String text){
        Fragment_Two textFragment = (Fragment_Two) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        textFragment.changeTextProperties(text);
    }

}
