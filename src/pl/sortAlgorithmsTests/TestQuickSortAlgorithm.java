package pl.sortAlgorithmsTests;

import org.junit.Assert;
import org.junit.Test;

import pl.sortAlgorithms.QuickSortAlgorithm;

public class TestQuickSortAlgorithm {

	// quick sort table
	@Test
	public void QuickSortTest() {

		// given
		int[] Table = { 3, 2, 6 };

		// when
		QuickSortAlgorithm.quickSort(Table);

		// then
		Assert.assertEquals(Table[0], 2);
		Assert.assertEquals(Table[1], 3);
		Assert.assertEquals(Table[2], 6);
	}

}
