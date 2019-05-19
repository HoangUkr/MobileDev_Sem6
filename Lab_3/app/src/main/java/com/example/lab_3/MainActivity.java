package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements fragment_one.OneFragmentListener{
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onButtonClick(String text){
        fragment_two textFragment = (fragment_two) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        textFragment.changeTextProperties(text);
    }
    @Override
    public void onOpenFileButtonInteraction(){
        Intent intent = new Intent(this, FileContent.class);
        intent.putExtra(EXTRA_MESSAGE, fragment_one.getFILE());
        startActivity(intent);
    }
}
