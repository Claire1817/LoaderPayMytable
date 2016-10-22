package com.example.claire.loader;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       FragmentManager fm = getSupportFragmentManager();
       DialogFragment newFragment = MyDialogFragment.newInstance();
        newFragment.show(fm, "kkk");
    }
}
