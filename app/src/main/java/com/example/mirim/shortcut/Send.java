package com.example.mirim.shortcut;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Send extends AppCompatActivity{
    /*private ArrayList<HashMap<String,String>> Data = new ArrayList<HashMap<String, String>>();
    private HashMap<String,String> InputData1 = new HashMap<>();
    private HashMap<String,String> InputData2 = new HashMap<>();
    private ListView listView;*/
    SQLiteDatabase DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("key");
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.list_view);
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


        String sql = "select * from data where pgname='"+name+"';";
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



        /*
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;

                Drawable changeIcon = R.drawable.full_heart;

                item.setIcon();

                // TODO : use item data.
            }
        }) ;

        */



        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        /*
        listView =(ListView)findViewById(R.id.list_view);

        InputData1.put("school","서울대");
        InputData1.put("name","유혁");
        Data.add(InputData1);

        InputData2.put("school","연세대");
        InputData2.put("name","유재석");
        Data.add(InputData2);

        //simpleAdapter 생성
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,Data,android.R.layout.simple_list_item_2,
                new String[]{"school","name"},new int[]{android.R.id.text1,android.R.id.text2});
        listView.setAdapter(simpleAdapter);
*/


        //받아온 값을 통해 쿼리를 돌리고 리사이클러 뷰로 다시 출력한다. 모든 뷰를 한 xml에서 처리한다. 효율적이게.


    }
}
