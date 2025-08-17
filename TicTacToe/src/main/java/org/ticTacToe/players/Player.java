package org.ticTacToe.players;

import org.ticTacToe.Board;
import org.ticTacToe.Move;
import org.ticTacToe.Symbol;

abstract public class Player {
    public Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract Move nextMove(Board board);

    public Symbol getSymbol() {
        return symbol;
    }
}
