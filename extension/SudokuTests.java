/*
file name:      SudokuTests.java
Authors:        Max Bender and Ike Lage 
modified:       Muneeb Azfar Nafees
last modified:  04/08/2025

How to run:     java -ea SudokuTests
*/

public class SudokuTests {

    /**
    * Stack Tests
    */
    public static double sudokuTests() {

        double testScore = 0. ;

        /**
        * Solve Blank Board using brute force
        */
        Sudoku game = new Sudoku( 0 , 0 ) ;
        assert game.solve() == true : "Blank board not solving using brute force (solve)" ;
        testScore += 2;

        /**
        * Solve a Board with a small number of elements using brute force
        */
        Sudoku game1 = new Sudoku( 5 , 0 ) ;
        assert game1.solve() == true : "5-element board not solving brute force (solve)" ;
        testScore += 2;

        /**
        * Solve a Board with a more elements using brute force
        */
        System.out.println( "If your program hangs here, you have an error with the board auxilary constructor");
        Sudoku game2 = new Sudoku( 40 , 0 ) ;
        System.out.println( "Your program isn't hanging, disregard the note above" );
        System.out.println( "If your program hangs here, you have an error within the solve method" );
        game2.solve() ;
        System.out.println( "Your program isn't hanging, disregard the note above" );
        testScore += 2;

        /**
        * Solve Blank Board using MRV heuristic
        */
        Sudoku game3 = new Sudoku( 0 , 0 ) ;
        assert game3.solve2() == true : "Blank board not solving using MRV heuristic (solve2)" ;
        testScore += 2;

        /**
        * Solve a Board with a small number of elements using MRV heuristic
        */
        Sudoku game4 = new Sudoku( 5 , 0 ) ;
        assert game4.solve2() == true : "5-element board not solving using MRV heuristic (solve2)" ;
        testScore += 2;

        /**
        * Solve a Board with a more elements using MRV heuristic
        */
        System.out.println( "If your program hangs here, you have an error with the board auxilary constructor");
        Sudoku game5 = new Sudoku( 40 , 0 ) ;
        System.out.println( "Your program isn't hanging, disregard the note above" );
        System.out.println( "If your program hangs here, you have an error" );
        game5.solve2() ;
        System.out.println( "Your program isn't hanging, disregard the note above" );
        testScore += 2;

        return testScore ;
    }

    public static void main(String[] args) {
        System.out.println( sudokuTests() + "/12" );
    }

}