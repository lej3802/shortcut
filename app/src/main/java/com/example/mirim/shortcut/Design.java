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

public class Design extends Fragment implements View.OnClickListener{
    Button ai,ph;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.design, container, false);

        ai = rootView.findViewById(R.id.DeAi);
        ph = rootView.findViewById(R.id.DePh);

        ai.setOnClickListener(this);
        ph.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        intent = new Intent(getActivity(),Send.class);
        intent.putExtra("key", String.valueOf(view.getId()));
        startActivity(intent);
    }
}


