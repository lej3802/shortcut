package com.example.mirim.shortcut;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Develop  extends Fragment implements View.OnClickListener{
    Button DvEc, DvEd, DvVs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.develop, container, false);

        DvEc = rootView.findViewById(R.id.DvEc);
        DvEd = rootView.findViewById(R.id.DvEd);
        DvVs = rootView.findViewById(R.id.DvVs);

        DvEc.setOnClickListener(this);    //2131230722
        DvEd.setOnClickListener(this);    //2131230725
        DvVs.setOnClickListener(this);    //2131230726

        return rootView;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),Send.class);
        intent.putExtra("key", String.valueOf(view.getId()));
        Toast.makeText(getActivity(), String.valueOf(view.getId()), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
