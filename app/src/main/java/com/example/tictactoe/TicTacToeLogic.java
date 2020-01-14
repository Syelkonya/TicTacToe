package com.example.tictactoe;

public class TicTacToeLogic {

    private int data[][] = new int[3][3];

    private void pushToData(int[][] data, int x, int y) {
        data[x][y] = 0;
        this.data = data;
    }

}
