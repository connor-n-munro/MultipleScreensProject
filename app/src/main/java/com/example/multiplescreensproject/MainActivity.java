package com.example.multiplescreensproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> player = new ArrayList<>();
    ArrayList<Integer> instructions = new ArrayList<>();
    Random randy;
    boolean first = false;
    boolean success = false;
    int score;
    Button red;
    Button blue;
    Button green;
    Button yellow;
    Animation focus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        focus = AnimationUtils.loadAnimation(this, R.anim.button_focus);
        final Button red = (Button) findViewById(R.id.redButton);
        final Button blue = (Button) findViewById(R.id.blueButton);
        final Button green = (Button) findViewById(R.id.greenButton);
        final Button yellow = (Button) findViewById(R.id.yellowButton);
        randy = new Random();
        first = true;
        score = 0;
        red.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(0);
            }
        });
        blue.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(1);
            }
        });
        green.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(2);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(3);
            }
        });
        run();
    }

    public void goToScoreboard()
    {
        instructions.clear();
        player.clear();
        Intent intent = new Intent(this, Leaderboard.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

    public void run()
    {
        if(first)
        {
            instructions.add(0);
            first = false;
            red.startAnimation(focus);
        }
        else if (success)
        {
            success = false;
            int step = randy.nextInt(4);
            instructions.add(step);
            red.setClickable(false);
            blue.setClickable(false);
            green.setClickable(false);
            yellow.setClickable(false);
            for(int i = 0; i < instructions.size(); i++)
            {
                if(instructions.get(i) == 0) //red
                {
                    red.startAnimation(focus);
                }
                else if (instructions.get(i) == 1) //blue
                {
                    blue.startAnimation(focus);
                }
                else if (instructions.get(i) == 2) //green
                {
                    green.startAnimation(focus);
                }
                else //yellow
                {
                    yellow.startAnimation(focus);
                }
            }
            red.setClickable(true);
            blue.setClickable(true);
            green.setClickable(true);
            yellow.setClickable(true);
        }
        else
        {
            for(int i = 0; i < player.size(); i++)
            {
                if(!player.get(i).equals(instructions.get(i)))
                {
                    score = player.size() - 1;
                    player.clear();
                    instructions.clear();
                    goToScoreboard();
                }
            }
            if (player.size() == instructions.size())
            {
                success = true;
                player.clear();
            }
        }
        run();
    }
}
