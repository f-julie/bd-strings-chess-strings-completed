package chess;

import processing.core.PApplet;

import java.util.Scanner;

public class App {

    public static boolean graphics = false;

    public static void main(String[] args) {
        ChessController cc = new ChessController();

        cc.move("e2", "e4");
        cc.printGame();

//        System.out.println("Type 'q' to quit");
//        runGame(cc);
    }

    public static void runGame(ChessController cc) {
        //Including this line "turns on" the processing sketch
        //which provides the graphics for this game
        if (graphics) {
            PApplet.main("chess.ChessGraphics");
        }

        //We use a Scanner to collect input from the user
        Scanner scanner = new Scanner(System.in);
        String from;
        String to;

        //This do-while loop continuously polls the user
        //for moves, and calls the move method on the ChessController.
        //The loop pauses while waiting for console input.
        do {
            System.out.println("Enter starting tile: ");
            from = scanner.nextLine();

            //If the first coordinate is a quit request, we can break out of the loop.
            if (from.equalsIgnoreCase( "Q")) break;

            System.out.println("Enter destination tile: ");
            to = scanner.nextLine();

            cc.move(from, to);
            cc.printGame();

            //This do-while loop ends if the user types 'q' or 'Q'
        } while (!from.equalsIgnoreCase( "Q") &&
                !to.equalsIgnoreCase( "Q"));

        //This terminates the application
        System.exit(0);
    }
}
