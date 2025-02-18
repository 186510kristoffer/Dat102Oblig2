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

    // Ny metode for å sette inn to elementer om gangen
    public static <T extends Comparable<? super T>> void sorterVedInnsettingMedToElementer(T[] a, int forste, int siste) {
        for (int i = forste + 1; i <= siste; i++) {
            // Finn minste og største element
            T tempMin = a[i];
            T tempMax = a[i];
            int minIndex = i;
            int maxIndex = i;

            for (int j = i + 1; j <= siste; j++) {
                if (a[j].compareTo(tempMin) < 0) {
                    tempMin = a[j];
                    minIndex = j;
                }
                if (a[j].compareTo(tempMax) > 0) {
                    tempMax = a[j];
                    maxIndex = j;
                }
            }

         // Flytt største element først
            if (maxIndex > i) {
                T temp = a[maxIndex];
                for (int j = maxIndex; j > i; j--) {
                    a[j] = a[j - 1];
                }
                a[i] = temp;
            }

            // Juster minIndex hvis det er endret
            if (minIndex == i) {
                minIndex = maxIndex;
            }

            // Flytt minste element
            if (minIndex > i + 1) {
                T temp = a[minIndex];
                for (int j = minIndex; j > i + 1; j--) {
                    a[j] = a[j - 1];
                }
                a[i + 1] = temp;
            }
        }
    }
}