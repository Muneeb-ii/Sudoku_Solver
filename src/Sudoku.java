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

    /**
     * Solves the Sudoku puzzle using backtracking
     * @return true if the puzzle is solved, false otherwise
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the value of the cell if it is valid, 0 otherwise
     */
    public int findNextValue(Cell cell) {
        for (int i = cell.getValue()+1; i <= 9; i++) {
            if (board.validValue(cell.getCol(), cell.getRow(), i)) {
                return i;
            }
        }
        return 0;
    }
}

