package org.ticTacToe.players;

import org.ticTacToe.Board;
import org.ticTacToe.Move;
import org.ticTacToe.Symbol;

public class HumanPlayer extends Player {
    private final java.util.function.Supplier<Move> inputSupplier;
    public HumanPlayer(Symbol symbol, java.util.function.Supplier<Move> supplier) {
        super(symbol);
        this.inputSupplier = supplier;
    }
    public Move nextMove(Board board) { return inputSupplier.get(); }
}
