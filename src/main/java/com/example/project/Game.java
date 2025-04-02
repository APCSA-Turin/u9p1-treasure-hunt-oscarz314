package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 
    private Treasure treasure;

    public Game(int size){ //the constructor should call initialize() and play()
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

        while(true){
            grid.display();
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

     
            }
    }

    public void initialize(){

        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        int size = 10;
        grid = new Grid(size);
        player = new Player(0, 0);
        treasure = new Treasure(2, 2);
        grid.placeSprite(treasure);
        grid.placeSprite(player);
    }

    public void test(){
        grid.display();
        System.out.println();
        player.move("w");//[8][0]

        player.move("w");//[7][0]
        player.move("d");//[7][1]   

        player.interact(10, "d", 2, treasure);
        player.move("d");//[7][2] // treasure 
        grid.placeSprite(player, "d");
        grid.display();
        System.out.println();

        player.move("w"); //[6][2]
        grid.placeSprite(player,"w");
        grid.display();
        System.out.println(grid.getGrid()[2][2].getClass());
    }
    public static void main(String[] args) {
        Game test = new Game(10);
        test.initialize();
        test.test();
        // int size = 10;
        // Grid grid = new Grid(size);
        // Player player = new Player(0, 0);
        // Enemy enemy = new Enemy(5, 5);
        // Enemy enemy2 = new Enemy(7,8);
        // Treasure treasure = new Treasure(2, 2);
        // Treasure treasure2 = new Treasure(1,7);
        // Trophy trophy = new Trophy(9, 9);

        // grid.placeSprite(player);
        // grid.placeSprite(enemy);
        // grid.placeSprite(enemy2);
        // grid.placeSprite(treasure);
        // grid.placeSprite(treasure2);
        // grid.placeSprite(trophy);
        // grid.display();

        // for(int i=0;i<5;i++){
        //     player.move("w"); //[9-5][0]
        //     grid.placeSprite(player, "w");
        // }

        // for(int i=0;i<4;i++){
        //     player.move("d");//[5][4]
        //     grid.placeSprite(player, "d");
        // }

        //  // Interact with the enemy
        // player.interact(10, "d", 1, enemy);
        // player.move("d");//[4][5]
        // grid.placeSprite(player, "d"); for(int i=0;i<5;i++){
        //     player.move("w"); //[9-5][0]
        //     grid.placeSprite(player, "w");
        // }

        // for(int i=0;i<4;i++){
        //     player.move("d");//[5][4]
        //     grid.placeSprite(player, "d");
        // }

        //  // Interact with the enemy
        // player.interact(10, "d", 1, enemy);
        // player.move("d");//[4][5]
        // grid.placeSprite(player, "d");

        // player.move("w");//[3][5]
        // player.move("w");//[2][5]
        // player.move("d");//[2][6]

        // player.interact(10,"d",1,enemy2);
        // player.move("d");//[2][7]
        // grid.placeSprite(player,"d");

        // grid.display();
        // System.out.println(player.getLives());
    }
}