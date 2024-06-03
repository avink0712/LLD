package org.snakeLadderGame;

public class Ladder {
   private int top;
   private int base;

   public Ladder(int head, int tail){
       this.top = head;
       this.base = tail;
   }

    public int getTop() {
        return top;
    }

    public int getBase() {
        return base;
    }
}
