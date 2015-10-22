package pl.sortAlgorithms;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class SortAlgorithms {
	public static void main(String[] args) {

		final int ArraySize = 1000;
		final int RandomTopRange = 1000;

		int[] RandomTable = new int[ArraySize]; // tablica niepouk³adana
		Arrays.fill(RandomTable, -1);
		randomTable(RandomTable, RandomTopRange);
		// printArray(RandomTable);

		int[] AscTable = new int[ArraySize]; // tablica w kolejnoœæi rosn¹cej

		AscTable = Arrays.copyOf(RandomTable, ArraySize);
		Arrays.sort(AscTable);
		// printArray(AscTable);

		int[] DescTable = new int[ArraySize]; // tablica w kolejnoœæi malej¹cej

		int[] TempTable = Arrays.copyOf(RandomTable, ArraySize);
		Arrays.sort(TempTable);
		for (int i = 0; i < DescTable.length; i++) {
			DescTable[i] = TempTable[TempTable.length - 1 - i];
		}
		// printArray(DescTable);

		System.out.println("Witam w programie porównuj¹cym czasy sortowañ.");

		printNowDateNHour();

		List<StopWatch> Timers = new ArrayList<StopWatch>();
		Timers.add(new StopWatch());
		Timers.get(0).start();
		long temp = 0;
		for (int i = 0; i < 100000; i++) {
			temp = temp + i;
		}

		Timers.get(0).stop();
		System.out.println("Value:" + Timers.get(0).getElapsedTime());

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

	private static void printNowDateNHour() {
		GregorianCalendar calendar = new GregorianCalendar();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		String[] monthNames = new DateFormatSymbols().getMonths();

		System.out.printf("Dziœ: %s %d %s %d\n", weekdayNames[weekday], day, monthNames[month], year);
		System.out.println("Godzina " + hour + ":" + minute + ":" + second);

		// int [] TableAfterSort = new int[ArraySize];

	}

	private static void randomTable(int[] Table, int TopRange) {
		Random gen = new Random();
		for (int i = 0; i < Table.length; i++) {
			Table[i] = gen.nextInt(TopRange);
		}
	}

	private static void printArray(int[] Table) {
		int i = 0;
		for (int a : Table) {
			System.out.println("Element : " + i++ + " Wartoœæ elementu : " + a);
		}
	}
}
