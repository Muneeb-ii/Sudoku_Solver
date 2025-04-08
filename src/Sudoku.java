/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class:
 * 
 */

public class Sudoku {
    
    private Board board;
    private LandscapeDisplay display;
    private int delay;

    /**
     * Constructor for Sudoku with a random board
     * @param numLocked the number of locked cells
     * @param delay the delay in milliseconds
     */
    public Sudoku(int numLocked, int delay){
        board = new Board(numLocked);
        this.delay = delay;
        display = new LandscapeDisplay(board);
    }

    /**
     * Constructor for Sudoku using a text file
     * @param filename the name of the file containing the board
     * @param delay the delay in milliseconds
     */
    public Sudoku(String filename, int delay){
        board = new Board(filename);
        this.delay = delay;
        display = new LandscapeDisplay(board);
    }
}
