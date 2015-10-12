package pl.sortAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class SortAlgorithms {
	public static void main(String[] args) {

		// LinkedList<Integer> lista = new LinkedList<Integer>(); lista.add(12);
		// lista.add(3); System.out.println("Lista zawiera " + lista.get(0));
		// System.out.println("Lista zawiera " + lista.get(1));

		final int ArraySize = 100;
		final int RandomUpRange = 100;

		int[] RandomTable = new int[ArraySize]; // lista niepouk³adana
		Arrays.fill(RandomTable, -1);
		randomTable(RandomTable, RandomUpRange);
		printArray(RandomTable);

		int[] AscTable = new int[ArraySize]; // lista w kolejnoœæi rosn¹cej
		AscTable = Arrays.copyOf(RandomTable, ArraySize);
		Arrays.sort(AscTable);
		printArray(AscTable);

		int[] DescTable = new int[ArraySize]; // lista w kolejnoœæi malej¹cej
		int[] TempTable = Arrays.copyOf(RandomTable, ArraySize);
		Arrays.sort(TempTable);
		for (int i = 0; i < DescTable.length; i++) {
			DescTable[i] = TempTable[TempTable.length - 1 - i];
		}
		printArray(DescTable);

		int i;
		//
		// System.out.println("Ile liczb chesz posortowac.");
		// ile_liczb = Console.readInt("?");
		// tablica = new int[ile_liczb];
		// for (i = 0; i < ile_liczb; i++) {
		// tablica[i] = Console.readInt("Wprowadz liczbe #" + (i + 1));
		// }
		//
		// System.out.println("Tablica przed posortowaniem:");
		// for (i = 0; i < ile_liczb; i++)
		// System.out.println(tablica[i]);
		// quicksort(tablica, 0, ile_liczb - 1);
		// System.out.println("Tablica po posortowaniu:");
		// for (i = 0; i < ile_liczb; i++)
		// System.out.println(tablica[i]);
	}

	private static void randomTable(int[] Table, int up) {
		Random gen = new Random();
		for (int i = 0; i < Table.length; i++) {
			Table[i] = gen.nextInt(up);
		}
	}

	private static void printArray(int[] Table) {
		int i = 0;
		for (int a : Table) {
			System.out.println("Element : " + i++ + " Wartoœæ elementu : " + a);
		}
	}
}
