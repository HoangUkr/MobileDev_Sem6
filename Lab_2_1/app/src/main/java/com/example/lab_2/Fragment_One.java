package com.example.lab_2;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Fragment_One extends Fragment {

    EditText editText;
    RadioButton radioButton;
    RadioButton radioButton1;
    Button button;
    Button button4;
    OneFragmentListener activityCallback;


    public interface OneFragmentListener{
         void onButtonClick(String text);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
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
        View view = inflater.inflate(R.layout.fragment_fragment__one, container, false);
        button = (Button) view.findViewById(R.id.button2);
        button4 = (Button) view.findViewById(R.id.button4);
        editText = (EditText) view.findViewById(R.id.editText);
        radioButton = (RadioButton) view.findViewById(R.id.radioButton);
        radioButton1 = (RadioButton) view.findViewById(R.id.radioButton2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               buttonClicked(v);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
    public void buttonClicked(View view)
    {

        String str;
        if (radioButton.isChecked()) {
            str = editText.getText().toString() + System.getProperty("line.separator") + radioButton.getText().toString();
            activityCallback.onButtonClick(str);

        } else {
            str = editText.getText().toString() + System.getProperty("line.separator") + radioButton1.getText().toString();
            activityCallback.onButtonClick(str);
        }
    }
    public void ShowClicked()
    {

    }
}
