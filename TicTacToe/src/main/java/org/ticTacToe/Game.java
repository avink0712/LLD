package org.ticTacToe;

import org.ticTacToe.players.Player;

public class Game {
    private final Board board;
    private final Player[] players;
    private GameState state = GameState.IN_PROGRESS;

    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.players = new Player[]{p1, p2};
    }

    public GameState getState() { return state; }

    public void play() {
        while (state == GameState.IN_PROGRESS) {
            for(Player currPlayer: players){
                board.getBoardView();
                Move move = currPlayer.nextMove(board);
                board.place(move);
                state = Rules.evaluate(board, move);
            }
        }
    }
}

