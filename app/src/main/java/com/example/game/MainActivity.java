package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // 0 -> X
    // 1 -> O
    int ActivePlayer=0; // the active player will be "X" by default. // 0 -> X , 1 -> O, 2 -> NULL.
    int [] GameState={2,2,2,2,2,2,2,2,2}; // Starting state of the game.
    public void OnTap(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}