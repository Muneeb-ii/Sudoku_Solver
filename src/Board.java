/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class:
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
    public Board (String filename){
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
    public boolean isLockecd(int row, int col){
        return board[row][col].isLocked();
    }

}
