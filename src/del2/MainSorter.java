package del2;

import java.util.Arrays;
import java.util.Random;

public class MainSorter {
    public static void main(String[] args) {
        int storrelse = 10000; // Endre denne for større tester
        Integer[] tallTabell1 = genererTilfeldigeTall(storrelse);
        Integer[] tallTabell2 = Arrays.copyOf(tallTabell1, tallTabell1.length); // Kopi for metode 2
        Integer[] tallTabell3 = Arrays.copyOf(tallTabell1, tallTabell1.length); // Kopi for metode 3

        // 1️⃣ Vanlig Insertion Sort
        long startTid1 = System.nanoTime();
        InnsettingSorter.sorterVedInnsetting(tallTabell1);
        long sluttTid1 = System.nanoTime();
        double tid1 = (sluttTid1 - startTid1) / 1_000_000.0; // Konverter til millisekunder
        System.out.println("Vanlig Insertion Sort brukte: " + tid1 + " ms");

        // 2️⃣ Insertion Sort med minste først
        long startTid2 = System.nanoTime();
        InnsettingMinste.sorterVedInnsettingMedMin(tallTabell2);
        long sluttTid2 = System.nanoTime();
        double tid2 = (sluttTid2 - startTid2) / 1_000_000.0;
        System.out.println("Minste først Insertion Sort brukte: " + tid2 + " ms");
    
    
        long startTid3 = System.nanoTime();

     // Flytt minste element til først posisjon
     InnsettingMinste.sorterVedInnsettingMedMin(tallTabell3);

     // Sett inn to elementer om gangen (minste og største)
     InnsettingMinste.sorterVedInnsettingMedToElementer(tallTabell3, 0, tallTabell3.length - 1);


     long sluttTid3 = System.nanoTime();
     double tid3 = (sluttTid3 - startTid3) / 1_000_000.0;
     System.out.println("Minste først og sette inn to elementer om gangen brukte: " + tid3 + " ms");
	}


    private static Integer[] genererTilfeldigeTall(int storrelse) {
        Random rand = new Random();
        Integer[] tallTabell = new Integer[storrelse];
        for (int i = 0; i < storrelse; i++) {
            tallTabell[i] = rand.nextInt(1000) + 1; // Tilfeldig tall mellom 1 og 1000
        }
        return tallTabell;
    }
}
