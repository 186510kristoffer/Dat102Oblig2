package del2Oppgave2;

import java.util.Arrays;

public class SortingTimeMeasurement {
    public static void main(String[] args) {
        int[] sizes = {32000, 64000, 128000};
        int numMeasurements = 5;
        double smallConstant = 1e-6; // Small constant to avoid division by zero

        // Results table
        System.out.println("Results for all sorting methods:");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "N", "Method", "Measured time (ms)", "Theoretical time", "Constant c");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            long insertionSortTotalTime = 0;
            long selectionSortTotalTime = 0;
            long quickSortTotalTime = 0;
            long mergeSortTotalTime = 0;

            for (int i = 0; i < numMeasurements; i++) {
                Integer[] array = TestDataGenerator.generateRandomArray(size);

                // Measure each sorting algorithm
                long start, end;

                // Insertion Sort
                start = System.nanoTime();
                SortingAlgorithms.insertionSort(array.clone());
                end = System.nanoTime();
                insertionSortTotalTime += (end - start);

                // Selection Sort
                start = System.nanoTime();
                SortingAlgorithms.selectionSort(array.clone());
                end = System.nanoTime();
                selectionSortTotalTime += (end - start);

                // Quick Sort
                start = System.nanoTime();
                SortingAlgorithms.quickSort(array.clone());
                end = System.nanoTime();
                quickSortTotalTime += (end - start);

                // Merge Sort
                start = System.nanoTime();
                SortingAlgorithms.mergeSort(array.clone());
                end = System.nanoTime();
                mergeSortTotalTime += (end - start);
            }

            // Calculate average times
            double avgInsertionSortTime = (double) insertionSortTotalTime / numMeasurements / 1_000_000.0;
            double avgSelectionSortTime = (double) selectionSortTotalTime / numMeasurements / 1_000_000.0;
            double avgQuickSortTime = (double) quickSortTotalTime / numMeasurements / 1_000_000.0;
            double avgMergeSortTime = (double) mergeSortTotalTime / numMeasurements / 1_000_000.0;

            // Calculate log2(size) for O(n log n) complexities
            double log2n = Math.log(size) / Math.log(2);

            // Calculate constants c
            double cInsertion = (avgInsertionSortTime > 0) ? avgInsertionSortTime / (size * size) : 0;
            double cSelection = (avgSelectionSortTime > 0) ? avgSelectionSortTime / (size * size) : 0;
            double cQuick = (avgQuickSortTime > 0) ? avgQuickSortTime / (size * log2n) : 0;
            double cMerge = (avgMergeSortTime > 0) ? avgMergeSortTime / (size * log2n) : 0;

            // Calculate theoretical times using c
            double theoreticalInsertionTime = Math.max(cInsertion * size * size, 0);
            double theoreticalSelectionTime = Math.max(cSelection * size * size, 0);
            double theoreticalQuickTime = Math.max(cQuick * size * log2n, 0);
            double theoreticalMergeTime = Math.max(cMerge * size * log2n, 0);

            // Output results
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Insertion Sort", avgInsertionSortTime, theoreticalInsertionTime, cInsertion);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Selection Sort", avgSelectionSortTime, theoreticalSelectionTime, cSelection);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Quick Sort", avgQuickSortTime, theoreticalQuickTime, cQuick);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Merge Sort", avgMergeSortTime, theoreticalMergeTime, cMerge);
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }
}