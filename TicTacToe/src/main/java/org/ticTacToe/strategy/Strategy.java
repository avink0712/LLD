package org.ticTacToe.strategy;

import org.ticTacToe.Board;
import org.ticTacToe.Move;
import org.ticTacToe.Symbol;

public interface Strategy {
    Move choose(Board board, Symbol me);
}
