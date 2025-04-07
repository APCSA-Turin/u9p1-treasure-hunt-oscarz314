package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite{ //child  of Sprite
    private boolean isDestroyed = false;
    
    public Enemy(int x, int y) {
        super(x, y);
    }


    //the methods below should override the super class 
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:" + super.getCoords();
    }


    public String getRowCol(int size){ //return "Enemy:"+row col
        return "Enemy:" + super.getRowCol(size);
    }

    //originally used for enemy movement; not used now
    public void destroy(){
        isDestroyed = true;
        setX(-1); 
        setY(-1);     
    }

    public boolean getIsDestroyed(){
        return isDestroyed;
    }
}