package org.ticTacToe;

public class Rules {
    public static GameState evaluate(Board b, Move last) {
        Symbol s = last.symbol();
        int r = last.row(), c = last.col();

        if (checkLine(b, s, r, 0, 0, 1) ||     // row
                checkLine(b, s, 0, c, 1, 0) ||     // col
                (r == c && checkLine(b, s, 0, 0, 1, 1)) || // main diag
                (r + c == b.size() - 1 && checkLine(b, s, 0, b.size() - 1, 1, -1))) {
            return (s == Symbol.X) ? GameState.X_WINS : GameState.O_WINS;
        }
        return b.hasEmpty() ? GameState.IN_PROGRESS : GameState.DRAW;
    }

    private static boolean checkLine(Board b, Symbol s, int r, int c, int dr, int dc) {
        for (int i = 0; i < b.size(); i++) {
            if (b.getSymbol(r + i * dr, c + i * dc) != s) return false;
        }
        return true;
    }
}
