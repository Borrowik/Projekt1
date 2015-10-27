package pl.sortAlgorithmsTests;

import org.junit.Assert;
import org.junit.Test;

import pl.sortAlgorithms.MergeSortAlgorithm;

public class TestMergeSortAlgorithm {

	MergeSortAlgorithm ObjectMergeSort = new MergeSortAlgorithm();

	// merge sort empty table
	@Test
	public final void EmptyMergeSortTest() {

		// given
		int[] Table = new int[0];

		// when
		ObjectMergeSort.MergeSort(Table);

		// then
		Assert.assertEquals(Table.length, 0);

	}

	// merge sort one element table
	@Test
	public final void oneElementMergeSortTest() {

		// given
		int[] Table = { 5 };

		// when
		ObjectMergeSort.MergeSort(Table);

		// then
		Assert.assertEquals(Table.length, 1);
		Assert.assertEquals(Table[0], 5);

	}

	// merge sort table
	@Test
	public final void MergeSortTest() {

		// given
		int[] Table = { 3, 2, 6 };

		// when
		ObjectMergeSort.MergeSort(Table);

		// then
		Assert.assertEquals(Table.length, 3);
		Assert.assertEquals(Table[0], 2);
		Assert.assertEquals(Table[1], 3);
		Assert.assertEquals(Table[2], 6);
	}

	@Test
	public final void MergeSortTest2() {

		// given
		int[] Table = { 3, 2, 6, 46, -3, 0 };

		// when
		ObjectMergeSort.MergeSort(Table);

		// then
		Assert.assertEquals(Table.length, 6);
		Assert.assertEquals(Table[0], -3);
		Assert.assertEquals(Table[1], 0);
		Assert.assertEquals(Table[2], 2);
		Assert.assertEquals(Table[3], 3);
		Assert.assertEquals(Table[4], 6);
		Assert.assertEquals(Table[5], 46);
	}

	@Test
	public final void MergeSortTest3() {

		// given
		int[] Table = { 3, 2, 6, 46, -3, -3, 0 };

		// when
		ObjectMergeSort.MergeSort(Table);

		// then
		Assert.assertEquals(Table.length, 7);
		Assert.assertEquals(Table[0], -3);
		Assert.assertEquals(Table[1], -3);
		Assert.assertEquals(Table[2], 0);
		Assert.assertEquals(Table[3], 2);
		Assert.assertEquals(Table[4], 3);
		Assert.assertEquals(Table[5], 6);
		Assert.assertEquals(Table[6], 46);
	}

}
