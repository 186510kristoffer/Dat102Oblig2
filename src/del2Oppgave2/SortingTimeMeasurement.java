package del2Oppgave2;

public class SortingTimeMeasurement {
    public static void main(String[] args) {
        int n = 32000;
        Integer[] array = TestDataGenerator.generateRandomArray(n);

        long start, end;

        // Mål tid for Insertion Sort
        Integer[] arrayForInsertion = array.clone();
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arrayForInsertion);
        end = System.nanoTime();
        System.out.println("Insertion Sort Time: " + (end - start) / 1_000_000.0 + " ms");

        // Mål tid for Selection Sort
        Integer[] arrayForSelection = array.clone();
        start = System.nanoTime();
        SortingAlgorithms.selectionSort(arrayForSelection);
        end = System.nanoTime();
        System.out.println("Selection Sort Time: " + (end - start) / 1_000_000.0 + " ms");

        // Mål tid for Quick Sort
        Integer[] arrayForQuick = array.clone();
        start = System.nanoTime();
        SortingAlgorithms.quickSort(arrayForQuick);
        end = System.nanoTime();
        System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");

        // Mål tid for Merge Sort
        Integer[] arrayForMerge = array.clone();
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arrayForMerge);
        end = System.nanoTime();
        System.out.println("Merge Sort Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
