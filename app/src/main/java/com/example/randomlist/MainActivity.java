package com.example.randomlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.randomlist.userview.UserGridFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new UserGridFragment())
                    .commit();
        }
    }
}
