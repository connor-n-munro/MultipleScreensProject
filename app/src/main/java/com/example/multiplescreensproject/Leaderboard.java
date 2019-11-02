package com.example.multiplescreensproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Leaderboard extends AppCompatActivity
{
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        score = getIntent().getIntExtra("SCORE", 0);
        TextView scoreboard = findViewById(R.id.scoreboard);
        scoreboard.setText(score + "!");
    }
    public void tryAgain(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
