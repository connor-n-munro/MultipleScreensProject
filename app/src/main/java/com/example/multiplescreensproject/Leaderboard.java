package com.example.multiplescreensproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }
    public void tryAgain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
