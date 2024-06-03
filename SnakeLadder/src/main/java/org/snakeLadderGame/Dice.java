package org.snakeLadderGame;

import java.util.Random;

public class Dice {
    private Random random = new Random();
    private int number;

    public int roll(){
        //write code to generate number bw 1-6.
        return random.nextInt(1,7);
    }
}
