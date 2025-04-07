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
        grid[size - 1 - s.getY()][s.getX()] = s; // set (x, y) to [row][col] on grid
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
            //Replace old player position with a dot
            if(s instanceof Player){
                for(int i = 0; i < size; i++){ 
                    for(int j = 0; j < size; j++){
                        if(grid[i][j] instanceof Player){
                            grid[i][j] = new Dot(grid[i][j].getX(), grid[i][j].getY());
                        }
                    }
                }
            }

            //Place enemy
            // if(s instanceof Enemy){
            //     for(int i = 0; i < size; i++){
            //         for(int j = 0; j < size; j++){
            //             if(grid[i][j] == s){ // when find our enemy
            //                 if(((Enemy) s).getIsDestroyed()){
            //                     grid[i][j] = grid[i][j] = new Dot(grid[i][j].getX(), grid[i][j].getY());
            //                     return;
            //                 }
            //                 temp = grid[size - 1 - s.getY()][s.getX()]; 
            //                 if(temp instanceof Treasure){
            //                     placeSprite(temp);
            //                 }
            //                 else{
            //                     grid[i][j] = new Dot(grid[i][j].getX(), grid[i][j].getY());
            //                 }
            //                 placeSprite(s);
            //             } 
            //         }
            //     }
            // }

            //Redo player to new position
            placeSprite(s);
    }

    // public void moveEnemy (Enemy enemy, Player player){
    //     if(!enemy.getIsDestroyed()){
    //         int yDifference = player.getY() - enemy.getY();
    //         int xDifference = player.getX() - enemy.getX();

    //         if(enemy.getY() < player.getY()){
    //             enemy.move("w");
    //             return;
    //         }
    //         if(enemy.getY() > player.getY()){
    //             enemy.move("s");
    //             return;
    //         }

    //         if(enemy.getX() > player.getX()){
    //             enemy.move("a");
    //             return;
    //         }
    //         if(enemy.getX() < player.getX()){
    //             enemy.move("d");
    //             return;
    //         }
    //     }
    // }

    public void display() { //print out the current grid to the screen 
        // Print grid base on object type of element
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
        for(int i = 0; i < size; i++){ // a grid of lose characters in chinese
            for(int j = 0; j < size; j++){
                System.out.print(" 输 ");
            }
            System.out.println();
        }
        System.out.println("You've lost!");
    }

    public void win(){ //use this method to display a win 
        for(int i = 0; i < size; i++){ // a grid of win characters in chinese
            for(int j = 0; j < size; j++){
                System.out.print(" 赢 ");
            }
            System.out.println();
        }
        System.out.println("You've won!");
    }


}