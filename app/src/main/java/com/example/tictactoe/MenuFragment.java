package com.example.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentMenu extends Fragment {

    private TextView winnerName;
    private Button restartButton;
    private Button closeButton;

    


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        restartButton = rootView.findViewById(R.id.button_restart);
        closeButton = rootView.findViewById(R.id.button_close);
        winnerName = rootView.findViewById(R.id.text_winner_name);

        restartButton.setOnClickListener(v -> onDestroy());

        closeButton.setOnClickListener(v -> android.os.Process.killProcess(android.os.Process.myPid()));



        winnerName.setText("123");

        return rootView;
    }


}
