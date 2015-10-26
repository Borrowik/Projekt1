package pl.sortAlgorithms;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class SortAlgorithms {
	public static void main(String[] args) {

		System.out.println("Welcome in application for comparing time of the sort algorithms.\n");

		Scanner in = new Scanner(System.in);
		final int ArraySize = getArraySize(in);
		final int RandomTopRange = getTopRange(in);

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

		int[] selectionAlgorithms = new int[3]; // algorithms to compare
												// 1-on / 0-off
		pickUpAlgorithms(selectionAlgorithms, in, RandomTable);
		in.close();

		ArrayList<String> results = new ArrayList<>();
		if (selectionAlgorithms[0] == 1) {
			results.add(quickSortRank(RandomTable, AscTable, DescTable));
		}

		if (selectionAlgorithms[1] == 1) {
			results.add(bubbleSortRank(RandomTable, AscTable, DescTable));
		}

		if (selectionAlgorithms[2] == 1) {
			results.add(margeSortRank(RandomTable, AscTable, DescTable));
		}

		printResults(results);

	}

	private static int[] pickUpAlgorithms(int[] selectionAlgorithms, Scanner aIn, int[] aRandomTable) {
		System.out.println("Please pick up algorithms to compare.");
		System.out.println("INFO:\n Enter Q-QuickSort, B-BubbleSort, M-MargeSort, R- run , I- info , A-print array");

		char choice = '0';
		do {
			System.out.print("|QuickSort[" + selectionAlgorithms[0] + "]");
			System.out.print("|BubbleSort[" + selectionAlgorithms[1] + "]");
			System.out.print("|MargeSort[" + selectionAlgorithms[2] + "] :");

			choice = (char) aIn.nextLine().charAt(0);
			choice = Character.toUpperCase(choice);

			switch (choice) {
			case 'Q':
				if (selectionAlgorithms[0] == 0) {
					selectionAlgorithms[0] = 1;
				} else {
					selectionAlgorithms[0] = 0;
				}
				break;
			case 'B':
				if (selectionAlgorithms[1] == 0) {
					selectionAlgorithms[1] = 1;
				} else {
					selectionAlgorithms[1] = 0;
				}
				break;
			case 'M':
				if (selectionAlgorithms[2] == 0) {
					selectionAlgorithms[2] = 1;
				} else {
					selectionAlgorithms[2] = 0;
				}
				break;
			case 'I':
				System.out.println("Enter Q-QuickSort, B-BubbleSort, M-MargeSort, R- Run ,I- Info");
				System.out.println("pick one character from menu and press enter");
				break;
			case 'A':
				System.out.println("Randomed Table is: ");
				printArray(aRandomTable);
				break;
			case 'R':
				System.out.println("Algorithms has been picked up. Start at:");
				printNowDateNHour();
				break;

			default:
				System.out.println("\nthere is no posiotion like that in menu");
				break;
			}

		} while (choice != 'R');

		return selectionAlgorithms;
	}

	private static int getArraySize(Scanner in) {
		int size = 0;
		boolean isOk = false;

		do {
			System.out.println("Please insert size of array to analyze [1-1000000]:\n");

			try {
				size = Integer.parseInt(in.nextLine());
				if (size > 0 && size <= 1000000) {
					isOk = true;
				}
			} catch (NumberFormatException n) {
				System.out.println(" Wrong data type ");
			}

		} while (!isOk);
		return size;
	}

	private static int getTopRange(Scanner in) {
		int topValue = 0;
		boolean isOk = false;

		do {
			System.out.println("Please insert top value for random [1-1000000]:\n");

			try {
				topValue = Integer.parseInt(in.nextLine());
				if (topValue > 0 && topValue <= 1000000) {
					isOk = true;
				}

			} catch (NumberFormatException n) {
				System.out.println(" Wrong data type ");
			}

		} while (!isOk);
		return topValue;
	}

	private static void printResults(ArrayList<String> results) {
		System.out.println("Results are:");
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
		Locale.setDefault(Locale.ENGLISH);
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

		System.out.printf("Today: %s %d %s %d\n", weekdayNames[weekday], day, monthNames[month], year);
		System.out.println("Hour " + hour + ":" + minute + ":" + second);

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
