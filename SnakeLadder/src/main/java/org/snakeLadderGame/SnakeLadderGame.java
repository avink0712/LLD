package org.snakeLadderGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderGame {

    private Dice dice;
    private List<Player> players;

    private Map<Integer,Integer> specialPosition = new HashMap<>();

    private int count = 0;




    public SnakeLadderGame(List<Player> players){
        this.players = new ArrayList<>(players);
        this.dice = new Dice();
    }


    public void play(){
        for(Snake snake: Board.getSnakes()){
            specialPosition.put(snake.getHead(),snake.getTail());
        }
        for(Ladder ladder: Board.getLadder()){
            specialPosition.put(ladder.getBase(),ladder.getTop());
        }
        int count = 0;
        while(!isGameOver(players)) {

            for(Player player: players){
                int num = dice.roll();
                player.setCurrentPosition(player.getCurrentPosition()+num);
                resetCurrentPositionIfRequired(player);
            }


        }

    }

    private void resetCurrentPositionIfRequired(Player player) {
        if(specialPosition.containsKey(player.getCurrentPosition())){
            int updatedPosition = specialPosition.get(player.getCurrentPosition());
            player.setCurrentPosition(updatedPosition);
        }

    }

    private boolean isGameOver(List<Player> players) {
        count++;
        for(Player player: players){
            if(player.getCurrentPosition()==Board.BOARD_SIZE){
                System.out.println("Player won: "+ player.getName()+" in "+ count+" moves.");
                return true;
            }
        }
        return false;
    }
}
