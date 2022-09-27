package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
        ImageView img=(ImageView) view; // Storing the view in image view.
        int TappedImage=Integer.parseInt(img.getTag().toString()); // Get the tag of the tapped location.
        if(GameState[TappedImage]==2){ // Check if the place is empty or not.
            GameState[TappedImage]= ActivePlayer; // Set X / O on the tapped position.
            if(ActivePlayer==0){
                img.setImageResource(R.drawable.x);
                ActivePlayer=1;
            } else{
              img.setImageResource(R.drawable.o);
              ActivePlayer=0;
            };
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}