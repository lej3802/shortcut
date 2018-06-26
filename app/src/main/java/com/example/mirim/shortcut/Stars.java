package com.example.mirim.shortcut;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Stars extends AppCompatActivity {
    SQLiteDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stars);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.star_list);
        listview.setAdapter(adapter);


/*
        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.round_favorite_black_18dp),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.round_favorite_black_18dp),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.round_favorite_black_18dp),
                "Ind", "Assignment Ind Black 36dp") ;
*/
        DB = openOrCreateDatabase("data", Context.MODE_PRIVATE, null);


        String sql = "select * from data where star=1;";
        //id pgname shortkey dowhat star
        List<String> shortkey = new ArrayList<String>();
        List<String> dowhat = new ArrayList<String>();
        List<Integer> stars = new ArrayList<Integer>();

        Cursor result = DB.rawQuery(sql,null);

        result.moveToFirst();

        while(result.moveToNext()){
            shortkey.add(result.getString(result.getColumnIndex("shortkey")));
            dowhat.add(result.getString(result.getColumnIndex("dowhat")));
            stars.add(result.getInt(result.getColumnIndex("star")));
            if(result.isLast()) break;
        }

        result.close();

        int max = shortkey.size();

        for(int i=0;i<max;i++) {
            if(stars.get(i)==0) {
                adapter.addItem(ContextCompat.getDrawable(this, R.drawable.bin_heart),
                        shortkey.get(i), dowhat.get(i));
            }
            else{
                adapter.addItem(ContextCompat.getDrawable(this, R.drawable.full_heart),
                        shortkey.get(i), dowhat.get(i));
            }
        }

    }
}
