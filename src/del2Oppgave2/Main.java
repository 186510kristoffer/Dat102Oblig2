package del2Oppgave2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {3,4,9,6,5,2};

        // Kopier arrayet for hver sorteringsmetode
        Integer[] arrayForInsertion = array.clone();
        Integer[] arrayForSelection = array.clone();
        Integer[] arrayForQuick = array.clone();
        Integer[] arrayForMerge = array.clone();

        // Bruk sorteringsmetodene
        SortingAlgorithms.insertionSort(arrayForInsertion);
        SortingAlgorithms.selectionSort(arrayForSelection);
        SortingAlgorithms.quickSort(arrayForQuick);
        SortingAlgorithms.mergeSort(arrayForMerge);

        System.out.println("Insertion Sort: " + Arrays.toString(arrayForInsertion));
        System.out.println("Selection Sort: " + Arrays.toString(arrayForSelection));
        System.out.println("Quick Sort: " + Arrays.toString(arrayForQuick));
        System.out.println("Merge Sort: " + Arrays.toString(arrayForMerge));
        
    }
}
