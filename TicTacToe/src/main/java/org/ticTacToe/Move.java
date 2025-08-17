package org.ticTacToe;

public final class Move {
    private final int row;
    private final int col;
    private final Symbol symbol;

    public Move(int row, int col, Symbol symbol) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }
    public int row() { return row; }
    public int col() { return col; }
    public Symbol symbol() { return symbol; }
}
