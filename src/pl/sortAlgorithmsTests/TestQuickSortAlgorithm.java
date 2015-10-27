package pl.sortAlgorithmsTests;

import org.junit.Assert;
import org.junit.Test;

import pl.sortAlgorithms.QuickSortAlgorithm;

public class TestQuickSortAlgorithm {

	// quick sort empty table
	@Test
	public final void EmptyQuickSortTest() {

		// given
		int[] Table = new int[0];

		// when
		QuickSortAlgorithm.quickSort(Table);

		// then
		Assert.assertEquals(Table.length, 0);

	}

	// quick sort one element table
	@Test
	public final void oneElementQuickSortTest() {

		// given
		int[] Table = { 5 };

		// when
		QuickSortAlgorithm.quickSort(Table);

		// then
		Assert.assertEquals(Table[0], 5);

	}

	// quick sort table
	@Test
	public final void QuickSortTest() {

		// given
		int[] Table = { 3, 2, 6 };

		// when
		QuickSortAlgorithm.quickSort(Table);

		// then
		Assert.assertEquals(Table[0], 2);
		Assert.assertEquals(Table[1], 3);
		Assert.assertEquals(Table[2], 6);
	}

	@Test
	public final void QuickSortTest2() {

		// given
		int[] Table = { 3, 2, 6, 46, -3, 0 };

		// when
		QuickSortAlgorithm.quickSort(Table);

		// then
		Assert.assertEquals(Table[0], -3);
		Assert.assertEquals(Table[1], 0);
		Assert.assertEquals(Table[2], 2);
		Assert.assertEquals(Table[3], 3);
		Assert.assertEquals(Table[4], 6);
		Assert.assertEquals(Table[5], 46);
	}

	@Test
	public final void QuickSortTest3() {

		// given
		int[] Table = { 3, 2, 6, 46, -3, -3, 0 };

		// when
		QuickSortAlgorithm.quickSort(Table);

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
