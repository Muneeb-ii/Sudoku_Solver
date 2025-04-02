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
        if (cell.getRow() == 1 && cell.getCol() == 2 && cell.getValue() == 3) {
            testScore += 1.0;
        }

        // Test the locked property
        if (!cell.isLocked()) {
            testScore += 1.0;
        }

        // Test the locked property with a locked cell
        Cell lockedCell = new Cell(1, 2, 3, true);
        if (lockedCell.isLocked()) {
            testScore += 1.0;
        }

        return testScore;
    }

    public static void main(String[] args) {
        System.out.println(cellTests() + "/3");
    }
}
