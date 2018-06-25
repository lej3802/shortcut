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

        String key;
        switch(view.getId()){
            case R.id.WoHn: key = "WoHn"; break;
            case R.id.WoEx: key = "WoEx"; break;
            case R.id.WoPt: key = "WoPt"; break;
            default : key="error"; break;
        }

        intent.putExtra("key", key);
        //Toast.makeText(getActivity(), key, Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
