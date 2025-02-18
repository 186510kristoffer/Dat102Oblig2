package testDel2Oppgave2;


import org.junit.jupiter.api.Test;
import del2Oppgave2.SortingAlgorithms;
import del2Oppgave2.TestDataGenerator;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortingTests {

    @Test
    public void testInsertionSort() {
        Integer[] array = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSort() {
        Integer[] array = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};
        SortingAlgorithms.selectionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSort() {
        Integer[] array = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};
        SortingAlgorithms.quickSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSort() {
        Integer[] array = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};
        SortingAlgorithms.mergeSort(array);
        assertArrayEquals(expected, array);
    }
}
