package org.ticTacToe.strategy;

import org.ticTacToe.Board;
import org.ticTacToe.Move;
import org.ticTacToe.Symbol;

public class RandomStrategy implements Strategy {
    private final java.util.Random random = new java.util.Random();

    public Move choose(Board board, Symbol me) {
        var cells = new java.util.ArrayList<int[]>();
        for (int i = 0; i < board.size(); i++)
            for (int j = 0; j < board.size(); j++)
                if (board.getSymbol(i, j) == Symbol.EMPTY) cells.add(new int[]{i, j});
        int[] pick = cells.get(random.nextInt(cells.size()));
        return new Move(pick[0], pick[1], me);
    }

}
