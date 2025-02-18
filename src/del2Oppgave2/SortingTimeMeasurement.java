package del2Oppgave2;

import java.util.Arrays;

public class SortingTimeMeasurement {
    public static void main(String[] args) {
        int[] sizes = {32000, 64000, 128000};
        int numMeasurements = 5;
        double smallConstant = 1e-6; // Forhindrer divisjon med null

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

                start = System.nanoTime();
                SortingAlgorithms.insertionSort(array.clone());
                end = System.nanoTime();
                insertionSortTotalTime += (end - start);

                start = System.nanoTime();
                SortingAlgorithms.selectionSort(array.clone());
                end = System.nanoTime();
                selectionSortTotalTime += (end - start);

                start = System.nanoTime();
                SortingAlgorithms.quickSort(array.clone());
                end = System.nanoTime();
                quickSortTotalTime += (end - start);

                start = System.nanoTime();
                SortingAlgorithms.mergeSort(array.clone());
                end = System.nanoTime();
                mergeSortTotalTime += (end - start);
            }

            double avgInsertionSortTime = (double) insertionSortTotalTime / numMeasurements / 1_000_000.0;
            double avgSelectionSortTime = (double) selectionSortTotalTime / numMeasurements / 1_000_000.0;
            double avgQuickSortTime = (double) quickSortTotalTime / numMeasurements / 1_000_000.0;
            double avgMergeSortTime = (double) mergeSortTotalTime / numMeasurements / 1_000_000.0;

            double log2n = Math.log(size) / Math.log(2);

            // Beregn konstante verdier og unngå negative verdier
            double cInsertion = Math.max(avgInsertionSortTime / (size * size), smallConstant);
            double cSelection = Math.max(avgSelectionSortTime / (size * size), smallConstant);
            double cQuick = Math.max(avgQuickSortTime / (size * log2n), smallConstant);
            double cMerge = Math.max(avgMergeSortTime / (size * log2n), smallConstant);

            // Debugging-utskrift for c-verdiene
            System.out.printf("Debug c-values for N=%d: cInsertion=%.10f, cSelection=%.10f, cQuick=%.10f, cMerge=%.10f\n",
                    size, cInsertion, cSelection, cQuick, cMerge);

            // Beregn teoretiske tider
            double theoreticalInsertionTime = cInsertion * size * size;
            double theoreticalSelectionTime = cSelection * size * size;
            double theoreticalQuickTime = cQuick * size * log2n;
            double theoreticalMergeTime = cMerge * size * log2n;

            // Skriv ut resultater
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Insertion Sort", avgInsertionSortTime, theoreticalInsertionTime, cInsertion);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Selection Sort", avgSelectionSortTime, theoreticalSelectionTime, cSelection);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Quick Sort", avgQuickSortTime, theoreticalQuickTime, cQuick);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Merge Sort", avgMergeSortTime, theoreticalMergeTime, cMerge);
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }
}
