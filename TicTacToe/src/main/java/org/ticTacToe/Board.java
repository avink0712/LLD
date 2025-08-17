package org.ticTacToe;

public class Board {
    private static final int SIZE = 3;
    private Symbol[][] grid;

    public Board() {
        this.grid = new Symbol[SIZE][SIZE];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.grid[i][j] = Symbol.EMPTY;
            }
        }
    }
    public boolean isFree(int r, int c) {
        return inBounds(r, c) && grid[r][c] == Symbol.EMPTY;
    }

    public void place(Move move) {
        if (!isFree(move.row(), move.col())) {
           // throw new IllegalArgumentException("Invalid move at " + move.row() + "," + move.col());
            System.out.println("Invalid move: Please select different grid");
        }
        grid[move.row()][move.col()] = move.symbol();
    }

    public Symbol getSymbol(int r, int c) { return grid[r][c]; }
    public boolean hasEmpty() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (grid[i][j] == Symbol.EMPTY) return true;
        return false;
    }
    public int size() { return SIZE; }

    private boolean inBounds(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }
    public void getBoardView(){
        for(Symbol[] row: grid){
            System.out.println("["+row[0]+" "+row[1]+" "+row[2]+"]");
        }
    }
}
