/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class:
 * 
 */

public class Cell{
    
    private int rowIndex;
    private int columnIndex;
    private int value;
    private boolean locked;

    /**
     * Constructor for Cell
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the value of the cell
     */
    public Cell(int row, int col, int value){
        this.rowIndex = row;
        this.columnIndex = col;
        this.value = value;
        this.locked = false;
    }

    /**
     * Constructor for Cell
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the value of the cell
     * @param locked whether the cell is locked or not
     */
    public Cell(int row, int col, int value, boolean locked){
        this.rowIndex = row;
        this.columnIndex = col;
        this.value = value;
        this.locked = locked;
    }
}