package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ImageView imageCross;
    private ImageView imageCircle;
    private TextView winCounterCrossText;
    private TextView winCounterCircleText;

    private int winCounterCrossInt;
    private int winCounterCircleInt;

    private static final String TAG = "Main Activity";

    TicTacToeLogic mTicTacToeLogic = new TicTacToeLogic();

    private int[] figuresPosition = new int[9];

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;
    private ImageButton imageButton9;

    private static ImageButton[] arrayOfButtons = new ImageButton[9];

    MenuFragment mMenuFragment = new MenuFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] flag = new int[1];
        flag[0] = 1;

        imageCross = findViewById(R.id.image_cross);
        imageCircle = findViewById(R.id.image_circle);

        winCounterCrossText = findViewById(R.id.win_counter_cross);
        winCounterCircleText = findViewById(R.id.win_counter_circle);

        imageButton1 = findViewById(R.id.cell_1);
        imageButton2 = findViewById(R.id.cell_2);
        imageButton3 = findViewById(R.id.cell_3);
        imageButton4 = findViewById(R.id.cell_4);
        imageButton5 = findViewById(R.id.cell_5);
        imageButton6 = findViewById(R.id.cell_6);
        imageButton7 = findViewById(R.id.cell_7);
        imageButton8 = findViewById(R.id.cell_8);
        imageButton9 = findViewById(R.id.cell_9);

        arrayOfButtons = new ImageButton[]{imageButton1, imageButton2, imageButton3, imageButton4,
                imageButton5, imageButton6, imageButton7, imageButton8, imageButton9};


        imageCross.setImageResource(R.drawable.cross);
        imageCircle.setImageResource(R.drawable.circle);

        Objects.requireNonNull(getSupportActionBar()).hide();

        View.OnClickListener onClickListenerButton = (v) -> {
            ImageButton btn = findViewById(v.getId());
            btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
            int numberOfCell = Integer.parseInt(getResources().getResourceName(v.getId()).replaceAll("\\D", ""));
            figuresPosition[numberOfCell - 1] = (flag[0] % 2) + 1;
            //Если 1 - нолик, если 2 крестик
            flag[0]++;
            btn.setEnabled(false);
            Log.d(TAG, numberOfCell + "");
            winnerStatistics();

//            if (mTicTacToeLogic.winnerExistance(figuresPosition) || mTicTacToeLogic.isDraw(figuresPosition))
//                clearBoard(arrayOfButtons);
        };


        for (ImageButton button : arrayOfButtons) {
            button.setOnClickListener(onClickListenerButton);
        }

        winCounterCrossInt = 0;
        winCounterCircleInt = 0;

        winCounterCrossText.setText(winCounterCrossInt + "");
        winCounterCircleText.setText(winCounterCircleInt + "");


    }

    private void winnerStatistics() {
        int winner = mTicTacToeLogic.whoIsWinner(figuresPosition);

        switch (winner) {
            case 1:
                winCounterCircleInt++;
                winCounterCircleText.setText(winCounterCircleInt + "");
                mMenuFragment.putWinnerName(getString(R.string.circle));
                break;
            case 2:
                winCounterCrossInt++;
                winCounterCrossText.setText(winCounterCrossInt + "");
                mMenuFragment.putWinnerName(getString(R.string.cross));
                break;
            case 3:
                mMenuFragment.putWinnerName("Ничья");
                break;
        }

        if (winner >= 1 && winner <=3) {
            figuresPosition = new int[9];
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.relative_layout_with_result, mMenuFragment)
                    .commit();
        }
    }


    static void clearBoard() {
        for (ImageButton button : arrayOfButtons) {
            button.setEnabled(true);
            button.setImageResource(0);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("winCounterCircleInt", winCounterCircleInt);
        outState.putInt("winCounterCrossInt", winCounterCrossInt);
        outState.putIntArray("figuresPosition", figuresPosition);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        winCounterCircleInt = savedInstanceState.getInt("winCounterCircleInt");
        winCounterCrossInt = savedInstanceState.getInt("winCounterCrossInt");
        figuresPosition = savedInstanceState.getIntArray("figuresPosition");
        winCounterCircleText.setText(winCounterCircleInt + "");
        winCounterCrossText.setText(winCounterCrossInt + "");
        for (int position = 0; position < figuresPosition.length; position++) {
            if (figuresPosition[position] != 0) {
                arrayOfButtons[position].setImageResource(figuresPosition[position] == 1
                        ? R.drawable.circle : R.drawable.cross);
                arrayOfButtons[position].setEnabled(false);
            }
        }
    }
}
