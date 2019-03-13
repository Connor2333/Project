/*
	
	From Presentation:
	
		Readme file : Include rules and instructions on how to play the game. Please, submit the readme file in d2l.
			Done
			
		Code base:  Fix the errors in the console based version of your project. Code needs to be documented (javadoc). 
			Not Done
			
		Class Diagram: Include all the classes and relationships that you are going to use for the next demo.
			Not Done
				
		OO design : Your code must have to be Object Oriented for the next demo.
			Not done
			
	To Do before 5pm, March 13:
	
		Implement GUI board board and checkers that can be interacted with -    Mischa
			Not Done
		
		For the console based version, if wrong coordinates are entered, display the board again. (Just in case GUI 
		doesn't function as intended, but not a priority)  
			Not Done
	
		Split into multiple classes to make it more object oriented  --Folahan
		(use this site for simple explanation of concept, it helped me out: 
		https://medium.freecodecamp.org/object-oriented-programming-concepts-21bb035f7260)
			Not Yet Done
		
		Finish implementing all checkers rules         --Connor
		
			- Once a checker reaches the opposite side of board, it may move forwards or backwards
			  currently all checkers can only move forward
				Not Done
				//3.7 21:48 update
					I guess I found the soloution for reversing a checker. but it is uncertain if it is work or not
					Alogrithm: once a checker can update to "king", the y-coordinate should be 8(for black) 
						   or 1(for red). When a checker reach the end, the variable "detKing" will 
						   equal true and this checker can move in reverse.
					problem: I am trying to convert current code to Object-orinated type because normal checkers 
						 and "king" checkers can exist at same time.Diffierent checkers have diffierent 
						 properties.
					the code below the comments is not updated. I need some implements on the code.
			
			- Update code to stop the game if one team has no more valid moves
				Not Done
				//3.7 21:48 update 
					For this problem, I cannot find the soloution of this. but I think if we solve the problem above
					(checkers move backward), the situation of no valid moves will not exist. Just a guess.  cannot 
					imagine the no valid move situation. 
					In alternate way, how about add button to stop or restart or concede the game?  
				
			- Don't allow the user to select a blank space
				Not Done
				//3.7 21:48 update 
					If we regard the checkers as a button,this problem will be solved because there is no actions 
					once mouse click on the background.
					
			
			
		Cite all sources
			Done
		
	

*/

/**
* A lot of this initial code comes from 
* http://www.cs.ucf.edu/~dmarino/ucf/java/Checkers.java
*/
import java.io.*;
import java.util.*;

public class Checkers {

    private final static int SIZE = 8;
    private char[][] board; // Stores the checkerboard, with chars 'r','b','_'
    private int redcheckers; // Number of red checkers on the board
    private int blackcheckers; // Number of black checkers on the board
    private char whosemove; // Either 'r' or 'b', for who's move it currently is.

    // Constructs default Checkers object, initializing board to starting
    // playing position.
    public Checkers() {
	
	board = new char[SIZE][SIZE]; // creates an 8x8 board
	redcheckers = 12;
	blackcheckers = 12;
	whosemove = 'r'; // red starts

	// Initialize board with all the red and black checkers in starting
	// positions.
	int x,y;
	for (x=0;x<SIZE;x++)
	    for (y=0;y<SIZE;y++)
		board[x][y] = '_';

	for (x=1;x<SIZE;x+=2) {	// puts a checker on every second space
	    board[x][1] = 'r';
	    board[x][5] = 'b';
	    board[x][7] = 'b';
	}
	for (x=0;x<SIZE;x+=2) {
	    board[x][0] = 'r';
	    board[x][2] = 'r';
	    board[x][6] = 'b';
	}
    }

    // Print out the checkerboard, by looping through all board positions in
    // appropriate order.
    public void printBoard() {
	int x,y;
	System.out.println("  1 2 3 4 5 6 7 8 x");
	for (x=0;x<SIZE;x++) {
	    System.out.print((x+1) + " ");
	    for (y=0;y<SIZE;y++) {
		System.out.print(board[y][x] + " ");
	    }
	    System.out.println();
	}
	System.out.println("y");
    }

    // This method executes one move.
    public void getNextMove() throws IOException {
	
	Scanner stdin = new Scanner(System.in);

	if (whosemove=='r')
	    System.out.println("It is your turn, red.");
	else
	    System.out.println("It is your turn, black.");

	boolean moved = false;
	// Loops until legal move is entered.
	while (!moved) {
	    // Reads in square to move from and to.
	    System.out.println("Enter from the square you would like to move from.");
	    System.out.print("Enter as a 2-digit number. (e.g. if you were moving from");
	    System.out.println(" x=1,y=3, enter 13");
	    int movefrom = stdin.nextInt();

	    System.out.print("Enter from the square you would like to move to, ");
	    System.out.println("using the same convention.");
	    int moveto = stdin.nextInt();

	    // Checks to see if move is valid, if so, executes it.
	    if (validMove(movefrom,moveto)) {
		executeMove(movefrom,moveto);
		moved = true;
	    }
	    else
		System.out.println("That was an invalid move, try again.");
	}

	// Update whosemove it is.
	if (whosemove == 'r')
	    whosemove = 'b';
	else
	    whosemove = 'r';
    }

    // Checks if a move is valid.
    public boolean validMove(int movefrom, int moveto) {

	// Gets array indeces corresponding to the move, from parameters.
	int xfrom = movefrom/10 - 1;
	int yfrom = movefrom%10 - 1;
	int xto = moveto/10 - 1;
	int yto = moveto%10 - 1;
	
	// Check if indeces in range, if not, return false.
	if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
	    xto < 0 || xto > 7 || yto < 0 || yto > 7) 
	    return false;

	// Check to see you are moving your piece to a blank square.
	else if (board[xfrom][yfrom]==whosemove && board[xto][yto]=='_') {

	    // Checks case of simple move
	    if (Math.abs(xfrom-xto)==1) {
		if ((whosemove == 'r') && (yto - yfrom == 1))
		    return true;
		else if ((whosemove == 'b') && (yto - yfrom == -1))
		    return true;
	    }
	    
	    // Checks case of a jump
	    else if (Math.abs(xfrom-xto)==2) {
		if (whosemove == 'r' && (yto - yfrom == 2) && 
		    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'b')
		    return true;
		else if (whosemove == 'b' && (yto - yfrom == -2) && 
		    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'r')
		    return true;
	    }
	}
	// If move is neither a simple one or a jump, it is not legal.
	return false;
    }

    // Executes a move.
    public void executeMove(int movefrom, int moveto) {
	// Gets array indeces corresponding to the move, from parameters.
	int xfrom = movefrom/10 - 1;
	int yfrom = movefrom%10 - 1;
	int xto = moveto/10 - 1;
	int yto = moveto%10 - 1;
	
	// Change appropriate board elements and decrement redcheckers or
	// blackcheckers if necessary.
	board[xfrom][yfrom] = '_';
	board[xto][yto] = whosemove;
	if (Math.abs(xto - xfrom) == 2) {
	    board[(xfrom+xto)/2][(yfrom+yto)/2] = '_';
	    if (whosemove == 'r')
		redcheckers--;
	    else
		blackcheckers--;
	}

    }

    // Checks to see if game is over based on number of checkers left.
    public boolean gameOver() {
	return (redcheckers == 0 || blackcheckers == 0);
    }

    // Returns color of the winner.
    public String winnerIs() {
	if (blackcheckers == 0)
	    return "red";
	else
	    return "black";
    }

    public static void main(String args[]) throws IOException {

	// Setup and print out checker board.
	Checkers game = new Checkers();
	game.printBoard();
	
	// Loop until game is over. Currently an infinite loop until all checkers of one colour are removed
	while (!game.gameOver()) {
	    //Execute a move and print the board out afterwards.
	    game.getNextMove();
	    game.printBoard();
	}
	// Announce winner.
	System.out.println("The winner is " + game.winnerIs());
    }
}