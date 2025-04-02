/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class:
 * 
 */

public class Board {
    
    private Cell[][] board;

    /**
     * Constructor for Board: creates a 9x9 board of cells and initializes them with value 0
     */
    public void Board(){
        board = new Cell[9][9]; // 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new Cell(i, j, 0); // Initialize cells with value 0
            }
        }
    }

    /**
     * Returns the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     */
    public Cell get(int row, int col){
        return board[row][col];
    }
}
