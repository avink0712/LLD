package org.snakeLadderGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

       Snake snake1 = new Snake(15,5);
        Snake snake2 = new Snake(22,2);
        Snake snake3 = new Snake(46,30);
        Snake snake4 = new Snake(70,50);
        Snake snake5 = new Snake(88,20);
        Snake snake6 = new Snake(95,44);

        Ladder ladder1 = new Ladder(5,20);
        Ladder ladder2 = new Ladder(14,50);
        Ladder ladder3 = new Ladder(36,75);
        Ladder ladder4 = new Ladder(50,85);
        Ladder ladder5 = new Ladder(68,90);

        List<Snake> snakes = new ArrayList<>(Arrays.asList(snake1,snake2,snake3,snake4,snake5,snake6));

        List<Ladder> ladders = new ArrayList<>(Arrays.asList(ladder1,ladder2,ladder3,ladder3,ladder4));


        Board board = new Board(snakes,ladders);

        Player player1 = new Player(1,"Avinash");
        Player player2 = new Player(2,"Anand");

        SnakeLadderGame game = new SnakeLadderGame(new ArrayList<>(Arrays.asList(player1,player2)));
        game.play();

    }
}