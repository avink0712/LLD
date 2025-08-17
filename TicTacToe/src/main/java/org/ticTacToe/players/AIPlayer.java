package org.ticTacToe.players;

import org.ticTacToe.*;
import org.ticTacToe.strategy.Strategy;

public class AIPlayer extends Player {
    private final Strategy strategy;
    public AIPlayer(Symbol symbol, Strategy strategy) {
        super(symbol);
        this.strategy = strategy;
    }
    public Move nextMove(Board board) { return strategy.choose(board, symbol); }
}
