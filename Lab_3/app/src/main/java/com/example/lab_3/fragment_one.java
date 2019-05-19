package com.example.lab_3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class fragment_one extends Fragment {
    EditText editText;
    RadioGroup rdgp;
    private final static String FILE_NAME = "content.txt";
    Context context;
    OneFragmentListener activityCallback;

    private String message = "";
    private int choice=-1;
    private boolean isChecked=false;

    public static String getFILE() {
        return FILE_NAME;
    }

    public interface OneFragmentListener{
        void onButtonClick(String text);
        void onOpenFileButtonInteraction();

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.context = context;
            activityCallback = (OneFragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        Button okeyButton = (Button) view.findViewById(R.id.okeyButton);
        Button showButton = (Button) view.findViewById(R.id.showButton);
        Button openButton = view.findViewById(R.id.openButton);
        editText = (EditText) view.findViewById(R.id.editText);
        rdgp = view.findViewById(R.id.radioGroup);
        rdgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                choice = i;
                isChecked=true;
            }
        });
        okeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked();
            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activityCallback.onButtonClick(message);
            }
        });
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFile();
            }
        });

        return view;
    }
    private void buttonClicked() {
        if(isChecked){
            RadioButton radioButton = getView().findViewById(choice);
            setMessage(radioButton);
            saveToFile();
        }
    }
    public void setMessage(RadioButton rdb){
        message = editText.getText().toString() + System.getProperty("line.separator") + rdb.getText().toString();
    }
    public void saveToFile(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_APPEND);
            fileOutputStream.write((message+"\n").getBytes());
            Toast.makeText(context, "File is saved", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fileOutputStream!=null)
                    fileOutputStream.close();
            }
            catch(IOException ex){

                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void openFile() {
        activityCallback.onOpenFileButtonInteraction();
    }
}
