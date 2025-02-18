package del2;

import java.util.Arrays;
import java.util.Random;

public class MainSorter {
    public static void main(String[] args) {
        
        // 1️⃣ Vanlig Insertion Sort
        int storrelse = 100000; // Endre denne for større tester
        Integer[] tallTabell1 = genererTilfeldigeTall(storrelse);
        Integer[] tallTabell2 = Arrays.copyOf(tallTabell1, tallTabell1.length); // Kopi for metode 2
        Integer[] tallTabell3 = Arrays.copyOf(tallTabell1, tallTabell1.length); //ny kopi

        // Vanlig Insertion Sort
        long startTid1 = System.nanoTime();
        InnsettingSorter.sorterVedInnsetting(tallTabell1);
        long sluttTid1 = System.nanoTime();
        double tid1 = (sluttTid1 - startTid1) / 1_000_000.0; // Konverter til millisekunder
        System.out.println("Vanlig Insertion Sort brukte: " + tid1 + " ms");

        
        // 1a) Insertion Sort med minste først
        long startTid2 = System.nanoTime();
        InnsettingMinste.sorterVedInnsettingMedMin(tallTabell2);
        long sluttTid2 = System.nanoTime();
        double tid2 = (sluttTid2 - startTid2) / 1_000_000.0;
        System.out.println("Minste først Insertion Sort brukte: " + tid2 + " ms");
    
    
        // 1b) Sortering ved innsetting, to og to
        long startTid3 = System.nanoTime();
        Innsetting2og2.sorterVedInnsetting2og2(tallTabell3);
        long sluttTid3 = System.nanoTime();
        double tid3 = (sluttTid3 - startTid3) / 1_000_000.0;
        System.out.println("To om gangen Insertion Sort brukte: " + tid3 + " ms");
        
        // 1c)
        
        long startTid4 = System.nanoTime();
        // Flytt minste element til først posisjon
        InnsettingMinste.sorterVedInnsettingMedMin(tallTabell3);
        // Sett inn to elementer om gangen (minste og største)
        InnsettingMinste.sorterVedInnsettingMedToElementer(tallTabell3, 0, tallTabell3.length - 1);
        long sluttTid4 = System.nanoTime();
        double tid4 = (sluttTid4 - startTid4) / 1_000_000.0;
        System.out.println("Minste først og sette inn to elementer om gangen brukte: " + tid4 + " ms");
   	
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
