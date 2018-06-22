package com.example.mirim.shortcut;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Send extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        //받아온 값을 통해 쿼리를 돌리고 리사이클러 뷰로 다시 출력한다. 모든 뷰를 한 xml에서 처리한다. 효율적이게.
    }
}
