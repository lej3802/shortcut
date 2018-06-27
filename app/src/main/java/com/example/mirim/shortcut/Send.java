package com.example.mirim.shortcut;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

    List<String> shortkey = new ArrayList<String>();
    List<String> dowhat = new ArrayList<String>();
    List<Integer> stars = new ArrayList<Integer>();
    List<String> pgname = new ArrayList<String>();


    private boolean check = false;

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

        ImageView star_img = (ImageView)findViewById(R.id.imageView1);


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


        Cursor result = DB.rawQuery(sql,null);

        while(result.moveToNext()) {

            pgname.add(result.getString(result.getColumnIndex("pgname")));

            shortkey.add(result.getString(result.getColumnIndex("shortkey")));
            dowhat.add(result.getString(result.getColumnIndex("dowhat")));
            stars.add(result.getInt(result.getColumnIndex("star")));
            if (result.isLast()) break;
        }


        result.close();

        int max = shortkey.size();

        for(int i=0;i<max;i++) {
            if(stars.get(i)==0) {
                if(pgname.get(i).equals("DeAi") == true) {
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.illustrator),
                            shortkey.get(i), dowhat.get(i));
                }
                else if(pgname.get(i).equals("DePh") == true){
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.photoshop),
                            shortkey.get(i), dowhat.get(i));
                }
                else if(pgname.get(i).equals("DvEc") == true){
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.eclipse),
                            shortkey.get(i), dowhat.get(i));
                }
                else if(pgname.get(i).equals("DvVs") == true){
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.visualstudio),
                            shortkey.get(i), dowhat.get(i));
                }

                else if(pgname.get(i).equals("DvEd") == true){
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.editplus),
                            shortkey.get(i), dowhat.get(i));
                }
                else if(pgname.get(i).equals("WoHn") == true){
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hangul),
                            shortkey.get(i), dowhat.get(i));
                }
                else if(pgname.get(i).equals("WoEx") == true){
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.excel),
                            shortkey.get(i), dowhat.get(i));
                }
                else /*if(pgname.equals("WoPt") == true)*/{
                    adapter.addItem(ContextCompat.getDrawable(this, R.drawable.powerpoint),
                            shortkey.get(i), dowhat.get(i));
                }
            }
        }




        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
               /* // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);
                ImageView star_img = (ImageView)findViewById(R.id.imageView1);

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;

                //boolean check = false;

                if(star_img.equals(android.R.drawable.btn_star_big_off) != true){

                    star_img.setBackgroundResource(android.R.drawable.btn_star_big_on);


                }else{
                    star_img.setBackgroundResource(android.R.drawable.btn_star_big_off);
                }*/
            }
        }) ;



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
