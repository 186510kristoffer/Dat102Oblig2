package del2;

import java.util.Arrays;

//oppgave 1a)

public class InnsettingMinste {
    
        public static <T extends Comparable<? super T>> void sorterVedInnsettingMedMin(T[] a) {
        flyttMinstTilForste(a, 0, a.length - 1);  
        sorterVedInnsetting(a, 0, a.length - 1);  
    }

    
    private static <T extends Comparable<? super T>> void flyttMinstTilForste(T[] a, int forste, int siste) {
        int minIndex = forste;
        
       
        for (int i = forste + 1; i <= siste; i++) {
            if (a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        
        
        T temp = a[minIndex];
        a[minIndex] = a[forste];
        a[forste] = temp;
    }

    
    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a, int forste, int siste) {
        for (int i = forste + 1; i <= siste; i++) {
            T temp = a[i];
            int j = i - 1;

           
            while (j >= forste && temp.compareTo(a[j]) < 0) {
                a[j + 1] = a[j]; 
                j--;
            }

            a[j + 1] = temp;
        }
    }
}
