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

    /**
     * Returns the row index of the cell
     * @return the row index of the cell
     */
    public int getRow(){
        return rowIndex;
    }

    /**
     * Returns the column index of the cell
     * @return the column index of the cell
     */
    public int getCol(){
        return columnIndex;
    }

    /**
     * Returns the value of the cell
     * @return the value of the cell
     */
    public int getValue(){
        return value;
    }

    /**
     * Sets the value of the cell if it is not locked
     * @param newVal the new value of the cell
     */
    public void setValue(int newVal){
        if(!locked){
            this.value = newVal;
        }
        else{
            System.out.println("Cell is locked. Cannot change value.");
        }
    }

    /**
     * Returns whether the cell is locked or not
     * @return true if the cell is locked, false otherwise
     */
    public boolean isLocked(){
        return locked;
    }

    /**
     * Sets the locked status of the cell
     * @param locked the new locked status of the cell
     */
    public void setLocked(boolean locked){
        this.locked = locked;
    }
}