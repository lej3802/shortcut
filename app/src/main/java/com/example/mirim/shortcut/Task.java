package com.example.mirim.shortcut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Task extends Fragment implements View.OnClickListener{
    Button WoHn, WoPt, WoEx;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.task, container, false);

        WoHn = rootView.findViewById(R.id.WoHn);
        WoPt = rootView.findViewById(R.id.WoPt);
        WoEx = rootView.findViewById(R.id.WoEx);

        WoHn.setOnClickListener(this); //2131230732
        WoPt.setOnClickListener(this); //2131230733
        WoEx.setOnClickListener(this); //2131230731

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
