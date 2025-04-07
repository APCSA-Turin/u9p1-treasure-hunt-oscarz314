package com.example.project;
import java.util.*;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        initialize(); //intialize the game upon creation
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while(true){
            //gameplay
            if(player.getWin() == false && player.getLives() > 0){
                //display and input
                grid.display();
                System.out.println(player.getCoords());
                System.out.println(player.getRowCol(size));
                System.out.println("Treasure collected: " + player.getTreasureCount());
                System.out.println("Lives remaining: " + player.getLives());
                System.out.print("Enter a direction (w,a,s,d) or 'q' to exit: ");
                input = scanner.next();

                if(input.equals("q")){
                    return;
                }

                if(player.isValid(size, input)){
                    player.interact(size, input, treasures.length, grid.getGrid()[size - 1- player.getY()][player.getX()]);
                    // Player
                    player.move(input);
                    player.interact(size, input, treasures.length, grid.getGrid()[size - 1- player.getY()][player.getX()]);
                    //Player
                    grid.placeSprite(player, input);
                }
            }
            // if lose
            else if (player.getWin() == false && player.getLives() == 0){
                grid.gameover();
                System.out.print("Play again? y or n: ");
                input = scanner.next();
                if(input.equals("y")){
                    initialize();
                }
                return;
            }
            // win
            else if (player.getWin() == true){
                grid.win();
                System.out.print("Play again? y or n: ");
                input = scanner.next();
                if(input.equals("y")){
                    initialize();
                }
                return;
            }
            
            // update
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
        }
    }

    public void initialize(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose easy, medium, or hard difficultly: ");
        String choice = scanner.nextLine();

        // presets based on difficulty
        if(choice.equals("easy")){
            size = 10;
            grid = new Grid(size);
            generate(2);
        }
        else if(choice.equals("medium")){
            size = 15;
            grid = new Grid(size);
            generate(3);
        }
        else if(choice.equals("hard")){
            size = 20;
            grid = new Grid(size);
            generate(4);
        }

        play();
    }

    public void generate(int amount){
        enemies = new Enemy[amount];
        treasures = new Treasure[amount];
        player = new Player(0, 0);
        trophy = new Trophy((int) (Math.random() * size), (int) (Math.random() * size));
        grid.placeSprite(player);
        grid.placeSprite(trophy);

        // set enemies random position not overlapping
        for(int i = 0; i < enemies.length; i++){
            boolean uniquePos = false;

            while(uniquePos == false){
                int tempX = (int) (Math.random() * size);
                int tempY = (int) (Math.random() * size);
                uniquePos = true;

                if(grid.getGrid()[size - 1 - tempY][tempX] instanceof Dot){
                    grid.placeSprite(new Enemy(tempX, tempY));
                    uniquePos = true;
                }
            }
        }

        //set treasures random position not overlapping
        for(int i = 0; i < treasures.length; i++){
            boolean uniquePos = false;

            while(uniquePos == false){
                int tempX = (int) (Math.random() * size);
                int tempY = (int) (Math.random() * size);
                uniquePos = true;

                if(grid.getGrid()[size - 1 - tempY][tempX] instanceof Dot){
                    grid.placeSprite(new Treasure(tempX, tempY));
                    uniquePos = true;
                }
            }
        }


    }

    public static void main(String[] args) {
        Game test = new Game(10);
    }
}