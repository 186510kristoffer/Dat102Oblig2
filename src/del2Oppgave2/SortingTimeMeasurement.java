package del2Oppgave2;
import java.util.Arrays;

public class SortingTimeMeasurement {
    public static void main(String[] args) {
        int[] sizes = {32000, 64000, 128000};
    	int numMeasurements = 5;

        // Tabell for resultater
        System.out.println("Resultat Kvikksortering:");
        System.out.printf("%-10s %-20s %-20s %-20s\n", "N", "Antall målinger", "Målt tid (ms)", "Teoretisk tid");
        System.out.println("----------------------------------------------------------------------------");

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
            double log2n = Math.log(size) / Math.log(2);  // Bruk log2 istedenfor ln
            double cInsertion = avgInsertionSortTime / (size * size);
            double cSelection = avgSelectionSortTime / (size * size);
            double cQuick = avgQuickSortTime / (size * log2n);
            double cMerge = avgMergeSortTime / (size * log2n);

            // Skriv ut resultatene
            System.out.printf("%-10d %-20d %-20.2f %-20.2f\n", size, numMeasurements, avgQuickSortTime, cQuick * size * log2n);
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}