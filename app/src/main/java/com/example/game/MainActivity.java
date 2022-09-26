package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // 0 -> X
    // 1 -> O
    int ActivePlayer=0; // The active player will be "X" by default. // 0 -> X , 1 -> O, 2 -> NULL.
    int [] GameState={2,2,2,2,2,2,2,2,2}; // Starting state of the game.
    int[][] WinPositions={ // Game winning positions on the grid.
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
    };
    public void OnTap(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}