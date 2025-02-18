package del2Oppgave2;

import java.util.Arrays;

public class SortingTimeMeasurement {
    public static void main(String[] args) {
        int[] sizes = {32000, 64000, 128000};
        int numMeasurements = 5;
        double smallConstant = 1e-6; // En liten konstant for å unngå nullverdier

        // Tabell for resultater
        System.out.println("Resultater for alle sorteringsmetoder:");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "N", "Metode", "Målt tid (ms)", "Teoretisk tid", "Konstant c");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            long insertionSortTotalTime = 0;
            long selectionSortTotalTime = 0;
            long quickSortTotalTime = 0;
            long mergeSortTotalTime = 0;

            for (int i = 0; i < numMeasurements; i++) {
                Integer[] array = TestDataGenerator.generateRandomArray(size);

                // Mål tid for hver sorteringsmetode
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

            // Beregn gjennomsnittlig tid for hver metode
            double avgInsertionSortTime = (double) insertionSortTotalTime / numMeasurements / 1_000_000.0;
            double avgSelectionSortTime = (double) selectionSortTotalTime / numMeasurements / 1_000_000.0;
            double avgQuickSortTime = (double) quickSortTotalTime / numMeasurements / 1_000_000.0;
            double avgMergeSortTime = (double) mergeSortTotalTime / numMeasurements / 1_000_000.0;

            // Beregn konstanten c for hver metode
            double log2n = Math.log(size) / Math.log(2); // Bruk log2 istedenfor ln

            double cInsertion = (avgInsertionSortTime + smallConstant) / (size * size);
            double cSelection = (avgSelectionSortTime + smallConstant) / (size * size);
            double cQuick = (avgQuickSortTime + smallConstant) / (size * log2n);
            double cMerge = (avgMergeSortTime + smallConstant) / (size * log2n);

            // Beregn teoretisk tid for hver metode
            double theoreticalInsertionTime = Math.max(cInsertion * size * size, avgInsertionSortTime);
            double theoreticalSelectionTime = Math.max(cSelection * size * size, avgSelectionSortTime);
            double theoreticalQuickTime = Math.max(cQuick * size * log2n, avgQuickSortTime);
            double theoreticalMergeTime = Math.max(cMerge * size * log2n, avgMergeSortTime);

            // Skriv ut resultatene for hver metode
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Insertion Sort", avgInsertionSortTime, theoreticalInsertionTime, cInsertion);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Selection Sort", avgSelectionSortTime, theoreticalSelectionTime, cSelection);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Quick Sort", avgQuickSortTime, theoreticalQuickTime, cQuick);
            System.out.printf("%-10d %-20s %-20.2f %-20.2f %-20.10f\n", size, "Merge Sort", avgMergeSortTime, theoreticalMergeTime, cMerge);
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }
}