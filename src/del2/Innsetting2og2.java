package del2;

//oppgave 1b)

public class Innsetting2og2 { 
	
	public static <T extends Comparable<? super T>> void sorterVedInnsetting2og2(T[] a) {
		sorterVedInnsetting2og2(a, 0, a.length - 1);
		}

	
		public static <T extends Comparable<? super T>> void sorterVedInnsetting2og2(T[] a, int forste, int siste) {

			for (int i = forste + 2; i <= siste; i+=2) {
				if(i > siste) break;

				T min = (a[i].compareTo(a[i - 1]) < 0) ? a[i] : a[i - 1];
				T max = (a[i].compareTo(a[i - 1]) > 0) ? a[i] : a[i - 1];

				int j=i-1;
				while (j >= forste && max.compareTo(a[j]) < 0) {
					a[j + 2] = a[j];
					j--;
				}

				a[j + 2] = max;
				
				while (j >= forste && min.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				}

				a[j + 1] = min;
			}

		}	

	}


