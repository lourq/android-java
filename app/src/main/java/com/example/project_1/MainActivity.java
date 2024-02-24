package com.example.project_1;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int xImage = R.drawable.x_image;
    private int oImage = R.drawable.o_image;
    private ImageView[] imageViews = new ImageView[9];
    private int[] field = new int[9];
    private boolean move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INFO: assigning id to handlers , add num to field
        for(int i = 0 ; i < imageViews.length ; i++){
            String imageViewId = "imageView" + (i + 1);
            int resId = getResources().getIdentifier(imageViewId, "id", getPackageName());
            imageViews[i] = findViewById(resId);
            field[i] = i;
        }
        move = false;
    }

    public void onCellClicked(View v) {
        for(int i = 0 ; i < imageViews.length ; i++){
            if(v.getId() == imageViews[i].getId()){
                if (!move) {
                    imageViews[i].setImageResource(xImage);
                    field[i] = 1;
                } else {
                    imageViews[i].setImageResource(oImage);
                    field[i] = 2;
                }
                move = !move;
            }
        }
        if(checkWinner()) {
            String winner = "Player " + (move ? "X" : "O") + " Winner";
            Toast.makeText(MainActivity.this,
                    String.valueOf(winner),
                    Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private boolean checkWinner() {
        // INFO: checking horizontal lines
        for (int i = 0; i < 9; i += 3) {
            if (field[i] == field[i + 1] && field[i] == field[i + 2] && field[i] != 0) {
                return true;
            }
        }

        // INFO: checking vertical lines
        for (int i = 0; i < 3; i++) {
            if (field[i] == field[i + 3] && field[i] == field[i + 6] && field[i] != 0) {
                return true;
            }
        }

        // INFO: checking diagonal lines
        if (field[0] == field[4] && field[0] == field[8] && field[0] != 0) {
            return true;
        }
        if (field[2] == field[4] && field[2] == field[6] && field[2] != 0) {
            return true;
        }

        return false;
    }

    private void resetGame() {
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImageResource(0);
            field[i] = 0;
        }
        move = false;
    }
}
