package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton imageButton1 = findViewById(R.id.cell_1_1);
        final ImageButton imageButton2 = findViewById(R.id.cell_2_1);
        final ImageButton imageButton3 = findViewById(R.id.cell_3_1);
        final ImageButton imageButton4 = findViewById(R.id.cell_1_2);
        final ImageButton imageButton5 = findViewById(R.id.cell_2_2);
        final ImageButton imageButton6 = findViewById(R.id.cell_3_2);
        final ImageButton imageButton7 = findViewById(R.id.cell_1_3);
        final ImageButton imageButton8 = findViewById(R.id.cell_2_3);
        final ImageButton imageButton9 = findViewById(R.id.cell_3_3);
        final int[] flag = new int[1];
        flag[0] = 1;



        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);

            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton btn = (ImageButton) findViewById(v.getId());
                btn.setImageResource(flag[0] % 2 == 0 ? R.drawable.circle : R.drawable.cross);
                flag[0]++;
                btn.setEnabled(false);
            }
        });

    }


}
