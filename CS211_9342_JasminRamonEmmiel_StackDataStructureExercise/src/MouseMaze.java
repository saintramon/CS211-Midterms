/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 13 September 2023
 *
 * Mouse Maze Puzzle
 *
 * GENERAL ALGORITHM
 * 1. Create a maze called myMaze and instantiate it ith a sample maze
 * 2. In its constructor, find the entry and exit cell
 * 3. Traverse the entire maze and mark '.' the visited cells using a Stack data structure.
 * 4. Display the current state of the maze until the exit is found
 * 5. Prompt the user that the exit is found.
 */

import java.io.*;
import java.lang.*;
import java.util.Stack;
import java.util.Scanner;

public class MouseMaze {
    private char[][] myMaze = {
            {'1','1','1','1','1','1'},
            {'1','1','0','0','E','1'},
            {'1','0','0','1','1','1'},
            {'1','0','0','0','0','1'},
            {'1','1','0','0','M','1'},
            {'1','0','1','1','1','1'}
    };

    private int rows = myMaze.length;
    private int cols = myMaze[0].length;
    private MazeCell currentCell = null;
    private MazeCell exitCell = new MazeCell();
    private MazeCell entryCell = new MazeCell();

    private final char EXIT_MARKER = 'E';
    private final char ENTRY_MARKER = 'M';
    private final char VISITED = '.';
    private final char PASSAGE = '0';
    private final char WALL = '1';

    private Stack<MazeCell> mazeStack = new Stack<MazeCell>();

    private FileReader fileReader;
    private BufferedReader bufferReader;
    private Scanner keyboard = new Scanner(System.in);

    /**
     * CONSTRUCTOR
     * 1. Create a foundEntryCell and foundExitCell variables and instantiate it to false.
     * 2. Using a nested for loop, visit each cell and find the 'M'. If found, set the corresponding row and column of the entryCell.
     * 3. Using a nested for loop, visit each cell and compare if the current cell is 'E'. If found, set the corresponding row and column of the exitCell.
     */
    public MouseMaze(){
        boolean foundEntryCell = false;
        boolean foundExitCell = false;

        for (int row = 0; row < myMaze.length && !foundEntryCell; row++){
            for (int col = 0; col < myMaze[row].length && !foundEntryCell; col++){
                if (myMaze[row][col] == 'M'){
                    entryCell.setRow(row);
                    entryCell.setColumn(col);
                    foundEntryCell = true;
                }
            }
        }

        for (int row = 0; row<myMaze.length && !foundExitCell; row++){
            for (int col = 0; col<myMaze[row].length && !foundExitCell; col++){
                if (myMaze[row][col] == 'E'){
                    exitCell.setRow(row);
                    exitCell.setColumn(col);
                    foundExitCell = true;
                }
            }
        }
    }

    /**
     * 1. Create the first loop which will handle the case for rows.
     * 2. Create an inner loop which will hande the case for the columns.
     * 3. Let the first row run until it is in the last row.
     * 4. Let the inner loop run until the counter is in the last element of the current row
     * 5. In every pass, print the current element.
     * @param myMaze
     */
    private void display(char[][] myMaze){
        for (int row = 0; row<myMaze.length; row++){
            for (int col = 0; col < myMaze[row].length; col++){
                System.out.print(myMaze[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 1. Initialize the row and column variables to 0
     * 2. Set the entryCell to a new variable called current cell
     * 3. Display the maze and ask the user to press enter
     * 4. While the current cell is not the exit cell:
     * 4.1 Mark the currentCell as visited.
     * 4.2 Call the pushUnvisited method 4 times in corresponding to the 4 cells surrounding the current cell
     * 4.3 If the while loop runs until the stack became empty, prompt that the exit cannot be found
     * 4.4 If the cell is the exit cell, prompt that the solving of the maze is a success
     * @throws IOException
     */
    private void findWayOut() throws IOException{
        int row = 0;
        int col = 0;

        currentCell = entryCell;
        System.out.println();
        display(myMaze);

        System.out.println("");
        System.out.println("The above figure shows a maze where a mouse M is in.");
        System.out.println("The Mouse M should move to exhaustively find the Exit cell E");
        System.out.println("A cell marked 0 is an open cell, a cell marked by 1 is a closed cell");
        System.out.println("Keep pressing the enter key until success or failure is reached.");
        System.out.println("Find the way out.");
        keyboard.nextLine();

        while (!currentCell.equals(exitCell)){
            row = currentCell.getRow();
            col = currentCell.getColumn();

            if (currentCell.sameAs(exitCell)){
                display(myMaze);
                System.out.println("Success! Exit found");
                break;
            }

            if (!currentCell.sameAs(entryCell)){
                myMaze[row][col] = VISITED;
                display(myMaze);
                System.out.println("Find the way out.");
                keyboard.nextLine();
            }

            pushUnvisited(row - 1, col);
            pushUnvisited(row + 1, col);
            pushUnvisited(row, col - 1);
            pushUnvisited(row,col+1);

            if (mazeStack.isEmpty()){
                display(myMaze);
                System.out.println("Failure: Exit cannot be reached");
            }else {
                currentCell = (MazeCell) mazeStack.pop();
            }
        }
    }

    /**
     * 1. If the passed element is a PASSAGE or it is the exit point
     * 1.1 Push the current cell into the stack
     * @param row
     * @param col
     */
    public void pushUnvisited(int row, int col){
        if (myMaze[row][col] == PASSAGE || myMaze[row][col] == EXIT_MARKER){
            mazeStack.push(new MazeCell(row,col));
        }
    }

    public static void main(String[] args) {
        try {
            MouseMaze solver = new MouseMaze();
            solver.findWayOut();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}
