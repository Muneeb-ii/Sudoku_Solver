/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class: Board class for a Sudoku game that represents a 9x9 grid of cells.
 * 
 */

import java.io.*;

public class Board {
    
    private Cell[][] board;

    /**
     * Constructor for Board: creates a 9x9 board of cells and initializes them with value 0
     */
    public Board(){
        board = new Cell[9][9]; // 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new Cell(i, j, 0); // Initialize cells with value 0
            }
        }
    }

    /**
     * Auxiliary Constructor for Board: creates a 9x9 board of cells and initializes them with value 0
     * @param filename the name of the file to read
     */
    public Board(String filename){
        // Call the default constructor to initialize the board
        this(); 
        // Read the file and set the values of the cells
        read(filename); 
    }

    /**
     * Returns the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     */
    public Cell get(int row, int col){
        return board[row][col];
    }

    /**
     * Sets the value of the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the value to set
     */
    public void set(int row, int col, int value){
        board[row][col].setValue(value);
    }

    /**
     * Sets the locked property of the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param locked whether the cell is locked or not
     */
    public void set(int row, int col, boolean locked){
        board[row][col].setLocked(locked);
    }

    /**
     * Sets the value and locked property of the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the value to set
     * @param locked whether the cell is locked or not
     */
    public void set(int row, int col, int value, boolean locked){
        board[row][col].setValue(value);
        board[row][col].setLocked(locked);
    }

    /**
     * Reads a file and sets the values of the cells in the board accordingly
     * @param filename the name of the file to read
     * @return true if the file was read successfully, false otherwise
     */
    public boolean read(String filename) {
        try {
            // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
            FileReader fr = new FileReader(filename);
            // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
            BufferedReader br = new BufferedReader(fr);
            
            // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
            String line = br.readLine();
            // start a while loop that loops while line isn't null
            int j = 0;
            while(line != null){
                // assign to an array of Strings the result of splitting the line up by spaces (line.split("[ ]+"))
                String[] arr = line.split( "[ ]+" );
                // use the line to set various Cells of this Board accordingly
                for(int i = 0; i < arr.length; i++) {
                    // set the value of the cell at row j and column i to the value in arr[i]
                    board[j][i].setValue( Integer.parseInt(arr[i]) );
                }
                // assign to line the result of calling the readLine method of your BufferedReader object.
                line = br.readLine();
                j++;
            }
            // call the close method of the BufferedReader
            br.close();
            return true;
        }
        catch(FileNotFoundException ex) {
          System.out.println("Board.read():: unable to open file " + filename );
        }
        catch(IOException ex) {
          System.out.println("Board.read():: error reading file " + filename);
        }

        return false;
    }

    /**
     * Prints the board to the console
     * @return a string representation of the board
     */
    public String toString() {
        String stringRep = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringRep = stringRep + board[i][j].getValue() + " ";
            }
            stringRep = stringRep + "\n";
        }
        return stringRep;
    }

    /**
     * Returns the number of columns in the board
     * @return the number of columns in the board
     */
    public int getCols(){
        return board[0].length;
    }

    /**
     * Returns the number of rows in the board
     * @return the number of rows in the board
     */
    public int getRows(){
        return board.length;
    }

    /**
     * Returns whether the cell at the given row and column is locked or not
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return true if the cell is locked, false otherwise
     */
    public boolean isLocked(int row, int col){
        return board[row][col].isLocked();
    }

    /**
     * Returns the number of locked cells in the board
     * @return the number of locked cells in the board
     */
    public int numLocked(){
        int count = 0;
        for(int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if(board[i][j].isLocked()){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Returns the value of the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the value of the cell at the given row and column
     */
    public int value(int row, int col){
        return board[row][col].getValue();
    }

    /**
     * Checks if the given value is valid for the cell at the given row and column
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the value to check
     * @return true if the value is valid, false otherwise
     */
    public boolean validValue(int row, int col, int value){
        // Check if the value is between 1 and 9
        if (value<1 || value>9){
            return false;
        }
        
        // Check if the cell if the value is already in the row or column
        for(int i = 0; i<9; i++){
            if(board[row][i].getValue()==value && i!=col){
                return false;
            }
        }
        for(int i = 0; i<9; i++){
            if(board[i][col].getValue()==value && i!=row){
                return false;
            }
        }

        int localRow = row/3; // use integer division to get the local row (0, 1, or 2)
        int localCol = col/3; // use integer division to get the local column (0, 1, or 2)

        // Check if the value is already in the 3x3 box
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int curRow = i + (3 * localRow);
                int curCol = j + (3 * localCol);
                // Skip the candidate cell
                if (curRow == row && curCol == col) {
                    continue;
                }
                if (board[curRow][curCol].getValue() == value) {
                    return false;
                }
            }
}
        return true;
    }

    /*
     * Added main method to run tests for Board class methods (except read method).
     * The tests use assert statements and sums a score as follows:
     *  - getRows() and getCols() (2 points)
     *  - Default board initialization (2 points)
     *  - set(int, int, int) (1 point)
     *  - set(int, int, boolean) and isLockecd() (2 points)
     *  - set(int, int, int, boolean) (1 point)
     *  - numLocked() (1 point)
     *  - value(int, int) (1 point)
     *  - toString() (1 point)
     * Total expected score: 10
     */

    public static void main(String[] args) {
        int score = 0;

        // Test Board constructor and getRows, getCols
        Board board = new Board();
        assert board.getRows() == 9 : "getRows should return 9";
        assert board.getCols() == 9 : "getCols should return 9";
        score += 2;

        // Test default values in board
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                assert board.get(i, j).getValue() == 0 : "Cell at (" + i + "," + j + ") should be 0";
                assert board.get(i, j).isLocked() == false : "Cell at (" + i + "," + j + ") should not be locked";
            }
        }
        score += 2;

        // Test set(int, int, int)
        board.set(0, 0, 5);
        assert board.get(0, 0).getValue() == 5 : "Cell (0,0) value should be 5";
        score += 1;

        // Test set(int, int, boolean) and isLocked 
        board.set(1, 1, true);
        assert board.get(1, 1).isLocked() == true : "Cell (1,1) should be locked";
        assert board.isLocked(1, 1) == true : "isLocked method should return true for a locked cell";
        score += 1;

        // Test set(int, int, int, boolean)
        board.set(2, 2, 7, true);
        assert board.get(2, 2).getValue() == 7 : "Cell (2,2) value should be 7";
        assert board.get(2, 2).isLocked() == true : "Cell (2,2) should be locked";
        score += 1;

        // Test numLocked method
        int numLocked = board.numLocked();
        assert numLocked == 2 : "numLocked should return 2";
        score += 1;

        // Test value(int, int)
        assert board.value(0, 0) == 5 : "value method at (0,0) should be 5";
        score += 1;

        // Test toString method: first row should start with "5 0 0 0 0 0 0 0 0 \n"
        String boardStr = board.toString();
        String expectedRow0 = "5 0 0 0 0 0 0 0 0 \n";
        assert boardStr.startsWith(expectedRow0) : "toString output is not as expected for the first row.";
        score += 1;

        System.out.println("All Board tests passed! Score: " + score + "/10");
    }
}
