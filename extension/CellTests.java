/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class: Test the Cell class
 * 
 * How to run: java -ea CellTests
 */

public class CellTests {
    /**
     * Test the Cell class
     * @return the score of the test
     */
    public static double cellTests() {
        double testScore = 0.0;

        // Test the constructor
        Cell cell = new Cell(1, 2, 3);
        Cell cell2 = new Cell(4, 5, 6, true);
        if (cell != null && cell2 != null) {
            testScore += 1.0;
        }
        assert cell != null && cell2 != null : "Constructor test failed";

        // Test the locked property
        if (!cell.isLocked() && cell2.isLocked()) {
            testScore += 1.0;
        }
        assert !cell.isLocked() && cell2.isLocked() : "Locked property test failed";

        // Test the getRow method
        if (cell.getRow() == 1 && cell2.getRow() == 4) {
            testScore += 1.0;
        }
        assert cell.getRow() == 1 && cell2.getRow() == 4 : "getRow test failed";

        // Test the getCol method
        if (cell.getCol() == 2 && cell2.getCol() == 5) {
            testScore += 1.0;
        }
        assert cell.getCol() == 2 && cell2.getCol() == 5 : "getCol test failed";

        // Test the getValue method
        if (cell.getValue() == 3 && cell2.getValue() == 6) {
            testScore += 1.0;
        }
        assert cell.getValue() == 3 && cell2.getValue() == 6 : "getValue test failed";

        // Test the setValue method
        cell.setValue(5);
        if (cell.getValue() == 5) {
            testScore += 1.0;
        }
        assert cell.getValue() == 5 : "setValue test failed";

        // Test the setLocked method
        cell.setLocked(true);
        cell2.setValue(2); // Attempt to set value when locked
        if (cell.isLocked() && cell2.getValue() == 6) {
            testScore += 1.0;
        }
        assert cell.isLocked() && cell2.getValue() == 6 : "setLocked test failed";

        // Test the toString method
        String expectedString = "Cell [rowIndex=1, columnIndex=2, value=5, locked=true]";
        if (cell.toString().equals(expectedString)) {
            testScore += 1.0;
        }
        assert cell.toString().equals(expectedString) : "toString test failed";

        return testScore;
    }

    public static void main(String[] args) {
        System.out.println(cellTests() + "/8.0");
    }
}
