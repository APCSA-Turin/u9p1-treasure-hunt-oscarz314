package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite{
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
        win = false;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        super.move(direction);
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
        if(obj instanceof Treasure && !(obj instanceof Trophy)){
            treasureCount++;
        }
        if(obj instanceof Enemy){
            numLives--;
        }
        if(obj instanceof Trophy && treasureCount == numTreasures){
            win = true;
        }
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        //determine if valid in (x,y) with WASD
        if(direction.equals("w") && getY() + 1 > size - 1){
            return false;
        }
        else if(direction.equals("a" ) && getX() - 1 < 0){
            return false;
        }
        else if(direction.equals("s") && getY() - 1 < 0){
            return false;
        }
        else if(direction.equals("d") && getX() + 1 > size - 1){
            return false;
        }
    
        return true;
    }

    public String getRowCol(int size){
        return "Player:" + super.getRowCol(size);
    }

    public String getCoords(){
        return "Player:" + super.getCoords();
    }

   
}



