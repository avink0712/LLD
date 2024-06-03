package org.snakeLadderGame;

public class Player {
    private int id;
    private String name;

    private int currentPosition;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        this.currentPosition = 1;

    }

    public void makeMove(int number){

    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName(){
        return this.name;
    }
}
