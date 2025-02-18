package testDel2Oppgave2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import del2Oppgave2.SortingAlgorithms;

public class SortingTests {

    @Test
    public void testInsertionSort() {
        Integer[] array = {5, 3, 8, 4, 2};
        Integer[] expected = {2, 3, 4, 5, 8};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    // Legg til flere test-metoder for andre algoritmer...
}
