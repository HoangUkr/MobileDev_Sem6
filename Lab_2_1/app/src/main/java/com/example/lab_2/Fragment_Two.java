package com.example.lab_2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

public class Fragment_Two extends Fragment {
    private static TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_fragment__two, container, false);
         mTextView = (TextView) view.findViewById(R.id.textview);
         return view;
    }
    public void changeTextProperties(String item)
    {
        mTextView.setText(item);
    }

}
