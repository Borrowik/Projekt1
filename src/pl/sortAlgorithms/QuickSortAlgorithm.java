package pl.sortAlgorithms;

public class QuickSortAlgorithm {
	private static int Table[];
	private static int TableSize;

	public static int[] quickSort(int TableIn[]) {

		Table = TableIn;
		if (TableIn.length > 1) {
			TableSize = TableIn.length;
			quickSort(Table, 0, TableSize - 1);
		}
		return Table;

	}

	private static void quickSort(int Table[], int x, int y) {

		int i, j, v, temp;

		i = x;
		j = y;
		v = Table[(x + y) / 2];
		do {
			while (Table[i] < v)
				i++;
			while (v < Table[j])
				j--;
			if (i <= j) {
				temp = Table[i];
				Table[i] = Table[j];
				Table[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (x < j)
			quickSort(Table, x, j);
		if (i < y)
			quickSort(Table, i, y);
	}

}
