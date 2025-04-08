/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class: Test the Cell class
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
        if (cell != null) {
            testScore += 1.0;
        }
        else {
            System.out.println("Constructor test failed");
        }

        // Test the locked property
        if (!cell.isLocked()) {
            testScore += 1.0;
        }
        else {
            System.out.println("Locked property test failed");
        }

        // Test the getRow method
        if (cell.getRow() == 1) {
            testScore += 1.0;
        }
        else {
            System.out.println("getRow test failed");
        }

        // Test the getCol method
        if (cell.getCol() == 2) {
            testScore += 1.0;
        }
        else {
            System.out.println("getCol test failed");
        }

        // Test the getValue method
        if (cell.getValue() == 3) {
            testScore += 1.0;
        }
        else {
            System.out.println("getValue test failed");
        }

        // Test the setValue method
        cell.setValue(5);
        if (cell.getValue() == 5) {
            testScore += 1.0;
        }
        else {
            System.out.println("setValue test failed");
        }

        // Test the setLocked method
        cell.setLocked(true);
        if (cell.isLocked()) {
            testScore += 1.0;
        }
        else {
            System.out.println("setLocked test failed");
        }

        // Test the toString method
        String expectedString = "Cell [rowIndex=1, columnIndex=2, value=5, locked=true]";
        if (cell.toString().equals(expectedString)) {
            testScore += 1.0;
        }
        else {
            System.out.println("toString test failed");
        }

        return testScore;
    }

    public static void main(String[] args) {
        System.out.println(cellTests() + "/8.0");
    }
}
