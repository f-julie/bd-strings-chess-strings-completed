# Making a Chess game

In this project we will be implementing movement using
a primitive chess notation. (You do not need to know the
rules of chess).

We will be taking some liberties such as assuming all input
to be in the desired format, and we wont be enforcing
any rules of the game.

The ultimate goal is to specify that the game should move
the piece at position `e4` to say `c6`.

An imaginary coworker will be implementing the rules of the game, all
they need from us is the ability to move a piece from one
square to the next.

## Starter Code:

The App class contains the `main` method you'll want to run.
This project can be a simple console program, however there is a graphical
sketch you are provided with. Feel free to inspect the `ChessGraphics` class
if you would like to see how the graphics were achieved.

The static boolean `graphics` can be set to true or false to turn on or off
the use of graphics.

The `runGame` method is already built out for you and will not
need any further modification. Feel free to inspect this method
if you would like to see how it works.

## The `ChessController` class

This is the class which controls the entire game. You are given all of the
pieces in their starting positions, represented in a single string `pieces`.

- (R)ooks
- k(N)ights
- (B)ishops
- (Q)eens
- (K)ings
- (P)awn
- (x) empty square

Uppercase = White
Lowercase = Black

*Note that the board appears to be flipped vertically when you look at the String.
This is so that the `a1` square corresponds to the 0th index of the String.*
    - This was a design decision and not the only way it could have been done.

## Your Task

Complete the following methods according to the descriptions and hints provided
in the following sections.

## `printGame()`

Use substrings to print each row of the board to the console. Remember that the
pieces String looks upside down to the real board.

If the pieces string looks like this in Java:

```java
public static String pieces =
        "RNBQKBNR" +
        "PPPPPPxP" +
        "xxxxxxxx" +
        "xxxxxxPx" +
        "xxxxxxxx" +
        "xxnxxxxx" +
        "pppppppp" +
        "rxbqkbnr";
```

Then the printed board should look like this in the console:

```
rxbqkbnr
pppppppp
xxnxxxxx
xxxxxxxx
xxxxxxPx
xxxxxxxx
PPPPPPxP
RNBQKBNR
```

**HINT**
We have not gotten to loops yet in this unit, it is okay to use 8 separate
System out messages.

## `coordinateToIndex(String coordinate)`

This first helper method is to allow us to map "chess coordinate notation" 
to the corresponding String index.

It takes a String as input and we expect the String to be of the form:
`xy` where:
 
 - `x` is a letter from a-h
 - `y` is a number from 1-8

![](https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/SCD_algebraic_notation.svg/1200px-SCD_algebraic_notation.svg.png)

```
NOTE: It is possible to test coordinates as they come in to make
sure they are in proper form. If the user types `fish` our application 
should detect this and warn the user. However, this is something we 
will be handling later in the program.
    - (Look up "regex" and "throwing exceptions").
```

**For this lesson we will assume all coordinates are in proper form**.

This method may be called with the string "e2". The method should
convert this String to the index 12.

#### Hints:

- `String.charAt(int index)` returns a character at a given string index.
    - You can typecast a `char` as an `int`.
    - `(int)'a' == 97`.
    - `(int)'1' == 49`.
    - Here's an [ASCII table](https://www.asciitable.com/)  to see what characters map to each value.
- Look how the index numbers change as you move up rows 1-8.
- Look how they change as you move down the columns a-h.

## `move(String from, String to)`    

This method takes two chess coordinate strings and moves the piece from the
`from` position, and moves it to the `to` position.

We are not worried about ensuring valid moves. (Let's assume an imaginary
coworker is tasked with coding the rules of the game).

When a piece is moved, it's position in the String is replaced with an `x`
character. Wherever the piece is moved to, it's character in the String is
replaced by the moved piece.

For example let's say we have this starting board state:

```
rnbqkbnr
pppppppp 
xxxxxxxx 
xxxxxxxx 
xxxxxxxx 
xxxxxxxx
PPPPPPPP  
RNBQKBNR 
```

The move method is called `move("e2", "e4")`. We should now see that the white
pawn on `e2` has "moved" to `e4`.

```
rnbqkbnr
pppppppp 
xxxxxxxx 
xxxxxxxx 
xxxxPxxx 
xxxxxxxx
PPPPxPPP  
RNBQKBNR 
```

**HINTS**
- You'll need to make use of the `coordinateToIndex` method you made.
- You can concatenate substrings to do the replacement.

### The project is complete when

You can make a few valid moves and get the correct board state after each move.
If you enter the following moves, you should see this board state:

- `e2` to `e4`
- `e7` to `e5`
- `f1` to `c4`
- `b8` to `c6`
- `d1` to `f3`
- `f8` to `c5`
- `f3` to `f7` checkmate

```
rxbqkxnr
ppppxQpp
xxnxxxxx
xxbxpxxx
xxBxPxxx
xxxxxxxx
PPPPxPPP
RNBxKxNR
```

![](lessonImages/scholarsmate.png)
