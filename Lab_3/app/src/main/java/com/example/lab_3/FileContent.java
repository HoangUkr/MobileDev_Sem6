package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class FileContent extends AppCompatActivity {
    private String FILE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_content);
        Intent intent = getIntent();
        FILE = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        outputMessageFromFile();
    }
    private void outputMessageFromFile() {
        FileInputStream fin = null;
        TextView textView = (TextView) findViewById(R.id.textView2);
        try {
            fin = openFileInput(FILE);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            if (text.isEmpty()) {
                Toast.makeText(this, "File is empty", Toast.LENGTH_SHORT).show();
            }

            textView.setText(text);
        } catch (IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {

            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
