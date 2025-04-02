package com.example.project;

//only needs a constructor
public class Trophy extends Treasure{ //child of trophy
    public Trophy(int x, int y){
        super(x, y);
    }

    public String getRowCol(int size){
        return "Trophy:" + super.getRowCol(size);
    }

    public String getCoords(){
        return "Trophy:" + super.getCoords();
    }
}
