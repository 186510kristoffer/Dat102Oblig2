package del2Oppgave2;

import java.util.Random;

public class TestDataGenerator {

    // Metode for å generere en tabell med tilfeldige heltall
    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Genererer tilfeldige tall mellom 0 og 999
        }
        return array;
    }

    // Metode for å generere en tabell med tilfeldige tall innenfor et bestemt område
    public static Integer[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min; // Tall mellom min og max
        }
        return array;
    }
}
