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
        assert cell != null && cell2 != null : "Constructor test failed";
        testScore += 1.0;

        // Test the locked property
        assert !cell.isLocked() && cell2.isLocked() : "Locked property test failed";
        testScore += 1.0;

        // Test the getRow method
        assert cell.getRow() == 1 && cell2.getRow() == 4 : "getRow test failed";
        testScore += 1.0;

        // Test the getCol method
        assert cell.getCol() == 2 && cell2.getCol() == 5 : "getCol test failed";
        testScore += 1.0;

        // Test the getValue method
        assert cell.getValue() == 3 && cell2.getValue() == 6 : "getValue test failed";
        testScore += 1.0;

        // Test the setValue method
        cell.setValue(5);
        assert cell.getValue() == 5 : "setValue test failed";
        testScore += 1.0;

        // Test the setLocked method
        cell.setLocked(true);
        cell2.setValue(2); // Attempt to set value when locked
        assert cell.isLocked() && cell2.getValue() == 6 : "setLocked test failed";
        testScore += 1.0;

        // Test the toString method
        String expectedString = "Cell [rowIndex=1, columnIndex=2, value=5, locked=true]";
        assert cell.toString().equals(expectedString) : "toString test failed";
        testScore += 1.0;

        return testScore;
    }

    public static void main(String[] args) {
        System.out.println(cellTests() + "/8.0");
    }
}
