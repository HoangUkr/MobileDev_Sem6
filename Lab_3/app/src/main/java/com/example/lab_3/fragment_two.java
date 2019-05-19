package com.example.lab_3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment_two extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        return view;
    }
    public TextView getEditText() {
        return getView().findViewById(R.id.textview);
    }

    public void changeTextProperties(String item)
    {
        if(item.isEmpty()) return;
        else{
            getEditText().setText(item);
        }
    }
}
