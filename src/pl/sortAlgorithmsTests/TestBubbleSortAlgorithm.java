package pl.sortAlgorithmsTests;

import org.junit.Assert;
import org.junit.Test;

import pl.sortAlgorithms.BubbleSortAlgorithm;

public class TestBubbleSortAlgorithm {

	// bubble sort empty table
	@Test
	public final void EmptyBubbleSortTest() {

		// given
		int[] Table = new int[0];

		// when
		BubbleSortAlgorithm.BubbleSort(Table);

		// then
		Assert.assertEquals(Table.length, 0);

	}

	// bubble sort one element table
	@Test
	public final void oneElementBubbleSortTest() {

		// given
		int[] Table = { 5 };

		// when
		BubbleSortAlgorithm.BubbleSort(Table);

		// then
		Assert.assertEquals(Table[0], 5);

	}

	// bubble sort table
	@Test
	public final void BubbleSortTest() {

		// given
		int[] Table = { 3, 2, 6 };

		// when
		BubbleSortAlgorithm.BubbleSort(Table);

		// then
		Assert.assertEquals(Table[0], 2);
		Assert.assertEquals(Table[1], 3);
		Assert.assertEquals(Table[2], 6);
	}

	@Test
	public final void BubbleSortTest2() {

		// given
		int[] Table = { 3, 2, 6, 46, -3, 0 };

		// when
		BubbleSortAlgorithm.BubbleSort(Table);

		// then
		Assert.assertEquals(Table[0], -3);
		Assert.assertEquals(Table[1], 0);
		Assert.assertEquals(Table[2], 2);
		Assert.assertEquals(Table[3], 3);
		Assert.assertEquals(Table[4], 6);
		Assert.assertEquals(Table[5], 46);
	}

	@Test
	public final void BubbleSortTest3() {

		// given
		int[] Table = { 3, 2, 6, 46, -3, -3, 0 };

		// when
		BubbleSortAlgorithm.BubbleSort(Table);

		// then
		Assert.assertEquals(Table[0], -3);
		Assert.assertEquals(Table[1], -3);
		Assert.assertEquals(Table[2], 0);
		Assert.assertEquals(Table[3], 2);
		Assert.assertEquals(Table[4], 3);
		Assert.assertEquals(Table[5], 6);
		Assert.assertEquals(Table[6], 46);
	}
}
