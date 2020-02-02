package com.example.tictactoe;

import android.util.Log;

class TicTacToeLogic {

    private static final String TAG = "Logic" ;

    int whoIsWinner(int[] data){
        int cell = cellOfWinner(data);
        try {
            if (cell >= 0)
                return data[cell];
            else if (isDraw(data))
                return 3;
        }catch (NullPointerException e){
            Log.e(TAG, "whoIsWinner: ");
        }
        return 0;
    }

    boolean winnerExistance(int[] data){
        int winner = whoIsWinner(data);
        Log.d(TAG, "winnerExistance() called " + winner);
        return winner == 1 || winner == 2;
    }

    boolean isDraw(int[] data){
        for (int position: data) {
            if(position == 0)
                return false;
        }
        return cellOfWinner(data) == -1;
    }


    private int cellOfWinner(int[] data) {

        if ((data[0] == data[3]) && (data[0] == data[6]) && data[0]!= 0) {
            return 0;
        }
        else if((data[1] == data[4]) && (data[1] == data[7]) && data[1]!= 0){
            return 1;
        }
        else if((data[2] == data[5]) && (data[2] == data[8]) && data[2]!= 0){
            return 2;
        }
        else if((data[0] == data[2]) && (data[2] == data[1]) && data[0]!= 0){
            return 2;
        }
        else if((data[3] == data[5]) && (data[3] == data[4]) && data[3]!= 0){
            return 3;
        }
        else if((data[6] == data[7]) && (data[6] == data[8]) && data[6]!= 0){
            return 6;
        }
        else if((data[0] == data[4]) && (data[0] == data[8]) && data[0]!= 0){
            return 0;
        }
        else if((data[2] == data[4]) && (data[2] == data[6])  && data[2]!= 0){
            return 2;
        }
        else
            return -1;
    }


}
