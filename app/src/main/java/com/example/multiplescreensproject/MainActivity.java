package com.example.multiplescreensproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    Vector player;
    Vector instructions;
    Random randy;
    boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = new Vector<Integer>();
        player = new Vector<Integer>();
        ImageButton red = findViewById(R.id.redButton);
        ImageButton blue = findViewById(R.id.blueButton);
        ImageButton green = findViewById(R.id.greenButton);
        ImageButton yellow = findViewById(R.id.yellowButton);
        randy = new Random();
        first = true;
        red.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(0);
                if(!player.equals(instructions))
                {
                    player.clear();
                    instructions.clear();
                    goToLeaderboard();
                }

            }
        });
        blue.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(1);
                if(!player.equals(instructions))
                {
                    player.clear();
                    instructions.clear();
                    goToLeaderboard();
                }
            }
        });
        green.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(2);
                if(!player.equals(instructions))
                {
                    player.clear();
                    instructions.clear();
                    goToLeaderboard();
                }
            }
        });
        yellow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                player.add(3);
                if(!player.equals(instructions))
                {
                    player.clear();
                    instructions.clear();
                    goToLeaderboard();
                }
            }
        });
        run();
    }

    public void goToLeaderboard()
    {
        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }

    public void run()
    {
        if(first)
        {
            instructions.add(0);
            first = false;
        }
        else
        {
            instructions.add(randy.nextInt(4));

        }
        run();
    }
}
