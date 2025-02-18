package del2;

import java.util.Arrays;
import java.util.Random;

public class RandomTall {

	public static void main(String[] args) {
		int rader = 10;
		int kolonner = 10;
		int storrelse = rader * kolonner;
		int[] tallTabell = new int[storrelse];

		Random rand = new Random();

		for (int i = 0; i < tallTabell.length; i++) {
			tallTabell[i] = rand.nextInt(1000) + 1;
		}
		System.out.println("Tabellen skrevet ut i kolonner:");
		for (int rad = 0; rad < rader; rad++) {
			for (int kol = 0; kol < kolonner; kol++) {
				int index = rad + kol * rader;
				if (index < tallTabell.length) {
					System.out.printf("%4d ", tallTabell[index]);
				}
			}
			System.out.println();

		}
	}
}