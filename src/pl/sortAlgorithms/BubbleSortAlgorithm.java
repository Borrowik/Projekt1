package pl.sortAlgorithms;

public class BubbleSortAlgorithm {
	public static int[] BubbleSort(int[] Table) {
		int j;
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false; // set flag to false awaiting a possible swap
			for (j = 0; j < Table.length - 1; j++) {
				if (Table[j] < Table[j + 1]) // change to > for ascending sort
				{
					temp = Table[j]; // swap elements
					Table[j] = Table[j + 1];
					Table[j + 1] = temp;
					flag = true; // shows a swap occurred
				}
			}
		}
		return Table;
	}
}
