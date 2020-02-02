package com.example.tictactoe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Objects;

import static com.example.tictactoe.MainActivity.clearBoard;

public class MenuFragment extends Fragment {

    private TextView winnerName;
    private Button restartButton;
    private Button closeButton;
    private String mWinnerNameString;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        restartButton = rootView.findViewById(R.id.button_restart);
        closeButton = rootView.findViewById(R.id.button_close);
        winnerName = rootView.findViewById(R.id.text_winner_name);

        restartButton.setOnClickListener(v -> {
            clearBoard();
            Objects.requireNonNull(getActivity())
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .remove(this)
                    .commit();
        });

        closeButton.setOnClickListener(v -> android.os.Process.killProcess(android.os.Process.myPid()));

        winnerName.setText(mWinnerNameString);

        if (savedInstanceState != null) {
            mWinnerNameString = savedInstanceState.getString("winner");
            winnerName.setText(mWinnerNameString);
        }

        return rootView;
    }

    public void putWinnerName(String name) {
        mWinnerNameString = name;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("winner", mWinnerNameString);
    }
}
