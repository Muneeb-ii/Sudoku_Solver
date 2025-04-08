/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class:
 * 
 */

public class Sudoku {
    
    private Board board;
    private LandscapeDisplay ld;
    private int delay;

    /**
     * Constructor for Sudoku with a random board
     * @param numLocked the number of locked cells
     * @param delay the delay in milliseconds
     */
    public Sudoku(int numLocked, int delay){
        board = new Board(numLocked);
        this.delay = delay;
        if(delay > 0){
            ld = new LandscapeDisplay(board);
        }
    }

    /**
     * Constructor for Sudoku using a text file
     * @param filename the name of the file containing the board
     * @param delay the delay in milliseconds
     */
    public Sudoku(String filename, int delay){
        board = new Board(filename);
        this.delay = delay;
        if(delay > 0){
            ld = new LandscapeDisplay(board);
        }
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
            if (board.validValue(cell.getRow(), cell.getCol(), i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Finds the next cell to fill in the Sudoku board
     * @return the cell with the next value, or null if no valid value is found
     */
    public Cell findNextCell() {
        // Iterate over all cells in row-column order
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.value(i, j) == 0) { // found an empty cell
                    int newValue = findNextValue(board.get(i, j));
                    if (newValue != 0) {
                        board.set(i, j, newValue);
                        return board.get(i, j);
                    } 
                    else {
                        return null; // No valid value found for this cell
                    }
                }
            }
        }
        return null; // No empty cells found
    }
    
    /**
     * Solves the Sudoku puzzle using backtracking
     * @return true if the puzzle is solved, false otherwise
     */
    public boolean solve(){
        LinkedList<Cell> stack = new LinkedList<Cell>();
        int unspecifiedCells=0;

        // Count the number of unspecified cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.value(i, j) == 0) {
                    unspecifiedCells++;
                }
            }
        }

        while (stack.size()<unspecifiedCells){
            // Control the speed of visualization
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            Cell next = findNextCell();

            while (next==null && stack.size()>0){
                Cell previous = stack.pop();
                // Update the cell's value by trying the next candidate
                int newValue = findNextValue(previous);
                // Update the cell accordingly
                previous.setValue(newValue);
                if (previous.getValue()!=0){
                    next = previous;
                }

            }

            if(next==null){
                board.isFinished(true);
                return false;
            }
            else {
                stack.push(next);
            }
        }

        board.isFinished(true);
        return true;
    }

    public static void main(String[] args) {
        Sudoku game =  new Sudoku(0,10);
        game.solve();
        System.out.println("Final (Solved) State: \n" + game.board.toString());

        Sudoku game2 = new Sudoku("board1.txt", 10);
        System.out.println("Initial State: \n" + game2.board.toString());
        game2.solve();
        System.out.println("Final (Solved) State: \n" + game2.board.toString());
    }
}

