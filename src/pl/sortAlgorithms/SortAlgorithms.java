package pl.sortAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class SortAlgorithms {
	public static void main(String[] args) {

		final int ArraySize = 10000;
		final int RandomUpRange = 1000;

		int[] RandomTable = new int[ArraySize]; // Tabela niepouk³adana
		Arrays.fill(RandomTable, -1);
		randomTable(RandomTable, RandomUpRange);
		// printArray(RandomTable);

		int[] AscTable = new int[ArraySize]; // Tabela w kolejnoœæi rosn¹cej
		AscTable = Arrays.copyOf(RandomTable, ArraySize);
		Arrays.sort(AscTable);
		// printArray(AscTable);

		int[] DescTable = new int[ArraySize]; // Tabela w kolejnoœæi malej¹cej
		int[] TempTable = Arrays.copyOf(RandomTable, ArraySize);
		Arrays.sort(TempTable);
		for (int i = 0; i < DescTable.length; i++) {
			DescTable[i] = TempTable[TempTable.length - 1 - i];
		}
		// printArray(DescTable);

		// int [] TableAfterSort = new int[ArraySize];

		QuickSortAlgorithm.quickSort(Arrays.copyOf(RandomTable, RandomTable.length));

		QuickSortAlgorithm.quickSort(Arrays.copyOf(AscTable, AscTable.length));

		QuickSortAlgorithm.quickSort(Arrays.copyOf(DescTable, DescTable.length));

		BubbleSortAlgorithm.BubbleSort(Arrays.copyOf(RandomTable, RandomTable.length));

		BubbleSortAlgorithm.BubbleSort(Arrays.copyOf(AscTable, AscTable.length));

		BubbleSortAlgorithm.BubbleSort(Arrays.copyOf(DescTable, DescTable.length));

		MergeSortAlgorithm ObjectMergeSort = new MergeSortAlgorithm();

		ObjectMergeSort.MergeSort(Arrays.copyOf(RandomTable, RandomTable.length));

		ObjectMergeSort.MergeSort(Arrays.copyOf(AscTable, AscTable.length));

		ObjectMergeSort.MergeSort(Arrays.copyOf(DescTable, DescTable.length));

		// printArray(TableAfterSort);

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
