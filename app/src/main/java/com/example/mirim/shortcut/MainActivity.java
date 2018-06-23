package com.example.mirim.shortcut;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase DB;
    String dbresult = "";
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDatabase();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, dbresult, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void setDatabase() {
        //데이터베이스 객체가 data 라는 테이블이 있으면 열고 없으면 생성하라는 뜻
        DB = openOrCreateDatabase("data", Context.MODE_PRIVATE, null);
        dbresult+="db cre, ";

        //테이블 열렸으면 삭제
        /*if(DB.isOpen()){
            String sql = "drop table data";
            DB.execSQL(sql);
            dbresult+="tab drop, ";
        }
        */


        //테이블 생성
        String sql = "create table if not exists " + "data (" +
                    "id integer primary key autoincrement, " +
                    "pgname text," +
                    "shortkey text," +
                    "dowhat text," +
                    "star integer" +
                    ")";

            DB.execSQL(sql);
            dbresult += "tab cre, ";

        dbresult+=insertRecord();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // deleted PlaceholderFragment class from here
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Develop tab1 = new Develop();
                    return tab1;
                case 1:
                    Design tab2 = new Design();
                    return tab2;
                case 2:
                    Task tab3 = new Task();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "개발";
                case 1:
                    return "디자인";
                case 2:
                    return "사무";
            }
            return null;
        }
    }

    private String insertRecord() {
        //illustrator
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+Alt+P', 'document로 설정',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+F', '제자리 위에 붙여넣기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+B', '제자리 뒤에 붙여넣기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+D', '변형 작업 반복',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+7', 'Cliping mask 생성',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+Alt+7', 'Cliping mask 해제',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+;', '안내선 보기/숨기기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'Ctrl+Shift+J', '정렬 초기화',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'F7', 'Simbol 생성',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DeAi', 'F12', '저장 시점으로 되돌리기',0);");

        //Photoshop
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh', 'Ctrl+Alt+Z', '연속 작업 취소',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+Alt+I', '이미지 크기 조절',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+A', '전체 선택',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+G', '레이어 그룹화',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+(+/-)', '화면 확대/축소',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+O', '이미지 열기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+T', '이미지 자유 변형',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+Shift+;', '스냅 선택/해제',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+U', '색조/채도 메뉴',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DePh','Ctrl+Alt+C', '캔버스 사이즈 조절',0);");

        //eclipse
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Ctrl+Shift+/', '블록 주석(/* */)처리',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Ctrl+Alt+↓', '현재 라인 복사, 아래 붙여넣기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Ctrl+K', '(블록 지정)문자열 찾기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'F3', '선언 위치 찾기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Ctrl+M', '창 키우기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Ctrl+Q', '마지막 편집장소로 이동',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Alt+↑/↓', '줄 위치 조정',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Alt+Shift+R', '파일 찾기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Alt+Shift+J', '자동 주석',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEc', 'Ctrl+Space', '자동 완성',0);");

        //visual studio
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+Shift+F2', '지정된 모든 북마크 해제 ',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+F', '문자열 찾기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Alt+드래그', '세로로 블록 설정',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Shift+F12', '선언으로 이동',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+]', '괄호 짝 찾아주기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+Shift+L', '줄 삭제',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+Space', '자동완성',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Alt+F8;', '인덴트 정리',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+K', '주석 처리/해제',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvVs', 'Ctrl+C/U', '선택 주석 처리/해제',0);");


        // 에디트 플러스
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+N', '새문서 작성',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+Shift+N', '새 HTML 페이지 작성',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+O', '파일 열기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+S', '저장하기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+End', '문서의 끝으로 이동',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+Shift+Delete', '현재 줄을 끝까지 지움',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+F', '찾기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+Y', '이전 취소 동작 다시 수행',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('DvEd', 'Ctrl+H', '문자열을 찾아 바꿈',0);");

        // 한글
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+S', '저장하기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+Y', '한 줄 지우기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+N', '새 문서 만들기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+Alt+T', '새 탭 만들기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+Alt+N', '문서마당',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+O', '불러오기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+Y', '다른 이름으로 저장하기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+Q', '문서정보',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+P', '인쇄',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+F4', '문서 닫기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'F7', '편집용지 설정',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+Z', '문서의 상태를 전 상태로 되돌림',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+X', '문서의 글이나 그림을 잘라냄',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+C', '문서의 글이나 그림을 복사',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+C', '문서의 글이나 그림의 속성을 복사',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+G', '문서를 전체화면으로 바꿈',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Ctrl+W', '글을 아이콘으로 바꿈',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'F9', '한글을 한자로 변환',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+F9', '한자를 한글로 변환',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoHn', 'Alt+T', '문단 모양',0);");

        // 엑셀
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Ctrl+enter', '범위 이동',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Ctrl+F5', '창 사이즈 변환',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Ctrl+D', '윗 셀 복사 후 붙여넣기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'F2', '현재 셀 편집',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Shift+F9', '시트 재계산',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', ' Shift+F3', '함수 마법사',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Alt+enter', '한 셀에 여러 줄 입력',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Alt+F2', '다른 이름으로 저장',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoEx', 'Alt+F11', 'VB 편집기 실행',0);");

        // 파워포인트
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+A', '모두 선택',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+B', '굵은 글씨',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+C', '복사하기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+G', '그룹지정',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+H', '텍스트 변경',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Alt+K', '하이퍼링크',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+N', '새 슬라이드 추가',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+O', '슬라이드 열기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+P', '인쇄',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+V', '붙여넣기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+F2', '인쇄 미리보기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+[/]', '글씨 크기 조절',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+X', '잘라내기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Shift+F3', '눈금선 보기',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Ctrl+Shift+S', '다른 이름으로 저장',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'F7', '맞춤법 검사',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'F5', '슬라이드 쇼 실행',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'Shift+F5', '현재 슬라이드 쇼부터 시작',0);");
        DB.execSQL("insert into " + "data" + "(pgname, shortkey, dowhat,star) values ('WoPt', 'end', '마지막 슬라이드로 이동',0);");


        return "rec ok, ";
    }

}


