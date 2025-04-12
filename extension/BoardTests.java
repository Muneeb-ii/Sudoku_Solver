/**
 * Author : Muneeb Azfar Nafees
 * 
 * Purpose of class: Test the Board class
 * 
 * How to run: java -ea BoardTests
 */

public class BoardTests {
    
    public static void main(String[] args) {
        System.out.println("All Board tests passed! Score: " + testBoard() + "/14");
    }

    public static int testBoard() {
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

        // Test isLocked(int, int)
        assert board.isLocked(1, 1) == true : "isLocked method at (1,1) should return true";
        assert board.isLocked(0, 0) == false : "isLocked method at (0,0) should return false";
        score += 1;

        // Test toString method: first row should start with "5 0 0 0 0 0 0 0 0 \n"
        String boardStr = board.toString();
        String expectedRow0 = "5 0 0 0 0 0 0 0 0 \n";
        assert boardStr.startsWith(expectedRow0) : "toString output is not as expected for the first row.";
        score += 1;

        // Test readFile method
        Board fileBoard = new Board("board1.txt");
        assert fileBoard.get(0, 3).getValue() == 3 : "Cell (0,3) value should be 3 from file";
        assert fileBoard.get(0, 3).isLocked() == true : "Cell (0,3) should be locked from file";
        score += 1;

        // Test validSolution method
        Board validBoard = new Board("validBoard.txt");
        assert validBoard.validSolution() == true : "validSolution should return true for a valid board";
        Board invalidBoard = new Board("board1.txt");
        assert invalidBoard.validSolution() == false : "validSolution should return false for an invalid board";
        score += 1;

        // Test auxiliary constructor
        Board auxBoard = new Board(5);
        assert auxBoard.numLocked() == 5 : "Auxiliary board should have 5 locked cells";
        score += 1;

        return score;
    }
}
