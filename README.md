# Sudoku_Solver

## Project Overview

This project provides a complete implementation of a Sudoku solver in Java. The solver utilizes a stack-based backtracking algorithm to fill in a 9x9 Sudoku board. In addition to a basic brute force approach, the project extends the solver with an advanced cell-selection method that uses the Minimum Remaining Values (MRV) heuristic combined with the Degree heuristic. This extension aims to improve performance by focusing on the most constrained cells first.

## Core Features

- **Sudoku Board Representation:**
  - The board is modeled as a 9x9 grid of cells, where each cell holds its value and a locked status.
  - The project includes methods to initialize the board (both from a file and by randomly locking cells), validate moves, and check for a complete and valid solution.
- **Solver Implementations:**
  - **Basic Brute Force Solver (`solve()`):**  
    Uses a simple row–major order scan to select the first empty cell and applies recursive backtracking to fill the board.
  - **Advanced MRV+Degree Solver (`solve3()`):**  
    Enhances the cell-selection process by choosing the empty cell with the fewest valid candidate values (MRV), breaking ties by selecting the cell with the highest number of neighboring empty cells (Degree heuristic). This method is expected to reduce the search space and backtracking overhead on more constrained boards.
- **Visualization:**
  - A Swing-based graphical display (via the `LandscapeDisplay` class) renders the board, including a grid with bold 3x3 subgrid lines, to provide visual feedback during solving.
  - Locked cells are displayed in blue and cells being solved in red.
- **Simulation and Testing:**
  - The project includes robust tester files (e.g., `CellTests.java`, `BoardTests.java`, and `SudokuTests.java`) that verify individual methods as well as overall solver functionality.
  - A simulation framework runs extensive experiments to study the impact of varying numbers of pre-filled cells on solution likelihood and solving time.
  - Multiple experiments compare the performance of the basic brute force method with the MRV+Degree heuristic extension.

## Experiments

The project includes automated experiments to answer key questions:

1. **Likelihood of Finding a Solution:**  
   By running simulations with 0 to 40 randomly locked cells (50 tests per configuration), the effect of initial constraints on the solver’s success rate is measured.
2. **Solving Time Analysis:**  
   The simulation also records the average solving time for tests that complete successfully, revealing that, while lightly constrained boards are solved quickly, moderately constrained configurations incur longer solving times due to extensive backtracking. Highly constrained boards are quickly determined to be unsolvable.
3. **Algorithm Comparison:**  
   The performance of the basic brute force method is compared against the MRV+Degree solver, highlighting the improvements gained through intelligent cell selection.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later.
- An IDE (such as Eclipse, IntelliJ IDEA) or command-line tools.
- Git to clone the repository.

### Compilation and Execution

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/Muneeb-ii/Sudoku_Solver.git
   cd Sudoku_Solver
2. Compile the Project:
To compile all necessary files, run:
   ```bash
   javac *.java
3. Run the Solver:
To run the basic solver simulation:
   ```bash
   java SudokuSimulation
   For the extended simulation with the MRV+Degree heuristic, use:
   ```bash
   java SudokuSimulationExt
4. Visualization:
If you want to see the graphical display while solving, run the appropriate simulation with a non-zero delay:
   ```bash
   java Sudoku

## Code Structure

- **Cell.java:**  
  Represents an individual Sudoku cell, including its value and locked status. Also includes a draw method for visualization.

- **Board.java:**  
  Manages a 9x9 grid of cells, including board initialization, value validation, and solution checking.

- **Sudoku.java:**  
  Implements the basic stack-based backtracking solver.

- **SudokuExt.java:**  
  Extends the basic solver to include the new MRV+Degree heuristic (e.g., the `solve3()` method).

- **LandscapeDisplay.java:**  
  Provides the graphical interface for visualizing the Sudoku board.

- **Tester Files:**  
  Unit test files (e.g., `CellTests.java`, `BoardTests.java`, `SudokuTests.java`) to verify each component.

- **Simulation Files:**  
  Simulation frameworks (e.g., `SudokuSimulation.java` for the basic solver and `SudokuSimulationExt.java` for the extended solver) which run automated experiments.

## Acknowledgments

- This project was inspired by various online resources, including the Sudoku-Solver repository on GitHub.
- Special thanks to peers and instructors for their feedback and support.

### References

- [Sudoku-Solver GitHub Repository](https://github.com/sg2295/Sudoku-Solver)
- [Java documentation for concurrent programming: ExecutorService API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html)


   
