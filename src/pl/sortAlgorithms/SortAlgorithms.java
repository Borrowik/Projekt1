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

		final int ArraySize = 100000;
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

		ArrayList<String> results = new ArrayList<>();

		results.add(quickSortRank(RandomTable, AscTable, DescTable));

		results.add(bubbleSortRank(RandomTable, AscTable, DescTable));

		results.add(margeSortRank(RandomTable, AscTable, DescTable));

		printResults(results);

	}

	private static void printResults(ArrayList<String> results) {
		for (String st : results) {
			System.out.println(st);
		}
	}

	private static String margeSortRank(int[] RandomTable, int[] AscTable, int[] DescTable) {

		MergeSortAlgorithm ObjectMergeSort = new MergeSortAlgorithm();
		StringBuilder result = new StringBuilder("Merge sort timers results :");
		StopWatch Timer = new StopWatch();

		Timer.start();
		ObjectMergeSort.MergeSort(Arrays.copyOf(RandomTable, RandomTable.length));
		Timer.stop();
		result = result.append(" Random: " + Timer.getElapsedTime());

		Timer.start();
		ObjectMergeSort.MergeSort(Arrays.copyOf(AscTable, AscTable.length));
		Timer.stop();
		result = result.append(" Asc: " + Timer.getElapsedTime());

		Timer.start();
		ObjectMergeSort.MergeSort(Arrays.copyOf(DescTable, DescTable.length));
		Timer.stop();
		result = result.append(" Desc: " + Timer.getElapsedTime());

		return result.toString();

	}

	private static String bubbleSortRank(int[] RandomTable, int[] AscTable, int[] DescTable) {

		StringBuilder result = new StringBuilder("Bubble sort timers results :");
		StopWatch Timer = new StopWatch();

		Timer.start();
		BubbleSortAlgorithm.BubbleSort(Arrays.copyOf(RandomTable, RandomTable.length));
		Timer.stop();
		result = result.append(" Random: " + Timer.getElapsedTime());

		Timer.start();
		BubbleSortAlgorithm.BubbleSort(Arrays.copyOf(AscTable, AscTable.length));
		Timer.stop();
		result = result.append(" Asc: " + Timer.getElapsedTime());

		Timer.start();
		BubbleSortAlgorithm.BubbleSort(Arrays.copyOf(DescTable, DescTable.length));
		Timer.stop();
		result = result.append(" Desc: " + Timer.getElapsedTime());

		return result.toString();

	}

	private static String quickSortRank(int[] RandomTable, int[] AscTable, int[] DescTable) {

		StringBuilder result = new StringBuilder("Quick sort timers results :");
		StopWatch Timer = new StopWatch();

		Timer.start();
		QuickSortAlgorithm.quickSort(Arrays.copyOf(RandomTable, RandomTable.length));
		Timer.stop();
		result = result.append(" Random: " + Timer.getElapsedTime());

		Timer.start();
		QuickSortAlgorithm.quickSort(Arrays.copyOf(AscTable, AscTable.length));
		Timer.stop();
		result = result.append(" Asc: " + Timer.getElapsedTime());

		Timer.start();
		QuickSortAlgorithm.quickSort(Arrays.copyOf(DescTable, DescTable.length));
		Timer.stop();
		result = result.append(" Desc: " + Timer.getElapsedTime());

		return result.toString();
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
