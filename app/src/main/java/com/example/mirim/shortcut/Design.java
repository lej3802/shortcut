package com.example.mirim.shortcut;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Design extends Fragment {
    Button ai,ph;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.design, container, false);

        return rootView;
    }

    public void onSent() {
        Intent intent;
        intent = new Intent(getActivity(),Send.class);
        //intent.putExtra("text", String.valueOf(editText.getText()));
        startActivity(intent);
    }
}


