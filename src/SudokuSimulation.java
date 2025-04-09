/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of class: Simulate the Sudoku solver with different initial locked cell counts
 */

import java.util.concurrent.*;

public class SudokuSimulation {

    // Timeout for each individual test in seconds.
    private static final int TIMEOUT_SECONDS = 1;
    // Number of tests per case (for each initial locked cell count)
    private static final int NUM_TESTS = 50;

    public static void main(String[] args) {
        // Print header for the result table.
        System.out.println("Initial Locked Cells\tSolved\tFailed\tTimeout\tAvg Time (sec, non-timeout)");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Loop over initial locked cell counts from 0 to 40.
        for (int numLocked = 0; numLocked <= 40; numLocked++) {
            int solved = 0;
            int failed = 0;
            int timeouts = 0;
            double totalTime = 0.0; // Total elapsed time (in seconds) for tests that finished.

            // Run NUM_TESTS tests for this number of locked cells.
            for (int test = 0; test < NUM_TESTS; test++) {
                // Create a new Sudoku board with numLocked randomly locked cells and delay 0 (to maximize speed).
                Sudoku game = new Sudoku(numLocked, 0);

                // Record start time.
                long startTime = System.currentTimeMillis();

                Future<Boolean> future = executor.submit(new Callable<Boolean>() {
                    public Boolean call() {
                        return game.solve();
                    }
                });

                try {
                    boolean result = future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
                    long endTime = System.currentTimeMillis();
                    double duration = (endTime - startTime) / 1000.0;

                    // Only count the test in the average if it didn't timeout.
                    totalTime += duration;

                    if (result) {
                        solved++;
                    } else {
                        failed++;
                    }
                } 
                catch (TimeoutException e) {
                    timeouts++;
                    future.cancel(true);
                }
                catch (Exception e) {
                    long endTime = System.currentTimeMillis();
                    double duration = (endTime - startTime) / 1000.0;
                    totalTime += duration;
                    System.out.println("Exception encountered: " + e);
                    failed++;
                }
            }

            double averageTime = 0.0;
            if (totalTime>0){
                averageTime = totalTime / (failed+solved);
            }
            // Print the summary for this number of locked cells.
            System.out.println(numLocked + "\t\t\t" + solved + "\t" + failed + "\t" + timeouts + "\t" + averageTime);
        }

        executor.shutdownNow();
    }
}