package com.example.multiplescreensproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Vector instructions = new Vector<Integer>();
    }
}
