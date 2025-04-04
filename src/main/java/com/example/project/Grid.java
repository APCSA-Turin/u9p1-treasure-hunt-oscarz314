package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = new Dot(j, size - 1 - i);
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[size - 1 - s.getY()][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(grid[i][j] instanceof Player){
                        grid[i][j] = new Dot(grid[i][j].getX(), grid[i][j].getY());
                    }
                }
            }

            placeSprite(s);
    }


    public void display() { //print out the current grid to the screen 
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if (grid[i][j] instanceof Dot){
                    System.out.print("[ ]");
                }
                if (grid[i][j] instanceof Treasure && !(grid[i][j] instanceof Trophy)){
                    System.out.print("[T]");
                }
                else if (grid[i][j] instanceof Player){
                    System.out.print("[P]");
                }
                else if (grid[i][j] instanceof Trophy){
                    System.out.print("[W]");
                }
                else if (grid[i][j] instanceof Enemy){
                    System.out.print("[E]");
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
    }

    public void win(){ //use this method to display a win 
    }


}