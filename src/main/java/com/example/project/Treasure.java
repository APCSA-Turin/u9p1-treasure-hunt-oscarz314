package com.example.project;

//only needs a constructor
public class Treasure extends Sprite{ //child of Sprite
    public Treasure(int x, int y) {
        super(x, y);
    }

    public String getRowCol(int size){
        return "Treasure:" + super.getRowCol(size);
    }

    public String getCoords(){
        return "Treasure:" + super.getCoords();
    }
}