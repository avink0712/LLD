package org.snakeLadderGame;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int BOARD_SIZE = 100;

    private static List<Snake> snakes;
    private static List<Ladder> ladders;

    //int[][] positions = new int[100][1];

    public Board(List<Snake> snakes,List<Ladder> ladders){
        this.snakes = new ArrayList<>(snakes);
        this.ladders = new ArrayList<>(ladders);
    }

    public static  List<Snake> getSnakes(){
        return snakes;
    }

    public static  List<Ladder> getLadder(){
        return ladders;
    }

}
