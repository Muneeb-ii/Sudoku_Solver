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

    public Sudoku(int numLocked, int delay){
        board = new Board(numLocked);
        this.delay = delay;
        display = new LandscapeDisplay(board);
    }
}
