package chess;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;

public class ChessGraphics extends PApplet {
    HashMap<String, PImage> imageCodes;

    @Override
    public void settings() {
        size(512, 512);
        imageCodes = new HashMap<>();
        imageCodes.put("r", loadImage("images/bRook.png"));
        imageCodes.put("n", loadImage("images/bKnight.png"));
        imageCodes.put("b", loadImage("images/bBishop.png"));
        imageCodes.put("q", loadImage("images/bQueen.png"));
        imageCodes.put("k", loadImage("images/bKing.png"));
        imageCodes.put("p", loadImage("images/bPawn.png"));
        imageCodes.put("R", loadImage("images/wRook.png"));
        imageCodes.put("N", loadImage("images/wKnight.png"));
        imageCodes.put("B", loadImage("images/wBishop.png"));
        imageCodes.put("Q", loadImage("images/wQueen.png"));
        imageCodes.put("K", loadImage("images/wKing.png"));
        imageCodes.put("P", loadImage("images/wPawn.png"));
    }

    @Override
    public void setup() {
        noStroke();
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        for(int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                int index = row * 8 + col;
                char symbol = ChessController.pieces.charAt(index);

                if ((col + row) % 2 == 0) {
                    fill(100, 60, 200);
                } else {
                    fill(30, 30, 255);
                }
                int x = col * 64;
                int y = 448 - row * 64;
                rect(x, y, 64, 64);

                if (symbol == 'x') continue;

                image(imageCodes.get(String.valueOf(symbol)), x, y,64, 64);
            }
        }
    }
}
