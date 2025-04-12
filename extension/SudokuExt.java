/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Solve a Sudoku puzzle using backtracking algorithm
 * 
 */

public class SudokuExt {
    
    private Board board;
    private LandscapeDisplay ld;
    private int delay;

    /**
     * Constructor for Sudoku with a random board
     * @param numLocked the number of locked cells
     * @param delay the delay in milliseconds
     */
    public SudokuExt(int numLocked, int delay){
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
    public SudokuExt(String filename, int delay){
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
     * Finds the next cell to fill using the minimum remaining values heuristic.
     * It looks for the empty cell (value 0) that has the fewest valid candidate values.
     * If a valid candidate is found using findNextValue, the cell is updated and returned.
     * If no valid candidate exists for that cell, returns null.
     *
     * @return the cell with the next value or null if no valid cell is found.
     */
    public Cell findNextCell2() {
        Cell bestCell = null;
        int bestCandidateCount = 10; // since maximum candidates is 9
        
        // Loop over all cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.value(i, j) == 0) {  // For each empty cell
                    int candidateCount = countCandidates(i, j);
                    if (candidateCount < bestCandidateCount) {
                        bestCandidateCount = candidateCount;
                        bestCell = board.get(i, j);
                    }
                }
            }
        }
        
        // If no empty cell is found, return null
        if (bestCell == null) {
            return null;
        }
        
        // Try to get the next valid candidate for this cell.
        int candidate = findNextValue(bestCell);
        if (candidate != 0) {
            board.set(bestCell.getRow(), bestCell.getCol(), candidate);
            return board.get(bestCell.getRow(), bestCell.getCol());
        }
        
        return null;
    }

    /**
     * Helper method to count the number of valid candidates for the cell at (row, col).
     * Iterates through values 1 to 9 and checks if they are valid at this position.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The count of candidate values.
     */
    private int countCandidates(int row, int col) {
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            if (board.validValue(row, col, i)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Solves the Sudoku puzzle using backtracking
     * @return true if the puzzle is solved, false otherwise
     */
    public boolean solve(){
        LinkedList<Cell> stack = new LinkedList<>();
        int unspecifiedCells=0;
        int iterations = 0;

        // Count the number of unspecified cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.value(i, j) == 0) {
                    unspecifiedCells++;
                }
            }
        }
        
        while (stack.size() < unspecifiedCells){ // Count the number of unspecified cells
            // Control the speed of visualization
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } 
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                ld.repaint();
            }
            Cell next = findNextCell();

            while (next==null && !stack.isEmpty()){
                Cell previous = stack.pop();
                // Update the cell's value by trying the next candidate
                int newValue = findNextValue(previous);
                // Update the cell accordingly
                previous.setValue(newValue);
                if (previous.getValue()!=0){
                    next = previous;
                }
                iterations++;
                if (iterations>100000000) {
                    board.setFinished(true);
                    return true;
                }

            }

            if(next==null){
                board.setFinished(true);
                return false;
            }
            else {
                stack.push(next);
            }
        }
        board.setFinished(true);
        return true;
    }

    /**
     * Solves the Sudoku puzzle using backtracking
     * @return true if the puzzle is solved, false otherwise
     */
    public boolean solve2(){
        LinkedList<Cell> stack = new LinkedList<>();
        int unspecifiedCells=0;
        int iterations = 0;

        // Count the number of unspecified cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.value(i, j) == 0) {
                    unspecifiedCells++;
                }
            }
        }
        
        while (stack.size() < unspecifiedCells){ // Count the number of unspecified cells
            // Control the speed of visualization
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } 
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                ld.repaint();
            }
            Cell next = findNextCell2();

            while (next==null && !stack.isEmpty()){
                Cell previous = stack.pop();
                // Update the cell's value by trying the next candidate
                int newValue = findNextValue(previous);
                // Update the cell accordingly
                previous.setValue(newValue);
                if (previous.getValue()!=0){
                    next = previous;
                }
                iterations++;
                if (iterations>100000000) {
                    board.setFinished(true);
                    return true;
                }

            }

            if(next==null){
                board.setFinished(true);
                return false;
            }
            else {
                stack.push(next);
            }
        }
        board.setFinished(true);
        return true;
    }

    public static void main(String[] args) {
        SudokuExt game =  new SudokuExt(0,10);
        System.out.println("Initial State: \n" + game.board.toString());
        game.solve();
        System.out.println("Final (Solved) State: \n" + game.board.toString());
    }
}

