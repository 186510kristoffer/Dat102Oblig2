package del2;

import java.util.Arrays;
import java.util.Random;

public class Sortering {

	public static void main(String[] args) {
		int storrelse = 500; 
		int[] tallTabell = new int[storrelse]; 

		Random rand = new Random(); 

	
		for (int i = 0; i < tallTabell.length; i++) {
			tallTabell[i] = rand.nextInt(1000) + 1;
		}
		System.out.print(Arrays.toString(tallTabell));
		
	
		}
	}


