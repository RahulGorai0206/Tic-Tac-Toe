package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 -> X
    // 1 -> O
    Boolean GameActive=true; // At first set game as active.
    int draw=0 ,counter=0; // Indicator and counter of the draw.
    int ActivePlayer=0; // The active player will be "X" by default. // 0 -> X , 1 -> O, 2 -> NULL.
    int [] GameState={2,2,2,2,2,2,2,2,2}; // Starting state of the game.
    int[][] WinPositions={ // Game winning positions on the grid.
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
    };
    public void OnTap(View view){
        counter++; // Increse the counter in every tap.
        ImageView img=(ImageView) view; // Storing the view in image view.
        int TappedImage=Integer.parseInt(img.getTag().toString()); // Get the tag of the tapped location.
        if(GameState[TappedImage]==2 && GameActive==true){ // Check if the place is empty or not. and start the game it it's in active state.
            GameState[TappedImage]= ActivePlayer; // Set X / O on the tapped position.
            if(ActivePlayer==0){
                img.setImageResource(R.drawable.x);
                ActivePlayer=1; // Set the next active player.
                TextView status= findViewById(R.id.textView2); // Get the element by its id.
                status.setText("O's Turn"); // Set indicator to this string.
            } else{
              img.setImageResource(R.drawable.o);
              ActivePlayer=0; // Set the next active player.
                TextView status= findViewById(R.id.textView2); // Get the element by its id.
                status.setText("X's Turn"); // Set indicator to this string.
            };
        };
        for(int[] WinPosition:WinPositions) // Check the game status.
            if(GameState[WinPosition[0]]==GameState[WinPosition[1]] && GameState[WinPosition[1]]==GameState[WinPosition[2]] && GameState[WinPosition[0]] != 2){
                if(GameState[WinPosition[0]]==0){
                    TextView status= findViewById(R.id.textView2); // Get the element by its id.
                    status.setText("X Won the game"); // Set indicator to this string.
                    draw=1; // Set to 1 if anyone won so it is not gonna draw anymore.
                    GameActive=false; // Game will not active after winning.
                }else{
                    TextView status1= findViewById(R.id.textView2); // Get the element by its id.
                    status1.setText("O Won the game"); // Set indicator to this string.
                    draw=1; // Set to 1 if anyone won so it is not gonna draw anymore.
                    GameActive=false;
                };
            };
        if (counter==9 && draw==0){
            TextView status1= findViewById(R.id.textView2); // Get the element by its id.
            status1.setText("Game Draw, Reset the game"); // Set indicator to this string.
        }
    };
    public void GameResett(View view){ // Only will be called when tapping on the reset button.
        GameActive=true; // Active the game.
        ActivePlayer=0; // Set the active player.
        TextView status= findViewById(R.id.textView2); // Get the element by its id.
        draw=0; // Set to zero on reset.
        counter=0; // Set to 0 on reset.
        status.setText("X's Turn"); // Set indicator to this string.
        for(int i=0; i<GameState.length;i++){
            GameState[i]=2; // Set all fields to no active player.
        };
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0); // Set the blank image.
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    };
};